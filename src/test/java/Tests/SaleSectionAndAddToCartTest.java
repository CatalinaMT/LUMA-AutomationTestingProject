package Tests;

import HelperMethods.ElementsMethods;
import HelperMethods.JavascriptMethods;
import Logger.LoggerUtility;
import Pages.HomePage;
import Pages.SaleSectionAndAddToCartPage;
import ShareDataBrowser.Hooks;

import com.aventstack.chaintest.plugins.ChainTestListener;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;

public class SaleSectionAndAddToCartTest extends Hooks {

    HomePage homePage;
    SaleSectionAndAddToCartPage saleSectionAndAddToCartPage;
    ElementsMethods elementsMethods;
    JavascriptMethods javascriptMethods;

    @Test

    public void metodaTest() {

        homePage = new HomePage(getDriver());
        saleSectionAndAddToCartPage = new SaleSectionAndAddToCartPage(getDriver());
        elementsMethods = new ElementsMethods(getDriver());
        javascriptMethods = new JavascriptMethods(getDriver());

        ChainTestListener.log("Chrome opened");

        homePage.clickOnSaleButtonHomePage();
        LoggerUtility.infoTest("The user clicks on Sale Button from Home Page");
        ChainTestListener.log("User clicks on Sale Button from Home Page");

        javascriptMethods.scrollOnPage(0, 300);
        LoggerUtility.infoTest("The user scrolls on page");
        ChainTestListener.log("User scrolled on page");

        saleSectionAndAddToCartPage.dealWithExpandStyle();
        LoggerUtility.infoTest("The user waite until Style Locator expanded and after that it closed. Also user expands Size section");
        ChainTestListener.log("User waited until Style Locator expanded and after that it closed. Also user expanded Size section");

        saleSectionAndAddToCartPage.dealWithJacketFromSaleButton();
        LoggerUtility.infoTest("The user clicks on Jacket section from Sale Page");
        ChainTestListener.log("User clicked on Jacket section from Sale Page");

        saleSectionAndAddToCartPage.filterXSjackets();
        LoggerUtility.infoTest("User clicks on the XS size filter on the Jackets Page");
        ChainTestListener.log("User clicked on the XS size filter on the Jackets Page");

        javascriptMethods.scrollOnPage(0, 300);
        LoggerUtility.infoTest("The user scrolls on page");
        ChainTestListener.log("User scrolled on page");

        saleSectionAndAddToCartPage.sortByLowToHighPrice();
        LoggerUtility.infoTest("The user selects first XS Jacket with the lowest price");
        ChainTestListener.log("User selected first XS Jacket with the lowest price");

        saleSectionAndAddToCartPage.hoverOverXSjacket();
        LoggerUtility.infoTest("The user hovers over the first XS Jacket with the lowest price");
        ChainTestListener.log("User hovers over the first XS Jacket with the lowest price");

        saleSectionAndAddToCartPage.dealWithJacketColor();
        LoggerUtility.infoTest("The user selects the green color for the first XS Jacket with the lowest price");
        ChainTestListener.log("User selected the green color for the first XS Jacket with the lowest price");

        saleSectionAndAddToCartPage.addToCart();
        LoggerUtility.infoTest("The user clicks on Add To Cart Button to put the selected jacket in the basket");
        ChainTestListener.log("User clicked on Add To Cart Button to put the selected jacket in the basket");

    }
}
