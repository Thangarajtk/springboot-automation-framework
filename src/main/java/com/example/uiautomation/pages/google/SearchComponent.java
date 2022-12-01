package com.example.uiautomation.pages.google;

import com.example.uiautomation.pages.Base;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SearchComponent extends Base {

    @FindBy(name = "q")
    private WebElement searchBox;

    @FindBy(name = "btnK")
    private List<WebElement> searchBtn;

    public void search(String keyword) {
        this.searchBox.sendKeys(keyword);
        this.searchBox.sendKeys(Keys.TAB);
        this.searchBtn.stream()
                .filter(e -> e.isDisplayed() && e.isEnabled())
                .findFirst()
                .ifPresent(WebElement::click);
    }

    @Override
    protected boolean isAt() {
        return this.wait.until(d -> this.searchBox.isDisplayed());
    }
}
