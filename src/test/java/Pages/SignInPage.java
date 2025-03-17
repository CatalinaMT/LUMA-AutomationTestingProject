package Pages;

import HelperMethods.ElementsMethods;
import Logger.LoggerUtility;
import ObjectData.CreateAccount_SignIn_ObjectData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignInPage
{
    WebDriver driver;
    ElementsMethods elementsMethods;

    public SignInPage(WebDriver driver)
    {
        this.driver = driver;
        this.elementsMethods = new ElementsMethods(driver);
        PageFactory.initElements(driver, this);
    }


    //identificarea WebElementelor de pe pagina de SignIn

    @FindBy (id="email")
    WebElement emailFieldSignIn;

    @FindBy (id="pass")
    WebElement passwordFieldSignIn;

    @FindBy (xpath = "//button[@class='action login primary']")
    WebElement signInButton;

    //identificare text "My Account"
    @FindBy (xpath = "//*[@class='base']")
    WebElement signInSuccessfullyMessage;

    //identificare mesaj eroare
    @FindBy (xpath = "//*[@class='message-error error message']")
    WebElement unsuccessfullySignInMessage;

    //metode
    //Sign In cu credentiale valide - happy flow
    public void completeSignInPositiveFlow(CreateAccount_SignIn_ObjectData data3)
    {
        elementsMethods.fillElement(emailFieldSignIn, data3.getEmailSignIn1());
        LoggerUtility.infoTest("The user completes email field");
        elementsMethods.fillElement(passwordFieldSignIn, data3.getPasswordSignIn1());
        LoggerUtility.infoTest("The user completes password field");
    }


    //Sign In cu credentiale invalide - negative flow
    public void completeSignInNegativeFlow(CreateAccount_SignIn_ObjectData data4)
    {
        elementsMethods.fillElement(emailFieldSignIn, data4.getEmailSignIn2());
        LoggerUtility.infoTest("The user completes email field");
        elementsMethods.fillElement(passwordFieldSignIn, data4.getPasswordSignIn2());
        LoggerUtility.infoTest("The user completes password field");
    }


    public void clickOnSignInButton ()
    {
        elementsMethods.clickOnElement(signInButton);
    }


    //textul "My Account" (true/false) din Positive Flow
    public boolean signInSuccessfullyMessageDisplayed()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(signInSuccessfullyMessage));
        return signInSuccessfullyMessage.isDisplayed();
    }

    //mesajul de eroare (true/false) din Negative Flow
    public boolean unsuccessfullySignInMessageDisplayed()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(unsuccessfullySignInMessage));
        return unsuccessfullySignInMessage.isDisplayed();
    }



}
