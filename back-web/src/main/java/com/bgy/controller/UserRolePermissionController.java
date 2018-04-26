package com.bgy.controller;

import com.bgy.common.dto.UserBaseInfoDTO;
import com.bgy.common.utils.apiresult.AbstractApiResult;
import com.bgy.common.utils.page.PageParam;
import com.bgy.common.utils.page.PageResult;
import com.bgy.entity.dto.*;
import com.bgy.entity.vo.*;
import com.bgy.service.AuthUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author yyg
 * @date 2018/4/25 14:38
 * @desc 用户、角色、权限控制层
 */
@RestController
@Api(value = "back", tags = {"user"})
@RequestMapping(value = "/identity")
public class UserRolePermissionController {

    @Autowired
    private AuthUserService authUserService;

    @Resource
    UserBaseInfoDTO userBaseInfoDTO;

    @RequestMapping(value = "/user/adduserinfo", method = RequestMethod.POST)
    @ApiOperation(value = "新增用户方法", produces = "application/json")
    public AbstractApiResult addUserInfo(@RequestBody AddUserDTO userDTO) throws Exception {
        userDTO.setCreateBy(userBaseInfoDTO.getId().toString());
        authUserService.addUserInfo(userDTO);
        return AbstractApiResult.success("success");
    }

    @RequestMapping(value = "/user/deleteuserinforbyid", method = RequestMethod.DELETE)
    @ApiOperation(value = "删除用户方法", produces = "application/json")
    public AbstractApiResult deleteUserinFoRById(@RequestBody DeleteAuthUserInfoDTO deleteAuthUserInfoDTO) {
        deleteAuthUserInfoDTO.setUpdateBy(userBaseInfoDTO.getId().toString());
        authUserService.deteleUserInfo(deleteAuthUserInfoDTO);
        return AbstractApiResult.success("success");
    }

    @RequestMapping(value = "/user/getuserinfobyid{id}", method = RequestMethod.GET)
    @ApiOperation(value = "单个用户获取信息方法", produces = "application/json")
    public AbstractApiResult getUserInfoById(@PathVariable Long id) {
        AuthUserInfoVO result = authUserService.getUserInfoOne(id);
        return AbstractApiResult.success(result);
    }

    @RequestMapping(value = "/user/updateuserinfobyid", method = RequestMethod.PUT)
    @ApiOperation(value = "修改单个用户方法", produces = "application/json")
    public AbstractApiResult updateUserInfoById(@RequestBody UpdateAuthUserInfoDTO updateAuthUserInfoDTO) {
        updateAuthUserInfoDTO.setUpdateBy(userBaseInfoDTO.getId().toString());
        authUserService.updateUserInfo(updateAuthUserInfoDTO);
        return AbstractApiResult.success("success");
    }


    @RequestMapping(value = "/user/getuserinfolist", method = RequestMethod.POST)
    @ApiOperation(value = "查看用户列表", produces = "application/json")
    public AbstractApiResult getUserInfolist(@RequestBody GetAuthUserInfoDTO getAuthUserInfoDTO, @ModelAttribute PageParam pageParam) {
        PageResult pageResult = authUserService.getUserInfoList(getAuthUserInfoDTO, pageParam);
        return AbstractApiResult.success(pageResult);
    }


    @RequestMapping(value = "/role/addrole", method = RequestMethod.POST)
    @ApiOperation(value = "新增角色方法", produces = "application/json")
    public AbstractApiResult addRole(@RequestBody AuthRoleDTO authRoleDTO) {
        authRoleDTO.setCreateBy(userBaseInfoDTO.getId().toString());
        authUserService.addAuthRole(authRoleDTO);
        return AbstractApiResult.success("success");
    }

    @RequestMapping(value = "/role/deleterolebyid", method = RequestMethod.DELETE)
    @ApiOperation(value = "删除角色方法", produces = "application/json")
    public AbstractApiResult deleteRoleById(@RequestBody DeleteAuthRoleDTO deleteAuthRoleDTO) {
        deleteAuthRoleDTO.setUpdateBy(userBaseInfoDTO.getId().toString());
        authUserService.deteleAuthRole(deleteAuthRoleDTO);
        return AbstractApiResult.success("success");
    }

    @RequestMapping(value = "/role/getRoleById/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "单个角色获取信息方法", produces = "application/json")
    public AbstractApiResult getRoleById(@PathVariable Long id) {
        AuthRoleVO result = authUserService.getRoleOne(id);
        return AbstractApiResult.success(result);
    }

    @RequestMapping(value = "/role/updaterolebyid", method = RequestMethod.PUT)
    @ApiOperation(value = "修改单个角色方法", produces = "application/json")
    public AbstractApiResult updateRoleById(@RequestBody UpdateAuthRoleDTO updateAuthRoleDTO) {
        updateAuthRoleDTO.setUpdateBy(userBaseInfoDTO.getId().toString());
        authUserService.updateAuthRole(updateAuthRoleDTO);
        return AbstractApiResult.success("success");
    }

    @RequestMapping(value = "/role/getrolelist", method = RequestMethod.POST)
    @ApiOperation(value = "查看角色列表", produces = "application/json")
    public AbstractApiResult getRolelist(@RequestBody GetAuthRoleDTO getAuthUserInfoDTO, @ModelAttribute PageParam pageParam) {
        PageResult pageResult = authUserService.getRoleList(getAuthUserInfoDTO, pageParam);
        return AbstractApiResult.success(pageResult);
    }

    @RequestMapping(value = "/role/getechoroleandall", method = RequestMethod.POST)
    @ApiOperation(value = "获取用户角色回显和所有角色", produces = "application/json")
    public AbstractApiResult getEchoRoleAndAll(@RequestBody GetAuthRoleEchoAndAllDTO getAuthRoleEchoAndAllDTO) {
        GetAuthUserRoleVO result = authUserService.selectEchoRoleAndAllRole(getAuthRoleEchoAndAllDTO);
        return AbstractApiResult.success(result);
    }

    @RequestMapping(value = "/role/assignrole", method = RequestMethod.PUT)
    @ApiOperation(value = "分配角色方法", produces = "application/json")
    public AbstractApiResult assignRole(@RequestBody AddAuthUserRoleDTO addAuthUserRoleDTO) {
        authUserService.addAuthUserRole(addAuthUserRoleDTO);
        return AbstractApiResult.success("success");
    }


    @RequestMapping(value = "/user/getloginuserfunction", method = RequestMethod.POST)
    @ApiOperation(value = "获取当前登录人的信息以及权限方法", produces = "application/json")
    public AbstractApiResult getLoginUserFunction() {
        GetAuthFunctionDTO getAuthFunctionDTO = new GetAuthFunctionDTO();
        getAuthFunctionDTO.setUserId(userBaseInfoDTO.getId());
        AuthUserGetFuntionInfoVO result = authUserService.getLoginUserFuntionIn(getAuthFunctionDTO);
        return AbstractApiResult.success(result);
    }

    @RequestMapping(value = "/function/getallfunctionforassignuser", method = RequestMethod.POST)
    @ApiOperation(value = "获取当前需要分配人的权限回显，同时获取所有权限方法", produces = "application/json")
    public AbstractApiResult getAssignUserFAndAllFunc(@RequestBody  GetAuthFunctionDTO getAuthFunctionDTO) {
        AuthFunctionForUserAndAllVO result = authUserService.getAllfunction(getAuthFunctionDTO);
        return AbstractApiResult.success(result);
    }

    @RequestMapping(value = "/function/assignfucntion", method = RequestMethod.POST)
    @ApiOperation(value = "分配权限方法", produces = "application/json")
    public AbstractApiResult assignFucntion(@RequestBody AddAuthRoleFunctionDTO addAuthRoleFunctionDTO) {
        authUserService.addAuthRoleFucntion(addAuthRoleFunctionDTO);
        return AbstractApiResult.success("success");
    }

}


