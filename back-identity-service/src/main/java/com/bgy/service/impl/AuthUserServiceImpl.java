package com.bgy.service.impl;

import com.bgy.common.utils.TokenUtils;
import com.bgy.common.utils.apiresult.AbstractApiResult;
import com.bgy.common.utils.exception.ExceptionManager;
import com.bgy.common.utils.mapper.MapperUtils;
import com.bgy.dao.AuthUserCUDMapper;
import com.bgy.dao.AuthUserQueryMapper;
import com.bgy.entity.dto.AuthUserInfoDTO;
import com.bgy.entity.dto.AuthUserLoginDTO;
import com.bgy.entity.po.AuthUserInfoPO;
import com.bgy.entity.po.AuthUserPO;
import com.bgy.entity.po.AuthUserTokenLogPO;
import com.bgy.entity.po.AuthUserTokenPO;
import com.bgy.entity.vo.AuthUserTokenVO;
import com.bgy.service.AuthUserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.Duration;
import java.time.LocalDateTime;

/**
 * @author yyg
 * @date 2018/4/23 19:00
 * @desc 用户验证操作service
 */
@Service
public class AuthUserServiceImpl implements AuthUserService {

    @Resource
    private AuthUserQueryMapper authUserQueryMapper;

    @Resource
    private AuthUserCUDMapper authUserCUDMapper;

    @Resource
    private ExceptionManager exceptionManager;

    //超时时间
    @Value("${outTime}")
    Integer outTime;

    //cookie 的key
    @Value("${key}")
    String key;

    //cookie 的key
    @Value("${hour}")
    Long hour;

    /**
     * 登录验证方法
     *
     * @param loginDTO
     * @param response
     * @return
     * @throws Exception
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public AbstractApiResult loginCheck(AuthUserLoginDTO loginDTO, HttpServletResponse response) throws Exception {
        //String md5Pwd = MD5Utils.md5Bit32Lower(loginDTO.getPwd());
        AuthUserPO user = authUserQueryMapper.selectUserInfoOne(loginDTO);
        //未注册或者密码错误，提示用户名或密码错误
        if (user == null) {
            throw exceptionManager.createByCode("IDEN_ERR_0004");
        }
        //生成一个token，保存用户登录状态
        String token = TokenUtils.getUUToken();
        // 将token写入cookie
        TokenUtils.setTokenCookie(key, token, outTime, response);
        //将token写入数据库
        AuthUserTokenPO authUserTokenPO = new AuthUserTokenPO();
        authUserTokenPO.setToken(token);
        authUserTokenPO.setUserId(user.getId());
        authUserTokenPO.setCreateBy(user.getId());
        authUserTokenPO.setCreateTime(LocalDateTime.now());
        authUserTokenPO.setUserCreateTime(LocalDateTime.now());
        authUserCUDMapper.addUserToken(authUserTokenPO);
        //写入token历史记录表
        AuthUserTokenLogPO authUserTokenLogPO = MapperUtils.mapperBean(authUserTokenPO, AuthUserTokenLogPO.class);
        authUserTokenLogPO.setUserLoseTime(LocalDateTime.now());
        authUserTokenLogPO.setCreateBy(user.getId());
        authUserTokenLogPO.setCreateTime(LocalDateTime.now());
        authUserCUDMapper.addUserTokenLog(authUserTokenLogPO);
        return AbstractApiResult.success("success");
    }

    /**
     * 退出登录
     *
     * @param request
     * @param response
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void logout(HttpServletRequest request, HttpServletResponse response) {
        TokenUtils.delectCookieByName(request, response, key);
    }


    /**
     * 获取登录用户的基本信息
     *
     * @param token
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public AuthUserInfoPO getLoginUserInfo(String token) {
        //获取用户token信息
        AuthUserTokenVO authUserTokenVO = continuedLifeForToken(token);
        //查询用户信息
        AuthUserInfoDTO authUserInfoDTO = MapperUtils.mapperBean(authUserTokenVO, AuthUserInfoDTO.class);
        AuthUserInfoPO authUserInfoPO = authUserQueryMapper.selectUeerInfoOne(authUserInfoDTO);
        //todo 查询对应权限
        return authUserInfoPO;
    }

    /**
     * 检验token是否过期，不过期继续续命
     *
     * @param token
     * @return
     */
    private AuthUserTokenVO continuedLifeForToken(String token) {
        AuthUserTokenVO authUserTokenVO = authUserQueryMapper.selectTokenInfoOne(token);
        Duration duration = Duration.between(authUserTokenVO.getUserCreateTime(), LocalDateTime.now());
        Long hours = duration.toHours();
        if (hours > hour) {
            throw exceptionManager.createByCode("IDEN_ERR_0005");
        }
        //续命token
        AuthUserTokenPO authUserTokenPO = MapperUtils.mapperBean(authUserTokenVO, AuthUserTokenPO.class);
        authUserTokenPO.setUpdateTime(LocalDateTime.now());
        authUserTokenPO.setUserCreateTime(LocalDateTime.now());
        authUserCUDMapper.updateUserToken(authUserTokenPO);
        return authUserTokenVO;
    }
}
