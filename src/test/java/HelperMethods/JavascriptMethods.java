package HelperMethods;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class JavascriptMethods
{
    WebDriver driver;
    //scroll pe pagina
    public void scrollOnPage(int x, int y)
    {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("window.scrollTo(arguments[0], arguments[1]);", x, y);
    }


}
