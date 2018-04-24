package com.bgy.dao;

import org.apache.ibatis.annotations.Select;

/**
 * Created by beyondLi
 * Date 2018/4/21 15:24
 * Desc .
 */
public interface HelloQueryMapper {
    @Select("select USERNAME from TEST_USER")
    String getInfo();
}
