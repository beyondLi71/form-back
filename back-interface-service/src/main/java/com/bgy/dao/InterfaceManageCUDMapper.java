package com.bgy.dao;

import com.bgy.entity.po.InterfaceMangerPO;
import com.bgy.entity.po.WiteListPO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author LF--liufang@maxrocky.com
 * @date 2018/4/24 17:49
 * @desc ${DESCRIPTION}.
 */

public interface InterfaceManageCUDMapper {
    @Insert("insert into sys_interface_manager (interface_name, method_name, type, status, create_time, update_time, create_by, update_by, mark) values "
            + "(#{interfaceName}, #{methodName}, #{type}, #{status}, #{createTime}, #{updateTime}, #{createBy}, #{updateBy}, 'ENABLE')")
    void saveInterfaceManage(InterfaceMangerPO interfaceMangerPO);

    @Update("update sys_interface_manager set interface_name = #{interfaceName}, method_name = #{methodName}, "
            + "type = #{type}, status = #{status},update_time = #{updateTime},update_by = #{updateBy}  where id = #{id} and mark = 'ENABLE'")
    void updateInterfaceManage(InterfaceMangerPO interfaceMangerPO);

    @Update("update sys_interface_manager set mark = 'DISENABLE' where id = #{id} and mark = 'ENABLE'")
    void deleteInterfaceManage(Integer id);

    @Update("update sys_whitename_manager set url_start = #{urlStart}, url_end = #{urlEnd}, remark = #{remark}, "
            + " status = #{status},update_time = #{updateTime},update_by = #{updateBy}  where id = #{id} and mark = 'ENABLE'")
    void updateWhiteNameByKeyword(WiteListPO witeListPO);
    @Insert("insert into sys_whitename_manager (url_start, url_end, remark, status, create_time, update_time, create_by, update_by, mark) values "
            + "(#{urlStart}, #{urlEnd}, #{remark}, #{status}, #{createTime}, #{updateTime}, #{createBy}, #{updateBy}, 'ENABLE')")
    void saveWhiteNameByKeyword(WiteListPO witeListPO);

    @Update("update sys_whitename_manager set status = #{status} where id = #{id} and mark = 'ENABLE'")
    void updateWhiteNameByStatus(@Param(value = "status") String status, @Param(value = "id") Integer id);

    @Update("update sys_interface_manager set status = #{status} where id = #{id} and mark = 'ENABLE'")
    void updateInterfaceManageStatus(@Param(value = "status") String status, @Param(value = "id") Integer id);

    @Update("<script>update sys_whitename_manager set mark = 'DISENABLE' where id in "
            + "<foreach collection = 'id' item = 'item' index = 'index' open = '(' separator = ',' close = ')'>"
            + "#{item}"
            + "</foreach>"
            + "</script>")
    void deleteWhiteNameById(@Param("id")List<Integer> id);
}
