package com.bgy.common.utils.apiresult;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 向SAP 返回数据的模板
 * @by linlangleo
 * {
 *"formURL": "/hello/helloworld.html?docID=123&processTempID=321",
 *"docID": "1",
 *"processTempID": "1"
 *}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultData {

    //返回的页面地址
    private String formURL;

    //返回的单号
    private String docID;

    //返回的流程模板ID
    private String processTempID;
}
