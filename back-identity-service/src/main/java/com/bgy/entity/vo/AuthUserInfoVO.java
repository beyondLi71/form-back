package com.bgy.entity.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author yyg
 * @date 2018/4/23 17:32
 * @desc 用户基本信息实体VO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthUserInfoVO {

    //主键
    private Long id;

    //用户id
    private Long userId;

    //用户名字
    private String userName;

    //用户联系电话
    private String userPhone;

    // 创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    //创建人
    private Long createBy;

    //修改时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

    //修改人
    private Long updateBy;

    //是否删除 DISABLE:已删除 ENABLE:未删除
    private String isDelete;
}
