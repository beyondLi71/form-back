package com.bgy.dao;

import com.bgy.entity.po.*;
import org.apache.ibatis.annotations.*;

import java.util.List;

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

    /***
     * 添加用户登录信息
     * @param authUserPO
     */
    @Insert("INSERT  INTO  auth_user(name,pwd) VALUES (#{name},#{pwd}) ")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void addAuthUser(AuthUserPO authUserPO);

    /**
     * 添加用户基本信息
     *
     * @param authUserInfoPO
     */
    @Insert("INSERT  INTO auth_user_info(user_id,user_name,user_phone,create_time,create_by)"
            + "VALUES (#{userId},#{userName},#{userPhone},#{createTime},#{createBy}); ")
    void addAuthUserInfo(AuthUserInfoPO authUserInfoPO);

    /**
     * 添加角色
     *
     * @param authRolePO
     */
    @Insert("INSERT into auth_role (name,create_time,create_by)"
            + " VALUES (#{name},#{createTime},#{createBy}) ")
    void addAuthRole(AuthRolePO authRolePO);

    /**
     * 修改用户基本信息
     *
     * @param authUserInfoPO
     */
    @Update("UPDATE  auth_user_info SET user_name=#{userName},user_phone=#{userPhone},"
            + "update_by=#{updateBy},update_time =#{updateTime} WHERE id=#{id}")
    void updateAuthUserInfo(AuthUserInfoPO authUserInfoPO);

    /**
     * 修改系统角色
     *
     * @param authRolePO
     */
    @Update(" update auth_role set name = #{name},update_time = #{updateTime},update_by = #{updateBy}"
            + " WHERE id = #{id}")
    void updateAuthRole(AuthRolePO authRolePO);

    /**
     * 删除用户（逻辑删除）
     *
     * @param authUserInfoPO
     */
    @Update("UPDATE  auth_user_info SET is_delete=#{isDelete},update_time = #{updateTime},update_by = #{updateBy}"
            + "WHERE id=#{id}")
    void deteleAuthUserInfo(AuthUserInfoPO authUserInfoPO);

    /**
     * 删除角色（逻辑删除）
     *
     * @param authRolePO
     */
    @Update("update auth_role set is_delete=#{isDelete},update_time = #{updateTime},update_by = #{updateBy}"
            + "WHERE id = #{id}")
    void deteleAuthRole(AuthRolePO authRolePO);

    /**
     * 写入用户与角色关联表
     *
     * @param authUserRolePO
     */
    @Insert("INSERT into auth_user_role (role_id,user_id) VALUES (#{roleId},#{userId}) ")
    void addUserRole(AuthUserRolePO authUserRolePO);

    /**
     * 根据用户id删除 用户与角色的关联信息
     *
     * @param userId
     */
    @Delete("DELETE from auth_user_role WHERE user_id=#{userId}")
    void deleteUserRole(Long userId);

    /**
     * 根据角色id删除 角色与权限的关联信息
     *
     * @param roleId
     */
    @Delete("DELETE from auth_role_function WHERE role_id=#{roleId}")
    void deleteRoleFuncion(Long roleId);

    /**
     * 写入角色权限关联表
     *
     * @param authRoleFunctionPOS
     */
    @Insert("<script> insert  into auth_role_function(role_id,function_id) values "
            + "<foreach collection = \"list\" item = \"po\" index = \"index\" separator = \",\"> "
            + "(#{po.roleId}, #{po.functionId} ) "
            + "</foreach>"
            + "</script>")
    void addRoleFunction(@Param("list") List<AuthRoleFunctionPO> authRoleFunctionPOS);

}

