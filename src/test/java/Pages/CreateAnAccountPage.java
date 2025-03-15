package Pages;

import HelperMethods.ElementsMethods;
import ObjectData.CreateAccount_SignIn_ObjectData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAnAccountPage
{

    WebDriver driver;
    ElementsMethods elementsMethods;

    public CreateAnAccountPage(WebDriver driver)
    {
        this.driver = driver;
        this.elementsMethods = new ElementsMethods(driver);
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



    //completare nume
    public void completeFirstNameField (CreateAccount_SignIn_ObjectData data)
    {
        elementsMethods.fillElement(firstNameField, data.getFirstName());
    }

    //completare prenume
    public void completeLastNameField (CreateAccount_SignIn_ObjectData data)
    {
        elementsMethods.fillElement(lastNameField, data.getLastName());
    }

    //completare mail
    public void completeEmailField (CreateAccount_SignIn_ObjectData data)
    {
        elementsMethods.fillElement(emailField, data.getEmail());
    }

    //completare parola
    public void completePasswordField (CreateAccount_SignIn_ObjectData data)
    {
        elementsMethods.fillElement(passwordField, data.getPassword());
    }

    //completare confirmare parola
    public void completeConfirmPasswordField (CreateAccount_SignIn_ObjectData data)
    {
        elementsMethods.fillElement(confirmPasswordField, data.getConfirmPassword());
    }



    //click buton creare cont
    public void clickOnCreateAnAccButtonRegister()
    {
        elementsMethods.clickOnElement(createAnAccountButtonRegister);
    }


}
