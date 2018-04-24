package com.bgy.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Configuration;

/**
* @author yyg
* @date 2018/4/24 19:51
* @desc 当前登录用户信息类
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Configuration
public class UserBaseInfoDTO {

    //主键
    private Long id;

    //用户名称
    private String userName;

    //用户联系电话
    private String userPhone;
}
