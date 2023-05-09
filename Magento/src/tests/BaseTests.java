package tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BaseTests {
    public WebDriver driver;
    public FirefoxOptions options;  

    String email = "marko.kadijevic@icloud.com";
    String password = "Marko88!";


    @Before
    public void setUp(){
        options = new FirefoxOptions();
        
        
        driver = new FirefoxDriver(options);
        driver.manage().window().maximize(); // maximize Firefox
    }

    @After
    public void tearDown(){
        driver.quit(); // zatvaranje browsera
    }
}
