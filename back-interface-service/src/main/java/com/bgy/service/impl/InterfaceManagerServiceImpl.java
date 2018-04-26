package com.bgy.service.impl;

import com.bgy.common.utils.mapper.MapperUtils;
import com.bgy.common.utils.page.PageParam;
import com.bgy.common.utils.page.PageResult;
import com.bgy.common.utils.page.PageResultFactory;
import com.bgy.dao.InterfaceManageCUDMapper;
import com.bgy.dao.InterfaceManageQueryMapper;
import com.bgy.entity.dto.*;
import com.bgy.entity.po.*;
import com.bgy.entity.vo.*;
import com.bgy.service.InterfaceManagerService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;
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
    @Resource
    InterfaceManageCUDMapper interfaceManageCUDMapper;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public PageResult<InterfaceMangerVO> queryInterfaceManageAll(PageParam pageParam) {
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

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveInterfaceManage(InterfaceMangerDTO interfaceMangerDTO) {
        //拷贝
        InterfaceMangerPO interfaceMangerPO = MapperUtils.mapperBean(interfaceMangerDTO, InterfaceMangerPO.class);
        //封装数据
        interfaceMangerPO.setCreateTime(LocalDateTime.now());
        interfaceMangerPO.setUpdateTime(interfaceMangerPO.getCreateTime());
        interfaceMangerPO.setCreateBy(interfaceMangerDTO.getUserId());
        interfaceMangerPO.setUpdateBy(interfaceMangerDTO.getUserId());
        //数据存储
        interfaceManageCUDMapper.saveInterfaceManage(interfaceMangerPO);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateInterfaceManage(InterfaceMangerUpdateDTO interfaceMangerUpdateDTO) {
        //拷贝
        InterfaceMangerPO interfaceMangerPO = MapperUtils.mapperBean(interfaceMangerUpdateDTO, InterfaceMangerPO.class);
        //封装数据
        interfaceMangerPO.setUpdateTime(LocalDateTime.now());
        interfaceMangerPO.setUpdateBy(interfaceMangerUpdateDTO.getUserId());
        //数据存储
        interfaceManageCUDMapper.updateInterfaceManage(interfaceMangerPO);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteInterfaceManage(Integer id) {
        //数据删除
        interfaceManageCUDMapper.deleteInterfaceManage(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public InterfaceMangerVO getInterfaceManage(Integer id) {
        //数据查询
        InterfaceMangerPO interfaceMangerPO = interfaceManageQueryMapper.getInterfaceManage(id);
        //数据拷贝
        InterfaceMangerVO interfaceMangerVO = MapperUtils.mapperBean(interfaceMangerPO, InterfaceMangerVO.class);
        return interfaceMangerVO;

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public PageResult<WiteListVO> queryWhiteNameByKeyword(PageParam pageParam) {
        //设置分页
        Page<InterfaceMangerPO> page = PageHelper.startPage(pageParam.getP(), pageParam.getC());
        //查询sql
        List<WiteListPO> witeListPOList = interfaceManageQueryMapper.queryWhiteNameByKeyword();
        //取分页信息
        int total = (int) page.getTotal();
        //拷贝
        List<WiteListVO> witeListVOS = MapperUtils.mapperList(witeListPOList, WiteListVO.class);
        //分页类
        PageResult pageResult = pageResultFactory.createPageResult(pageParam.getP(), total, witeListVOS);
        return pageResult;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public WiteListVO getWhiteNameByKeyword(Integer id) {
        //根据id查询数据
        WiteListPO witeListPO = interfaceManageQueryMapper.getWhiteNameByKeyword(id);
        //数据拷贝
        WiteListVO witeListVOS = MapperUtils.mapperBean(witeListPO, WiteListVO.class);
        return witeListVOS;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateWhiteNameByKeyword(WiteListDTO witeListDTO) {
        //数据拷贝
        WiteListPO witeListPO = MapperUtils.mapperBean(witeListDTO, WiteListPO.class);
        //填充数据
        witeListPO.setUpdateBy(witeListDTO.getUserId());
        witeListPO.setUpdateTime(LocalDateTime.now());
        //修改数据
        interfaceManageCUDMapper.updateWhiteNameByKeyword(witeListPO);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveWhiteNameByKeyword(WiteListDTO witeListDTO) {
        //数据拷贝
        WiteListPO witeListPO = MapperUtils.mapperBean(witeListDTO, WiteListPO.class);
        //填充数据
        witeListPO.setCreateBy(witeListDTO.getUserId());
        witeListPO.setCreateTime(LocalDateTime.now());
        witeListPO.setUpdateTime(witeListPO.getCreateTime());
        witeListPO.setUpdateBy(witeListDTO.getUserId());
        //保存数据
        interfaceManageCUDMapper.saveWhiteNameByKeyword(witeListPO);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateWhiteNameByStatus(String status, Integer id) {
        //修改数据启用禁用
        interfaceManageCUDMapper.updateWhiteNameByStatus(status, id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateInterfaceManageStatus(String status, Integer id) {
        interfaceManageCUDMapper.updateInterfaceManageStatus(status, id);
    }

    @Override
    public void deleteWhiteNameById(List<Integer> id) {
        //批量删除
        interfaceManageCUDMapper.deleteWhiteNameById(id);

    }

}

