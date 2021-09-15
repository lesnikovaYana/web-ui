package org.example;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginPage extends Base{

    @FindBy(id = "prependedInput")
    private WebElement loginInput;

    @FindBy(id = "prependedInput2")
    private WebElement passwordInput;

    @FindBy(id = "_submit")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step(value = "Enter login")
    public LoginPage enterLogin(String login) {
        loginInput.sendKeys(login);
        return this;
    }

    @Step(value = "Enter password")
    public LoginPage enterPassword(String password) {
        passwordInput.sendKeys(password);
        return this;
    }

    @Step(value = "Click login button")
    public HomePage clickLoginButton() {
        loginButton.click();
        return new HomePage(driver);
    }

    @Step(value = "Authorization")
    public HomePage authorization(String login, String password) {
        loginInput.sendKeys(login);
        passwordInput.sendKeys(password);
        loginButton.click();
        return new HomePage(driver);
    }
}
