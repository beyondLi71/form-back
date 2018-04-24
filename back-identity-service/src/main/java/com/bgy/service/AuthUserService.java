package com.bgy.service;

import com.bgy.common.utils.apiresult.AbstractApiResult;
import com.bgy.entity.dto.AuthUserLoginDTO;
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
}
