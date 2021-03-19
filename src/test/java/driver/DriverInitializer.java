package driver;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverInitializer {
    static {
        try {
            System.setProperty("webdriver.chrome.driver", "D:\\Bissi Tech\\Modulr-Automation\\src\\test\\resources\\drivers\\chromedriver.exe");
            System.setProperty("webdriver.gecko.driver", "resources/drivers/chromedriver.exe");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static WebDriver getDriver(String browser) {
        WebDriver driver = null;
        switch (browser) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            default:
                driver = new ChromeDriver();
        }
        return driver;
    }


}

