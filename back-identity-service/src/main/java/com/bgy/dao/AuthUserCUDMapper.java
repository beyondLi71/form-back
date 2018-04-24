package com.bgy.dao;

import com.bgy.entity.po.AuthUserTokenLogPO;
import com.bgy.entity.po.AuthUserTokenPO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

/**
 * @author yyg
 * @date 2018/4/23 17:36
 * @desc 用户认证dao层
 */
public interface AuthUserCUDMapper {

    /**
     * 添加用户token
     *
     * @param authUserTokenPO
     */
    @Insert("insert  into auth_user_token (user_id,token,user_create_time,create_time,create_by) values"
            + "(#{userId},#{token},#{userCreateTime},#{createTime},#{createBy}) ")
    void addUserToken(AuthUserTokenPO authUserTokenPO);

    /**
     * 添加用户token历史记录
     *
     * @param authUserTokenLogPO
     */
    @Insert("insert  into auth_user_token_log (user_id,user_create_time,user_lose_time,token,create_time,create_by) values"
            + "(#{userId},#{userCreateTime},#{userLoseTime},#{token},#{createTime},#{createBy}) ")
    void addUserTokenLog(AuthUserTokenLogPO authUserTokenLogPO);

    /**
     * 更新用户的token创建时间
     *
     * @param authUserTokenPO
     */
    @Update("UPDATE  auth_user_token SET user_create_time =#{userCreateTime} WHERE id=#{id} and token=#{token} ")
    void updateUserToken(AuthUserTokenPO authUserTokenPO);


}
