package com.bohdan.page;

/**
 * Interface representing the login page of the application.
 * Provides methods to interact with the login page elements and perform login actions.
 */
public interface LoginPage {
    /**
     * Method to perform login action with given username and password.
     *
     * @param url the URL of the login page
     * @param username the username to enter
     * @param password the password to enter
     */
    void login(String url, String username, String password);

    /**
     * Method to check if an error message is displayed on the login page.
     *
     * @return true if an error message is displayed, false otherwise
     */
    boolean isErrorDisplayed();
}
