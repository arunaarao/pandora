package com.src.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by arunap on 05/03/17.
 */
public class SearchPage {
    public WebElement getSeachTextbox() {
        return seachTextbox;
    }

    public WebElement getSearchButton() {
        return searchButton;
    }

    @FindBy(css = "#query")
    private WebElement seachTextbox;

    @FindBy(css = "#search")
    private WebElement searchButton;

    public WebElement getGetSearchResult() {
        return getSearchResult;
    }

    @FindBy(css = ".number-of-search-results-and-search-terms")
    private WebElement getSearchResult;

    public WebElement getNoSearchResult() {
        return noSearchResult;
    }

    @FindBy(id = "no-results-message")
    private WebElement noSearchResult;

    @FindBy()
    private WebElement searchResult2;

    @FindBy()
    private WebElement searchResult3;

    @FindBy()
    private WebElement searchResult4;

    @FindBy()
    private WebElement searchResult5;
}
