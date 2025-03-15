package ShareDataBrowser.Browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class EdgeService implements BrowserServiceInterface
{
    //abstractizare cu interfete
    //instantierea browserului Chrome

    private WebDriver driver;


    @Override
    public void openBrowser()
    {
        EdgeOptions options = (EdgeOptions) browserOptions();
        driver = new EdgeDriver(options);
    }

    @Override
    public Object browserOptions() {
        EdgeOptions options = new EdgeOptions();
        //setari Edge
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sendbox");
        options.addArguments("--window-size=1920,1080");
        return options;
    }

    public WebDriver getDriver()
    {
        return driver;
    }
}
