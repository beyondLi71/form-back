package com.bgy.entity.vo;

import com.bgy.entity.dto.InterfaceType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author LF--liufang@maxrocky.com
 * @date 2018/4/24 13:07
 * @desc 接口报表vo.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InterfaceStatemVO {
    //接口名称
    private String interfaceName;
    //访问类型
    private InterfaceType type;
    //调用次数
    private Integer callingNumber;
    //成功次数
    private Integer succeeNumber;
    //失败次数
    private Integer loserNumber;
}

