package com.bgy.service;

import com.bgy.common.utils.page.PageParam;
import com.bgy.common.utils.page.PageResult;
import com.bgy.entity.dto.InterfaceLogKeyWordDTO;
import com.bgy.entity.dto.InterfaceStatementKeyWordDTO;
import com.bgy.entity.vo.InterfaceLogByIdVO;
import com.bgy.entity.vo.InterfaceMangerDetailVO;
import com.bgy.entity.vo.InterfaceMangerVO;
import com.bgy.entity.vo.InterfaceStatemVO;
import org.springframework.validation.annotation.Validated;

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
}
