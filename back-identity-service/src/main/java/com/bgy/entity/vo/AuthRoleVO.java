package com.bgy.entity.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
* @author yyg
* @date 2018/4/25 10:49
* @desc  系统角色实体VO
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "角色列表实体")
public class AuthRoleVO {

    //主键
    @ApiModelProperty(value = "主键", example = "")
    private Long id;

    //角色名称
    @ApiModelProperty(value = "角色名称", example = "")
    private String name;

    // 创建时间
    @ApiModelProperty(value = "创建时间", example = "")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    //创建人
    @ApiModelProperty(value = "创建人", example = "")
    private String createBy;

    //修改时间
    @ApiModelProperty(value = "修改时间", example = "")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

    //修改人
    @ApiModelProperty(value = "修改人", example = "")
    private String updateBy;

    //是否删除 DISABLE:已删除 ENABLE:未删除
    @ApiModelProperty(value = "是否删除", example = "")
    private String isDelete;
}
