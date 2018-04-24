package com.bgy.entity.vo;

import com.bgy.entity.dto.InterfaceStatus;
import com.bgy.entity.dto.InterfaceType;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author LF--liufang@maxrocky.com
 * @date 2018/4/24 9:54
 * @desc 接口配置.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InterfaceMangerVO {
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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
    //修改时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;
    //创建人
    private String createBy;
    //修改人
    private String updateBy;
    //备注
    private String remark;
}

