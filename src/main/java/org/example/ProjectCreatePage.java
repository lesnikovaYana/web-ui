package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.UUID;

public class ProjectCreatePage extends Base{

    @FindBy(name = "crm_project[name]")
    private WebElement nameInput;

    @FindBy(xpath = "//*[@class='company-container']//a[1]")
    private WebElement companyButton;

    @FindBy(css = "input.select2-input")
    private WebElement companyInput;

    @FindBy(css = "span.select2-match")
    private WebElement companyDropButton;

    @FindBy(xpath = "//div[@class='select2-container select2'] ")
    private WebElement contactButton;

    @FindBy(css = "input.select2-input")
    private WebElement contactInput;

    @FindBy(css = "span.select2-match")
    private WebElement contactDropButton;

    @FindBy(name = "crm_project[businessUnit]")
    private WebElement businessUnit;

    @FindBy(name = "crm_project[curator]")
    private WebElement curator;

    @FindBy(name = "crm_project[rp]")
    private WebElement projectManager;

    @FindBy(name = "crm_project[administrator]")
    private WebElement administrator;

    @FindBy(name = "crm_project[manager]")
    private WebElement manager;

    @FindBy(xpath = "//button[contains(.,'Сохранить и закрыть')]")
    private WebElement saveButton;

    public ProjectCreatePage(WebDriver driver) {
        super(driver);
    }

    public ProjectCreatePage enterName() {
        nameInput.sendKeys(UUID.randomUUID().toString());
        return this;
    }

    private void waitForVisibility(WebElement element) throws Error{
        new WebDriverWait(driver, 30)
                .until(ExpectedConditions.visibilityOf(element));
    }

    private void waitToBeClickable(WebElement element) throws Error{
        new WebDriverWait(driver, 30)
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    public ProjectCreatePage enterCompany(String company){
        companyButton.click();
        waitForVisibility(companyInput);
        companyInput.sendKeys(company);
        waitForVisibility(companyDropButton);
        companyDropButton.click();
        return this;
    }

    public ProjectCreatePage enterContact(String contact){
        waitToBeClickable(contactButton);
        contactButton.click();
        waitForVisibility(contactInput);
        contactInput.sendKeys(contact);
        waitForVisibility(contactDropButton);
        contactDropButton.click();
        return this;
    }

    public ProjectCreatePage enterBusinessUnit(int value){
        Select businessUnitDropDown = new Select(businessUnit);
        businessUnitDropDown.selectByValue(String.valueOf(value));
        return this;
    }

    public ProjectCreatePage enterCurator(int value){
        Select curatorDropDown = new Select(curator);
        curatorDropDown.selectByValue(String.valueOf(value));
        return this;
    }

    public ProjectCreatePage enterProjectManager(int value){
        Select projectManagerDropDown = new Select(projectManager);
        projectManagerDropDown.selectByValue(String.valueOf(value));
        return this;
    }

    public ProjectCreatePage enterAdministrator(int value){
        Select administratorDropDown = new Select(administrator);
        administratorDropDown.selectByValue(String.valueOf(value));
        return this;
    }

    public ProjectCreatePage enterManager(int value){
        Select managerDropDown = new Select(manager);
        managerDropDown.selectByValue(String.valueOf(value));
        return this;
    }

    public AllMyProjectPage saveAndClose(){
        saveButton.click();
        return new AllMyProjectPage(driver);
    }

}
