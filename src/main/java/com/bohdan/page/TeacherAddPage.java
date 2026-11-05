package com.bohdan.page;

/**
 * Interface representing the "Add Teacher" page of the application.
 * Provides methods to interact with the elements on the page for adding a new teacher.
 */
public interface TeacherAddPage {
    /**
     * Method to check if the modal window for adding a teacher is open.
     *
     * @return true if the modal window is open, false otherwise
     */
    boolean isModalOpen();

    /**
     * Method to enter the email into the email field on the "Add Teacher" page.
     *
     * @param email the email to enter
     */
    void enterEmail(String email);

    /**
     * Method to enter the password into the password field on the "Add Teacher" page.
     *
     * @param password the password to enter
     */
    void enterPassword(String password);

    /**
     * Method to enter personal details of the teacher.
     *
     * @param lastName the last name of the teacher
     * @param firstName the first name of the teacher
     * @param middleName the middle name of the teacher
     */
    void enterPersonalDetails(String lastName, String firstName, String middleName);

    /**
     * Method to enter academic information of the teacher.
     *
     * @param degree the academic degree of the teacher
     * @param rank the academic rank of the teacher
     * @param hireDate the hire date of the teacher in "YYYY-MM-DD" format
     */
    void enterAcademicInfo(String degree, String rank, String hireDate);

    /**
     * Method to select a faculty from the dropdown by visible text.
     *
     * @param facultyName the visible text of the faculty to select
     */
    void selectFacultyByVisibleText(String facultyName);

    /**
     * Method to select a department from the dropdown by visible text.
     *
     * @param departmentName the visible text of the department to select
     */
    void selectDepartmentByVisibleText(String departmentName);

    /**
     * Method to enter education details of the teacher.
     *
     * @param institution the name of the educational institution
     * @param specialization the specialization of the teacher
     * @param endingDate the ending date of the education in "YYYY-MM-DD" format
     */
    void enterEducationDetails(String institution, String specialization, String endingDate);

    /**
     * Method to click the submit button on the "Add Teacher" page.
     */
    void clickSubmit();
}
