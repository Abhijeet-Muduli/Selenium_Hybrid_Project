package uistore;

import org.openqa.selenium.By;

public class HomePageLocators {

  
    public static By footer = By.tagName("footer");

    public static By careersLink =
            By.xpath("//footer//a[normalize-space()='Careers']");


    public static By helloUserAccountsOrders =
            By.xpath("//span[contains(text(),'Hello User, Accounts & Orders')]" +
                     " | //a[contains(text(),'Hello User, Accounts & Orders')]" +
                     " | //div[contains(text(),'Hello User, Accounts & Orders')]");

    
    public static By phoneNumberField =
            By.cssSelector("input[placeholder*='880'], input[type='tel'], input[name='phone']");


    public static By haveReferralCode =
            By.xpath("//span[contains(text(),'Have a referral code?')]" +
                     "/ancestor::div | //a[contains(text(),'Have a referral code?')]" +
                     " | //p[contains(text(),'Have a referral code?')]" +
                     " | //*[normalize-space()='Have a referral code?']");


    public static By referralCodeInput =
            By.cssSelector("input[placeholder='Referral code']," +
                           "input[name='referralCode']," +
                           "input[placeholder*='referral']");

    
    public static By sendButton =
            By.xpath("//button[normalize-space()='Send']" +
                     " | //input[@value='Send']" +
                     " | //button[contains(@class,'send')]");


    public static By termsAndConditionsLogin =
            By.xpath("//a[contains(text(),'Terms & Conditions')]" +
                     " | //span[contains(text(),'Terms & Conditions')]");


    public static By blogsMenu =
            By.xpath("//a[normalize-space()='Blogs'] | //a[normalize-space()='Blog']");


    public static By labTestNavMenu =
            By.xpath("//nav//span[normalize-space()='Lab Test']" +
                     " | //nav//a[normalize-space()='Lab Test']" +
                     " | //ul//li//a[normalize-space()='Lab Test']");

    public static By browseByHealthConcern =
            By.xpath("//a[normalize-space()='Browse by Health Concern']" +
                     " | //span[normalize-space()='Browse by Health Concern']" +
                     " | //li[normalize-space()='Browse by Health Concern']");

    public static By heartHealthOption =
            By.xpath("//a[normalize-space()='Heart Health']" +
                     " | //span[normalize-space()='Heart Health']");

    public static By minPriceInput =
            By.xpath("//input[@placeholder='Min']" +
                     " | //input[contains(@placeholder,'min') or contains(@placeholder,'Min')]");

    public static By heartHealthResultHeading =
            By.xpath("//*[contains(text(),'Heart Health')]");


    public static By supplementMenu =
            By.xpath("//span[normalize-space()='Supplement']" +
                     " | //a[normalize-space()='Supplement']");

    public static By digestiveProbioticOption =
            By.xpath("//span[normalize-space()='Digestive Probiotic']" +
                     " | //a[normalize-space()='Digestive Probiotic']");

    public static By fishOilOption =
            By.xpath("//a[normalize-space()='Fish Oil']" +
                     " | //span[normalize-space()='Fish Oil']");

    public static By firstProductCard =
            By.xpath("(//div[contains(@class,'product')]//a)[1]" +
                     " | (//div[contains(@class,'item')])[1]" +
                     " | (//article)[1]");

    public static By productDescriptionLabel =
            By.xpath("//*[contains(text(),'Product Description')]");

    
    public static By registerPharmacyLink =
            By.xpath("//footer//a[contains(normalize-space(),'Register')" +
                     " and contains(normalize-space(),'Pharmacy')]" +
                     " | //a[normalize-space()='Register the Pharmacy']");

    public static By closePopupButton =
            By.xpath("//button[contains(@class,'close') or @aria-label='Close']" +
                     " | //button[normalize-space()='×']" +
                     " | //*[@class='modal-close' or @data-dismiss='modal']");

    public static By fullNameField =
            By.xpath("//input[@placeholder='Enter your full name'" +
                     " or @name='fullName' or @id='fullName']");

    public static By mobileNumberRegisterField =
            By.xpath("//input[@placeholder='Enter your mobile number'" +
                     " or @name='mobileNumber' or @id='mobileNumber']");

    public static By businessTypeDropdown =
            By.xpath("//select[@name='businessType' or @id='businessType']" +
                     " | //div[contains(@class,'select')]//select");

    public static By pharmacyOption =
            By.xpath("//option[normalize-space()='Pharmacy']");

    public static By pharmacyNameField =
            By.xpath("//input[@placeholder='Enter your pharmacy name'" +
                     " or @name='pharmacyName']");

    public static By drugsLicenceField =
            By.xpath("//input[@placeholder='Enter your drugs licence number'" +
                     " or @name='drugsLicenceNumber']");

    public static By submitButton =
            By.xpath("//button[normalize-space()='Submit']" +
                     " | //input[@type='submit' and @value='Submit']");

    public static By otpErrorMessage =
            By.xpath("//*[contains(text(),'Please input your OTP!')]" +
                     " | //*[contains(text(),'OTP')]");
}