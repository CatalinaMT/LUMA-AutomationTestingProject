package Pages;

import HelperMethods.ElementsMethods;
import HelperMethods.SaleSectionAndAddToCartMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SaleSectionAndAddToCartPage {

    WebDriver driver;
    ElementsMethods elementsMethods;
    SaleSectionAndAddToCartMethods saleSectionAndAddToCartMethods;

    public SaleSectionAndAddToCartPage(WebDriver driver)
    {
        this.driver = driver;
        this.elementsMethods = new ElementsMethods(driver);
        this.saleSectionAndAddToCartMethods = new SaleSectionAndAddToCartMethods(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[4]/div[2]/div/div/ul[1]/li[2]/a")
    WebElement jacketFromSaleButton;

//    @FindBy(xpath = "//*[@class='filter-options-title']")
//    List<WebElement> saleMeniu;

//    @FindBy(xpath = "div[data-role='title'][class='filter-options-title']")
//    WebElement elementLocatorStyleSale;

    @FindBy(xpath = "div[class='swatch-option text '][option-id='166']")
    WebElement filterForJacketSize;

    @FindBy(id="sorter")
    WebElement sortElements;

    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[1]/div")
    WebElement selectXsJacket;

    @FindBy(id = "option-label-color-93-item-53")
    WebElement selectJacketColor;

    @FindBy(id = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[1]/div/div/div[4]/div/div[1]/form/button")
    WebElement jacketToCart;


    public void dealWithJacketFromSaleButton()
    {
        elementsMethods.clickOnElement(jacketFromSaleButton);

    }






    public void dealWithExpandStyle()
    {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        List<WebElement> meniu = driver.findElements(By.xpath("//*[@class='filter-options-title']"));//Meniul Jackets Shopping Options din Sale
        WebElement elementLocatorStyle = driver.findElement(By.cssSelector("div[data-role='title'][class='filter-options-title']")); //identificare STYLE-cand dam refrash pe pagina, se expandeaza pt cateva secunde si dupa se inchide
        wait.until(ExpectedConditions.attributeToBe(elementLocatorStyle, "aria-expanded", "false"));//asteapta pana cand atributul aria expanded pentru Style este false, adica Style nu mai e expandat
        meniu.get(0).click();// click pentru expandarea unui element din lista

        elementsMethods.clickOnElement(elementLocatorStyle);

    }





}
