package Pages;

import HelperMethods.ElementsMethods;
import ObjectData.CreateAccount_SignIn_ObjectData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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


    //sign in elements

    @FindBy(id="email")
    WebElement emailFieldSignIn;

    @FindBy(id="pass")
    WebElement passwordFieldSignIn;

    @FindBy(xpath = "//button[@class='action login primary']")
    WebElement signInButton;


    public void signInEmailField (CreateAccount_SignIn_ObjectData data)
    {
        elementsMethods.fillElement(emailFieldSignIn, data.getEmailSignIn());
    }


    public void signInPasswordField (CreateAccount_SignIn_ObjectData data)
    {
        elementsMethods.fillElement(passwordFieldSignIn, data.getPasswordSignIn());
    }



    public void clickOnSignInButton ()
    {
        elementsMethods.clickOnElement(signInButton);
    }

}
