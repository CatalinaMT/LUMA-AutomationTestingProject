package Tests;

import HelperMethods.ElementsMethods;
import Logger.LoggerUtility;
import ObjectData.CreateAccount_SignIn_ObjectData;
import Pages.HomePage;
import Pages.SignInPage;
import ShareDataBrowser.Hooks;
import ShareDataBrowser.ShareData;
import XmlReaderUtility.XmlReader;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Map;

public class SignInTest extends Hooks {

    HomePage homePage;
    ElementsMethods elementsMethods;
    SignInPage signInPage;
    private Map<String, CreateAccount_SignIn_ObjectData> createAccount_SignIn_ObjectDataMap;


    //SIGN IN POSITIVE FLOW
    @Test
    public void metodaTestPositiveFlow()
    {
       homePage = new HomePage(getDriver());
        elementsMethods = new ElementsMethods(getDriver());
        signInPage = new SignInPage(getDriver());

        createAccount_SignIn_ObjectDataMap = XmlReader.loadData("src/test/resources/CreateAccount_SignIn_Data.xml", CreateAccount_SignIn_ObjectData.class);
        CreateAccount_SignIn_ObjectData data3 = createAccount_SignIn_ObjectDataMap.get("dataSetSignIn_1");

        homePage.clickOnSignInHomeButton();
        LoggerUtility.infoTest("The user clicks on Sign In from Home Page");
        signInPage.completeSignInPositiveFlow(data3);
        signInPage.clickOnSignInButton();
        LoggerUtility.infoTest("The user clicks on Sign In from Sign In page");
        Assert.assertTrue(signInPage.signInSuccessfullyMessageDisplayed());
    }

    //SIGN IN NEGATIVE FLOW
    @Test
    public void metodaTestNegativeFlow()
    {
        homePage = new HomePage(getDriver());
        elementsMethods = new ElementsMethods(getDriver());
        signInPage = new SignInPage(getDriver());

        createAccount_SignIn_ObjectDataMap = XmlReader.loadData("src/test/resources/CreateAccount_SignIn_Data.xml", CreateAccount_SignIn_ObjectData.class);
        CreateAccount_SignIn_ObjectData data4 = createAccount_SignIn_ObjectDataMap.get("dataSetSignIn_2");

        homePage.clickOnSignInHomeButton();
        LoggerUtility.infoTest("The user clicks on Sign In from Home Page");
        signInPage.completeSignInNegativeFlow(data4);
        signInPage.clickOnSignInButton();
        LoggerUtility.infoTest("The user clicks on Sign In from Sign In page");
        Assert.assertTrue(signInPage.unsuccessfullySignInMessageDisplayed());
    }

}

