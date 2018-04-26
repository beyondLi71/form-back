package com.bgy.entity.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
* @author yyg
* @date 2018/4/25 10:49
* @desc  系统角色实体
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthRolePO {

    //主键
    private Long id;

    //用户名
    private String name;

    // 创建时间
    private LocalDateTime createTime;

    //创建人
    private String createBy;

    //修改时间
    private LocalDateTime updateTime;

    //修改人
    private String updateBy;

    //是否删除 DISABLE:已删除 ENABLE:未删除
    private String isDelete;
}
