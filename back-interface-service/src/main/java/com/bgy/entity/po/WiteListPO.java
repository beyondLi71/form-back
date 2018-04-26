package com.bgy.entity.po;

import com.bgy.entity.dto.InterfaceStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author LF--liufang@maxrocky.com
 * @date 2018/4/24 20:10
 * @desc 白名单.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WiteListPO {
    //id
    private String id;
   //起始url
    private String urlStart;
   //结束url
    private String urlEnd;
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

