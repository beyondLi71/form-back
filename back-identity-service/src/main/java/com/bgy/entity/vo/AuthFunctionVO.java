package com.bgy.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
* @author yyg
* @date 2018/4/26 11:12
* @desc  权限实体
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthFunctionVO {

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

    private Long userId;

    List<AuthFunctionVO> authFunctionVOChild;

}
