package TestScenario;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Objects.TwitterLoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TwitterLoginTest {
     WebDriver driver;
     
     
     
     @BeforeMethod
     public void beforemethod() {
    	 WebDriverManager.chromedriver().setup();
    	 driver = new ChromeDriver();
    	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	 
    	 driver.get("https://twitter.com/i/flow/login");
     }
     
     @Test
     public void testInvalidLogin() {
         TwitterLoginPage loginPage = new TwitterLoginPage(driver);
         loginPage.setUsername("invalid_username");
         loginPage.setPassword("valid_password");
         loginPage.clickLogin();

         String errorMessage = loginPage.getErrorMessage();
         Assert.assertEquals(errorMessage, "The username and password you entered did not match");
     }
     @Test
     public void testEmptyPasswordField() {
         TwitterLoginPage loginPage = new TwitterLoginPage(driver);
         loginPage.setUsername("valid_username");
         // Leaving the password field empty
         loginPage.clickLogin();

         String errorMessage = loginPage.getErrorMessage();
         Assert.assertEquals(errorMessage, "The username and password you entered did not match");
     }

     @AfterMethod
     public void aftermethod() {
    	 driver.quit();
     }
}     
     
    
    