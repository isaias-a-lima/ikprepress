package com.ikservices.ikprepress.commons.constants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.annotation.PostConstruct;
import java.util.Locale;
import java.util.Objects;

@Configuration
@PropertySource(name = "ikprepress.properties", value = "classpath:ikprepress.properties", encoding = "UTF-8")
public class IKPropertyConfig {
    private static final Logger LOGGER = LoggerFactory.getLogger(IKPropertyConfig.class);

    @Value("${app.name}")
    private String appName;
    @Value("${app.version}")
    private String appVersion;
    @Value("${app.language}")
    private String language;
    @Value("${app.country}")
    private String country;
    @Value("${app.timezone}")
    private String timeZone;
    @Value("${app.invalid.param.message}")
    private String invalidParamMessage;
    @Value("${app.invalid.param.message}")
    private String nullParamMessage;

    @PostConstruct
    private void load() {
        IKConstant.APP_NAME = this.appName;
        IKConstant.APP_VERSION = this.appVersion;
        IKConstant.LANGUAGE = this.language;
        IKConstant.COUNTRY = this.country;
        IKConstant.TIME_ZONE = this.timeZone;
        IKConstant.LOCALE = Objects.nonNull(this.language) && Objects.nonNull(this.country) ? new Locale(this.language, this.country) : new Locale("pt", "BR");
        IKConstant.INVALID_PARAM_MESSAGE = this.invalidParamMessage;
        IKConstant.NULL_PARAM_MESSAGE = this.nullParamMessage;

        LOGGER.info( "######## Loaded Properties ####################");
        LOGGER.info( "####        NAME:    " + IKConstant.APP_NAME);
        LOGGER.info( "####        VERSION: " + IKConstant.APP_VERSION);
        LOGGER.info( "###############################################");

    }

}
