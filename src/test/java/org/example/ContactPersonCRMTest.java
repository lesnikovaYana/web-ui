package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ContactPersonCRMTest {
    private static WebDriver driver;
    private static final String LOGIN_PAGE_URL = "https://crm.geekbrains.space/user/login";
    private static final String STUDENT_LOGIN = "Applanatest";
    private static final String STUDENT_PASSWORD = "Student2020!";


    @BeforeAll
    public static void SetDriver(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void verifyAuthorization(){
        driver.get(LOGIN_PAGE_URL);

        WebElement loginTextInput = driver.findElement(By.id("prependedInput"));
        loginTextInput.sendKeys(STUDENT_LOGIN);

        WebElement passwordTextInput = driver.findElement(By.id("prependedInput2"));
        passwordTextInput.sendKeys(STUDENT_PASSWORD);

        WebElement loginButton = driver.findElement(By.id("_submit"));
        loginButton.click();

        String titleText = driver.findElement(By.xpath("//a[contains(text(),'Geekbrains')]")).getText() ;
        Assertions.assertEquals("Geekbrains",(titleText));
    }

    @Test
    public void goToContacts(){
        //Actions
        Actions action = new Actions(driver);
        WebElement menuButton = driver.findElement(By.xpath("//*[@class='dropdown first']"));
        WebElement menuDropButton = driver.findElement(By.xpath("//div[@id='main-menu']/ul/li/ul/li[5]/a"));
        action.moveToElement(menuButton).moveToElement(menuDropButton).click().build().perform();

        WebElement createButton = driver.findElement(By.xpath("//*[@id='container']//a[@href='/contact/create']"));
        createButton.click();

        String titleText = driver.findElement(By.xpath("//*[@id='container']//a[@href='/contact/create']")).getText() ;
        Assertions.assertEquals("Создать контактное лицо",(titleText));
    }

    @Test
    public void formFilling(){
        WebElement lastNameInput = driver.findElement(By.name("crm_contact[lastName]"));
        lastNameInput.sendKeys("test");

        WebElement firstNameInput = driver.findElement(By.name("crm_contact[firstName]"));
        firstNameInput.sendKeys("test");

        WebElement jobInput = driver.findElement(By.name("crm_contact[jobTitle]"));
        jobInput.sendKeys("test");

        Actions action = new Actions(driver);
        WebElement companyButton = driver.findElement(By.cssSelector("span.select2-chosen"));
        WebElement companyInput = driver.findElement(By.cssSelector("input.select2-input"));
        action.click(companyButton).sendKeys(companyInput, "1234").build().perform();

        WebElement companyDropButton = new WebDriverWait(driver,15).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='select2-drop']/ul[2]/li/div")));
        companyDropButton.click();

        WebElement saveButton = driver.findElement(By.xpath("(//button[@type='submit'])[4]"));
        saveButton.click();

        WebElement title = driver.findElement(By.xpath("//*[@id='container']//h1"));
        Assertions.assertTrue(title.isDisplayed());
    }


    @AfterAll
    public static void closeDriver() {
        driver.close();
    }
}
