package com.src.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by arunap on 05/03/17.
 */
public class CommonUtil {
    public static void waitForEvent(ExpectedCondition expCond, WebDriver webDriver){
        WebDriverWait wait = new WebDriverWait(webDriver,20);
        wait.until(expCond);
    }
}
