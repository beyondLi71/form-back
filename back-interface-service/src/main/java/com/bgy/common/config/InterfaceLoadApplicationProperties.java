package com.bgy.common.config;

import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @Author beyondLi
 */
@PropertySource(value = "application-interface.properties")
@Component
public class InterfaceLoadApplicationProperties {

}
