package com.bgy.dao;

import com.bgy.entity.dto.InterfaceStatementKeyWordDTO;
import com.bgy.entity.po.*;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author LF--liufang@maxrocky.com
 * @date 2018/4/24 9:37
 * @desc ${DESCRIPTION}.
 */

public interface InterfaceManageQueryMapper {

    @Select("select * from sys_interface_manager where mark = 'ENABLE'")
    List<InterfaceMangerPO> queryInterfaceManageAll();

    @Select("<script>select a.*, b.interface_name, b.method_name from sys_interface_manager_details as a left join "
            + "sys_interface_manager as b on a.manager_id = b.id where a.mark = 'ENABLE' and b.mark = 'ENABLE' "
           + "<if test = \"interfaceName != null and interfaceName != ''\"> "
            + "and b.interface_name = #{interfaceName} "
            + "</if> "
            + "<if test = \"id != null and id != ''\"> "
            + "and a.manager_id = #{id} "
            + "</if> "
            + "<if test = \"ip != null and ip != ''\"> "
            + "and a.ip like \"%\"#{ip}\"%\" "
            + "</if> "
            + "<if test = \"status != null and status != ''\"> "
            + "and a.status like \"%\"#{status}\"%\" "
            + "</if> "
            + "<if test = \"startTime != null and startTime != ''\"> "
            + "<if test = \"endTime != null and endTime != ''\"> "
            + "and  a.start_time between #{startTime} and #{endTime} "
            + "</if> "
            + "</if> "
            + "</script> ")
    List<InterfaceMangerDetailPO> queryInterfaceManageDetailByKeyword(InterfaceLogKeyWordPO interfaceLogKeyWordPO);

    @Select("select a.*, b.method_name from sys_interface_manager_details as a left join "
            + "sys_interface_manager as b on a.manager_id = b.id where a.id = #{id} and a.mark = 'ENABLE' and b.mark = 'ENABLE'")
    List<InterfaceLogByIdPO> getInterfaceManageDetailById(@Param("id") Integer id);

    // TODO: 2018/4/24 聚合函数实现计算总共访问次数 成功次数  失败次数 待测试
    @Select("<script>select count(if(a.status = \"NORMAL\",true,null)) as succeeNumber, count(if(a.status = \"ERRO\",true,null)) as loserNumber, COUNT(b.status) as callingNumber, "
            + "b.interface_name, b.type from sys_interface_manager_details as a left join "
            + "sys_interface_manager as b on a.manager_id = b.id where  a.mark =  'ENABLE' and b.mark = 'ENABLE' "
            + "<if test = \"interfaceName != null and interfaceName != ''\"> "
            + "and b.interface_name = #{interfaceName} "
            + "</if> "
            + "<if test = \"startTime != null and startTime != ''\"> "
            + "<if test = \"endTime != null and endTime != ''\"> "
            + "and  a.start_time between #{startTime} and #{endTime} "
            + "</if> "
            + "</if> "
            + " group by b.interface_name </script> ")
    List<InterfaceStatemPO> queryInterfaceStatementByKeyword(InterfaceStatementKeyWordDTO interfaceStatementKeyWordDTO);

    @Select("select * from sys_interface_manager where mark = 'ENABLE' and id= #{id}")
    InterfaceMangerPO getInterfaceManage(@Param("id")Integer id);

    @Select("select * from sys_whitename_manager where mark = 'ENABLE'")
    List<WiteListPO> queryWhiteNameByKeyword();

    @Select("select * from sys_whitename_manager where mark = 'ENABLE' and id = #{id}")
    WiteListPO getWhiteNameByKeyword(@Param("id")Integer id);
}
