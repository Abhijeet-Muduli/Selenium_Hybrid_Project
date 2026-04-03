package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Screenshot {


    private static final String PROJECT_ROOT = System.getProperty("user.dir");
    private static final String SCREENSHOT_DIR = PROJECT_ROOT + File.separator + "screenshots" + File.separator;
    private static final String REPORTS_DIR = PROJECT_ROOT + File.separator + "reports" + File.separator;

    public static String captureScreenshot(WebDriver driver, String fileName) {
        String filePath = "";
        try {
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File destDir = new File(SCREENSHOT_DIR);
            if (!destDir.exists()) {
                destDir.mkdirs();
            }
            filePath = SCREENSHOT_DIR + fileName + ".png";
            File destFile = new File(filePath);
            FileUtils.copyFile(srcFile, destFile);
            LoggerHandler.info("Screenshot captured: " + filePath);
        } catch (IOException e) {
            LoggerHandler.error("Failed to capture screenshot: " + e.getMessage());
        }
        return filePath;
    }

    public static String captureScreenshot(WebDriver driver) {
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        return captureScreenshot(driver, "screenshot_" + timestamp);
    }

    public static String captureAroggaScreenshot(WebDriver driver) {
       
        captureScreenshot(driver, "arogga_screenshot");

        try {
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File reportsDir = new File(REPORTS_DIR);
            if (!reportsDir.exists()) {
                reportsDir.mkdirs();
            }
            File destFile = new File(REPORTS_DIR + "arogga_screenshot.png");
            FileUtils.copyFile(srcFile, destFile);
            LoggerHandler.info("arogga_screenshot saved to reports/");
        } catch (IOException e) {
            LoggerHandler.error("Failed to copy arogga_screenshot: " + e.getMessage());
        }

        return "./arogga_screenshot.png";
    }
}