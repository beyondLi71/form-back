package com.bgy.common.utils.SysEnum;

/**
* @author yyg
* @date 2018/4/26 9:38
* @desc  系统删除状态枚举
*/
public enum DeleteEnum {
    /**删除标记 */
    DISABLE("DISABLE", "已删除"),
    ENABLE("ENABLE", "未删除");

    private String status;
    private String message;

    DeleteEnum(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
