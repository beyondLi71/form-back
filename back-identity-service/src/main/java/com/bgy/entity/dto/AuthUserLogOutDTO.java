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
public class AuthUserLogOutDTO {

    @ApiModelProperty(value = "token", example = "")
    @NotBlank(message = "IDEN_ERR_0003")
    private String token;

}
