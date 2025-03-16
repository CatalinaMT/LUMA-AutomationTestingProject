package Pages;

import HelperMethods.ElementsMethods;
import HelperMethods.JavascriptMethods;
import Logger.LoggerUtility;
import ObjectData.CreateAccount_SignIn_ObjectData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CreateAnAccountPage
{

    WebDriver driver;
    ElementsMethods elementsMethods;
    JavascriptMethods javascriptMethods;

    public CreateAnAccountPage(WebDriver driver)
    {
        this.driver = driver;
        this.elementsMethods = new ElementsMethods(driver);
        this.javascriptMethods = new JavascriptMethods(driver);
        PageFactory.initElements(driver, this);
    }


    //create account elements
    @FindBy (id="firstname")
    WebElement firstNameField;

    @FindBy (id="lastname")
    WebElement lastNameField;

    @FindBy (id="email_address")
    WebElement emailField;

    @FindBy (id="password")
    WebElement passwordField;

    @FindBy (id="password-confirmation")
    WebElement confirmPasswordField;

    @FindBy (xpath = "//button[@class='action submit primary']")
    WebElement createAnAccountButtonRegister;

    //mesaj eroare dupa click pe butonul creare cont (indiferent de tipul credentialelor)
    @FindBy (xpath = "//*[@class='message-error error message']")
    WebElement emailExistsErrorMessage;

    //mesaj cont creat cu succes
    @FindBy (xpath = "//*[@class='message-success success message']")
    WebElement accountCreatedSuccessfullyMessage;



    //completare fielduri Positive Flow
    public void completeCreateAccountPagePositiveFlow (CreateAccount_SignIn_ObjectData data1)
    {
        elementsMethods.fillElement(firstNameField, data1.getFirstName1());
        LoggerUtility.infoTest("The user completes first name field");
        elementsMethods.fillElement(lastNameField, data1.getLastName1());
        LoggerUtility.infoTest("The user completes last name field");
        elementsMethods.fillElement(emailField, data1.getEmail1());
        LoggerUtility.infoTest("The user completes email field");
        elementsMethods.fillElement(passwordField, data1.getPassword1());
        LoggerUtility.infoTest("The user completes password field");
        elementsMethods.fillElement(confirmPasswordField, data1.getConfirmPassword1());
        LoggerUtility.infoTest("The user completes confirm password field");
        javascriptMethods.scrollOnPage(0, 100);
    }




    //completare fielduri Negative Flow
    public void completeCreateAccountPageNegativeFlow (CreateAccount_SignIn_ObjectData data2)
    {
        elementsMethods.fillElement(firstNameField, data2.getFirstName2());
        LoggerUtility.infoTest("The user completes first name field");
        elementsMethods.fillElement(lastNameField, data2.getLastName2());
        LoggerUtility.infoTest("The user completes last name field");
        elementsMethods.fillElement(emailField, data2.getEmail2());
        LoggerUtility.infoTest("The user completes email field");
        elementsMethods.fillElement(passwordField, data2.getPassword2());
        LoggerUtility.infoTest("The user completes password field");
        elementsMethods.fillElement(confirmPasswordField, data2.getConfirmPassword2());
        LoggerUtility.infoTest("The user completes confirm password field");
        javascriptMethods.scrollOnPage(0, 100);
    }


    //click buton creare cont
    public void clickOnCreateAnAccButtonRegister()
    {
        elementsMethods.clickOnElement(createAnAccountButtonRegister);
    }


    //returnarea mesajului de eroare (true/false) din Negative Flow
    public boolean emailAlreadyExistsMessageDisplayed()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(emailExistsErrorMessage));
        return emailExistsErrorMessage.isDisplayed();
    }


    //returnare mesaj crearea cont cu succes din Positive Flow

    public boolean accountCreatedSuccessfullyMessageDisplayed()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(accountCreatedSuccessfullyMessage));
        return accountCreatedSuccessfullyMessage.isDisplayed();
    }





}
