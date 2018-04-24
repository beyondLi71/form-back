package com.bgy.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tk.mybatis.mapper.code.Style;
import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.spring.mapper.MapperScannerConfigurer;

import java.util.Properties;

/**
 * @author yyg
 * @date 2018/4/13 18:26
 * @desc mybatis通用mapper配置类
 */
@Configuration
public class TkMybatisConfig {

    @Bean(name = "mapperHelper")
    public MapperScannerConfigurer mapperHelper() {
        Properties properties = new Properties();
        properties.setProperty("mappers", BaseMapper.class.getName());
        properties.setProperty("IDENTITY", "MYSQL"); // 数据库方言（主要用于：取回主键的方式）
        properties.setProperty("notEmpty", "false"); // insert和update中，是否判断字符串类型!=''，少数方法会用到
        properties.setProperty("style", Style.camelhump.name());

        MapperScannerConfigurer scan = new MapperScannerConfigurer();
        scan.setSqlSessionFactoryBeanName("sqlSessionFactory"); // 多数据源时，必须配置

        scan.setBasePackage("com.bgy.dao"); //mapper.java文件的路径
        scan.setMarkerInterface(BaseMapper.class); // 直接继承了BaseDao接口的才会被扫描，basePackage可以配置的范围更大。
        scan.setProperties(properties);

        return scan;
    }
}