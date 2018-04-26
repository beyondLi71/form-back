package com.bgy.service;

import com.bgy.common.utils.apiresult.AbstractApiResult;
import com.bgy.common.utils.page.PageParam;
import com.bgy.common.utils.page.PageResult;
import com.bgy.entity.dto.*;
import com.bgy.entity.po.AuthUserInfoPO;
import com.bgy.entity.vo.*;
import org.springframework.validation.annotation.Validated;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * @author yyg
 * @date 2018/4/23 19:00
 * @desc 用户验证操作接口
 */
@Validated
public interface AuthUserService {

    AbstractApiResult loginCheck(@Valid AuthUserLoginDTO dto, HttpServletResponse response) throws Exception;

    void logout(HttpServletRequest request, HttpServletResponse response);

    AuthUserInfoPO getLoginUserInfo(String token);

    void addUserInfo(@Valid AddUserDTO userDTO) throws Exception;

    void addAuthRole(@Valid AuthRoleDTO authRoleDTO);

    void updateUserInfo(@Valid UpdateAuthUserInfoDTO updateAuthUserInfoDTO);

    void updateAuthRole(@Valid UpdateAuthRoleDTO updateAuthRoleDTO);

    void deteleUserInfo(@Valid DeleteAuthUserInfoDTO deleteAuthUserInfoDTO);

    void deteleAuthRole(@Valid DeleteAuthRoleDTO deleteAuthRoleDTO);

    AuthUserInfoVO getUserInfoOne(Long id);

    AuthRoleVO getRoleOne(Long id);

    PageResult getUserInfoList(GetAuthUserInfoDTO getAuthUserInfoDTO, PageParam pageParam);

    PageResult getRoleList(GetAuthRoleDTO getAuthRoleDTO, PageParam pageParam);

    void addAuthUserRole(@Valid AddAuthUserRoleDTO addAuthUserRoleDTO);

    GetAuthUserRoleVO selectEchoRoleAndAllRole(@Valid GetAuthRoleEchoAndAllDTO getAuthRoleEchoAndAllDTO);

    AuthUserGetFuntionInfoVO getLoginUserFuntionIn(GetAuthFunctionDTO getAuthFunctionDTO);

    AuthFunctionForUserAndAllVO getAllfunction(@Valid GetAuthFunctionDTO getAuthFunctionDTO);

     void  addAuthRoleFucntion(AddAuthRoleFunctionDTO addAuthRoleFunctionDTO);

}
