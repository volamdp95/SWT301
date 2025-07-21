package tests;

import org.junit.jupiter.api.*;
import pages.LoginPage;
import pages.RegistrationPage;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("Registration Tests - EasyGo")
public class RegistrationTest extends BaseTest {

    static LoginPage loginPage;
    static RegistrationPage registrationPage;

    @BeforeAll
    static void setupPages() {
        loginPage = new LoginPage(driver);
        registrationPage = new RegistrationPage(driver);
    }

    @Test
    @Order(1)
    @DisplayName("TC06 - Navigate to Registration page from Login page")
    void testNavigateToRegistration() {
        loginPage.navigate();
        loginPage.clickRegisterLink();
        assertTrue(registrationPage.isRegisterFormDisplayed(), "Registration form should be displayed after clicking the link.");
    }

    @Test
    @Order(2)
    @DisplayName("TC07 - Register with valid information")
    void testSuccessfulRegistration() {
        loginPage.navigate();
        loginPage.clickRegisterLink();

        registrationPage.enterFullName("LeMinhNhat");
        registrationPage.enterEmail("hehe" + System.currentTimeMillis() + "@example.com");
        registrationPage.enterPassword("password123");
        registrationPage.enterPhone("0123456789");
        registrationPage.clickRegisterButton();

        assertEquals("https://localhost:7034/login", driver.getCurrentUrl(), "Should be redirected to login page.");
        assertTrue(loginPage.getSuccessMessage().contains("Đăng ký thành công!"), "Success message should be displayed.");
    }

    @Test
    @Order(3)
    @DisplayName("TC08 - Register with an already existing email")
    void testRegistrationWithExistingEmail() {
        loginPage.navigate();
        loginPage.clickRegisterLink();

        registrationPage.enterFullName("ExistingUser");
        registrationPage.enterEmail("minh@example.com");
        registrationPage.enterPassword("password123");
        registrationPage.clickRegisterButton();
        assertTrue(loginPage.getErrorMessage().contains("Email đã tồn tại hoặc có lỗi xảy ra"), "Error message for existing email should be displayed.");
    }

    @Test
    @Order(4)
    @DisplayName("TC09 - Register with empty required fields")
    void testRegistrationWithEmptyFields() {
        loginPage.navigate();
        loginPage.clickRegisterLink();
        registrationPage.clickRegisterButton();

        assertTrue(registrationPage.isRegisterFormDisplayed(), "Should remain on the registration page.");
        assertTrue(loginPage.getErrorMessage().isEmpty(), "No custom error message should be displayed.");

        var fullNameInput = driver.findElement(org.openqa.selenium.By.id("regFullName"));
        String validationMessage = fullNameInput.getAttribute("validationMessage");
        assertNotNull(validationMessage);
        assertFalse(validationMessage.isEmpty(), "Validation message should be present for required field.");
    }

    @Test
    @Order(5)
    @DisplayName("TC10 - Register with weak (short) password")
    void testRegistrationWithShortPassword() {
        loginPage.navigate();
        loginPage.clickRegisterLink();

        registrationPage.enterFullName("ShortPassUser");
        registrationPage.enterEmail("shortpass" + System.currentTimeMillis() + "@example.com");
        registrationPage.enterPassword("123");
        registrationPage.enterPhone("0123456789");
        registrationPage.clickRegisterButton();

        new org.openqa.selenium.support.ui.WebDriverWait(driver, java.time.Duration.ofSeconds(2))
                .until(org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated(
                        org.openqa.selenium.By.id("client-register-error")));

        String actualError = registrationPage.getRegisterErrorMessage();
        assertTrue(registrationPage.isRegisterFormDisplayed(), "Should remain on the registration page.");
        assertTrue(actualError.contains("Vui lòng điền đầy đủ thông tin: mật khẩu phải có ít nhất 6 ký tự"), "Error message for short password should be displayed.");
    }
}
