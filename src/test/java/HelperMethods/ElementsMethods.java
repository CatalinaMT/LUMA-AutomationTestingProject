package HelperMethods;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static java.awt.SystemColor.text;


public class ElementsMethods extends CommonMethods {
    WebDriver driver;
    WebDriverWait driverWait;


    public ElementsMethods(WebDriver driver) {
        this.driver = driver;
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    //metode generice folosite in teste

    //click pe element
    public void clickOnElement(WebElement element) {
        element.click();
    }


    //completare campuri si verificari
    public void fillElement(WebElement element, String text) {
        Assert.assertTrue(isDisplayed(element)); //verificare elementul este afisat pe pagina
        Actions actions = new Actions(driver);
        actions.click()
                .build()
                .perform();
        String textElement = element.getText();
        Assert.assertTrue(textElement.isEmpty()); //verificare campul este gol
        element.sendKeys(text);

        Assert.assertEquals(element.getAttribute("value"), text);//verificare campul contine textul pe care l-am introdus
    }


    //hover peste un WebElement
    public void hoverOverAnElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element)
                .build()
                .perform();
    }

}
