package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage extends BasePage{

String baseUrl = "https://magento.softwaretestingboard.com";
String loginUrl = "https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS8%2C/";

By emailBy = By.xpath("//*[@id='email']");
By passwordBy = By.xpath("//*[@id='pass']");
By signInButtonBy = By.xpath("//*[@id='send2']/span");
    
    public LoginPage(WebDriver driver){
        super(driver);
    }

    public LoginPage goToLoginUrl(){
        driver.get(loginUrl);
        return this;
    }
    public LoginPage login(String email, String password){
        writeText(emailBy, email);
        writeText(passwordBy, password);
        click(signInButtonBy);
        return this;
    }


}
