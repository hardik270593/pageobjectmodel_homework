package com.demo.nopcommerce.Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

//this class  to config web_driver
public class BasePage {
    WebDriver driver;
    Properties prop;
    FileInputStream file;

//this method for verification of browser driver
    public WebDriver initializationDriver(String browserName) {
        if (browserName.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browserName.equals("Firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browserName.equals("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else {
            System.out.println("Browser not matched ");
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        return driver;
    }
//this method for config property like loading file
    public Properties initializationProperty() {
        prop = new Properties();
        try {
            file = new FileInputStream("C:\\Program Files\\Java\\jdk1.8.0_333\\bin\\pageObjectModel\\src\\test\\resources\\TestData\\config.properties");
            prop.load(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }catch (IOException e){
            System.out.println("property could not loaded");
        }


        return prop;
    }
}

