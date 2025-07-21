package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private final By emailInput = By.id("email");
    private final By passwordInput = By.id("password");
    private final By loginButton = By.cssSelector("form.login-container:not([id]) button[type='submit']");
    private final By errorMessage = By.xpath("//div[contains(@style,'#fee')]");
    private final By successMessage = By.xpath("//div[contains(@style,'#efe')]");
    private final By registerLink = By.xpath("//a[text()='Đăng ký']");

    public void navigate() { navigateTo("https://localhost:7034/login"); }
    public void enterEmail(String email) { type(emailInput, email); }
    public void enterPassword(String password) { type(passwordInput, password); }
    public void clickLogin() { click(loginButton); }
    public void clickRegisterLink() { click(registerLink); }
    public String getErrorMessage() {
        return isElementVisible(errorMessage) ? getText(errorMessage) : "";
    }
    public String getSuccessMessage() {
        return isElementVisible(successMessage) ? getText(successMessage) : "";
    }
}
