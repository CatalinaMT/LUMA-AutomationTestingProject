package ChainTestUtility;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ChainUtility
{
    //clasa ce face print screen daca pica testul si adauga print-ul intr-un anumit path

    private static String projectPath = System.getProperty("user.dir") + "/target/chaintest/ScreenShot/";

    public static byte[] getScreenShot(WebDriver driver, String reportName) throws IOException
    {
        String path = projectPath + reportName + ".png";
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        byte[] imageByte = null;
        FileUtils.copyFile(src, new File(path));
        imageByte = IOUtils.toByteArray(Files.newInputStream(Paths.get(path)));
        return imageByte;
    }

}
