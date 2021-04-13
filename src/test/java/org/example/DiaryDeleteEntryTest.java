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

import java.util.concurrent.TimeUnit;

public class DiaryDeleteEntryTest {
    private static WebDriver driver;
    private static final String LOGIN_PAGE_URL = "https://diary.ru/user/login";
    private static final String STUDENT_LOGIN = "testUser2021";
    private static final String STUDENT_PASSWORD = "SCbW4It5Mp";


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

        WebElement loginTextInput = driver.findElement(By.id("loginform-username"));
        loginTextInput.sendKeys(STUDENT_LOGIN);

        WebElement passwordTextInput = driver.findElement(By.id("loginform-password"));
        passwordTextInput.sendKeys(STUDENT_PASSWORD);

        WebElement loginButton = driver.findElement(By.name("login-button"));
        loginButton.click();

        String titleText = driver.findElement(By.xpath("//div[@id='page_content']/div/h1")).getText() ;
        Assertions.assertEquals("Популярное",(titleText));
    }

    @Test
    public void deleteEntry(){
        WebElement menuButton = driver.findElement(By.id("myCommunityLink"));
        menuButton.click();

        WebElement epigraph = driver.findElement(By.xpath("//div[@id='epigraph']"));
        Assertions.assertTrue(epigraph.isDisplayed());

        WebElement delButton = driver.findElement(By.xpath("//span[2]/a[3]/span"));
        delButton.click();

        String titleText = driver.findElement(By.xpath("xpath=//h1")).getText() ;
        Assertions.assertEquals("Подтверждение",(titleText));

        WebElement confirmButton = driver.findElement(By.xpath("//div[2]/div[2]/button"));
        confirmButton.click();
    }

    @AfterAll
    public static void closeDriver() {
        driver.close();
    }
}
