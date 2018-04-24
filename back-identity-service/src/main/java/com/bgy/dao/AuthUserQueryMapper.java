package com.bgy.dao;

import com.bgy.entity.dto.AuthUserLoginDTO;
import com.bgy.entity.po.AuthUserPO;
import org.apache.ibatis.annotations.Select;

/**
* @author yyg
* @date 2018/4/23 17:36
* @desc
*/
public interface AuthUserQueryMapper {

    /**
     * 通过用户名获取登录用户信息
     * @param loginDTO
     * @return AuthUserPO
     */
    @Select("select id,name,pwd from auth_user where name=#{name} and pwd=#{pwd}")
    AuthUserPO selectUserInfoOne(AuthUserLoginDTO loginDTO);
}
