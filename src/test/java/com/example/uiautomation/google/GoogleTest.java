package com.example.uiautomation.google;

import com.example.uiautomation.BaseTestNGTest;
import com.example.uiautomation.pages.google.GooglePage;
import com.example.uiautomation.utils.ScreenshotUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.testng.Assert;

import java.io.IOException;

public class GoogleTest extends BaseTestNGTest {

    @Autowired
    private GooglePage googlePage;

    @Lazy
    @Autowired
    private ScreenshotUtil screenshotUtil;

    @Test
    public void googleTest() throws IOException {
        this.googlePage.goTo();
        Assert.assertTrue(this.googlePage.isAt());

        this.googlePage.getSearchComponent().search("Spring Boot");
        Assert.assertTrue(this.googlePage.getSearchResult().isAt());
        Assert.assertTrue(this.googlePage.getSearchResult().getCount() > 3);
        this.screenshotUtil.takeScreenshot("img.png");
    }

}
