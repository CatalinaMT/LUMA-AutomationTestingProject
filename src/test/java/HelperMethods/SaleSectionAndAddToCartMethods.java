package HelperMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SaleSectionAndAddToCartMethods
{
    WebDriver driver;
    WebDriverWait driverWait;

    public SaleSectionAndAddToCartMethods(WebDriver driver)
    {
        this.driver = driver;
        this.driverWait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }


//    public void expandStyle(String elementLocatorStyleSale,List<WebElement> meniu)
//    {
//
//        driverWait.until(ExpectedConditions.attributeToBe(elementLocatorStyleSale, "aria-expanded", "false"));
//        meniu.get(1).click();
//    }



}
