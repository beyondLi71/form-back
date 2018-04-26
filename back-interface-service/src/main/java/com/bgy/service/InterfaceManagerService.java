package com.bgy.service;

import com.bgy.common.utils.page.PageParam;
import com.bgy.common.utils.page.PageResult;
import com.bgy.entity.dto.*;
import com.bgy.entity.vo.*;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;

/**
 * @author LF--liufang@maxrocky.com
 * @date 2018/4/24 9:16
 * @desc ${DESCRIPTION}.
 */
@Validated
public interface InterfaceManagerService {
    /**
     * @author LF--liufang@maxrocky.com
     * @desc  .分页查询所有接口配置
     */
    PageResult<InterfaceMangerVO> queryInterfaceManageAll(PageParam pageParam);

    /**
     * @author LF--liufang@maxrocky.com
     * @desc  .根据条件分页查询日志
     */
    PageResult<InterfaceMangerDetailVO> queryInterfaceManageDetailByKeyword(InterfaceLogKeyWordDTO interfaceLogKeyWordDTO, PageParam pageParam);

    /**
     * @author LF--liufang@maxrocky.com
     * @desc  .根据id查询日志入参出参
     */
    List<InterfaceLogByIdVO> getInterfaceManageDetailById(Integer id);

    /**
     * @author LF--liufang@maxrocky.com
     * @desc  .根据条件查询日志报表
     */
    PageResult<InterfaceStatemVO> queryInterfaceStatementByKeyword(InterfaceStatementKeyWordDTO interfaceStatementKeyWordDTO, PageParam pageParam);

    /**
     * @author LF--liufang@maxrocky.com
     * @desc  .添加接口配置
     */
    void saveInterfaceManage(@Valid InterfaceMangerDTO interfaceMangerDTO);

    /**
     * @author LF--liufang@maxrocky.com
     * @desc  .根据id修改接口配置
     */
    void updateInterfaceManage(InterfaceMangerUpdateDTO interfaceMangerUpdateDTO);

    /**
     * @author LF--liufang@maxrocky.com
     * @desc  .根据id删除
     */
    void deleteInterfaceManage(Integer id);

    /**
     * @author LF--liufang@maxrocky.com
     * @desc  . 根据id获取配置数据
     */
    InterfaceMangerVO getInterfaceManage(Integer id);

    /**
     * @author LF--liufang@maxrocky.com
     * @desc  .分页查询白名单
     */
    PageResult<WiteListVO> queryWhiteNameByKeyword(PageParam pageParam);

    /**
     * @author LF--liufang@maxrocky.com
     * @desc  .根据id查询白名单数据
     */
    WiteListVO getWhiteNameByKeyword(Integer id);

    /**
     * @author LF--liufang@maxrocky.com
     * @desc  .根据id修改白名单数据
     */
    void updateWhiteNameByKeyword(WiteListDTO witeListDTO);

    /**
     * @author LF--liufang@maxrocky.com
     * @desc  .添加白名单数据
     */
    void saveWhiteNameByKeyword(WiteListDTO witeListDTO);

    /**
     * @author LF--liufang@maxrocky.com
     * @desc  .启用禁用白名单ip
     */
    void updateWhiteNameByStatus(String status, Integer id);

    /**
     * @author LF--liufang@maxrocky.com
     * @desc  .接口配置启用禁用按钮
     */
    void updateInterfaceManageStatus(String status, Integer id);

    /**
     * @author LF--liufang@maxrocky.com
     * @desc  .白名单删除
     */
    void deleteWhiteNameById(List<Integer> id);
}
