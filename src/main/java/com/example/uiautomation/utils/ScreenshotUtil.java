package com.example.uiautomation.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

@Lazy
@Component
public class ScreenshotUtil {

    @Autowired
    private TakesScreenshot driver;

    @Value("${screenshot.path}")
    private Path path;

    public void takeScreenshot(String imgName) throws IOException {
        File srcFile = this.driver.getScreenshotAs(OutputType.FILE);
        FileCopyUtils.copy(srcFile, this.path.resolve(imgName).toFile());
    }
}
