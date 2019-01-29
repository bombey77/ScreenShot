package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class DriverManager {

    private static String path;
    private static WebDriver webDriver;

    public static WebDriver getDriverManager() {
        path = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", path + "/drivers/chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.get("https://google.com");
        setWait();
        return webDriver;
    }

    public static void setWait() {
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
    }
}
