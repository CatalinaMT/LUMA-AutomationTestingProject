package Pages;

import HelperMethods.ElementsMethods;
import ShareDataBrowser.ShareData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage
{
    WebDriver driver;
    ElementsMethods elementsMethods;

    //constructorul pentru HomePage
    public HomePage(WebDriver driver)
    {
    this.driver = driver;
    this.elementsMethods = new ElementsMethods(driver);
    PageFactory.initElements(driver, this);
    }

    //identificarea WebElementelor de pe pagina de HomePage
    @FindBy(xpath = "/html/body/div[2]/header/div[1]/div/ul/li[3]/a")
    WebElement createAnACCButtonHomePage;

    @FindBy(xpath = "/html/body/div[2]/header/div[1]/div/ul/li[2]/a")
    WebElement signInHomeButton;

    @FindBy(xpath = "//span[text()='Sale']")
    WebElement saleButtonHomePage;

    //metode
    public void clickOnCreateAccButtonHome()
    {
            elementsMethods.clickOnElement(createAnACCButtonHomePage);
    }


    public void clickOnSignInHomeButton()
    {
        elementsMethods.clickOnElement(signInHomeButton);
    }


    public void clickOnSaleButtonHomePage()
    {
        elementsMethods.clickOnElement(saleButtonHomePage);
    }


}
