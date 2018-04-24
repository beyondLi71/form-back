package com.bgy.entity.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author yyg
 * @date 2018/4/23 17:32
 * @desc 用户登录验证实体
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthUserLoginDTO {

    @ApiModelProperty(value = "用户名", example = "")
    @NotBlank(message = "IDEN_ERR_0001")
    private String name;

    @ApiModelProperty(value = "用户密码", example = "")
    @NotBlank(message = "IDEN_ERR_0002")
    private String pwd;

}
