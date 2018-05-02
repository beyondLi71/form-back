package com.bgy.controller.interfacemanage;

import com.bgy.common.utils.apiresult.AbstractApiResult;
import com.bgy.common.utils.page.PageParam;
import com.bgy.common.utils.page.PageResult;
import com.bgy.entity.dto.*;
import com.bgy.entity.vo.*;
import com.bgy.service.InterfaceManagerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author LF--liufang@maxrocky.com
 * @date 2018/4/24 8:52
 * @desc 接口管理.
 */
@RestController
@Api(value = "back", tags = {"interfacemanage"})
@RequestMapping(value = "/interface")
public class interfaceManageController {

    @Resource
    InterfaceManagerService interfaceManagerService;
    /**
     * @author LF--liufang@maxrocky.com
     * @desc  .接口配置管理分页查询显示
     */
    @ApiOperation(value = "接口配置管理分页查询显示", produces = "application/json")
    @PostMapping (value = "/manage/queryinterfacemanageall")
    public AbstractApiResult queryInterfaceManageAll(@ModelAttribute PageParam pageParam){
        PageResult<InterfaceMangerVO> resultData = interfaceManagerService.queryInterfaceManageAll(pageParam);
        return AbstractApiResult.success(resultData);
    }

    /**
     * @author LF--liufang@maxrocky.com
     * @desc  .新增配置管理
     */
    @ApiOperation(value = "新增配置管理", produces = "application/json")
    @PostMapping (value = "/manage/saveinterfacemanage")
    public AbstractApiResult saveInterfaceManage(@RequestBody InterfaceMangerDTO interfaceMangerDTO){
        interfaceMangerDTO.setUserId("admin");
        interfaceManagerService.saveInterfaceManage(interfaceMangerDTO);
        return AbstractApiResult.success("success");
    }
    /**
     * @author LF--liufang@maxrocky.com
     * @desc  .配置管理数据根据id获取
     */
    @ApiOperation(value = "配置管理数据根据id获取", produces = "application/json")
    @GetMapping (value = "/manage/getinterfacemanagebyid/{id}")
    public AbstractApiResult getInterfaceManageById(@PathVariable Integer id){
        InterfaceMangerVO interfaceMangerVO = interfaceManagerService.getInterfaceManage(id);
        return AbstractApiResult.success(interfaceMangerVO);
    }

    /**
     * @author LF--liufang@maxrocky.com
     * @desc  .修改配置管理
     */
    @ApiOperation(value = "修改配置管理", produces = "application/json")
    @PostMapping (value = "/manage/updateinterfacemanagebyid")
    public AbstractApiResult updateInterfaceManageById(@RequestBody InterfaceMangerUpdateDTO interfaceMangerUpdateDTO){
        interfaceMangerUpdateDTO.setUserId("admin");
        interfaceManagerService.updateInterfaceManage(interfaceMangerUpdateDTO);
        return AbstractApiResult.success("success");
    }

    /**
     * @author LF--liufang@maxrocky.com
     * @desc  .删除配置管理
     */
    @ApiOperation(value = "删除配置管理", produces = "application/json")
    @GetMapping (value = "/manage/deleteinterfacemanagebyid/{id}")
    public AbstractApiResult deleteInterfaceManageById(@PathVariable Integer id){
        interfaceManagerService.deleteInterfaceManage(id);
        return AbstractApiResult.success("success");
    }
    /**
     * @author LF--liufang@maxrocky.com
     * @desc  .接口日志条件分页查询
     */
    @ApiOperation(value = "接口日志条件分页查询", produces = "application/json")
    @PostMapping (value = "/manage/queryinterfacemanagedetailbykeyword")
    public AbstractApiResult queryInterfaceManageDetailByKeyword(@RequestBody InterfaceLogKeyWordDTO interfaceLogKeyWordDTO, @ModelAttribute PageParam pageParam){
        PageResult<InterfaceMangerDetailVO> resultData = interfaceManagerService.queryInterfaceManageDetailByKeyword(interfaceLogKeyWordDTO, pageParam);
        return AbstractApiResult.success(resultData);
    }

    /**
     * @author LF--liufang@maxrocky.com
     * @desc  .根据日志id 查询接口名称入参与出参
     */
    @ApiOperation(value = "根据日志id 查询接口名称入参与出参", produces = "application/json")
    @GetMapping (value = "/manage/getinterfacemanagedetailbyid/{id}")
    public AbstractApiResult getInterfaceManageDetailById(@PathVariable Integer id){
        List<InterfaceLogByIdVO> result = interfaceManagerService.getInterfaceManageDetailById(id);
        return AbstractApiResult.success(result);
    }
    
    /**
     * @author LF--liufang@maxrocky.com
     * @desc  .分页条件查询接口报表
     */
    @ApiOperation(value = "分页条件查询接口报表", produces = "application/json")
    @PostMapping (value = "/statement/queryinterfacestatementbykeyword")
    public AbstractApiResult queryInterfaceStatementByKeyword(@RequestBody InterfaceStatementKeyWordDTO interfaceStatementKeyWordDTO, @ModelAttribute PageParam pageParam){
        PageResult<InterfaceStatemVO> result = interfaceManagerService.queryInterfaceStatementByKeyword(interfaceStatementKeyWordDTO, pageParam);
        return AbstractApiResult.success(result);
    }

    /**
     * @author LF--liufang@maxrocky.com
     * @desc  .白名单分页显示
     */
    @ApiOperation(value = "白名单分页显示", produces = "application/json")
    @PostMapping (value = "/whitename/querywhitenameall")
    public AbstractApiResult queryWhiteNameAll(@ModelAttribute PageParam pageParam){
        PageResult<WiteListVO> result = interfaceManagerService.queryWhiteNameByKeyword( pageParam);
        return AbstractApiResult.success(result);
    }

    /**
     * @author LF--liufang@maxrocky.com
     * @desc  .根据id查询白名单数据
     */
    @ApiOperation(value = "根据id查询白名单数据", produces = "application/json")
    @GetMapping (value = "/whitename/getwhitenamebyid/{id}")
    public AbstractApiResult getWhiteNameById(@PathVariable Integer id){
        WiteListVO witeListVO = interfaceManagerService.getWhiteNameByKeyword( id);
        return AbstractApiResult.success(witeListVO);
    }

    /**
     * @author LF--liufang@maxrocky.com
     * @desc  .根据id修改白名单数据
     */
    @ApiOperation(value = "根据id修改白名单数据", produces = "application/json")
    @PostMapping (value = "/whitename/updatewhitenameebyid")
    public AbstractApiResult updateWhiteNameeById(@RequestBody WiteListDTO witeListDTO){
        witeListDTO.setUserId("admin");
        interfaceManagerService.updateWhiteNameByKeyword(witeListDTO);
        return AbstractApiResult.success("success");
    }
    /**
     * @author LF--liufang@maxrocky.com
     * @desc  .添加白名单数据
     */
    @ApiOperation(value = "添加白名单数据", produces = "application/json")
    @PostMapping (value = "/whitename/savewhitename")
    public AbstractApiResult saveWhiteName(@RequestBody WiteListDTO witeListDTO){
        witeListDTO.setUserId("admin");
        interfaceManagerService.saveWhiteNameByKeyword(witeListDTO);
        return AbstractApiResult.success("success");
    }
    /**
     * @author LF--liufang@maxrocky.com
     * @desc  .白名单删除
     */
    @ApiOperation(value = "白名单删除", produces = "application/json")
    @PostMapping  (value = "/whitename/deletewhitenamebyid")
    public AbstractApiResult deleteWhiteNameById(@RequestBody List<Integer> id){
        interfaceManagerService.deleteWhiteNameById(id);
        return AbstractApiResult.success("success");
    }

    /**
     * @author LF--liufang@maxrocky.com
     * @desc  .白名单启用禁用按钮
     */
    @ApiOperation(value = "白名单启用禁用按钮", produces = "application/json")
    @GetMapping (value = "/whitename/updatewhitenamebystatus/{status}/{id}")
    public AbstractApiResult updateWhiteNameByStatus(@PathVariable(value = "status" ) String status, @PathVariable(value = "id") Integer id){
        interfaceManagerService.updateWhiteNameByStatus(status,id);
        return AbstractApiResult.success("success");
    }

    /**
     * @author LF--liufang@maxrocky.com
     * @desc  接口配置启用禁用按钮
     */
    @ApiOperation(value = "接口配置启用禁用按钮", produces = "application/json")
    @GetMapping (value = "/manage/updateinterfacemanagestatus/{status}/{id}")
    public AbstractApiResult updateInterfaceManageByStatus(@PathVariable(value = "status" ) String status, @PathVariable(value = "id") Integer id){
        interfaceManagerService.updateInterfaceManageStatus(status,id);
        return AbstractApiResult.success("success");
    }
}

