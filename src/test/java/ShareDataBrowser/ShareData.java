package ShareDataBrowser;

import ShareDataBrowser.Browser.BrowserFactory;
import org.openqa.selenium.WebDriver;

public class ShareData
{
    private WebDriver driver;

    //utilizarea principiului de incapsulare (initializarea driver-ului)

    public void initializeBrowser()
    {
        driver = new BrowserFactory().getBrowserFactory();
        driver.get("https://magento.softwaretestingboard.com/");
    }


    public void clearBrowser()
    {
        driver.quit();
    }


    //getter pentru driver
    public WebDriver getDriver()
    {
        return driver;
    }
}
