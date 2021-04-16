package org.example;

import org.junit.jupiter.api.Test;

public class ContactTest extends BaseTest{

    @Test
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
