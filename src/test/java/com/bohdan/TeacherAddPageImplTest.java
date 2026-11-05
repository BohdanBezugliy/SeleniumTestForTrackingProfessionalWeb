package com.bohdan;

import com.bohdan.helper.LoginPageHelper;
import com.bohdan.page.LoginPageImpl;
import com.bohdan.page.TeacherAddPageImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Test class for {@link TeacherAddPageImpl}.
 * This class sets up the necessary environment for testing the TeacherAddPageImpl functionality.
 */
public class TeacherAddPageImplTest {
    private WebDriverWait wait;

    private TeacherAddPageImpl modalPage;

    private WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        modalPage = new TeacherAddPageImpl(driver);
    }

    @Test
    void teacherAddPageShouldLoadSuccessfullyWhenUserHasValidCredentials() {
        LoginPageHelper.correctLogin(new LoginPageImpl(driver));

        driver.findElement(By.cssSelector("button[data-bs-target='#createUserModal']")).click();

        assertThat("Modal window should be visible", modalPage.isModalOpen(), is(true));

        modalPage.enterEmail("teacher.test@example.com");
        modalPage.enterPassword("Password123");

        modalPage.enterPersonalDetails("Шевченко", "Тарас", "Григорович");
        modalPage.enterAcademicInfo("Професор", "Доцент", "2023-09-01");

        modalPage.selectFacultyByVisibleText("Інноваційних технологій");
        modalPage.selectDepartmentByVisibleText("Інженерії програмного забезпечення");

        modalPage.enterEducationDetails("Київський національний університет",
                "Комп'ютерні науки", "2015-06-30");

        modalPage.clickSubmit();

        boolean isModalInvisible = wait.until(ExpectedConditions.invisibilityOfElementLocated(By
                .id("createUserModal")));
        assertThat("Modal window should close after successful submission", isModalInvisible, is(true));
    }

    @Test
    void teacherAddShouldFailWhenPasswordDoesNotMeetRequirements() {
        LoginPageHelper.correctLogin(new LoginPageImpl(driver));

        driver.findElement(By.cssSelector("button[data-bs-target='#createUserModal']")).click();

        assertThat("Modal window should be visible", modalPage.isModalOpen(), is(true));

        modalPage.enterEmail("teacher.invalid@example.com");
        modalPage.enterPassword("12345678");

        modalPage.enterPersonalDetails("Франко", "Іван", "Якович");
        modalPage.enterAcademicInfo("Доктор наук", "Професор", "2020-01-15");

        modalPage.selectFacultyByVisibleText("Інноваційних технологій");
        modalPage.selectDepartmentByVisibleText("Інженерії програмного забезпечення");

        modalPage.enterEducationDetails("Львівський університет", "Філологія",
                "2010-06-30");

        modalPage.clickSubmit();

        assertThat("Modal window should remain open due to invalid password validation",
                modalPage.isModalOpen(), is(true));
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
