package com.bohdan;

import com.bohdan.helper.LoginPageHelper;
import com.bohdan.page.LoginPage;
import com.bohdan.page.LoginPageImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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

    private LoginPage pageImpl;

    private WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        pageImpl = new LoginPageImpl(driver);
    }

    @Test
    @DisplayName("Успішний вхід з коректними обліковими даними")
    void loginPageShouldLoadSuccessfullyWhenUserHasValidCredentials() {
        LoginPageHelper.correctLogin(pageImpl);
    }

    @Test
    @DisplayName("Показує помилку при вході з некоректними обліковими даними")
    void loginPageShouldLoadSuccessfullyWhenUserHasInvalidCredentials() {
        pageImpl.login("http://localhost:8080",
                "invalid@example.com",
                "invalidPassword");
        assertThat(pageImpl.isErrorDisplayed(), is(true));
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
