package com.bgy.entity.po;

import com.bgy.entity.dto.InterfaceStatus;
import com.bgy.entity.dto.InterfaceType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author LF--liufang@maxrocky.com
 * @date 2018/4/24 9:24
 * @desc 接口配置管理.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InterfaceMangerPO {
    //id
    private Integer id;
    //接口名
    private String interfaceName;
    //方法名
    private String methodName;
    //访问类型
    private InterfaceType type;
    //状态
    private InterfaceStatus status;
    //创建时间
    private LocalDateTime createTime;
    //修改时间
    private LocalDateTime updateTime;
    //创建人
    private String createBy;
    //修改人
    private String updateBy;
    //备注
    private String remark;

}

