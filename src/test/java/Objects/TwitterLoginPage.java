package Objects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class TwitterLoginPage {
	WebDriver driver;
	By usernameField = By.xpath("//input[@name='session[username_or_email]']");
	By passwordField = By.xpath("//input[@name='session[password]']");
	By loginButton = By.xpath("//div[@data-testid='LoginForm_Login_Button']");
	
	public TwitterLoginPage(WebDriver driver) {
		this.driver = driver;
	}
    
	

    public void setUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void setPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public String getErrorMessage() {
        By errorLocator = By.xpath("//span[contains(text(),'The username and password you entered did not match')]");
        return driver.findElement(errorLocator).getText();
    }
}

