package org.example;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AllMyProjectPage extends Base{

    @FindBy(xpath = "//div[@id='container']//a[@href='/project/create/']")
    private WebElement createButton;

    public AllMyProjectPage(WebDriver driver) {
        super(driver);
    }

    @Step(value = "Click button 'Create a project'")
    public ProjectCreatePage clickCreateMyProjectButton() {
        createButton.click();
        return new ProjectCreatePage(driver);
    }

    @Step(value = "Check alert")
    public AllMyProjectPage checkNewProjectPopUp() {
        String message = wait10second.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(
                "div[class='message']"))).getText();
        assertTrue(message.contains("Проект сохранен"));
        return this;
    }
}
