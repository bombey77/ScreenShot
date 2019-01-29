package tests;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;

public class BaseDriver {

    private WebDriver webDriver;

    @BeforeTest
    public void setUp() {
        webDriver = DriverManager.getDriverManager();
    }

    @AfterTest
    public void tearDown() {
        webDriver.quit();
    }

    public void failed(String methodName) {
        File screenFile = ((TakesScreenshot)webDriver).getScreenshotAs(OutputType.FILE);
        try{
            FileUtils.copyFile(screenFile, new File("D:\\Project\\Screenshottestng\\src\\dest.jpg"));
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
