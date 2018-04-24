package com.bgy.service.impl;

import com.bgy.common.utils.mapper.MapperUtils;
import com.bgy.common.utils.page.PageParam;
import com.bgy.common.utils.page.PageResult;
import com.bgy.common.utils.page.PageResultFactory;
import com.bgy.dao.InterfaceManageQueryMapper;
import com.bgy.entity.dto.InterfaceLogKeyWordDTO;
import com.bgy.entity.dto.InterfaceStatementKeyWordDTO;
import com.bgy.entity.po.*;
import com.bgy.entity.vo.InterfaceLogByIdVO;
import com.bgy.entity.vo.InterfaceMangerDetailVO;
import com.bgy.entity.vo.InterfaceMangerVO;
import com.bgy.entity.vo.InterfaceStatemVO;
import com.bgy.service.InterfaceManagerService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author LF--liufang@maxrocky.com
 * @date 2018/4/24 9:17
 * @desc 接口管理服务.
 */
@Service
public class InterfaceManagerServiceImpl implements InterfaceManagerService {
    @Resource
    InterfaceManageQueryMapper interfaceManageQueryMapper;
    @Resource
    PageResultFactory pageResultFactory;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public  PageResult<InterfaceMangerVO> queryInterfaceManageAll(PageParam pageParam) {
        //设置分页
        Page<InterfaceMangerPO> page = PageHelper.startPage(pageParam.getP(), pageParam.getC());
        //查询sql
        List<InterfaceMangerPO> interfaceMangerPOS = interfaceManageQueryMapper.queryInterfaceManageAll();
        //取分页信息
        int total = (int) page.getTotal();
        //拷贝
        List<InterfaceMangerVO> interfaceMangerVOS = MapperUtils.mapperList(interfaceMangerPOS, InterfaceMangerVO.class);
        //分页类
        PageResult pageResult = pageResultFactory.createPageResult(pageParam.getP(), total, interfaceMangerVOS);
        return pageResult;
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public PageResult<InterfaceMangerDetailVO> queryInterfaceManageDetailByKeyword(InterfaceLogKeyWordDTO interfaceLogKeyWordDTO, PageParam pageParam) {
        InterfaceLogKeyWordPO interfaceLogKeyWordPO = MapperUtils.mapperBean(interfaceLogKeyWordDTO, InterfaceLogKeyWordPO.class);
        //设置分页
        Page<InterfaceMangerPO> page = PageHelper.startPage(pageParam.getP(), pageParam.getC());
        //查询sql
        List<InterfaceMangerDetailPO> interfaceMangerPOS = interfaceManageQueryMapper.queryInterfaceManageDetailByKeyword(interfaceLogKeyWordPO);
        //取分页信息
        int total = (int) page.getTotal();
        //拷贝
        List<InterfaceMangerDetailVO> interfaceMangerDetailVOS = MapperUtils.mapperList(interfaceMangerPOS, InterfaceMangerDetailVO.class);
        //分页类
        PageResult pageResult = pageResultFactory.createPageResult(pageParam.getP(), total, interfaceMangerDetailVOS);
        return pageResult;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<InterfaceLogByIdVO> getInterfaceManageDetailById(Integer id) {
        List<InterfaceLogByIdPO> result = interfaceManageQueryMapper.getInterfaceManageDetailById(id);
        List<InterfaceLogByIdVO> interfaceLogByIdVOS = MapperUtils.mapperList(result, InterfaceLogByIdVO.class);
        return interfaceLogByIdVOS;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public PageResult<InterfaceStatemVO> queryInterfaceStatementByKeyword(InterfaceStatementKeyWordDTO interfaceStatementKeyWordDTO, PageParam pageParam) {
        MapperUtils.mapperBean(interfaceStatementKeyWordDTO, InterfaceStatementKeyWordPO.class);
        //设置分页
        Page<InterfaceMangerPO> page = PageHelper.startPage(pageParam.getP(), pageParam.getC());
        //查询sql
        List<InterfaceStatemPO> interfaceStatemPOS = interfaceManageQueryMapper.queryInterfaceStatementByKeyword(interfaceStatementKeyWordDTO);
        //取分页信息
        int total = (int) page.getTotal();
        //拷贝
        List<InterfaceStatemVO> interfaceStatemVOS = MapperUtils.mapperList(interfaceStatemPOS, InterfaceStatemVO.class);
        //分页类
        PageResult pageResult = pageResultFactory.createPageResult(pageParam.getP(), total, interfaceStatemVOS);
        return pageResult;
    }
}

