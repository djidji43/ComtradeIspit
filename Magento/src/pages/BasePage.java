package pages;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    public static WebDriver driver;
    public WebDriverWait wait;
    
    public BasePage(WebDriver driver){
        BasePage.driver = driver; 
        wait = new WebDriverWait(driver, Duration.ofSeconds(15)); // koliko dugo se ceka pokretanje browsera
       }

       public void waitVisible(By elementBy){
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementBy)); // cekanje da elementi budu vidljivi
    }

    
    public void waitClickable(By elementBy){
        wait.until(ExpectedConditions.elementToBeClickable(elementBy)); // cekanje da elementi budu klikabil
    }

    public void writeText(By elementBy, String text){
        waitClickable(elementBy);
        driver.findElement(elementBy).clear();
        driver.findElement(elementBy).sendKeys(text); // metoda za unos teksta
    }

    public void click(By elementBy){
        waitClickable(elementBy);
        driver.findElement(elementBy).click(); // metoda za klik
    }

    public String readText(By productsPriceBy){
        waitVisible(productsPriceBy);
        return driver.findElement(productsPriceBy).getText(); // metoda za citanje teksta
    }

    public void checkIfTextIsTheSame(String expectedWelcomeText, String foundText){
        Assert.assertEquals(expectedWelcomeText, foundText); // metoda za uporedjivanje teksta
    }

    public void checkIfElementIsVisible(By elementBy){
        waitVisible(elementBy);
        boolean isVisible = driver.findElement(elementBy).isDisplayed();
        Assert.assertTrue(isVisible); // metoda koja proverava da li je element vidljiv
    }

    public int countItems(By elementBy){
        waitVisible(elementBy);
        return driver.findElements(elementBy).size(); // metoda koja broji elemente
    }

    public void verifyElementNotDisplayed (By elementBy){
        boolean isNotVisible;

        try{
            waitVisible(elementBy);
            isNotVisible = !driver.findElement(elementBy).isDisplayed();
        }
        catch (Exception e){
            isNotVisible = true;
        }

        Assert.assertTrue(isNotVisible); // metoda koja proverava da element nije vidljiv
    }
}