package com.bohdan;

import com.bohdan.helper.LoginPageHelper;
import com.bohdan.page.LoginPageImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Test class for {@link LoginPageImpl}.
 * Contains test methods to verify the functionality of the "Login" page.
 */
public class LoginPageImplTest {

    private LoginPageImpl loginPageImpl;

    private WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        loginPageImpl = new LoginPageImpl(driver);
    }

    @Test
    void loginPageShouldLoadSuccessfullyWhenUserHasValidCredentials() {
        LoginPageHelper.correctLogin(loginPageImpl);
    }

    @Test
    void loginPageShouldLoadSuccessfullyWhenUserHasInvalidCredentials() {
        loginPageImpl.login("http://localhost:8080",
                "invalid@example.com",
                "invalidPassword");
        assertThat(loginPageImpl.isErrorDisplayed(), is(true));
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
