package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver);
       
    }

    By pageTitleBy = By.xpath("//*[@id='maincontent']/div[3]/div/div[2]/div[2]/h2"); 
    // ubise me lokatori, nisam uspeo da ga vezem sa bilo cim racionalnim
    String expectedPageTitle = "Hot Sellers";

    By logOutTitleBy = By.xpath("//*[@id='maincontent']/div[1]/h1/span");
    String expectedLogoutText = "You are signed out";

    By expandButtonBy = By.xpath("/html/body/div[1]/header/div[1]/div/ul/li[2]/span");
    By logoutButtonBy = By.xpath("/html/body/div[1]/header/div[1]/div/ul/li[2]/div/ul/li[3]/a");
    
    public HomePage checkIfUserIsOnHomePage(){
        String curentPageTitle = readText(pageTitleBy);
        checkIfTextIsTheSame(expectedPageTitle, curentPageTitle);
        return this;
    }

    public HomePage checkIfUserCanLogout(){
        String curentLogoutTitle = readText(pageTitleBy);
        checkIfTextIsTheSame(expectedLogoutText, curentLogoutTitle);
        return this;
    }

    public HomePage clickOnExpand (){
        click(expandButtonBy);
        return this;
    }

    public HomePage clickOnLogout (){
        click(logoutButtonBy);
        return this;
    }

    public int countHotSellerItems(By elementBy) {
        waitVisible(elementBy);
        return driver.findElements(elementBy).size(); // metoda koja broji elemente
    }
        
    

    public void compareNumberOfElements (int expectedItems, int foundItems){
        Assert.assertEquals(expectedItems, foundItems); // poredjenje broja elemenata

}
}

