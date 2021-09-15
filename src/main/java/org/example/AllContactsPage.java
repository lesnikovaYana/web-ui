package org.example;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class AllContactsPage extends Base {

    @FindBy(xpath = "//*[@id='container']//a[@href='/contact/create']")
    private WebElement createButton;

    public AllContactsPage(WebDriver driver) {
        super(driver);
    }

    @Step(value = "Click button 'Create contact person'")
    public ContactCreatePage clickCreateContactButton() {
        createButton.click();
        return new ContactCreatePage(driver);
    }

    @Step(value = "Check alert")
    public AllContactsPage checkNewContactPopUp() {
        String message = wait10second.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(
                "div[class='message']"))).getText();
        assertTrue(message.contains("Контактное лицо сохранено"));
        return this;
    }
}
