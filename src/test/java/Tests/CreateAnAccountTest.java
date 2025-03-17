package Tests;

import HelperMethods.ElementsMethods;
import HelperMethods.JavascriptMethods;
import Logger.LoggerUtility;
import ObjectData.CreateAccount_SignIn_ObjectData;
import Pages.CreateAnAccountPage;
import Pages.HomePage;
import ShareDataBrowser.Hooks;
import XmlReaderUtility.XmlReader;
import com.aventstack.chaintest.plugins.ChainTestListener;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.util.Map;

public class CreateAnAccountTest extends Hooks {
    HomePage homePage;
    CreateAnAccountPage createAnAccountPage;
    ElementsMethods elementsMethods;
    JavascriptMethods javascriptMethods;
    private Map<String, CreateAccount_SignIn_ObjectData> createAccount_SignIn_ObjectDataMap;


    //CREARE CONT POSITIVE FLOW
    //PASSED test=TREBUIE SA MODIFICAM la fiecare rulare valorile din xml "CreateAccount_SignIn_Data" pt firstName2, lastName2 si email2
    @Test
    public void metodaTestPositiveFlow() {
        homePage = new HomePage(getDriver());
        elementsMethods = new ElementsMethods(getDriver());
        createAnAccountPage = new CreateAnAccountPage(getDriver());
        javascriptMethods = new JavascriptMethods(getDriver());

        ChainTestListener.log("Chrome opened");

        createAccount_SignIn_ObjectDataMap = XmlReader.loadData("src/test/resources/CreateAccount_SignIn_Data.xml", CreateAccount_SignIn_ObjectData.class);
        CreateAccount_SignIn_ObjectData data1 = createAccount_SignIn_ObjectDataMap.get("dataSet_1");

        homePage.clickOnCreateAccButtonHome();
        LoggerUtility.infoTest("The user clicks on Create Account Button from Home Page");
        ChainTestListener.log("User clicked on Create Account Button from Home Page");
        createAnAccountPage.completeCreateAccountPagePositiveFlow(data1);
        ChainTestListener.log("User completed fields from Create Account Page");
        javascriptMethods.scrollOnPage(0, 300);
        ChainTestListener.log("User scrolls on page");
        createAnAccountPage.clickOnCreateAnAccButtonRegister();
        LoggerUtility.infoTest("The user clicks on Create Account Button from Register Page");
        ChainTestListener.log("User clicked on on Create Account Button from Register Page after he finished to complete fields");
        Assert.assertTrue(createAnAccountPage.accountCreatedSuccessfullyMessageDisplayed());
    }


    //CREARE CONT NEGATIVE FLOW
    @Test
    public void metodaTestNegativeFlow() {
        homePage = new HomePage(getDriver());
        elementsMethods = new ElementsMethods(getDriver());
        createAnAccountPage = new CreateAnAccountPage(getDriver());
        javascriptMethods = new JavascriptMethods(getDriver());

        ChainTestListener.log("Chrome opened");

        createAccount_SignIn_ObjectDataMap = XmlReader.loadData("src/test/resources/CreateAccount_SignIn_Data.xml", CreateAccount_SignIn_ObjectData.class);
        CreateAccount_SignIn_ObjectData data2 = createAccount_SignIn_ObjectDataMap.get("dataSet_2");

        homePage.clickOnCreateAccButtonHome();
        LoggerUtility.infoTest("The user clicks on Create Account Button from Home Page");
        ChainTestListener.log("User clicked on Create Account Button from Home Page");
        createAnAccountPage.completeCreateAccountPageNegativeFlow(data2);
        ChainTestListener.log("User completed fields from Create Account Page");
        javascriptMethods.scrollOnPage(0, 300);
        ChainTestListener.log("User scrolls on page");
        createAnAccountPage.clickOnCreateAnAccButtonRegister();
        LoggerUtility.infoTest("The user clicks on Create Account Button from Register Page");
        ChainTestListener.log("User clicked on on Create Account Button from Register Page after he finished to complete fields");
        Assert.assertTrue(createAnAccountPage.emailAlreadyExistsMessageDisplayed());
    }

}





