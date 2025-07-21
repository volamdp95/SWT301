package tests;

import org.junit.jupiter.api.*;
import pages.RegistrationPage;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("Student Registration Form Tests")
 class RegistrationTest extends BaseTest {

    static RegistrationPage regPage;

    @BeforeAll
    static void setup() {
        regPage = new RegistrationPage(driver);
    }

    @Test
    @Order(1)
    @DisplayName("TC01 - Submit form with valid basic information")
    void testSubmitValidForm() {
        regPage.navigate();
        regPage.enterFirstName("Linh");
        regPage.enterLastName("Pham");
        regPage.enterEmail("linh.pham2025@example.com");
        regPage.selectGender("female");
        regPage.enterMobile("0912345678");
        regPage.setDateOfBirth("15 Jun 2000");
        regPage.enterSubject("Math");
        regPage.selectHobby("reading");
        regPage.uploadPicture("anh-mo-ta.jpg");
        regPage.enterAddress("123 Nguyen Trai, Hanoi");
        regPage.selectState("NCR");
        regPage.selectCity("Delhi");
        regPage.submitForm();

        assertTrue(regPage.isConfirmationModalDisplayed());
        assertEquals("Thanks for submitting the form", regPage.getConfirmationTitle());
    }

    @Test
    @Order(2)
    @DisplayName("TC03 - Submit form with invalid email (negative case)")
    void testSubmitWithInvalidEmail() {
        regPage.navigate();
        regPage.enterFirstName("Nam");
        regPage.enterLastName("Tran");
        regPage.enterEmail("namtran@invalid"); // Email sai định dạng
        regPage.selectGender("male");
        regPage.enterMobile("0933221144");
        regPage.setDateOfBirth("20 Dec 1999");
        regPage.enterSubject("Chemistry");
        regPage.selectHobby("music");
        regPage.uploadPicture("anh-mo-ta.jpg");
        regPage.enterAddress("456 Le Duan, Da Nang");
        regPage.selectState("NCR");
        regPage.selectCity("Delhi");
        regPage.submitForm();

        assertFalse(regPage.isConfirmationModalDisplayed());
    }

    @Test
    @Order(3)
    @DisplayName("TC04 - Submit form with all hobbies and multiple subjects")
    void testSubmitWithMultipleHobbiesSubjects() {
        regPage.navigate();
        regPage.enterFirstName("Tuan");
        regPage.enterLastName("Nguyen");
        regPage.enterEmail("tuan.nguyen@example.com");
        regPage.selectGender("other");
        regPage.enterMobile("0999888777");
        regPage.setDateOfBirth("12 Feb 2002");
        regPage.enterSubject("Math");
        regPage.enterSubject("English");
        regPage.selectHobby("sports");
        regPage.selectHobby("music");
        regPage.uploadPicture("anh-mo-ta.jpg");
        regPage.enterAddress("15B Hoang Hoa Tham, HCMC");
        regPage.selectState("Uttar Pradesh");
        regPage.selectCity("Lucknow");
        regPage.submitForm();

        assertTrue(regPage.isConfirmationModalDisplayed());
    }

    @Test
    @Order(4)
    @DisplayName("TC05 - Submit form with empty fields (negative case)")
    void testSubmitEmptyForm() {
        regPage.navigate();
        regPage.submitForm();

        assertFalse(regPage.isConfirmationModalDisplayed());
    }

    @Test
    @Order(5)
    @DisplayName("TC06 - Submit form with invalid mobile number (negative case)")
    void testSubmitWithInvalidMobile() {
        regPage.navigate();
        regPage.enterFirstName("Quang");
        regPage.enterLastName("Bui");
        regPage.enterEmail("quang.bui@example.com");
        regPage.selectGender("male");
        regPage.enterMobile("12abc345"); // Số điện thoại không hợp lệ
        regPage.setDateOfBirth("05 Sep 2001");
        regPage.enterSubject("Biology");
        regPage.selectHobby("reading");
        regPage.uploadPicture("anh-mo-ta.jpg");
        regPage.enterAddress("789 Vo Thi Sau, Can Tho");
        regPage.selectState("NCR");
        regPage.selectCity("Delhi");
        regPage.submitForm();

        assertFalse(regPage.isConfirmationModalDisplayed());
    }

    @Test
    @Order(6)
    @DisplayName("TC07 - Submit form with very long address")
    void testSubmitWithLongAddress() {
        regPage.navigate();
        regPage.enterFirstName("Mai");
        regPage.enterLastName("Le");
        regPage.enterEmail("mai.le@example.com");
        regPage.selectGender("female");
        regPage.enterMobile("0977665544");
        regPage.setDateOfBirth("19 Mar 1998");
        regPage.enterSubject("Physics");
        regPage.selectHobby("reading");
        regPage.uploadPicture("anh-mo-ta.jpg");
        // Địa chỉ rất dài
        String longAddress = "B".repeat(500);
        regPage.enterAddress(longAddress);
        regPage.selectState("NCR");
        regPage.selectCity("Delhi");
        regPage.submitForm();

        assertTrue(regPage.isConfirmationModalDisplayed());
    }

    @Test
    @Order(7)
    @DisplayName("TC08 - Submit form with future date of birth (negative case)")
    void testSubmitWithFutureDOB() {
        regPage.navigate();
        regPage.enterFirstName("Vu");
        regPage.enterLastName("Pham");
        regPage.enterEmail("vu.pham@example.com");
        regPage.selectGender("male");
        regPage.enterMobile("0988776655");
        regPage.setDateOfBirth("01 Jan 2100"); // Ngày sinh ở tương lai
        regPage.enterSubject("Math");
        regPage.selectHobby("reading");
        regPage.uploadPicture("anh-mo-ta.jpg");
        regPage.enterAddress("321 Tran Phu, Da Lat");
        regPage.selectState("NCR");
        regPage.selectCity("Delhi");
        regPage.submitForm();

        assertTrue(regPage.isConfirmationModalDisplayed());
    }
}
