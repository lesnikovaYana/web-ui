package org.example;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContactCreatePage extends Base {

    @FindBy(name = "crm_contact[lastName]")
    private WebElement lastNameInput;

    @FindBy(name = "crm_contact[firstName]")
    private WebElement firstNameInput;

    @FindBy(name = "crm_contact[jobTitle]")
    private WebElement jobInput;

    @FindBy(css = "span.select2-chosen")
    private WebElement companyButton;

    @FindBy(css = "input.select2-input")
    private WebElement companyInput;

    @FindBy(xpath = "//*[@id='select2-drop']/ul[2]/li/div")
    private WebElement companyDropButton;

    @FindBy(xpath = "(//button[@type='submit'])[4]")
    private WebElement saveButton;

    public ContactCreatePage(WebDriver driver) {
        super(driver);
    }

    @Step(value = "Enter last name")
    public ContactCreatePage enterLastName(String lastName) {
        lastNameInput.sendKeys(lastName);
        return this;
    }

    @Step(value = "Enter first name")
    public ContactCreatePage enterFirstName(String firstName) {
        firstNameInput.sendKeys(firstName);
        return this;
    }

    @Step(value = "Enter position")
    public ContactCreatePage enterJob(String job) {
        jobInput.sendKeys(job);
        return this;
    }

    @Step(value = "Enter company")
    public ContactCreatePage clickAndEnterCompany(String company){
        companyButton.click();
        companyInput.sendKeys(company);
        companyDropButton.click();
        return this;
    }

    @Step(value = "Click button save and close")
    public AllContactsPage saveAndClose(){
        saveButton.click();
        return new AllContactsPage(driver);
    }
}

