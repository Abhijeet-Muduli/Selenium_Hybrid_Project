package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;

public class Reporter {

    private static ExtentReports extent;
    private static ExtentTest test;

    public static void initReport() {
        File reportsDir = new File("reports/");
        if (!reportsDir.exists()) {
            reportsDir.mkdirs();
        }

        ExtentSparkReporter sparkReporter =
                new ExtentSparkReporter("reports/execution-report.html");
        sparkReporter.config().setTheme(Theme.STANDARD);
        sparkReporter.config().setDocumentTitle("Arogga Test Report");
        sparkReporter.config().setReportName("Arogga Automation Report");
        sparkReporter.config().setEncoding("utf-8");

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        extent.setSystemInfo("Application", "Arogga");
        extent.setSystemInfo("URL", "https://www.arogga.com/");
        extent.setSystemInfo("Framework", "Hybrid");
        LoggerHandler.info("Extent Report initialized.");
    }

    public static ExtentTest createTest(String testName, String description) {
        test = extent.createTest(testName, description);
        LoggerHandler.info("Test created in report: " + testName);
        return test;
    }

    public static ExtentTest createTest(String testName) {
        return createTest(testName, "");
    }

    public static void logInfo(String message) {
        if (test != null) {
            test.info(message);
        }
        LoggerHandler.info(message);
    }

    public static void logPass(String message) {
        if (test != null) {
            test.pass(message);
        }
        LoggerHandler.info("PASS: " + message);
    }

    public static void logFail(String message) {
        if (test != null) {
            test.fail(message);
        }
        LoggerHandler.error("FAIL: " + message);
    }

    public static void addScreenshot(String screenshotRelativePath) {
        try {
            if (test != null) {
                test.info(MediaEntityBuilder
                        .createScreenCaptureFromPath(screenshotRelativePath).build());
            }
            LoggerHandler.info("Screenshot added to report: " + screenshotRelativePath);
        } catch (Exception e) {
            LoggerHandler.error("Failed to add screenshot to report: " + e.getMessage());
        }
    }

    public static void flushReport() {
        if (extent != null) {
            extent.flush();
            LoggerHandler.info("Extent Report flushed to disk.");
        }
    }

    public static ExtentTest getTest() {
        return test;
    }

    public static void setTest(ExtentTest extentTest) {
        test = extentTest;
    }
}