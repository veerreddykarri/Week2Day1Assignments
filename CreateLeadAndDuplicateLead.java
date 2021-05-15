package week2.day1.Assignments;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class CreateLeadAndDuplicateLead {
    public static void main(String[] args) throws InterruptedException {
        //Chrome Driver Set-up//
        WebDriverManager.chromedriver().setup();
        ChromeDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("http://leaftaps.com/opentaps/control/main");
        //Login Page//
        chromeDriver.findElementById("username").sendKeys("demosalesmanager");
        WebElement password = chromeDriver.findElementById("password");
        password.clear();
        password.sendKeys("crmsfa");
        chromeDriver.findElementByClassName("decorativeSubmit").click();
        Thread.sleep(5000);
        //Landing Page//
        Assert.assertEquals(chromeDriver.getTitle(), "Leaftaps - TestLeaf Automation Platform");
        chromeDriver.findElementByLinkText("CRM/SFA").click();
        //Create Lead//
        chromeDriver.findElementByLinkText("Leads");
        chromeDriver.findElementByLinkText("Create Lead").click();
        //Company Information//
        chromeDriver.findElementById("createLeadForm_companyName").sendKeys("HomeOffice UK");
        chromeDriver.findElementById("createLeadForm_firstName").sendKeys("Veer");
        chromeDriver.findElementById("createLeadForm_lastName").sendKeys("Karri");
        WebElement source = chromeDriver.findElementById("createLeadForm_dataSourceId");
        Select sourceDropdown = new Select(source);
        sourceDropdown.selectByValue("LEAD_EMPLOYEE");
        WebElement marketing = chromeDriver.findElementById("createLeadForm_marketingCampaignId");
        Select marketingDropdown = new Select(marketing);
        marketingDropdown.selectByValue("9002");
        chromeDriver.findElementById("createLeadForm_firstNameLocal").sendKeys("Veer");
        chromeDriver.findElementById("createLeadForm_lastNameLocal").sendKeys("Karri");
        chromeDriver.findElementById("createLeadForm_personalTitle").sendKeys("Sir");
        chromeDriver.findElementById("createLeadForm_birthDate").sendKeys("03/12/84");
        chromeDriver.findElementById("createLeadForm_generalProfTitle").sendKeys("Mr");
        chromeDriver.findElementById("createLeadForm_departmentName").sendKeys("OSCT");
        chromeDriver.findElementById("createLeadForm_annualRevenue").sendKeys("100000");
        WebElement currency = chromeDriver.findElementById("createLeadForm_currencyUomId");
        Select currencyDropdown = new Select(currency);
        currencyDropdown.selectByValue("INR");
        WebElement industry = chromeDriver.findElementById("createLeadForm_industryEnumId");
        Select industryDropdown = new Select(industry);
        industryDropdown.selectByValue("IND_GEN_SERVICES");
        chromeDriver.findElementById("createLeadForm_numberEmployees").sendKeys("100");
        WebElement ownership = chromeDriver.findElementById("createLeadForm_ownershipEnumId");
        Select ownershipDropdown = new Select(ownership);
        ownershipDropdown.selectByValue("OWN_PUBLIC_CORP");
        chromeDriver.findElementById("createLeadForm_sicCode").sendKeys("VK100");
        chromeDriver.findElementById("createLeadForm_tickerSymbol").sendKeys("HSBCUK");
        chromeDriver.findElementById("createLeadForm_description").sendKeys("Veer added some description");
        chromeDriver.findElementById("createLeadForm_importantNote").sendKeys("Veer added some important note");
        //Contact Information//
        chromeDriver.findElementById("createLeadForm_primaryPhoneCountryCode").sendKeys("91");
        chromeDriver.findElementById("createLeadForm_primaryPhoneAreaCode").sendKeys("98661");
        chromeDriver.findElementById("createLeadForm_primaryPhoneNumber").sendKeys("66079");
        chromeDriver.findElementById("createLeadForm_primaryPhoneExtension").sendKeys("1345");
        chromeDriver.findElementById("createLeadForm_primaryPhoneAskForName").sendKeys("Veer");
        chromeDriver.findElementById("createLeadForm_primaryEmail").sendKeys("veer.karri@mymail.com");
        chromeDriver.findElementById("createLeadForm_primaryWebUrl").sendKeys("https://veerkarri.com");
        //Primary Address//
        chromeDriver.findElementById("createLeadForm_generalToName").sendKeys("Veer Karri");
        chromeDriver.findElementById("createLeadForm_generalAttnName").sendKeys("Testleaf Lead");
        chromeDriver.findElementById("createLeadForm_generalAddress1").sendKeys("Balaji Nagar");
        chromeDriver.findElementById("createLeadForm_generalAddress2").sendKeys("Nizampet");
        chromeDriver.findElementById("createLeadForm_generalCity").sendKeys("Hyderabad");
        chromeDriver.findElementById("createLeadForm_generalPostalCode").sendKeys("505215");
        WebElement country = chromeDriver.findElementById("createLeadForm_generalCountryGeoId");
        Select countryDropdown = new Select(country);
        countryDropdown.selectByValue("IND");
        Thread.sleep(2000);
        WebElement state = chromeDriver.findElementById("createLeadForm_generalStateProvinceGeoId");
        Select stateDropdown = new Select(state);
        stateDropdown.selectByValue("IN-AP");
        chromeDriver.findElementById("createLeadForm_generalPostalCodeExt").sendKeys("1234");
        //Submit Lead//
        chromeDriver.findElementByClassName("smallSubmit").click();
        Thread.sleep(5000);
        //Duplicate Lead//
        chromeDriver.findElementByLinkText("Duplicate Lead").click();
        Thread.sleep(2000);
        chromeDriver.findElementById("createLeadForm_companyName").clear();
        String duplicateCompanyName = "HMRC UK";
        chromeDriver.findElementById("createLeadForm_companyName").sendKeys(duplicateCompanyName);
        chromeDriver.findElementByClassName("smallSubmit").click();
        Thread.sleep(2000);
        //Get The Duplicate Company name and Verify//
        WebElement newCompanyName = chromeDriver.findElementById("viewLead_companyName_sp");
        String newCompanyNameText = newCompanyName.getText();
        String newCompanyNameAfterTrim = newCompanyNameText.replaceAll("[0-9()]", "").trim();
        String duplicateCompanyNameAfterTrim = duplicateCompanyName.trim();
        Assert.assertEquals(newCompanyNameAfterTrim, duplicateCompanyNameAfterTrim);
        //Close Browser//
        chromeDriver.close();
    }
}
