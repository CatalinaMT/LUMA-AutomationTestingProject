package ShareDataBrowser;

import Logger.LoggerUtility;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

import java.io.FileNotFoundException;

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
    public void clearEnvironment(ITestResult result)
    {
        clearBrowser();
        if (result.getStatus() == ITestResult.FAILURE)
        {
            LoggerUtility.errorLog(result.getThrowable().getMessage());
        }
        LoggerUtility.endTestCase(testName);
    }

    @AfterSuite
    public  void finishLogs()
    {
        LoggerUtility.mergeFilesIntoOne();
    }
}
