package CrmVtiger;

import java.io.IOException;

import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import generic_utility.FileUtility;
import object_repository.LeadPage;

@Listeners(listeners_utility.List_Imp.class)

public class LeadTest {
	
	@Test

    public static void leadCreation(WebDriver driver)
            throws InterruptedException, EncryptedDocumentException, IOException {

        // Fetch data from Excel using FileUtility
        String sheetName = "Leads";
        int rowIndex = 1;

        String prefix = FileUtility.getDataFromExcelFile(sheetName, rowIndex, 0);
        String firstName = FileUtility.getDataFromExcelFile(sheetName, rowIndex, 1);
        String lastName = FileUtility.getDataFromExcelFile(sheetName, rowIndex, 2);
        String companyName = FileUtility.getDataFromExcelFile(sheetName, rowIndex, 3);
        String title = FileUtility.getDataFromExcelFile(sheetName, rowIndex, 4);
        String leadSource = FileUtility.getDataFromExcelFile(sheetName, rowIndex, 5);
        String industry = FileUtility.getDataFromExcelFile(sheetName, rowIndex, 6);
        String annualRevenue = FileUtility.getDataFromExcelFile(sheetName, rowIndex, 7);
        String noOfEmployees = FileUtility.getDataFromExcelFile(sheetName, rowIndex, 8);
        String secondaryEmail = FileUtility.getDataFromExcelFile(sheetName, rowIndex, 9);
        String phone = FileUtility.getDataFromExcelFile(sheetName, rowIndex, 10);
        String mobile = FileUtility.getDataFromExcelFile(sheetName, rowIndex, 11);
        String fax = FileUtility.getDataFromExcelFile(sheetName, rowIndex, 12);
        String email = FileUtility.getDataFromExcelFile(sheetName, rowIndex, 13);
        String website = FileUtility.getDataFromExcelFile(sheetName, rowIndex, 14);
        String leadStatus = FileUtility.getDataFromExcelFile(sheetName, rowIndex, 15);
        String rating = FileUtility.getDataFromExcelFile(sheetName, rowIndex, 16);

        String street = FileUtility.getDataFromExcelFile(sheetName, rowIndex, 19);
        String poBox = FileUtility.getDataFromExcelFile(sheetName, rowIndex, 20);
        String postalCode = FileUtility.getDataFromExcelFile(sheetName, rowIndex, 21);
        String city = FileUtility.getDataFromExcelFile(sheetName, rowIndex, 22);
        String country = FileUtility.getDataFromExcelFile(sheetName, rowIndex, 23);
        String state = FileUtility.getDataFromExcelFile(sheetName, rowIndex, 24);
        String description = FileUtility.getDataFromExcelFile(sheetName, rowIndex, 25);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // Create object of LeadPage (POM)
        LeadPage lp = new LeadPage(driver);

        // Navigation
        wait.until(ExpectedConditions.elementToBeClickable(lp.getLeadsLink())).click();
        wait.until(ExpectedConditions.elementToBeClickable(lp.getCreateLeadImg())).click();

        // Filling Lead details
        new Select(lp.getSalutationDropdown()).selectByVisibleText(prefix);
        lp.getFirstName().sendKeys(firstName);
        lp.getLastName().sendKeys(lastName);
        lp.getCompanyName().sendKeys(companyName);
        lp.getDesignation().sendKeys(title);

        new Select(lp.getLeadSourceDropdown()).selectByVisibleText(leadSource);
        new Select(lp.getIndustryDropdown()).selectByValue(industry);

        lp.getAnnualRevenue().sendKeys(annualRevenue);
        lp.getNoOfEmployees().sendKeys(noOfEmployees);
        lp.getSecondaryEmail().sendKeys(secondaryEmail);
        lp.getPhone().sendKeys(phone);
        lp.getMobile().sendKeys(mobile);
        lp.getFax().sendKeys(fax);
        lp.getEmail().sendKeys(email);
        lp.getWebsite().sendKeys(website);

        // Address details
        lp.getStreet().sendKeys(street);
        lp.getPoBox().sendKeys(poBox);
        lp.getPostalCode().sendKeys(postalCode);
        lp.getCity().sendKeys(city);
        lp.getCountry().sendKeys(country);
        lp.getState().sendKeys(state);
        lp.getDescription().sendKeys(description);

        // Submit
        lp.getSaveButton().click();
    }
}