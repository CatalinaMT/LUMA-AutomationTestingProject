package Tests;


import HelperMethods.ElementsMethods;
import Pages.HomePage;
import Pages.SaleSectionAndAddToCartPage;
import ShareDataBrowser.Hooks;

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
            //WebDriver driver;
            HomePage homePage;
            SaleSectionAndAddToCartPage saleSectionAndAddToCartPage;


    @Test

    public void metodaTest() {

//        driver = new ChromeDriver();
//        driver.get("https://magento.softwaretestingboard.com/");
//        driver.manage().window().maximize();

        homePage = new HomePage(getDriver());
        saleSectionAndAddToCartPage = new SaleSectionAndAddToCartPage(getDriver());
        homePage.clickOnSale();

        saleSectionAndAddToCartPage.dealWithExpandStyle();






//        WebElement saleButton = driver.findElement(By.xpath("//span[text()='Sale']"));
//        saleButton.click();
//
//        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
//        javascriptExecutor.executeScript("window.scrollTo(0,285)");
//
//
//        WebElement jacketSaleButton = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[4]/div[2]/div/div/ul[1]/li[2]/a"));
//        jacketSaleButton.click();
//        javascriptExecutor.executeScript("window.scrollTo(0,285)");
//
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));  //driver wait - explicit care seteaza n secunde sa astepte
//
//        List<WebElement> meniu = driver.findElements(By.xpath("//*[@class='filter-options-title']"));//Meniul Jackets Shopping Options din Sale
//        WebElement elementLocatorStyle = driver.findElement(By.cssSelector("div[data-role='title'][class='filter-options-title']")); //identificare STYLE-cand dam refrash pe pagina, se expandeaza pt cateva secunde si dupa se inchide
//        wait.until(ExpectedConditions.attributeToBe(elementLocatorStyle, "aria-expanded", "false"));//asteapta pana cand atributul aria expanded pentru Style este false, adica Style nu mai e expandat
//        meniu.get(1).click();// click pentru expandarea unui element din lista
//
//
//
//
//
//        filtru pentru marime Jackets din sectiunea Sale, marimea XS
//    WebElement filterSizeJacketXs = driver.findElement(By.cssSelector("div[class='swatch-option text '][option-id='166']"));
//    filterSizeJacketXs.click();
//
//        javascriptExecutor.executeScript("window.scrollTo(0,300)");
//
//        //sortare in functie de pret, de la cel mai mic la cel mai mare
//        WebElement sortBy = driver.findElement(By.id("sorter"));
//        Select sortByHelp = new Select(sortBy);
//        sortByHelp.selectByIndex(2);
//
//        javascriptExecutor.executeScript("window.scrollTo(0,300)");
//
//        //hover peste produs, selectare culoare si adaugare in cos
//        WebElement xsJacketProduct = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[1]/div"));
//        Actions actions = new Actions(driver);
//        actions.moveToElement(xsJacketProduct)
//                .build()
//                .perform();
//
//        WebElement selectGreenColor = driver.findElement(By.id("option-label-color-93-item-53"));
//        selectGreenColor.click();
//
//        WebElement addJacketToCart = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[1]/div/div/div[4]/div/div[1]/form/button"));
//        addJacketToCart.click();
//
//       //am mutat mouse-ul de pe produsul adaugat in cos
//        actions.moveToLocation(0,200)
//                    .build()
//                        .perform();
//
//        javascriptExecutor.executeScript("window.scrollTo(0,50)");
//









    }
}
