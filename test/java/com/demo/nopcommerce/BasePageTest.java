package com.demo.nopcommerce;

import com.demo.nopcommerce.Base.BasePage;
import com.demo.nopcommerce.Pages.LoginPage;
import com.demo.nopcommerce.Pages.RegisterPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;

public class BasePageTest {
    WebDriver driver;
    BasePage basePage;
    Properties prop;
    LoginPage loginPage;
    RegisterPage registerPage;
    @BeforeClass
    public void openBrowser() {
        //object creation to call method from basePage //so you can call method to get all data from config file
        basePage = new BasePage();
        //create variable to call initializationProperty() method
        prop = basePage.initializationProperty();
        //create variable to call data via method from config file // compare browser name
        String webEngin = prop.getProperty("browser");
        //variable to call driver method to open that particular browser
        driver = basePage.initializationDriver(webEngin);
        //simple url call by object.getProperty//old style = driver.get("https://demo.nopcommerce.com/");
        driver.get(prop.getProperty("url"));


    }


    public void LoginTest() {
        loginPage = new LoginPage(driver);
        loginPage.ClickLoginLink();
        loginPage.DoLogin(prop.getProperty("username"), prop.getProperty("password"));

    }
    @Test(priority = 1)
    public void RegisterTest(){
        registerPage= new RegisterPage(driver);
        registerPage.Register_link();

        prop = basePage.initializationProperty();
        String Geder_selection = prop.getProperty("genderSelection");
        driver = registerPage.Gender_selection(Geder_selection);
        registerPage.DoRegister(prop.getProperty("firstname"), prop.getProperty("lastname"),prop.getProperty("email"),prop.getProperty("companyName"),prop.getProperty("register_password"),prop.getProperty("register_conform_password"));

    }
}
