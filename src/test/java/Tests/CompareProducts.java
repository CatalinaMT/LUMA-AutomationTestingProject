package Tests;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class CompareProducts {

    WebDriver driver;

    @Test

    public void metodaTest() {
        driver = new ChromeDriver();
        driver.get("https://magento.softwaretestingboard.com/");
        driver.manage().window().maximize();


        //hover peste Gear Button
        WebElement gearButton = driver.findElement(By.xpath("//*[@class='level0 nav-4 category-item level-top parent ui-menu-item']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(gearButton)
                .build()
                .perform();


        //click pe Watches
        WebElement watchesButton = driver.findElement(By.xpath("//*[@class='level1 nav-4-3 category-item last ui-menu-item']"));
        actions.click(watchesButton)
             .build()
             .perform();

        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("window.scrollTo(0,300)");

     WebElement firstWatch = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[1]/div/a/span/span/img"));
     firstWatch.click();

        javascriptExecutor.executeScript("window.scrollTo(0,150)");

        WebElement addToCompareFirstWatchButton = driver.findElement(By.xpath("//*[text()='Add to Compare']"));
        addToCompareFirstWatchButton.click();

//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//
//        driver.navigate().back();












    }

}
