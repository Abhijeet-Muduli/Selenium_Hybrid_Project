package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import uistore.HomePageLocators;
import utils.LoggerHandler;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class HomePage {

    private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        this.actions = new Actions(driver);
    }

   
    public void openUrl(String url) {
        driver.get(url);
        LoggerHandler.info("Opened URL: " + url);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    
    public void scrollToFooter() {
        try {
            WebElement footer = wait.until(
                    ExpectedConditions.presenceOfElementLocated(HomePageLocators.footer));
            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].scrollIntoView(true);", footer);
            Thread.sleep(1000);
            LoggerHandler.info("Scrolled to footer.");
        } catch (Exception e) {
            ((JavascriptExecutor) driver)
                    .executeScript("window.scrollTo(0, document.body.scrollHeight);");
            LoggerHandler.info("Scrolled to bottom via JS.");
        }
    }

    public void clickCareers() {
        WebElement careers = wait.until(
                ExpectedConditions.elementToBeClickable(HomePageLocators.careersLink));
        careers.click();
        LoggerHandler.info("Clicked Careers link in footer.");
    }

   
    public void clickHelloUserAccountsOrders() {
        WebElement elem = wait.until(
                ExpectedConditions.elementToBeClickable(
                        HomePageLocators.helloUserAccountsOrders));
        elem.click();
        LoggerHandler.info("Clicked Hello User, Accounts & Orders.");
    }

    public void enterPhoneNumber(String phoneNumber) {
        WebElement phoneField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        HomePageLocators.phoneNumberField));
        phoneField.clear();
        phoneField.sendKeys(phoneNumber);
        LoggerHandler.info("Entered phone number: " + phoneNumber);
    }

    public void clickHaveReferralCode() {
        WebElement referralLink = wait.until(
                ExpectedConditions.elementToBeClickable(HomePageLocators.haveReferralCode));
        referralLink.click();
        LoggerHandler.info("Clicked Have a referral code?");
    }

    public void enterReferralCode(String code) {
        WebElement referralInput = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        HomePageLocators.referralCodeInput));
        referralInput.clear();
        referralInput.sendKeys(code);
        LoggerHandler.info("Entered referral code: " + code);
    }

    public void clickSend() {
        WebElement sendBtn = wait.until(
                ExpectedConditions.elementToBeClickable(HomePageLocators.sendButton));
        sendBtn.click();
        LoggerHandler.info("Clicked Send button.");
    }

    public void clickTermsAndConditions() {
        WebElement termsLink = wait.until(
                ExpectedConditions.elementToBeClickable(
                        HomePageLocators.termsAndConditionsLogin));
        termsLink.click();
        LoggerHandler.info("Clicked Terms & Conditions.");
        switchToNewTab();
    }

    public void switchToNewTab() {
        String originalHandle = driver.getWindowHandle();
        List<String> handles = new ArrayList<>(driver.getWindowHandles());
        for (String handle : handles) {
            if (!handle.equals(originalHandle)) {
                driver.switchTo().window(handle);
                LoggerHandler.info("Switched to new tab.");
                break;
            }
        }
    }

    public void clickBlogsMenu() {
        WebElement blogs = wait.until(
                ExpectedConditions.elementToBeClickable(HomePageLocators.blogsMenu));
        blogs.click();
        LoggerHandler.info("Clicked Blogs in navigation bar.");
    }

    
    public void clickLabTestMenu() {
        WebElement labTest = wait.until(
                ExpectedConditions.elementToBeClickable(HomePageLocators.labTestNavMenu));
        labTest.click();
        LoggerHandler.info("Clicked Lab Test menu.");
    }

    public void clickBrowseByHealthConcern() {
        WebElement browse = wait.until(
                ExpectedConditions.elementToBeClickable(
                        HomePageLocators.browseByHealthConcern));
        browse.click();
        LoggerHandler.info("Clicked Browse by Health Concern.");
    }

    public void clickHeartHealth() {
        WebElement heartHealth = wait.until(
                ExpectedConditions.elementToBeClickable(HomePageLocators.heartHealthOption));
        heartHealth.click();
        LoggerHandler.info("Clicked Heart Health.");
    }

    public void enterMinPrice(String minValue) {
        WebElement minInput = wait.until(
                ExpectedConditions.visibilityOfElementLocated(HomePageLocators.minPriceInput));
        minInput.clear();
        minInput.sendKeys(minValue);
        minInput.sendKeys(Keys.ENTER);
        LoggerHandler.info("Entered MIN price: " + minValue + " and pressed ENTER.");
    }

    public boolean verifyHeartHealthResult() {
        try {
            WebElement heading = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            HomePageLocators.heartHealthResultHeading));
            boolean isPresent = heading.getText().contains("Heart Health");
            LoggerHandler.info("Heart Health result verified: " + isPresent);
            return isPresent;
        } catch (Exception e) {
            LoggerHandler.error("Heart Health result NOT found: " + e.getMessage());
            return false;
        }
    }

    // ── Week 5 Day 3 - Testcase 1: Supplement ────────────────────────────────
    public void clickSupplement() {
        WebElement supplement = wait.until(
                ExpectedConditions.elementToBeClickable(HomePageLocators.supplementMenu));
        supplement.click();
        LoggerHandler.info("Clicked Supplement.");
    }

    public void clickDigestiveProbiotic() {
        WebElement dp = wait.until(
                ExpectedConditions.elementToBeClickable(
                        HomePageLocators.digestiveProbioticOption));
        dp.click();
        LoggerHandler.info("click on Digestive Probiotic");
    }

    public void clickFishOil() {
        WebElement fishOil = wait.until(
                ExpectedConditions.elementToBeClickable(HomePageLocators.fishOilOption));
        fishOil.click();
        LoggerHandler.info("Clicked Fish Oil.");
    }

    public void clickFirstProduct() {
        WebElement firstProduct = wait.until(
                ExpectedConditions.elementToBeClickable(HomePageLocators.firstProductCard));
        firstProduct.click();
        LoggerHandler.info("Clicked first product in result list.");
    }

    public boolean verifyProductDescription() {
        try {
            WebElement desc = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            HomePageLocators.productDescriptionLabel));
            boolean found = desc.getText().contains("Product Description");
            LoggerHandler.info("Product Description label verified: " + found);
            return found;
        } catch (Exception e) {
            LoggerHandler.error("Product Description label NOT found: " + e.getMessage());
            return false;
        }
    }

   
    public void clickRegisterPharmacy() {
        WebElement regLink = wait.until(
                ExpectedConditions.elementToBeClickable(
                        HomePageLocators.registerPharmacyLink));
        regLink.click();
        LoggerHandler.info("Clicked Register the Pharmacy.");
    }

    public void closePopup() {
        try {
            WebElement closeBtn = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            HomePageLocators.closePopupButton));
            closeBtn.click();
            LoggerHandler.info("Closed popup.");
        } catch (Exception e) {
            LoggerHandler.warn("No close button found: " + e.getMessage());
        }
    }

    public void enterFullName(String fullName) {
        WebElement nameField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(HomePageLocators.fullNameField));
        nameField.clear();
        nameField.sendKeys(fullName);
        LoggerHandler.info("Entered Full Name: " + fullName);
    }

    public void enterMobileNumber(String mobileNumber) {
        WebElement mobileField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        HomePageLocators.mobileNumberRegisterField));
        mobileField.clear();
        mobileField.sendKeys(mobileNumber);
        LoggerHandler.info("Entered Mobile Number: " + mobileNumber);
    }

    public void selectBusinessTypePharmacy() {
        try {
            WebElement dropdown = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            HomePageLocators.businessTypeDropdown));
            Select select = new Select(dropdown);
            select.selectByVisibleText("Pharmacy");
            LoggerHandler.info("Selected Pharmacy in Business Type.");
        } catch (Exception e) {
            WebElement pharmacyOpt = wait.until(
                    ExpectedConditions.elementToBeClickable(HomePageLocators.pharmacyOption));
            pharmacyOpt.click();
            LoggerHandler.info("Clicked Pharmacy option directly.");
        }
    }

    public void enterPharmacyName(String pharmacyName) {
        WebElement pharmacyField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        HomePageLocators.pharmacyNameField));
        pharmacyField.clear();
        pharmacyField.sendKeys(pharmacyName);
        LoggerHandler.info("Entered Pharmacy Name: " + pharmacyName);
    }

    public void enterDrugsLicenceNumber(String licenceNumber) {
        WebElement licenceField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        HomePageLocators.drugsLicenceField));
        licenceField.clear();
        licenceField.sendKeys(licenceNumber);
        LoggerHandler.info("Entered Drugs Licence Number: " + licenceNumber);
    }

    public void clickSubmit() {
        WebElement submit = wait.until(
                ExpectedConditions.elementToBeClickable(HomePageLocators.submitButton));
        LoggerHandler.info("click on Submit");
        submit.click();
        LoggerHandler.info("Clicked Submit button.");
    }

    public boolean verifyOtpErrorMessage() {
        try {
            WebElement otpMsg = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            HomePageLocators.otpErrorMessage));
            boolean found = otpMsg.isDisplayed();
            LoggerHandler.info("OTP error message verified: " + found
                    + " | Text: " + otpMsg.getText());
            return found;
        } catch (Exception e) {
            LoggerHandler.error("OTP error message NOT found: " + e.getMessage());
            return false;
        }
    }

    public void scrollIntoView(WebElement element) {
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", element);
    }
}