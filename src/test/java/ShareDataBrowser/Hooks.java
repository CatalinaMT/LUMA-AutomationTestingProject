package ShareDataBrowser;

import ChainTestUtility.ChainUtility;
import Logger.LoggerUtility;
import com.aventstack.chaintest.plugins.ChainTestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import java.io.IOException;

@Listeners(ChainTestListener.class)  //chain test report
public class Hooks extends ShareData
{
    String testName;

    //metode generale

    @BeforeMethod
    public void prepareEnvironment()
    {
        testName = this.getClass().getSimpleName();
        initializeBrowser();
        LoggerUtility.startTestCase(testName);
    }

    @AfterMethod
    public void clearEnvironment(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE)
        {
           byte[] screenShot = ChainUtility.getScreenShot(getDriver(), testName);  //generare screen shot daca pica testul
            ChainTestListener.embed(screenShot, "image/png");
            LoggerUtility.errorLog(result.getThrowable().getMessage());
        }
        LoggerUtility.endTestCase(testName);
        clearBrowser();
    }

    @AfterSuite
    public  void finishLogs()
    {
        LoggerUtility.mergeFilesIntoOne();
    }
}
