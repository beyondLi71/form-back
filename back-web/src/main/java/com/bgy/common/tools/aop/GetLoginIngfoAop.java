package com.bgy.common.tools.aop;

import com.bgy.common.dto.UserBaseInfoDTO;
import com.bgy.common.utils.exception.ExceptionManager;
import com.bgy.entity.po.AuthUserInfoPO;
import com.bgy.service.AuthUserService;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;


/**
 * @author ygg
 * @date 2018/4/24 17:11
 * @desc 获取当前登录人的信息
 */
@Component
@Aspect
public class GetLoginIngfoAop {

    @Resource
    AuthUserService authUserService;

    @Resource
    UserBaseInfoDTO userBaseInfoDTO;

    @Resource
    private ExceptionManager exceptionManager;


    /**
     * aop前置通知获取用户信息 （为后台提供登录用户基本信息）
     *
     * @param
     * @return
     * @throws Throwable
     */
    @Before("execution (* com.bgy.controller..*.*(..))  &&"
            + "!execution(* com.bgy.controller.LoginController.*(..))")
    public Object beforeCheckToken() throws Throwable {
        //获取token
        String token = getToken();
        AuthUserInfoPO authUserInfoPO = authUserService.getLoginUserInfo(token);
        userBaseInfoDTO.setId(authUserInfoPO.getId());
        userBaseInfoDTO.setUserName(authUserInfoPO.getUserName());
        userBaseInfoDTO.setUserPhone(authUserInfoPO.getUserPhone());
        return authUserInfoPO;
    }



    /***
     * 通过request 获取token
     * @return
     */
    private String getToken() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        Cookie[] cookie = request.getCookies(); //获取token
        String token = null;
        //String requestAddress = request.getRequestURI();  //取出请求地址
        if (cookie != null) {
            for (Cookie index : cookie) {
                if (index.getName().equals("BACK_TOKEN"))  //取出token值
                    token = index.getValue();
            }
        }
        if (token == null) {
            throw exceptionManager.createByCode("IDEN_ERR_0005");
        }
        return token;
    }

}
