package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

public class EventHandler implements WebDriverListener {

    @Override
    public void beforeGet(WebDriver driver, String url) {
        LoggerHandler.info("Navigating to URL: " + url);
    }

    @Override
    public void afterGet(WebDriver driver, String url) {
        LoggerHandler.info("Successfully navigated to URL: " + url);
    }

    @Override
    public void beforeClick(WebElement element) {
        try {
            String text = element.getText();
            if (text != null && !text.isEmpty()) {
                LoggerHandler.info("click on " + text.trim());
            } else {
                LoggerHandler.info("Clicking on element: " + element.toString());
            }
        } catch (Exception e) {
            LoggerHandler.info("Clicking on element");
        }
    }

    @Override
    public void afterClick(WebElement element) {
        LoggerHandler.info("Click action performed successfully");
    }

    @Override
    public void beforeSendKeys(WebElement element, CharSequence... keysToSend) {
        LoggerHandler.info("Sending keys to element");
    }

    @Override
    public void afterSendKeys(WebElement element, CharSequence... keysToSend) {
        LoggerHandler.info("Keys sent successfully");
    }
}