package com.demo.nopcommerce;

import com.demo.nopcommerce.Base.BasePage;
import com.demo.nopcommerce.Pages.LoginPage;
import com.demo.nopcommerce.Pages.RegisterPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.util.Properties;

public class RegisterTest {
    WebDriver driver;
    BasePage basePage;
    BasePageTest basePageTest;
    Properties prop;

    RegisterPage registerPage;
    @Test
    public void RegisterTest() {
        basePageTest =new BasePageTest();
        basePageTest.openBrowser();
        registerPage= new RegisterPage(driver);

        registerPage.Register_link();

        prop = basePage.initializationProperty();
        String Geder_selection = prop.getProperty("genderSelection");
        driver = registerPage.Gender_selection(Geder_selection);
    }
}
