package com.example.uiautomation.pages.google;

import com.example.uiautomation.pages.Base;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class GooglePage extends Base {

    @Autowired
    private SearchComponent searchComponent;

    @Autowired
    private SearchResult searchResult;

    @Value("${application.url}")
    private String url;

    public void goTo() {
        this.driver.get(url);
    }

    public SearchComponent getSearchComponent() {
        return searchComponent;
    }

    public SearchResult getSearchResult() {
        return searchResult;
    }

    @Override
    public boolean isAt() {
        return this.searchComponent.isAt();
    }
}
