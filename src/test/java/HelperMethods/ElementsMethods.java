package HelperMethods;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static java.awt.SystemColor.text;
//import static jdk.internal.classfile.impl.DirectCodeBuilder.build;

public class ElementsMethods extends CommonMethods
{
    WebDriver driver;
    WebDriverWait driverWait;


    public ElementsMethods(WebDriver driver)
    {
        this.driver = driver;
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }



    //metode generice folosite in teste

    //click pe element
    public void clickOnElement(WebElement element)
    {
        element.click();
    }


    //completare campuri si verificari
 public void fillElement(WebElement element, String text)
     {
     //Assert.assertTrue(isDisplayed(element)); //verificare elementul este afisat pe pagina
        // Actions actions = new Actions(driver);
        //actions.click()
                  // .build()
                  // .perform();
      // String textElement = element.getText();
      // Assert.assertTrue(textElement.isEmpty()); //verificare campul este gol
            element.sendKeys(text);
      //Assert.assertTrue(!element.getText().isEmpty()); // verificare campul nu e gol
      //Assert.assertTrue(element.getText().equals(text)); //verificare campul contine textul pe care l-am introdus
  }

//        public void fillElement (WebElement element, String text)
//        {
//        isDisplayed(element);
//        element.sendKeys(text); // Fill field
//
//            Assert.assertTrue(element.getText().contains(text));
//    }







}
