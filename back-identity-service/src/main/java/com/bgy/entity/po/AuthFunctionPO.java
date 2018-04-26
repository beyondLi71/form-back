package com.bgy.entity.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
* @author yyg
* @date 2018/4/26 11:12
* @desc  权限实体
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthFunctionPO {

    //主键
    private Long id;

    //菜单名称
    private String name;

    //父id
    private Long parentId;

    //请求路径
    private String url;

    //排序
    private Integer serialNum;

    //是否是顶级菜单
    private String accordion;

    // 创建时间
    private LocalDateTime createTime;

    //创建人
    private String createBy;

    //修改时间
    private LocalDateTime updateTime;

    //修改人
    private String updateBy;

    //级别
    private Integer level;


}
