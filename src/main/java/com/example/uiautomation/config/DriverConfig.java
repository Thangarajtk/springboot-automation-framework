package com.example.uiautomation.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("!remote")
public class DriverConfig {

    @Value("${default.timeout:30}")
    private int timeout;

    @Bean
//    @Primary // Use this annotation whenever there is more than one bean
    @ConditionalOnProperty(name = "browser", havingValue = "chrome")
//    @ConditionalOnMissingBean // Use this annotation for the missing configuration
    public WebDriver chromeDriver() {
        return new ChromeDriver();
    }

    @Bean
    @ConditionalOnProperty(name = "browser", havingValue = "firefox")
    public WebDriver firefoxDriver() {
        return new FirefoxDriver();
    }

}
