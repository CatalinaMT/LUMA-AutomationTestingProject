package ShareDataBrowser.Browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeService implements BrowserServiceInterface

{
    //abstractizare cu interfete
    //instantierea browserului Chrome

    private WebDriver driver;

    @Override
    public void openBrowser()
    {
        ChromeOptions options = (ChromeOptions) browserOptions();
        driver = new ChromeDriver(options);

    }

    @Override
    public Object browserOptions() {

        String ci_cd = System.getProperty("ci_cd");

        ChromeOptions options = new ChromeOptions();
        //setari pentru Chrome
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sendbox");
        options.addArguments("--window-size=1920,1080");

        if (Boolean.parseBoolean(ci_cd))
            options.addArguments("--headless");  //ruleaza headless

        return options;
    }


    //getter pentru driver
    public WebDriver getDriver()
    {
        return driver;
    }

}
