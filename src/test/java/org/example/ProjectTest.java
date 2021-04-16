package org.example;

import org.junit.jupiter.api.Test;

public class ProjectTest extends BaseTest{

    @Test
    public void createProjectCreatePositiveTest(){
        new LoginPage(driver)
                .authorization(Configuration.STUDENT_LOGIN, Configuration.STUDENT_PASSWORD)
                .menuProject()
                .clickCreateMyProjectButton()
                .enterName()
                .enterCompany("1234")
                .enterContact("123 123")
                .enterBusinessUnit(1)
                .enterCurator(115)
                .enterProjectManager(58)
                .enterAdministrator(6)
                .enterManager(5)
                .saveAndClose()
                .checkNewProjectPopUp();
    }
}
