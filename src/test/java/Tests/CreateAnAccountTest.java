package Tests;

import HelperMethods.ElementsMethods;
import HelperMethods.JavascriptMethods;
import Logger.LoggerUtility;
import ObjectData.CreateAccount_SignIn_ObjectData;
import Pages.CreateAnAccountPage;
import Pages.HomePage;
import ShareDataBrowser.Hooks;
import XmlReaderUtility.XmlReader;
import org.testng.annotations.Test;


import java.util.Map;

public class CreateAnAccountTest extends Hooks
{
    HomePage homePage;
    CreateAnAccountPage createAnAccountPage;
    ElementsMethods elementsMethods;
    JavascriptMethods javascriptMethods;
    private Map<String, CreateAccount_SignIn_ObjectData> createAccount_SignIn_ObjectDataMap;

    @Test
    public void metodaTest() {

        homePage = new HomePage(getDriver());
        elementsMethods = new ElementsMethods(getDriver());
        createAnAccountPage = new CreateAnAccountPage(getDriver());
        javascriptMethods = new JavascriptMethods(getDriver());

        createAccount_SignIn_ObjectDataMap = XmlReader.loadData("src/test/resources/CreateAccount_SignIn_Data.xml", CreateAccount_SignIn_ObjectData.class);
        CreateAccount_SignIn_ObjectData data = createAccount_SignIn_ObjectDataMap.get("dataSet_1");

        homePage.clickOnCreateAccButtonHome();
        LoggerUtility.infoTest("The user clicks on Create Account Button from Home Page");
        javascriptMethods.scrollOnPage(0, 300);
        createAnAccountPage.completeFirstNameField(data);
        LoggerUtility.infoTest("The user complete first name field");
        createAnAccountPage.completeLastNameField(data);
        LoggerUtility.infoTest("The user complete last name field");
        createAnAccountPage.completeEmailField(data);
        LoggerUtility.infoTest("The user complete email field");
        createAnAccountPage.completePasswordField(data);
        LoggerUtility.infoTest("The user complete password field");
        createAnAccountPage.completeConfirmPasswordField(data);
        LoggerUtility.infoTest("The user complete confirm password field");
        javascriptMethods.scrollOnPage(0, 100);
        createAnAccountPage.clickOnCreateAnAccButtonRegister();
        LoggerUtility.infoTest("The user clicks on Create Account Button from Register Page");


    }

}
