package com.demo.nopcommerce.Pages;

import com.demo.nopcommerce.Uitilities.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import sun.security.util.Password;

public class RegisterPage {
    WebDriver driver;
    Utils utils;
    By Register_link = By.xpath("//a[text()=\"Register\"]");
    By gender_selection_m = By.id("gender-male");
    By gender_selection_f = By.id("gender-female");
    By Register_f_name = By.id("FirstName");
    By Register_l_name = By.id("LastName");
    By Register_DateOfBirth = By.xpath("//option[@value=\"27\"]");
    By Register_DateOfMonth = By.xpath("//option[text()=\"May\"]");
    By Register_DateOfYear = By.xpath("//option[@value=\"1993\"]");
    By Register_Email = By.id("Email");
    By Register_company = By.id("Company");
    By Register_Newsletter = By.id("Newsletter");
    By Register_password = By.id("Password");
    By Register_conform_password = By.id("ConfirmPassword");
    By Register_button = By.id("register-button");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        utils = new Utils(driver);

    }

    public void Register_link() {
        utils.doclick(Register_link);

    }

    public WebDriver Gender_selection(String GenderSelection) {
        if (GenderSelection.equals("mail")) {
            utils.doclick(gender_selection_m);
        } else if (GenderSelection.equals("femail")) {
            utils.doclick(gender_selection_f);

        }
        return driver;
    }

    public void DoRegister(String firstName, String lastname,String Email,String companyName,String password,String conformPassword) {
        utils.dosendkey(Register_f_name, firstName);
        utils.dosendkey(Register_l_name, lastname);
        utils.doclick(Register_DateOfBirth);
        utils.doclick(Register_DateOfMonth);
        utils.doclick(Register_DateOfYear);
        utils.dosendkey(Register_Email,Email);
        utils.dosendkey(Register_company,companyName);
        utils.dosendkey(Register_password, password);
        utils.dosendkey(Register_conform_password, conformPassword);
        utils.doclick(Register_button);


    }
}
