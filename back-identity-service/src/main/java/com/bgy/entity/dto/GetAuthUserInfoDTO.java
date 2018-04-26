package com.bgy.entity.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author yyg
 * @date 2018/4/23 17:32
 * @desc 用户基本信息分页入参实体DTO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAuthUserInfoDTO {

    //用户名字
    @ApiModelProperty(value = "用户名称", example = "")
    private String userName;

    //用户联系电话
    @ApiModelProperty(value = "用户联系电话", example = "")
    private String userPhone;

    // 创建时间
    @ApiModelProperty(value = "创建时间", example = "")
    private LocalDateTime createTime;

//    //创建人
//    @ApiModelProperty(value = "创建人", example = "")
//    private String createBy;
//
//    //修改时间
//    @ApiModelProperty(value = "修改时间", example = "")
//    private LocalDateTime updateTime;
//
//    //修改人
//    @ApiModelProperty(value = "修改人", example = "")
//    private String updateBy;

    //是否删除 DISABLE:已删除 ENABLE:未删除
    @ApiModelProperty(value = "是否删除", example = "", hidden = true)
    private String isDelete;
}
