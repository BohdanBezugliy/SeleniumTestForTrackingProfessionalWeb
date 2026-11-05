package com.bohdan.helper;

import com.bohdan.page.LoginPageImpl;

/**
 * Helper class for the "Login" page tests.
 * Provides utility methods to perform common actions related to the login process.
 */
public final class LoginPageHelper {

    /**
     * Private constructor to prevent instantiation of this utility class.
     */
    private LoginPageHelper() {
    }

    /**
     * Performs a correct login using the provided {@link LoginPageImpl} instance.
     *
     * @param loginPage the {@link LoginPageImpl} instance to use for login
     */
    public static void correctLogin(LoginPageImpl loginPage) {
        loginPage.login("http://localhost:8080",
                "admin@example.com",
                "adminPassword");
    }
}
