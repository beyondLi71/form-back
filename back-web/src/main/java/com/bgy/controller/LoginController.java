package com.bgy.controller;

import com.bgy.common.utils.apiresult.AbstractApiResult;
import com.bgy.entity.dto.AuthUserLoginDTO;
import com.bgy.service.AuthUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author yyg
 * @date 2018/4/23 18:47
 * @desc 获取和删除token的请求地址
 */
@RestController
@Api(value = "back", tags = {"identity"})
@RequestMapping(value = "/index")
public class LoginController {

    @Autowired
    private AuthUserService authUserService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ApiOperation(value = "登录方法", produces = "application/json")
    public AbstractApiResult login(HttpServletResponse response, @RequestBody AuthUserLoginDTO dto) throws Exception {
        AbstractApiResult result = authUserService.loginCheck(dto, response);
        return result;
    }


    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    @ApiOperation(value = "登出方法", produces = "application/json")
    public AbstractApiResult logout(HttpServletRequest request, HttpServletResponse response) {
        authUserService.logout(request, response);
        return AbstractApiResult.success("success");
    }

}
