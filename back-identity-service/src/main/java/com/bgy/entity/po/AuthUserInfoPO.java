package com.bgy.entity.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author yyg
 * @date 2018/4/23 17:32
 * @desc 用户基本信息实体
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthUserInfoPO {

    //主键
    private Long id;

    //用户id
    private Long userId;

    //用户名字
    private String userName;

    //用户联系电话
    private String userPhone;

    // 创建时间
    private LocalDateTime createTime;

    //创建人
    private Long createBy;

    //修改时间
    private LocalDateTime updateTime;

    //修改人
    private Long updateBy;
}
