package com.bgy.dao;

import com.bgy.entity.dto.*;
import com.bgy.entity.po.AuthRolePO;
import com.bgy.entity.po.AuthUserInfoPO;
import com.bgy.entity.po.AuthUserPO;
import com.bgy.entity.vo.*;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author yyg
 * @date 2018/4/23 17:36
 * @desc
 */
public interface AuthUserQueryMapper {

    /**
     * 通过用户名获取登录用户信息
     *
     * @param loginDTO
     * @return AuthUserPO
     */
    //@Select("select id,name,pwd from auth_user where name=#{name} and pwd=#{pwd}")
    @Select(" SELECT a.id,a.name,a.pwd FROM auth_user AS a LEFT JOIN auth_user_info AS b ON a.id=b.user_id "
            + " WHERE a.name=#{name} and a.pwd=#{pwd} and b.is_delete=#{isDelete}")
    AuthUserPO selectLoginUserInfoOne(AuthUserLoginDTO loginDTO);

    /**
     * 查询用户token信息
     *
     * @param token
     * @return
     */
    @Select("SELECT id,user_id,token,user_create_time FROM auth_user_token WHERE token=#{token}")
    AuthUserTokenVO selectTokenInfoOne(String token);

    /**
     * 查询用户基本信息
     *
     * @param authUserInfoDTO
     * @return
     */
    @Select("SELECT id,user_id,user_name,user_phone FROM auth_user_info WHERE user_id=#{userId}")
    AuthUserInfoPO selectUserInfoOne(AuthUserInfoDTO authUserInfoDTO);

    /**
     * 通过主键查询用户基本信息
     *
     * @param id
     * @return
     */
    @Select("SELECT id,user_id,user_name,user_phone FROM auth_user_info WHERE id=#{id}")
    AuthUserInfoPO selectUserById(Long id);

    /**
     * 查询角色单挑信息
     *
     * @param id
     * @return
     */
    @Select("SELECT id, name, create_time, create_by, update_time, update_by, is_delete FROM  auth_role WHERE id=#{id}")
    AuthRolePO selectRoleInfoOne(Long id);

    /**
     * 查询 所有用户
     *
     * @param getAuthUserInfoDTO
     * @return
     */
    @Select("<script> SELECT a.id as id,a.user_name AS userName, b.name AS loginName,"
            + "a.user_phone AS userPhone,a.create_time AS createTime,a.is_delete as isDelete,a.user_id as userId"
            + " FROM  auth_user_info AS a LEFT JOIN auth_user AS b ON a.user_id=b.id"
            + "<where>"
            + "<if test = \"userPhone != null and userPhone != ''\" >and a.user_phone like \"%\"#{userPhone}\"%\"</if>"
            + "<if test = \"userName != null and userName != ''\" >and user_name like \"%\"#{userName}\"%\"</if>"
            + "<if test = \"createTime != null \" >and create_time = #{createTime}</if>"
            + "<if test = \"isDelete != null and isDelete !='' \" >and is_delete = #{isDelete}</if>"
            + "</where>"
            + "</script>")
    List<AuthUserInfoListVO> selectUserInfoList(GetAuthUserInfoDTO getAuthUserInfoDTO);

    /**
     * 查询所有角色
     *
     * @param getAuthRoleDTO
     * @return
     */
    @Select("<script> SELECT  id, name, create_time, create_by, update_time, update_by, is_delete"
            + " FROM  auth_role"
            + "<where>"
            + "<if test = \"name != null and name != ''\" >and name like \"%\"#{name}\"%\"</if>"
            + "<if test = \"createTime != null \" >and create_time = #{createTime}</if>"
            + "<if test = \"isDelete != null and isDelete !='' \" >and is_delete = #{isDelete}</if>"
            + "</where>"
            + "</script>")
    List<AuthRoleVO> selectRoleInfoList(GetAuthRoleDTO getAuthRoleDTO);

    /**
     * 分配角色时数据回显
     *
     * @param getAuthRoleEchoAndAllDTO
     * @return
     */
    @Select("SELECT  a.role_id AS id,b.name AS NAME  FROM auth_user_role AS a"
            + " LEFT JOIN auth_role AS b ON a.role_id =b.id WHERE a.user_id=#{userId} AND b.is_delete=#{isDelete}")
    List<AuthRoleEchoVO> selectRolesForEcho(GetAuthRoleEchoAndAllDTO getAuthRoleEchoAndAllDTO);

    /**
     * 检查登录名称唯一性
     *
     * @param name
     * @return
     */
    @Select("SELECT  COUNT(1) FROM  auth_user WHERE NAME=#{NAME}")
    int checkLoginNameOnly(String name);

    /**
     * 检查用户名字唯一性
     *
     * @param userName
     * @return
     */
    @Select("SELECT  COUNT(1) FROM  auth_user_info WHERE user_name=#{userName} and is_delete=#{isDelete}")
    int checkUserNameOnly(String userName, String isDelete);

    /**
     * 检查角色名称唯一性
     *
     * @param name
     * @return
     */
    @Select("SELECT  COUNT(1) FROM  auth_role WHERE NAME=#{name}")
    int checkRoleNameOnly(String name);


    /**
     * 检查是否有用户引用该角色
     *
     * @param roleId
     * @return
     */
    @Select("SELECT  COUNT(1) FROM auth_user_role WHERE role_id=#{roleId}")
    int checkUserQuoteRolenly(Long roleId);


    /**
     * 根据用户id返回所有菜单权限
     * @param userId
     * @return
     */
    @Select("SELECT a.id AS id ,c.user_id as userId,a.name AS NAME,a.parent_id AS parentId,a.url AS url,a.serial_num AS serialNum "
            +  "FROM  auth_function AS a LEFT JOIN auth_role_function AS b ON a.`id`=b.function_id "
            +  "LEFT JOIN auth_user_role AS c ON b.`role_id`=c.role_id "
            +  "LEFT JOIN auth_user_info AS d ON c.user_id=d.user_id WHERE d.user_id=#{userId} GROUP BY a.id ")
    List<AuthFunctionVO> getFunctioChild(Long  userId);

    /**
     * 所有菜单权限
     * @return  List<AuthFunctionVO>
     */
    @Select(" <script> SELECT id, name, parent_id, url,create_time "
            +  "FROM  auth_function "
            + "<where>"
            + "<if test = \"name != null and name != ''\" >and name like \"%\"#{name}\"%\"</if>"
            + "<if test = \"url != null and url != ''\" >and url like \"%\"#{url}\"%\"</if>"
            + "<if test = \"createTime != null \" >and create_time = #{createTime}</if>"
            + "</where>"
            + "</script>")
    List<AuthFunctionVO> getAllFunctio();



    /**
     * 所有菜单权限分页方法
     * @return  List<AuthFunctionVO>
     */
    @Select(" <script> SELECT id, name, parent_id as  parentId , url,create_time as createTime  "
            +  "FROM  auth_function "
            + "<where>"
            + "<if test = \"name != null and name != ''\" >and name like \"%\"#{name}\"%\"</if>"
            + "<if test = \"url != null and url != ''\" >and url like \"%\"#{url}\"%\"</if>"
            + "<if test = \"createTime != null \" >and create_time = #{createTime}</if>"
            + "</where>"
            + "</script>")
    List<AuthFunctionVO> getAllFunctioListPage(GetAuthFunctionListDTO getAuthFunctionListDTO);

    /**
     * 检查权限名称唯一性
     *
     * @param name
     * @return
     */
    @Select("SELECT  COUNT(1) FROM  auth_function WHERE NAME=#{name}")
    int checkFunctionNameOnly(String name);


    /**
     * 通过 角色id获取角色拥有的权限
     * @param roleId
     * @return
     */
    @Select("SELECT function_id as id  FROM  auth_role_function  WHERE role_id=#{roleId} ")
    List<AuthFunctionVO> getFunctioforRole(Long  roleId);


    /**
     * 获取所有父节点
     *
     * @return
     */
    @Select("SELECT id,name FROM  auth_function  WHERE parent_id=0 ")
    List<AuthFunctionVO> getALLParentNode();



}
