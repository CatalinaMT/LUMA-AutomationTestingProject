package Tests;

import HelperMethods.ElementsMethods;
import Logger.LoggerUtility;
import ObjectData.CreateAccount_SignIn_ObjectData;
import Pages.HomePage;
import Pages.SignInPage;
import ShareDataBrowser.Hooks;
import ShareDataBrowser.ShareData;
import XmlReaderUtility.XmlReader;
import org.testng.annotations.Test;


import java.util.Map;

public class SignInTest extends Hooks {

    HomePage homePage;
    ElementsMethods elementsMethods;
    SignInPage signInPage;
    private Map<String, CreateAccount_SignIn_ObjectData> createAccount_SignIn_ObjectDataMap;

    @Test

    public void metodaTest() {


       homePage = new HomePage(getDriver());
        elementsMethods = new ElementsMethods(getDriver());
        signInPage = new SignInPage(getDriver());

        createAccount_SignIn_ObjectDataMap = XmlReader.loadData("src/test/resources/CreateAccount_SignIn_Data.xml", CreateAccount_SignIn_ObjectData.class);
        CreateAccount_SignIn_ObjectData data = createAccount_SignIn_ObjectDataMap.get("dataSetSignIn_1");

        homePage.clickOnSignInHomeButton();
        LoggerUtility.infoTest("The user clicks on Sign In from Home Page");
        signInPage.signInEmailField(data);
        LoggerUtility.infoTest("The user complete email field");
        signInPage.signInPasswordField(data);
        LoggerUtility.infoTest("The user complete password field");
        signInPage.clickOnSignInButton();
        LoggerUtility.infoTest("The user clicks on Sign In from Sign In page");


    }
}

