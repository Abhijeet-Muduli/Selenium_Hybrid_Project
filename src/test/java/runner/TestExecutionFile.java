package runner;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.HomePage;
import utils.*;

public class TestExecutionFile extends Base {

    private HomePage homePage;

    @BeforeSuite
    public void initExtentReport() {
        Reporter.initReport();
        LoggerHandler.info("Test suite started.");
    }

    @AfterSuite
    public void flushExtentReport() {
        Reporter.flushReport();
        LoggerHandler.info("Test suite completed.");
    }

    private void initPage() {
        homePage = new HomePage(driver);
    }


    @Test(priority = 1, description = "Login Module - Careers, Phone, Referral, T&C, Blogs")
    public void testLoginModule() {
        Reporter.createTest("Login Module Test",
                "Scroll to footer > Careers, Hello User, phone, referral, Send, T&C, Blogs");
        try {
            initPage();
            String url = Base.getProperty("url");
            homePage.openUrl(url);
            Reporter.logInfo("Opened URL: " + url);


            homePage.scrollToFooter();
            Reporter.logInfo("Scrolled to footer.");
            homePage.clickCareers();
            Reporter.logInfo("Clicked Careers in footer.");

            driver.navigate().back();
            Thread.sleep(2000);


            homePage.clickHelloUserAccountsOrders();
            Reporter.logInfo("Clicked Hello User, Accounts & Orders.");

            homePage.enterPhoneNumber("8808765427890");
            Reporter.logInfo("Entered phone number.");

            homePage.clickHaveReferralCode();
            Reporter.logInfo("Clicked Have a referral code?");

            String referralCode = ExcelFileReader.getReferralCode();
            if (referralCode.isEmpty()) referralCode = "7654";
            homePage.enterReferralCode(referralCode);
            Reporter.logInfo("Entered referral code: " + referralCode);

            homePage.clickSend();
            Reporter.logInfo("Clicked Send.");

            homePage.clickTermsAndConditions();
            Reporter.logInfo("Clicked Terms & Conditions - switched to new tab.");

            homePage.clickBlogsMenu();
            Reporter.logInfo("Clicked Blogs in navigation bar.");

            String screenshotPath = Screenshot.captureScreenshot(driver, "login_module_test");
            Reporter.addScreenshot("../" + screenshotPath);

            Reporter.logPass("Login Module test completed successfully.");
        } catch (Exception e) {
            LoggerHandler.error("Login Module test failed: " + e.getMessage());
            Reporter.logFail("Login Module test failed: " + e.getMessage());
        }
    }


    @Test(priority = 2, description = "Data Driven - Lab Test Heart Health Filter")
    public void testLabTestHeartHealth() {
        Reporter.createTest("Lab Test - Heart Health Data Driven",
                "Lab Test > Browse by Health Concern > Heart Health > MIN price filter");
        try {
            initPage();
            String url = Base.getProperty("url");
            homePage.openUrl(url);
            Reporter.logInfo("Opened URL: " + url);

            homePage.clickLabTestMenu();
            Reporter.logInfo("Clicked Lab Test menu.");

            homePage.clickBrowseByHealthConcern();
            Reporter.logInfo("Clicked Browse by Health Concern.");

            homePage.clickHeartHealth();
            Reporter.logInfo("Clicked Heart Health.");

            String minPrice = ExcelFileReader.getMinPrice();
            if (minPrice.isEmpty()) minPrice = "250";
            homePage.enterMinPrice(minPrice);
            Reporter.logInfo("Entered MIN price from Excel: " + minPrice);

            Thread.sleep(2000);

            boolean result = homePage.verifyHeartHealthResult();
            String screenshotPath = Screenshot.captureScreenshot(driver, "heart_health_result");
            Reporter.addScreenshot("../" + screenshotPath);

            if (result) {
                Reporter.logPass("Heart Health keyword found in search results.");
            } else {
                Reporter.logFail("Heart Health keyword NOT found in search results.");
            }
        } catch (Exception e) {
            LoggerHandler.error("Lab Test Heart Health failed: " + e.getMessage());
            Reporter.logFail("Lab Test Heart Health failed: " + e.getMessage());
        }
    }

    @Test(priority = 3, description = "TC1 - Supplement > Digestive Probiotic > Fish Oil")
    public void testCase1SupplementFishOil() {
        Reporter.createTest("Testcase 1 - Supplement Fish Oil",
                "Supplement > Digestive Probiotic > Fish Oil > Product Description");
        try {
            initPage();
            String url = Base.getProperty("url");
            homePage.openUrl(url);
            Reporter.logInfo("Opened URL: " + url);

            homePage.clickSupplement();
            Reporter.logInfo("Clicked Supplement.");

            homePage.clickDigestiveProbiotic();
            Reporter.logInfo("click on Digestive Probiotic");

            homePage.clickFishOil();
            Reporter.logInfo("Clicked Fish Oil.");

            homePage.clickFirstProduct();
            Reporter.logInfo("Clicked first product.");
            Thread.sleep(2000);

            boolean found = homePage.verifyProductDescription();
            String screenshotPath =
                    Screenshot.captureScreenshot(driver, "product_description_verification");
            Reporter.addScreenshot("../" + screenshotPath);

            if (found) {
                Reporter.logPass("Product Description label found.");
            } else {
                Reporter.logFail("Product Description label NOT found.");
            }
        } catch (Exception e) {
            LoggerHandler.error("Testcase 1 failed: " + e.getMessage());
            Reporter.logFail("Testcase 1 failed: " + e.getMessage());
        }
    }


    @Test(priority = 4, description = "TC2 - Register Pharmacy and verify OTP error")
    public void testCase2RegisterPharmacy() {
        Reporter.createTest("Testcase 2 - Register Pharmacy",
                "Footer > Register Pharmacy > fill form > Submit > OTP error > arogga_screenshot");
        try {
            initPage();
            String url = Base.getProperty("url");
            homePage.openUrl(url);
            Reporter.logInfo("Opened URL: " + url);

            homePage.scrollToFooter();
            Reporter.logInfo("Scrolled to footer.");

            homePage.clickRegisterPharmacy();
            Reporter.logInfo("Clicked Register the Pharmacy.");
            Thread.sleep(2000);

            homePage.closePopup();
            Reporter.logInfo("Attempted to close popup.");
            Thread.sleep(1000);

            String fullName = ExcelFileReader.getFullName();
            if (fullName.isEmpty()) fullName = "Kumar";
            homePage.enterFullName(fullName);
            Reporter.logInfo("Entered Full Name: " + fullName);

            homePage.enterMobileNumber("01712345678");
            Reporter.logInfo("Entered Mobile Number.");

            homePage.selectBusinessTypePharmacy();
            Reporter.logInfo("Selected Pharmacy in Business Type.");
            Thread.sleep(1000);

            homePage.enterPharmacyName("Pharmacy name");
            Reporter.logInfo("Entered Pharmacy Name.");

            homePage.enterDrugsLicenceNumber("DLN98765");
            Reporter.logInfo("Entered Drugs Licence Number: DLN98765");

            homePage.clickSubmit();
            Reporter.logInfo("Clicked Submit button.");
            Thread.sleep(2000);

            boolean otpError = homePage.verifyOtpErrorMessage();


            String screenshotRelPath = Screenshot.captureAroggaScreenshot(driver);
            Reporter.addScreenshot(screenshotRelPath);

            if (otpError) {
                Reporter.logPass("OTP error 'Please input your OTP!' verified.");
            } else {
                Reporter.logFail("OTP error message NOT found.");
            }

            Assert.assertTrue(otpError, "Expected OTP error message was not displayed.");

        } catch (AssertionError ae) {
            throw ae;
        } catch (Exception e) {
            LoggerHandler.error("Testcase 2 failed: " + e.getMessage());
            Reporter.logFail("Testcase 2 failed: " + e.getMessage());
            try {
                String screenshotRelPath = Screenshot.captureAroggaScreenshot(driver);
                Reporter.addScreenshot(screenshotRelPath);
            } catch (Exception se) {
                LoggerHandler.error("Screenshot capture failed: " + se.getMessage());
            }
        }
    }
}