package com.bgy.dao;

import com.bgy.entity.dto.AuthUserInfoDTO;
import com.bgy.entity.dto.AuthUserLoginDTO;
import com.bgy.entity.po.AuthUserInfoPO;
import com.bgy.entity.po.AuthUserPO;
import com.bgy.entity.vo.AuthUserTokenVO;
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

    /**
     * 查询用户token信息
     * @param token
     * @return
     */
    @Select("SELECT id,user_id,token,user_create_time FROM auth_user_token WHERE token=#{token}")
    AuthUserTokenVO selectTokenInfoOne(String token);

    /**
     * 查询用户基本信息
     * @param authUserInfoDTO
     * @return
     */
    @Select("SELECT id,user_id,user_name,user_phone FROM auth_user_info WHERE user_id=#{userId}")
    AuthUserInfoPO selectUeerInfoOne(AuthUserInfoDTO authUserInfoDTO);
}
