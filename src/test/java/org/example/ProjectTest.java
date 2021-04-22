package org.example;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Feature("Project create")
public class ProjectTest extends BaseTest{

    @Test
    @DisplayName("Create a new project")
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

