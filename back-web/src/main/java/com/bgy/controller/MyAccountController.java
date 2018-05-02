package com.bgy.controller;

import com.bgy.common.dto.UserBaseInfoDTO;
import com.bgy.common.utils.apiresult.AbstractApiResult;
import com.bgy.entity.dto.GetAuthFunctionDTO;
import com.bgy.entity.vo.AuthUserGetFuntionInfoVO;
import com.bgy.service.AuthUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author yyg
 * @date 2018/4/23 18:47
 * @desc  我的账户设置中心
 */
@RestController
@Api(value = "back", tags = {"account"})
@RequestMapping(value = "/account/info")
public class MyAccountController {

    @Autowired
    private AuthUserService authUserService;

    @Resource
    UserBaseInfoDTO userBaseInfoDTO;

    @RequestMapping(value = "/getloginuserfunction", method = RequestMethod.GET)
    @ApiOperation(value = "获取当前登录人的信息以及权限方法", produces = "application/json")
    public AbstractApiResult getLoginUserFunction() {
        GetAuthFunctionDTO getAuthFunctionDTO = new GetAuthFunctionDTO();
        getAuthFunctionDTO.setUserId(userBaseInfoDTO.getId());
        AuthUserGetFuntionInfoVO result = authUserService.getLoginUserFuntionIn(getAuthFunctionDTO);
        return AbstractApiResult.success(result);
    }


    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    @ApiOperation(value = "登出方法", produces = "application/json")
    public AbstractApiResult logout(HttpServletRequest request, HttpServletResponse response) {
        authUserService.logout(request, response);
        return AbstractApiResult.success("");
    }

}
