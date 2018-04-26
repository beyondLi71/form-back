package com.bgy.entity.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * @author yyg
 * @date 2018/4/23 17:32
 * @desc 用户基本信息实体DTO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateAuthUserInfoDTO {

    //主键
    @ApiModelProperty(value = "主键", example = "")
    @NotNull(message = "IDEN_ERR_0009")
    private Long id;

    //用户id
    @ApiModelProperty(value = "用户ID", example = "", hidden = true)
    private Long userId;

    //用户名字
    @ApiModelProperty(value = "用户名称", example = "")
    @NotBlank(message = "IDEN_ERR_0002")
    private String userName;

    //用户联系电话
    @ApiModelProperty(value = "用户联系电话", example = "")
    @NotBlank(message = "IDEN_ERR_0006")
    private String userPhone;

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
