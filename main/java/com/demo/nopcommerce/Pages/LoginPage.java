package com.demo.nopcommerce.Pages;

import com.demo.nopcommerce.Base.BasePage;
import com.demo.nopcommerce.Uitilities.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.Properties;

public class LoginPage {
    WebDriver driver;
    Utils utils;

    By l_loginLink = By.className("ico-login");
    By l_emailId = By.id("Email");
    By l_Password = By.id("Password");
    By l_button = By.xpath("//button[text()=\"Log in\"]");

    public LoginPage(WebDriver driver){
        this.driver =driver;
        utils = new Utils(driver);

    }
    public void ClickLoginLink(){
        utils.doclick(l_loginLink);
    }
    public void DoLogin(String UserName,String Password){
        utils.dosendkey(l_emailId, UserName);
        utils.dosendkey(l_Password,Password);
        utils.doclick(l_loginLink);
        utils.doclick(l_button);
    }
}
