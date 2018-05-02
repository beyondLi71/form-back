package com.bgy.entity.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
* @author yyg
* @date 2018/4/26 11:12
* @desc  权限分页DTO实体
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAuthFunctionListDTO {

    @ApiModelProperty(value = "菜单名称", example = "", hidden = true)
    private String name;

    @ApiModelProperty(value = "路径", example = "", hidden = true)
    private String url;

    @ApiModelProperty(value = "创建时间", example = "", hidden = true)
    private LocalDateTime createTime;




}
