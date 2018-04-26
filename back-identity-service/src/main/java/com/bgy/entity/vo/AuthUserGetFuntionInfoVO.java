package com.bgy.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author yyg
 * @date 2018/4/23 17:32
 * @desc 查询当前登录用户的信息和所拥有的权限实体
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "查询当前登录用户的信息和所拥有的权限实体")
public class AuthUserGetFuntionInfoVO {

    //主键
    @ApiModelProperty(value = "主键", example = "")
    private Long id;

    //用户id
    @ApiModelProperty(value = "用户id", example = "")
    private Long userId;

    //用户名字
    @ApiModelProperty(value = "用户名字", example = "")
    private String userName;

    //用户联系电话
    @ApiModelProperty(value = "用户联系电话", example = "")
    private String userPhone;

    //该用户所有的权限
    @ApiModelProperty(value = "该用户所有的权限", example = "")
    private List<AuthFunctionVO> authFunctionVOList;
}
