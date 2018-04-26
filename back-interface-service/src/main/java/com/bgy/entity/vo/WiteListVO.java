package com.bgy.entity.vo;

import com.bgy.entity.dto.InterfaceStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
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
public class WiteListVO {
    //id
    private String id;
   //起始url
    private String urlStart;
   //结束url
    private String urlEnd;
   //状态
    private InterfaceStatus status;
    //创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
    //创建人
    private String createBy;
    //备注
    private String remark;
}

