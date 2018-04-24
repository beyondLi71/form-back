package com.bgy.controller.interfacemanage;

import com.bgy.common.utils.apiresult.AbstractApiResult;
import com.bgy.common.utils.page.PageParam;
import com.bgy.common.utils.page.PageResult;
import com.bgy.entity.dto.InterfaceLogKeyWordDTO;
import com.bgy.entity.dto.InterfaceMangerDTO;
import com.bgy.entity.dto.InterfaceStatementKeyWordDTO;
import com.bgy.entity.vo.InterfaceLogByIdVO;
import com.bgy.entity.vo.InterfaceMangerDetailVO;
import com.bgy.entity.vo.InterfaceMangerVO;
import com.bgy.entity.vo.InterfaceStatemVO;
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
    @PostMapping (value = "/manage/savinterfacemanage")
    public AbstractApiResult savinterfacemanage(@RequestBody InterfaceMangerDTO interfaceMangerDTO){
        // TODO: 2018/4/24  待开发：添加接口配置 
        return AbstractApiResult.success("");
    }
    
    /**
     * @author LF--liufang@maxrocky.com
     * @desc  .接口日志条件分页查询
     */
    @ApiOperation(value = "接口日志条件分页查询", produces = "application/json")
    @PostMapping (value = "/managedetail/queryinterfacemanagedetailbykeyword")
    public AbstractApiResult queryInterfaceManageDetailByKeyword(@RequestBody InterfaceLogKeyWordDTO interfaceLogKeyWordDTO, @ModelAttribute PageParam pageParam){
        PageResult<InterfaceMangerDetailVO> resultData = interfaceManagerService.queryInterfaceManageDetailByKeyword(interfaceLogKeyWordDTO, pageParam);
        return AbstractApiResult.success(resultData);
    }

    /**
     * @author LF--liufang@maxrocky.com
     * @desc  .根据日志id 查询接口名称入参与出参
     */
    @ApiOperation(value = "根据日志id 查询接口名称入参与出参", produces = "application/json")
    @GetMapping  (value = "/managedetail/getinterfacemanagedetailbyid/{id}")
    public AbstractApiResult getInterfaceManageDetailById(@PathVariable Integer id){
        List<InterfaceLogByIdVO> result = interfaceManagerService.getInterfaceManageDetailById(id);
        return AbstractApiResult.success(result);
    }
    
    /**
     * @author LF--liufang@maxrocky.com
     * @desc  .分页条件查询接口报表
     */
    @ApiOperation(value = "分页条件查询接口报表", produces = "application/json")
    @PostMapping   (value = "/statement/queryinterfacestatementbykeyword")
    public AbstractApiResult queryInterfaceStatementByKeyword(@RequestBody InterfaceStatementKeyWordDTO interfaceStatementKeyWordDTO, @ModelAttribute PageParam pageParam){
        PageResult<InterfaceStatemVO> result = interfaceManagerService.queryInterfaceStatementByKeyword(interfaceStatementKeyWordDTO, pageParam);
        return AbstractApiResult.success(result);
    }

}

