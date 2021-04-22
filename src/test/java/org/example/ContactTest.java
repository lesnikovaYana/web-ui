package org.example;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Feature("Create contact")
public class ContactTest extends BaseTest{

    @Test
    @DisplayName("Create a new contact")
    public void createContactPersonPositiveTest(){
        new LoginPage(driver)
                .authorization(Configuration.STUDENT_LOGIN, Configuration.STUDENT_PASSWORD)
                .menuContact()
                .clickCreateContactButton()
                .enterLastName("test")
                .enterFirstName("test")
                .enterJob("test")
                .clickAndEnterCompany("1234")
                .saveAndClose()
                .checkNewContactPopUp();
    }

}
