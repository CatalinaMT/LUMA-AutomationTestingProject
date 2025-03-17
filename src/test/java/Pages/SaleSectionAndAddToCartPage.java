package Pages;

import HelperMethods.ElementsMethods;
import HelperMethods.JavascriptMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SaleSectionAndAddToCartPage {

    WebDriver driver;
    ElementsMethods elementsMethods;


    public SaleSectionAndAddToCartPage(WebDriver driver)
    {
        this.driver = driver;
        this.elementsMethods = new ElementsMethods(driver);
        PageFactory.initElements(driver, this);
    }


    //identificarea WebElementelor utilizate de pe pagina de Sale
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[4]/div[2]/div/div/ul[1]/li[2]/a")
    WebElement jacketFromSaleButton;

    @FindBy(xpath = "div[class='swatch-option text '][option-id='166']")
    WebElement xsJacketsFilter;

    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[1]/div")
    WebElement firstXsJacket;

    @FindBy(id = "option-label-color-93-item-53")
    WebElement greenColorJacket;

    @FindBy(id = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[1]/div/div/div[4]/div/div[1]/form/button")
    WebElement addToCartButton;


    //metode

    public void dealWithExpandStyle()
    {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
            List<WebElement> meniu = driver.findElements(By.xpath("//*[@class='filter-options-title']"));//Meniul Jackets Shopping Options din Sale
            WebElement elementLocatorStyle = driver.findElement(By.cssSelector("div[data-role='title'][class='filter-options-title']")); //identificare STYLE-cand dam refrash pe pagina, se expandeaza pt cateva secunde si dupa se inchide
            wait.until(ExpectedConditions.attributeToBe(elementLocatorStyle, "aria-expanded", "false"));//asteapta pana cand atributul aria expanded pentru Style este false, adica Style nu mai e expandat
            meniu.get(1).click();// click pentru expandarea elementului Size din Jackets
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //click pe Jackets din pagina de Sale
    public void dealWithJacketFromSaleButton()
    {
        elementsMethods.clickOnElement(jacketFromSaleButton);
    }


    //filtrarea jachetelor dupa marimea XS
    public void filterXSjackets()
    {
        try {
            elementsMethods.clickOnElement(xsJacketsFilter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //sortarea jachetelor in functie de pret, de la cel mai mic la cel mai mare
    public void sortByLowToHighPrice()
    {
        WebElement sortBy = driver.findElement(By.id("sorter"));
        Select sortByHelp = new Select(sortBy);
        sortByHelp.selectByIndex(2);
    }


    //hover peste jacheta XS cu pretul cel mai mic
    public void hoverOverXSjacket()
    {
        elementsMethods.hoverOverAnElement(firstXsJacket);
    }


    //alegerea culorii pentru jacheta selectata (culoarea verde)
    public void dealWithJacketColor()
    {
    elementsMethods.clickOnElement(greenColorJacket);
    }


    //adaugarea jachetei in cosul de cumparaturi
    public void addToCart()
    {
        try {
            elementsMethods.clickOnElement(addToCartButton);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
