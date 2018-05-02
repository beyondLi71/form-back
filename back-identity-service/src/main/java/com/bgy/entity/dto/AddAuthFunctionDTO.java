package com.bgy.entity.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

import java.time.LocalDateTime;

/**
 * @author yyg
 * @date 2018/4/25 10:49
 * @desc 系统添加权限实体DTO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddAuthFunctionDTO {

    @ApiModelProperty(value = "菜单名称", example = "")
    @NotBlank(message = "IDEN_ERR_0018")
    private String name;

    @ApiModelProperty(value = "父id（是根节点id为0）", example = "")
    private Long parentId;

    @ApiModelProperty(value = "路径", example = "")
    @NotBlank(message = "IDEN_ERR_0019")
    private String url;

//    private Integer serialNum;

    @ApiModelProperty(value = "是否为根节点YES:是 NO:否", example = "")
    private String accordion;

    @ApiModelProperty(value = "创建时间", example = "", hidden = true)
    private LocalDateTime createTime;

    @ApiModelProperty(value = "创建人", example = "", hidden = true)
    private String createBy;

    //级别
    @ApiModelProperty(value = "菜单级别", example = "", hidden = true)
    private Integer level;




}
