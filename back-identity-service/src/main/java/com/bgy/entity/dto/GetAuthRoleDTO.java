package com.bgy.entity.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
* @author yyg
* @date 2018/4/25 10:49
* @desc  系统角色分页入参实体DTO
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAuthRoleDTO {

    //角色名称
    @ApiModelProperty(value = "角色名称", example = "")
    private String name;

    // 创建时间
    @ApiModelProperty(value = "创建时间", example = "")
    private LocalDateTime createTime;

    //创建人
    @ApiModelProperty(value = "创建人", example = "", hidden = true)
    private String createBy;

    //修改时间
    @ApiModelProperty(value = "修改时间", example = "", hidden = true)
    private LocalDateTime updateTime;

    //修改人
    @ApiModelProperty(value = "修改人", example = "", hidden = true)
    private String updateBy;

    //是否删除 DISABLE:已删除 ENABLE:未删除
    @ApiModelProperty(value = "是否删除", example = "", hidden = true)
    private String isDelete;
}
