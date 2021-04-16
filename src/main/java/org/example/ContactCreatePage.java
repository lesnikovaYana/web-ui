package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    public ContactCreatePage enterLastName(String lastName) {
        lastNameInput.sendKeys(lastName);
        return this;
    }

    public ContactCreatePage enterFirstName(String firstName) {
        firstNameInput.sendKeys(firstName);
        return this;
    }

    public ContactCreatePage enterJob(String job) {
        jobInput.sendKeys(job);
        return this;
    }

    public ContactCreatePage clickAndEnterCompany(String company){
        companyButton.click();
        companyInput.sendKeys(company);
        companyDropButton.click();
        return this;
    }

    public AllContactsPage saveAndClose(){
        saveButton.click();
        return new AllContactsPage(driver);
    }
}
