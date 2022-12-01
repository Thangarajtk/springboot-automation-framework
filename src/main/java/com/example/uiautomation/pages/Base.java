package com.example.uiautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public abstract class Base {

    @Autowired
    protected WebDriver driver;

    @Autowired
    protected WebDriverWait wait;

    @PostConstruct
    private void init() {
        PageFactory.initElements(this.driver, this);
    }

    protected abstract boolean isAt();
}
