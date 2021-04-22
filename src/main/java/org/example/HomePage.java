package org.example;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;


public class HomePage extends Base{

    @FindBy(xpath = "//*[@class='dropdown first']")
    private WebElement menuContactButton;

    @FindBy(xpath = "//*[@id='main-menu']/ul/li[1]/ul/li[4]/a")
    private WebElement menuDropContactButton;

    @FindBy(xpath = "//div[@id='main-menu']/ul/li[3]/a")
    private WebElement menuMyProjectButton;

    @FindBy(xpath = "//div[@id='main-menu']/ul/li[3]/ul/li[4]/a")
    private WebElement menuDropMyProjectButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Step(value = "Click on the dropdown menu")
    public AllContactsPage menuContact(){
        Actions actions = new Actions(driver);
        actions
                .moveToElement(menuContactButton)
                .pause(5)
                .moveToElement(menuDropContactButton)
                .pause(5)
                .click()
                .build()
                .perform();
        return new AllContactsPage(driver);
    }

    @Step(value = "Click on the dropdown menu")
    public AllMyProjectPage menuProject(){
        Actions actions = new Actions(driver);
        actions
                .moveToElement(menuMyProjectButton)
                .moveToElement(menuDropMyProjectButton)
                .click()
                .build()
                .perform();
        return new AllMyProjectPage(driver);
    }

}
