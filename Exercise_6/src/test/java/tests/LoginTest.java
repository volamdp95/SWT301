package tests;

import org.junit.jupiter.api.*;
import pages.LoginPage;
import static org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("Login Tests - EasyGo")
public class LoginTest extends BaseTest {

    static LoginPage loginPage;

    @BeforeAll
    static void setup() {
        loginPage = new LoginPage(driver);
    }

    @Test
    @Order(1)
    @DisplayName("TC01 - Login with valid credentials")
    void testValidLogin() {
        loginPage.navigate();
        loginPage.enterEmail("minh@example.com");
        loginPage.enterPassword("pass123");
        loginPage.clickLogin();
        assertEquals("https://localhost:7034/", driver.getCurrentUrl());
    }

    @Test
    @Order(2)
    @DisplayName("TC02 - Login with invalid password")
    void testInvalidPassword() {
        loginPage.navigate();
        loginPage.enterEmail("minh@example.com");
        loginPage.enterPassword("1231234d");
        loginPage.clickLogin();
        assertTrue(loginPage.getErrorMessage().contains("Mật khẩu không đúng"));
    }

    @Test
    @Order(3)
    @DisplayName("TC03 - Login with empty fields")
    void testEmptyLogin() {
        loginPage.navigate();
        loginPage.enterEmail("");
        loginPage.enterPassword("");
        loginPage.clickLogin();
        assertEquals("https://localhost:7034/login", driver.getCurrentUrl());
        WebElement emailInput = driver.findElement(By.id("email"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        assertNotNull(emailInput.getAttribute("required"));
        assertNotNull(passwordInput.getAttribute("required"));
    }

    @Test
    @Order(4)
    @DisplayName("TC04 - Login with invalid email format")
    void testInvalidEmailFormat() {
        loginPage.navigate();
        loginPage.enterEmail("invalid-email");
        loginPage.enterPassword("pass123");
        loginPage.clickLogin();
        assertEquals("https://localhost:7034/login", driver.getCurrentUrl());
        WebElement emailInput = driver.findElement(By.id("email"));
        String validationMessage = emailInput.getAttribute("validationMessage");
        assertNotNull(validationMessage, "Validation message should be present for invalid email format.");
        assertFalse(validationMessage.isEmpty(), "Validation message should not be empty for invalid email format.");
    }

    @Test
    @Order(5)
    @DisplayName("TC05 - Login with non-existent or locked account")
    void testNonExistentOrLockedAccount() {
        loginPage.navigate();
        loginPage.enterEmail("nonexistent@example.com");
        loginPage.enterPassword("anypassword");
        loginPage.clickLogin();
        assertTrue(loginPage.getErrorMessage().contains("Email không tồn tại hoặc tài khoản đã bị khóa"));
    }
}
