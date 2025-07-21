package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage extends BasePage {

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    private final By registerForm = By.id("registerForm");
    private final By fullNameInput = By.id("regFullName");
    private final By emailInput = By.id("regEmail");
    private final By passwordInput = By.id("regPassword");
    private final By phoneInput = By.id("regPhone");
    private final By registerButton = By.cssSelector("#registerForm button[type='submit']");
    private final By loginLink = By.xpath("//a[text()='Đã có tài khoản? Đăng nhập']");
    private final By registerErrorDiv = By.id("client-register-error");

    public boolean isRegisterFormDisplayed() { return isElementVisible(registerForm); }
    public void enterFullName(String fullName) { type(fullNameInput, fullName); }
    public void enterEmail(String email) { type(emailInput, email); }
    public void enterPassword(String password) { type(passwordInput, password); }
    public void enterPhone(String phone) { type(phoneInput, phone); }
    public void clickRegisterButton() { click(registerButton); }
    public void clickLoginLink() { click(loginLink); }
    public String getRegisterErrorMessage() {
        return isElementVisible(registerErrorDiv) ? getText(registerErrorDiv) : "";
    }
}
