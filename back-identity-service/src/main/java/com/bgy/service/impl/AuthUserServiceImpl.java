package com.bgy.service.impl;

import com.auth0.jwt.internal.org.apache.commons.lang3.StringUtils;
import com.bgy.common.utils.SysEnum.DeleteEnum;
import com.bgy.common.utils.apiresult.AbstractApiResult;
import com.bgy.common.utils.cookie.CookieUtils;
import com.bgy.common.utils.exception.ExceptionManager;
import com.bgy.common.utils.mapper.MapperUtils;
import com.bgy.common.utils.md5.MD5Utils;
import com.bgy.common.utils.page.PageParam;
import com.bgy.common.utils.page.PageResult;
import com.bgy.common.utils.page.PageResultFactory;
import com.bgy.dao.AuthUserCUDMapper;
import com.bgy.dao.AuthUserQueryMapper;
import com.bgy.entity.dto.*;
import com.bgy.entity.po.*;
import com.bgy.entity.vo.*;
import com.bgy.service.AuthUserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    @Resource
    PageResultFactory pageResultFactory;

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
     * @return AbstractApiResult
     * @throws Exception
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public AbstractApiResult loginCheck(AuthUserLoginDTO loginDTO, HttpServletResponse response) throws Exception {
        //String md5Pwd = MD5Utils.md5Bit32Lower(loginDTO.getPwd());
        loginDTO.setIsDelete(DeleteEnum.ENABLE.getStatus());
        AuthUserPO user = authUserQueryMapper.selectLoginUserInfoOne(loginDTO);
        //未注册或者密码错误，提示用户名或密码错误
        if (user == null) {
            throw exceptionManager.createByCode("IDEN_ERR_0004");
        }
        //生成一个token，保存用户登录状态
        String token = CookieUtils.getUUToken();
        // 将token写入cookie
        CookieUtils.setTokenCookie(key, token, outTime, response);
        //将token写入数据库
        AuthUserTokenPO authUserTokenPO = new AuthUserTokenPO();
        authUserTokenPO.setToken(token);
        authUserTokenPO.setUserId(user.getId());
        authUserTokenPO.setCreateBy(user.getId().toString());
        authUserTokenPO.setCreateTime(LocalDateTime.now());
        authUserTokenPO.setUserCreateTime(LocalDateTime.now());
        authUserCUDMapper.addUserToken(authUserTokenPO);
        //写入token历史记录表
        AuthUserTokenLogPO authUserTokenLogPO = MapperUtils.mapperBean(authUserTokenPO, AuthUserTokenLogPO.class);
        authUserTokenLogPO.setUserLoseTime(LocalDateTime.now());
        authUserTokenLogPO.setCreateBy(user.getId().toString());
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
        CookieUtils.delectCookieByName(request, response, key);
    }


    /**
     * 获取登录用户的基本信息
     *
     * @param token
     * @return AuthUserInfoPO
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public AuthUserInfoPO getLoginUserInfo(String token) {
        //获取用户token信息
        AuthUserTokenVO authUserTokenVO = continuedLifeForToken(token);
        //查询用户信息
        AuthUserInfoDTO authUserInfoDTO = MapperUtils.mapperBean(authUserTokenVO, AuthUserInfoDTO.class);
        AuthUserInfoPO authUserInfoPO = authUserQueryMapper.selectUserInfoOne(authUserInfoDTO);
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
            throw exceptionManager.createByCode("IDEN_ERR_0010");
        }
        //续命token
        AuthUserTokenPO authUserTokenPO = MapperUtils.mapperBean(authUserTokenVO, AuthUserTokenPO.class);
        authUserTokenPO.setUpdateTime(LocalDateTime.now());
        authUserTokenPO.setUserCreateTime(LocalDateTime.now());
        authUserCUDMapper.updateUserToken(authUserTokenPO);
        return authUserTokenVO;
    }


    private void checkLoginNmaeOnly(String name) {
        int count = authUserQueryMapper.checkLoginNameOnly(name);
        if (count > 0) {
            throw exceptionManager.createByCode("IDEN_ERR_0012");
        }
    }

    private void checkUserNameOnly(String userName) {
        int count = authUserQueryMapper.checkUserNameOnly(userName);
        if (count > 0) {
            throw exceptionManager.createByCode("IDEN_ERR_0013");
        }
    }

    private void checkRoleNameOnly(String name) {
        int count = authUserQueryMapper.checkRoleNameOnly(name);
        if (count > 0) {
            throw exceptionManager.createByCode("IDEN_ERR_0014");
        }
    }

    private void checkUserQuoteRolenly(Long roleId) {
        int count = authUserQueryMapper.checkUserQuoteRolenly(roleId);
        if (count > 0) {
            throw exceptionManager.createByCode("IDEN_ERR_0015");
        }
    }


    /**
     * 添加用户信息
     *
     * @param userDTO
     * @throws Exception
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addUserInfo(AddUserDTO userDTO) throws Exception {
        //检查登录名唯一
        checkLoginNmaeOnly(userDTO.getAuthUserLoginDTO().getName());
        //检查用户名唯一
        checkUserNameOnly(userDTO.getAuthUserInfoDTO().getUserName());
        //添加 用户登录信息
        String md5Pwd = MD5Utils.md5Bit32Lower(userDTO.getAuthUserLoginDTO().getPwd());
        userDTO.getAuthUserLoginDTO().setPwd(md5Pwd);
        AuthUserPO authUserPO = MapperUtils.mapperBean(userDTO.getAuthUserLoginDTO(), AuthUserPO.class);
        authUserCUDMapper.addAuthUser(authUserPO);
        //添加用户基本信息
        AuthUserInfoPO authUserInfoPO = MapperUtils.mapperBean(userDTO.getAuthUserInfoDTO(), AuthUserInfoPO.class);
        authUserInfoPO.setUserId(authUserPO.getId());
        authUserInfoPO.setCreateTime(LocalDateTime.now());
        authUserInfoPO.setCreateBy(userDTO.getCreateBy());
        authUserCUDMapper.addAuthUserInfo(authUserInfoPO);
    }

    /**
     * 添加角色
     *
     * @param authRoleDTO
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addAuthRole(AuthRoleDTO authRoleDTO) {
        //检查角色名唯一
        checkRoleNameOnly(authRoleDTO.getName());
        //添加角色
        AuthRolePO authRolePO = MapperUtils.mapperBean(authRoleDTO, AuthRolePO.class);
        authRolePO.setCreateTime(LocalDateTime.now());
        authUserCUDMapper.addAuthRole(authRolePO);
    }

    /**
     * 修改用户基本信息
     *
     * @param updateAuthUserInfoDTO
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateUserInfo(UpdateAuthUserInfoDTO updateAuthUserInfoDTO) {
        //检查用户名唯一
        checkUserNameOnly(updateAuthUserInfoDTO.getUserName());
        //修改用户基本信息
        AuthUserInfoPO authUserInfoPO = MapperUtils.mapperBean(updateAuthUserInfoDTO, AuthUserInfoPO.class);
        authUserInfoPO.setUpdateTime(LocalDateTime.now());
        authUserCUDMapper.updateAuthUserInfo(authUserInfoPO);
    }

    /**
     * 修改角色信息
     *
     * @param updateAuthRoleDTO
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateAuthRole(UpdateAuthRoleDTO updateAuthRoleDTO) {
        //检查角色名唯一
        checkRoleNameOnly(updateAuthRoleDTO.getName());
        AuthRolePO authRolePO = MapperUtils.mapperBean(updateAuthRoleDTO, AuthRolePO.class);
        authRolePO.setUpdateTime(LocalDateTime.now());
        authUserCUDMapper.updateAuthRole(authRolePO);
    }


    /**
     * 删除用户基本信息（逻辑删除）
     *
     * @param deleteAuthUserInfoDTO
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deteleUserInfo(DeleteAuthUserInfoDTO deleteAuthUserInfoDTO) {
        //修改用户基本信息
        AuthUserInfoPO authUserInfoPO = MapperUtils.mapperBean(deleteAuthUserInfoDTO, AuthUserInfoPO.class);
        authUserInfoPO.setUpdateTime(LocalDateTime.now());
        authUserInfoPO.setIsDelete(DeleteEnum.DISABLE.getStatus());
        authUserCUDMapper.deteleAuthUserInfo(authUserInfoPO);
        //TODO 如果删除用户是否需要删除 用户角色关联表数据
         authUserCUDMapper.deleteUserRole(deleteAuthUserInfoDTO.getId());
    }

    /**
     * 根据用户id删除 用户与角色的关联信息
     * @param userId
     */

    /**
     * 删除角色信息（逻辑删除）
     *
     * @param deleteAuthRoleDTO
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deteleAuthRole(DeleteAuthRoleDTO deleteAuthRoleDTO) {
        checkUserQuoteRolenly(deleteAuthRoleDTO.getId());
        AuthRolePO authRolePO = MapperUtils.mapperBean(deleteAuthRoleDTO, AuthRolePO.class);
        authRolePO.setUpdateTime(LocalDateTime.now());
        authRolePO.setIsDelete(DeleteEnum.DISABLE.getStatus());
        authUserCUDMapper.deteleAuthRole(authRolePO);
        //TODO 如果删除角色是否需要删除 角色权限关联表数据
        authUserCUDMapper.deleteRoleFuncion(deleteAuthRoleDTO.getId());
    }

    /**
     * 通过id查询用户实体信息
     *
     * @param id
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public AuthUserInfoVO getUserInfoOne(Long id) {
        AuthUserInfoPO authUserInfoPO = authUserQueryMapper.selectUserById(id);
        AuthUserInfoVO authUserInfoVO = MapperUtils.mapperBean(authUserInfoPO, AuthUserInfoVO.class);
        return authUserInfoVO;
    }

    /**
     * 查询单个角色信息
     *
     * @param id
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public AuthRoleVO getRoleOne(Long id) {
        AuthRolePO authRolePO = authUserQueryMapper.selectRoleInfoOne(id);
        AuthRoleVO authRoleVO = MapperUtils.mapperBean(authRolePO, AuthRoleVO.class);
        return authRoleVO;
    }

    /****
     * 用户信息分页查询
     *
     * @param getAuthUserInfoDTO
     * @param pageParam
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public PageResult getUserInfoList(GetAuthUserInfoDTO getAuthUserInfoDTO, PageParam pageParam) {
        Page<AuthUserInfoListVO> page = PageHelper.startPage(pageParam.getP(), pageParam.getC());
        //查询数据
        getAuthUserInfoDTO.setIsDelete(DeleteEnum.ENABLE.getStatus());
        List<AuthUserInfoListVO> authUserInfoListVOList = authUserQueryMapper.selectUserInfoList(getAuthUserInfoDTO);
        //取分页信息
        int total = (int) page.getTotal();
        //分页类
        PageResult pageResult = pageResultFactory.createPageResult(pageParam.getP(), total, authUserInfoListVOList);
        return pageResult;
    }

    /**
     * 角色分页查询
     *
     * @param getAuthRoleDTO
     * @param pageParam
     * @return PageResult
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public PageResult getRoleList(GetAuthRoleDTO getAuthRoleDTO, PageParam pageParam) {
        Page<AuthUserInfoListVO> page = PageHelper.startPage(pageParam.getP(), pageParam.getC());
        //查询数据
        getAuthRoleDTO.setIsDelete(DeleteEnum.ENABLE.getStatus());
        List<AuthRoleVO> authRoleVOList = authUserQueryMapper.selectRoleInfoList(getAuthRoleDTO);
        //取分页信息
        int total = (int) page.getTotal();
        //分页类
        PageResult pageResult = pageResultFactory.createPageResult(pageParam.getP(), total, authRoleVOList);
        return pageResult;
    }

    /**
     * 获取分配权限时候回显数据 和所有角色数据
     *
     * @param getAuthRoleEchoAndAllDTO
     * @return GetAuthUserRoleVO
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public GetAuthUserRoleVO selectEchoRoleAndAllRole(GetAuthRoleEchoAndAllDTO getAuthRoleEchoAndAllDTO) {
        //查询回显数据
        getAuthRoleEchoAndAllDTO.setIsDelete(DeleteEnum.ENABLE.getStatus());
        List<AuthRoleEchoVO> authRoleEchoVO = authUserQueryMapper.selectRolesForEcho(getAuthRoleEchoAndAllDTO);
        //查询所有未删除的角色数据
        GetAuthRoleDTO getAuthRoleDTO = MapperUtils.mapperBean(getAuthRoleEchoAndAllDTO, GetAuthRoleDTO.class);
        List<AuthRoleVO> authRoleVOList = authUserQueryMapper.selectRoleInfoList(getAuthRoleDTO);
        //封装返回数据
        GetAuthUserRoleVO getAuthUserRoleVO = new GetAuthUserRoleVO();
        getAuthUserRoleVO.setAuthRoleVO(authRoleVOList);
        getAuthUserRoleVO.setAuthRoleEchoVO(authRoleEchoVO);
        return getAuthUserRoleVO;
    }

    /***
     * 分配角色使用方法
     * @param addAuthUserRoleDTO
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addAuthUserRole(AddAuthUserRoleDTO addAuthUserRoleDTO) {
        authUserCUDMapper.deleteUserRole(addAuthUserRoleDTO.getUserId());
        addAuthUserRoleDTO.getRoleIds().stream().forEach(s -> {
            AuthUserRolePO authUserRolePO = new AuthUserRolePO();
            authUserRolePO.setRoleId(s);
            authUserRolePO.setUserId(addAuthUserRoleDTO.getUserId());
            authUserCUDMapper.addUserRole(authUserRolePO);
        });
    }

    /**
     * 查询当前登录用户的信息和所拥有的权限
     *
     * @param getAuthFunctionDTO
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public AuthUserGetFuntionInfoVO getLoginUserFuntionIn(GetAuthFunctionDTO getAuthFunctionDTO) {
        //查询用户信息
        AuthUserInfoDTO authUserInfoDTO = MapperUtils.mapperBean(getAuthFunctionDTO, AuthUserInfoDTO.class);
        AuthUserInfoPO authUserInfoPO = authUserQueryMapper.selectUserInfoOne(authUserInfoDTO);
        AuthUserGetFuntionInfoVO authUserGetFuntionInfoVO = MapperUtils.mapperBean(authUserInfoPO, AuthUserGetFuntionInfoVO.class);
        //查询对应权限
        authUserGetFuntionInfoVO.setAuthFunctionVOList(getFunctionByUserId(getAuthFunctionDTO));
        return authUserGetFuntionInfoVO;
    }

    /**
     * 查询当前登录用户的权限
     *
     * @param getAuthFunctionDTO
     * @return
     */
    private List<AuthFunctionVO> getFunctionByUserId(GetAuthFunctionDTO getAuthFunctionDTO) {
        List<AuthFunctionVO> authFunctionVOS = authUserQueryMapper.getFunctioChild(getAuthFunctionDTO.getUserId());
        List<AuthFunctionVO> treeList = createMenuTreeList(authFunctionVOS);
        return treeList;

    }

    public List<AuthFunctionVO> createMenuTreeList(List<AuthFunctionVO> rootMenu) {
        // 最后的结果
        List<AuthFunctionVO> menuList = new ArrayList<AuthFunctionVO>();
        // 先找到所有的一级菜单
        for (int i = 0; i < rootMenu.size(); i++) {
            // 一级菜单没有parentId
            System.err.print(rootMenu.get(i).getParentId());
            if (rootMenu.get(i).getParentId() == 0) {
                menuList.add(rootMenu.get(i));
            }
        }
        // 为一级菜单设置子菜单，getChild是递归调用的
        for (AuthFunctionVO authFunctionVO : menuList) {
            authFunctionVO.setAuthFunctionVOChild(getChild(authFunctionVO.getId(), rootMenu));
        }
        return menuList;
    }

    /**
     * 递归查找子菜单
     *
     * @param id
     *            当前菜单id
     * @param rootMenu
     *            要查找的列表
     * @return
     */
    private List<AuthFunctionVO> getChild(Long id, List<AuthFunctionVO> rootMenu) {
        // 子菜单
        List<AuthFunctionVO> childList = new ArrayList<AuthFunctionVO>();
        for (AuthFunctionVO authFunctionVO : rootMenu) {
            // 遍历所有节点，将父菜单id与传过来的id比较
            if (!Objects.equals(authFunctionVO.getParentId(), 0)) {
                if (authFunctionVO.getParentId().equals(id)) {
                    childList.add(authFunctionVO);
                }
            }
        }
        // 把子菜单的子菜单再循环一遍
        for (AuthFunctionVO authFunctionVO : childList) {
            // 没有url子菜单还有子菜单
            if (StringUtils.isBlank(authFunctionVO.getUrl())) {
                // 递归
                authFunctionVO.setAuthFunctionVOChild(getChild(authFunctionVO.getId(), rootMenu));
            }
        } // 递归退出条件
        if (childList.size() == 0) {
            return null;
        }
        return childList;
    }

    /**
     *配权限时回显数据，返回所有系统权限方法
     *
     * @param getAuthFunctionDTO
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public AuthFunctionForUserAndAllVO getAllfunction(GetAuthFunctionDTO getAuthFunctionDTO) {
        //所要非配人的拥有权限（回显数据）
        List<AuthFunctionVO> assginFuncUser = getFunctionByUserId(getAuthFunctionDTO);

        //查询所有权限
        List<AuthFunctionVO> authFunctionVOS = authUserQueryMapper.getAllFunctio();
        //递归操作
        List<AuthFunctionVO> treeList = createMenuTreeList(authFunctionVOS);
        AuthFunctionForUserAndAllVO authFunctionForUserAndAllVO = new  AuthFunctionForUserAndAllVO();
        authFunctionForUserAndAllVO.setAllFunctions(treeList);
        authFunctionForUserAndAllVO.setUserfucntions(assginFuncUser);
        return authFunctionForUserAndAllVO;
    }

    /***
     * 分配权限方法
     * @param addAuthRoleFunctionDTO
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addAuthRoleFucntion(AddAuthRoleFunctionDTO addAuthRoleFunctionDTO) {
        authUserCUDMapper.deleteRoleFuncion(addAuthRoleFunctionDTO.getRoleId());
        List<AuthRoleFunctionPO> authRoleFunctionPOS = new ArrayList<AuthRoleFunctionPO>();
        addAuthRoleFunctionDTO.getFunctionIds().stream().forEach(s -> {
            AuthRoleFunctionPO authRoleFunctionPO = new AuthRoleFunctionPO();
            authRoleFunctionPO.setRoleId(addAuthRoleFunctionDTO.getRoleId());
            authRoleFunctionPO.setFunctionId(s);
            authRoleFunctionPOS.add(authRoleFunctionPO);
        });
        authUserCUDMapper.addRoleFunction(authRoleFunctionPOS);
    }

}
