package com.bohdan.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Implementation of the TeacherAddPage interface.
 * Provides methods to interact with the "Add Teacher" page of the application.
 */
public class TeacherAddPageImpl implements TeacherAddPage {

    private final By emailField = By.name("userRegistrationDto.email");
    private final By passwordField = By.name("userRegistrationDto.password");
    private final By lastNameField = By.name("lastName");
    private final By firstNameField = By.name("firstName");
    private final By middleNameField = By.name("middleName");
    private final By academicDegreeField = By.name("academicDegree");
    private final By academicRankField = By.name("academicRank");
    private final By hireDateField = By.name("hireDate");
    private final By facultySelect = By.id("facultySelect");
    private final By departmentSelect = By.id("departmentSelect");
    private final By institutionField = By.name("educations[0].institutionName");
    private final By specializationField = By.name("educations[0].specialization");
    private final By endingDateField = By.name("educations[0].endingDate");
    private final By submitButton = By.cssSelector("#createUserModal button[type='submit']");
    private final By modalWindow = By.id("createUserModal");

    private final WebDriver driver;

    private final WebDriverWait wait;


    public TeacherAddPageImpl(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Override
    public boolean isModalOpen() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(modalWindow)).isDisplayed();
    }

    @Override
    public void enterEmail(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailField)).sendKeys(email);
    }

    @Override
    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    @Override
    public void enterPersonalDetails(String lastName, String firstName, String middleName) {
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(firstNameField).sendKeys(firstName);
        if (middleName != null && !middleName.isEmpty()) {
            driver.findElement(middleNameField).sendKeys(middleName);
        }
    }

    @Override
    public void enterAcademicInfo(String degree, String rank, String hireDate) {
        driver.findElement(academicDegreeField).sendKeys(degree);
        driver.findElement(academicRankField).sendKeys(rank);
        driver.findElement(hireDateField).sendKeys(hireDate);
    }

    @Override
    public void selectFacultyByVisibleText(String facultyName) {
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(facultySelect));
        new Select(dropdown).selectByVisibleText(facultyName);
    }

    @Override
    public void selectDepartmentByVisibleText(String departmentName) {
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(departmentSelect));
        new Select(dropdown).selectByVisibleText(departmentName);
    }

    @Override
    public void enterEducationDetails(String institution, String specialization, String endingDate) {
        driver.findElement(institutionField).sendKeys(institution);
        driver.findElement(specializationField).sendKeys(specialization);
        driver.findElement(endingDateField).sendKeys(endingDate);
    }

    @Override
    public void clickSubmit() {
        driver.findElement(submitButton).click();
    }
}
