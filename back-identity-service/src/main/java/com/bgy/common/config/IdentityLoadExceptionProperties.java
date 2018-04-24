package com.bgy.common.config;

import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @Author beyondLi
 */
@PropertySource(value = "identity-exception.properties", encoding = "UTF-8")
@Component
public class IdentityLoadExceptionProperties {

}
