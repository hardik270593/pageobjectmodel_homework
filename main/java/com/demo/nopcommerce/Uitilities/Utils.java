package com.demo.nopcommerce.Uitilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Utils {
    WebDriver driver;
    // for working and fiend locator
    public Utils(WebDriver driver) {

        this.driver = driver;
    }

    public WebElement getElement(By locator) {
        //variable declaration for driver
        WebElement element = driver.findElement(locator);
        return element;
    }
    public void dosendkey(By locator ,String value){
        //variable declaration for send key
        getElement(locator).sendKeys(value);
    }
    //variable declaration for click
    public void doclick(By locator){
        getElement(locator).click();

    }
}
