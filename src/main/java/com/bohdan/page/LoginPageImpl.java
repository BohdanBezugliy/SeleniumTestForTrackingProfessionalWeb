package com.bohdan.page;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

/**
 * Implementation of the {@link LoginPage} interface using Selenium WebDriver.
 * Provides methods to interact with the login page elements and perform login actions.
 */
public class LoginPageImpl implements LoginPage {

    private final By emailField = By.id("username");

    private final By passwordField = By.id("password");

    private final By loginButton = By.cssSelector("button[type='submit']");

    private final By errorMessage = By.cssSelector("div.alert.alert-danger");

    private final WebDriver driver;

    private final WebDriverWait wait;

    /**
     * Constructor for {@link LoginPageImpl}.
     *
     * @param driver the WebDriver instance to interact with the web page
     */
    public LoginPageImpl(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    /**
     * Opens the login page with the specified URL.
     *
     * @param url the URL of the login page
     */
    private void open(String url) {
        driver.get(url);
    }

    /**
     * Enters the email into the email field on the login page.
     *
     * @param email the email to enter
     */
    private void enterEmail(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailField)).clear();
        driver.findElement(emailField).sendKeys(email);
    }

    /**
     * Enters the password into the password field on the login page.
     *
     * @param password the password to enter
     */
    private void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField)).clear();
        driver.findElement(passwordField).sendKeys(password);
    }

    /**
     * Clicks the login button on the login page.
     */
    private void clickLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }

    @Override
    public void login(String url,String email, String password) {
        open(url);
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();
    }

    @Override
    public boolean isErrorDisplayed() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage)).isDisplayed();
        } catch (TimeoutException _) {
            return false;
        }
    }
}
