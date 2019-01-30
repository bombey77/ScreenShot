package tests;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseDriver {

    private static WebDriver webDriver;

    @BeforeTest
    public void setUp() {
        setWebDriver(DriverManager.getDriverManager());
    }

    @AfterTest
    public void tearDown() {
        webDriver.quit();
    }

    public void failed(String methodName) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        String screenShotTime = dateFormat.format(new Date());
        File screenFile = ((TakesScreenshot)getWebDriver()).getScreenshotAs(OutputType.FILE);
        try{
            FileUtils.copyFile(screenFile, new File(methodName + "_" + screenShotTime + ".jpg"));
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public  WebDriver getWebDriver() {
        return webDriver;
    }

    public  void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
}
