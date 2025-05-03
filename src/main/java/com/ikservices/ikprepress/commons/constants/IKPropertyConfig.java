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
    @Value("${app.null.param.message}")
    private String nullParamMessage;
    @Value("${app.save.success.message}")
    private String saveSuccessMessage;
    @Value("${app.save.error.message}")
    private String saveErrorMessage;
    @Value("${app.list.error.message}")
    private String listErrorMessage;
    @Value("${app.get.error.message}")
    private String getErrorMessage;
    @Value("${app.update.success.message}")
    private String updateSuccessMessage;
    @Value("${app.update.error.message}")
    private String updateErrorMessage;
    @Value("${app.delete.success.message}")
    private String deleteSuccessMessage;
    @Value("${app.delete.success.message}")
    private String deleteErrorMessage;

    @PostConstruct
    private void load() {
        //APP CONFIG
        IKConstant.APP_NAME = this.appName;
        IKConstant.APP_VERSION = this.appVersion;
        IKConstant.LANGUAGE = this.language;
        IKConstant.COUNTRY = this.country;
        IKConstant.TIME_ZONE = this.timeZone;
        IKConstant.LOCALE = Objects.nonNull(this.language) && Objects.nonNull(this.country) ? new Locale(this.language, this.country) : new Locale("pt", "BR");

        //APP MESSAGES
        IKConstant.INVALID_PARAM_MESSAGE = this.invalidParamMessage;
        IKConstant.NULL_PARAM_MESSAGE = this.nullParamMessage;
        IKConstant.SAVE_SUCCESS_MESSAGE = this.saveSuccessMessage;
        IKConstant.SAVE_ERROR_MESSAGE = this.saveErrorMessage;
        IKConstant.LIST_ERROR_MESSAGE = this.listErrorMessage;
        IKConstant.GET_ERROR_MESSAGE = this.getErrorMessage;
        IKConstant.UPDATE_SUCCESS_MESSAGE = this.updateSuccessMessage;
        IKConstant.UPDATE_ERROR_MESSAGE = this.updateErrorMessage;
        IKConstant.DELETE_SUCCESS_MESSAGE = this.deleteSuccessMessage;
        IKConstant.DELETE_ERROR_MESSAGE = this.deleteErrorMessage;

        LOGGER.info( "############## Loaded Properties ##############");
        LOGGER.info( "####");
        LOGGER.info( "####        NAME:    " + IKConstant.APP_NAME);
        LOGGER.info( "####        VERSION: " + IKConstant.APP_VERSION);
        LOGGER.info( "####");
        LOGGER.info( "###############################################");
    }
}
