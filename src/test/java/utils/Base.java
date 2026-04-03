package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.events.WebDriverListener;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.apache.log4j.PropertyConfigurator;
import java.io.File;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class Base {

    public static WebDriver driver;
    protected static Properties config;
    protected static String baseUrl;

    @BeforeClass
    public void setup() throws IOException {
        String log4jPath = System.getProperty("user.dir") 
                       + File.separator + "src" 
                       + File.separator + "main" 
                       + File.separator + "resources" 
                       + File.separator + "log4j.properties";
    PropertyConfigurator.configure(log4jPath);

    // also create logs dir if not exists
    File logsDir = new File(System.getProperty("user.dir") + File.separator + "logs");
    if (!logsDir.exists()) logsDir.mkdirs();
        loadProperties();

        String browser = config.getProperty("browser", "chrome").toLowerCase();
        baseUrl = config.getProperty("url", "https://www.arogga.com/");

        LoggerHandler.info("Setting up WebDriver for browser: " + browser);

        if (browser.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            options.addArguments("--disable-notifications");
            options.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(options);
        }

        // Implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

        // Attach EventHandler listener
        WebDriverListener listener = new EventHandler();
        driver = new EventFiringDecorator<>(listener).decorate(driver);

        LoggerHandler.info("WebDriver initialized successfully.");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            LoggerHandler.info("Closing WebDriver.");
            driver.quit();
        }
    }

    private void loadProperties() throws IOException {
        config = new Properties();
        try (FileInputStream fis = new FileInputStream("config/browser.properties")) {
            config.load(fis);
            LoggerHandler.info("browser.properties loaded successfully.");
        }
    }

    public static String getProperty(String key) {
        return config != null ? config.getProperty(key, "") : "";
    }
}