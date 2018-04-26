package com.bgy.entity.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;

/**
 * @author yyg
 * @date 2018/4/23 17:32
 * @desc 管理员创建用户使用DTO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddUserDTO {

    @ApiModelProperty(value = "用户基本信息", example = "")
    @Valid
    private AuthUserInfoDTO authUserInfoDTO;

    @ApiModelProperty(value = "用户登录校验信息", example = "")
    @Valid
    private AuthUserLoginDTO authUserLoginDTO;

    @ApiModelProperty(value = "用户登录校验信息", example = "", hidden = true)
    private String createBy;


}
