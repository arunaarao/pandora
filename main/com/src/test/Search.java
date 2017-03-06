package com.src.test;

import com.src.pageobjects.SearchPage;
import com.src.utils.CommonUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

/**
 * Created by arunap on 05/03/17.
 */
public class Search {
    private SearchPage searchPage;
    private WebDriver driver;
    public void testSetUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "//usr//local//share//chromedriver");
        driver = new ChromeDriver();
        driver.get("https://link.springer.com/");
        driver.manage().window().maximize();
        searchPage = PageFactory.initElements(driver,SearchPage.class);
    }

    @Test
    public void verifySearchForValidInput() throws InterruptedException {
        testSetUp();
        searchPage.getSeachTextbox().sendKeys("syndrome");
        searchPage.getSearchButton().click();
        CommonUtil.waitForEvent(ExpectedConditions.visibilityOf(searchPage.getGetSearchResult()),driver);
        Assert.assertEquals(searchPage.getGetSearchResult().getText(),"658,728 Result(s) for 'syndrome'");
    }

    @Test
    public void verifySearchForInvalidInput() throws InterruptedException {
        testSetUp();
        searchPage.getSeachTextbox().sendKeys("£$%^");
        searchPage.getSearchButton().click();
        CommonUtil.waitForEvent(ExpectedConditions.visibilityOf(searchPage.getGetSearchResult()),driver);
        Assert.assertEquals(searchPage.getNoSearchResult().getText(),("Sorry – we couldn’t find what you are looking for. Why not...\n" +
                "Make sure that all words are spelled correctly\n" +
                "Try different keywords\n" +
                "Try more general keywords\n" +
                "Include preview-only content\n" +
                "Remove some/all of your search filters\n" +
                "Try using a wildcard seach where:\n" +
                "A * matches zero or more non-space characters.\n" +
                "A ? matches exactly one non-space character."));
    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
