package tests;

import javax.xml.xpath.XPath;

import org.junit.Test;

import pages.HomePage;
import pages.LoginPage;

public class HomeTests extends BaseTests{
    @Test

    public void verityHotSellersItems (){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.goToLoginUrl();
        loginPage.login(email, password);

        homePage.countHotSellerItems("$");
        homePage.compareNumberOfElements(6, 6);
    }
}
