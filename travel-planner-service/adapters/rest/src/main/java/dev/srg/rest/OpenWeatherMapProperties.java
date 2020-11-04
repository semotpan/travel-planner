package dev.srg.rest;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "openweathermap")
@PropertySource("classpath:/openweathermap.properties")
class OpenWeatherMapProperties {

    private String baseurl;
    private String service;
    private String appid;
    private String units;

    public String url() {
        return baseurl + "/" + service + "?units=" + units + "&appid=" + appid;
    }
}
