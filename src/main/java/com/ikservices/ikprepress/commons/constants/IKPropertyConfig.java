package com.ikservices.ikprepress.commons.constants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.annotation.PostConstruct;

@Configuration
@PropertySource(name = "ikprepress.properties", value = "classpath:ikprepress.properties", encoding = "UTF-8")
public class IKPropertyConfig {
    private static final Logger LOGGER = LoggerFactory.getLogger(IKPropertyConfig.class);

    @Value("${app.invalid.param.message}")
    private String invalidParamMessage;

    @PostConstruct
    private void load() {
        IKConstant.INVALID_PARAM_MESSAGE = this.invalidParamMessage;
    }

}
