package CrmVtiger;

import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import generic_utility.FileUtility;
import object_repository.OpportunitiesPage;



@Listeners(listeners_utility.List_Imp.class)


public class OpportunitiesTest {

    @Test
    public static void createOpportunities(WebDriver driver) 
            throws InterruptedException, EncryptedDocumentException, IOException {
		
        // Fetch data from Excel using FileUtility (Sheet: opportunities)
        String sheetName = "opportunities";
        int rowIndex = 1;

        // Shifted cell indexes to be sequential since organization name is hardcoded
        String oppNameData      = FileUtility.getDataFromExcelFile(sheetName, rowIndex, 0); // Column A
        String amountData       = FileUtility.getDataFromExcelFile(sheetName, rowIndex, 1); // Column B
        String closingDateData  = FileUtility.getDataFromExcelFile(sheetName, rowIndex, 2); // Column C
        String nextStepData     = FileUtility.getDataFromExcelFile(sheetName, rowIndex, 3); // Column D
        String probabilityData  = FileUtility.getDataFromExcelFile(sheetName, rowIndex, 4); // Column E
        String descriptionData  = FileUtility.getDataFromExcelFile(sheetName, rowIndex, 5); // Column F

        OpportunitiesPage op = new OpportunitiesPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		
        // Navigation
        wait.until(ExpectedConditions.elementToBeClickable(op.getOppLink())).click();
        wait.until(ExpectedConditions.elementToBeClickable(op.getCreateNewOppBtn())).click();
		
        // Fill basic opportunity details
        op.getOpportunityName().sendKeys(oppNameData);
		
        // Handle "Related To" Dropdown selection
        Select relatedTypeDD = new Select(op.getRelatedToDropdown());
        relatedTypeDD.selectByIndex(0);
		
        // Store window handle before opening lookup popup
        String parentWindow = driver.getWindowHandle();
        op.getRelatedToLookupImg().click();

        // Wait for the popup window to appear
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        Set<String> windows = driver.getWindowHandles();

        for (String id : windows) {
            // Skip the parent Opportunity window
            if (!id.equals(parentWindow)) {
                System.out.println("Popup Title: " + driver.getTitle());
                driver.switchTo().window(id);

                // Hardcoded search for "Qspider" link text inside popup
                WebElement organizationName = wait.until(
                    ExpectedConditions.elementToBeClickable(
                        By.linkText("Qspider")
                    )
                );
                organizationName.click();
                System.out.println("Qspider organization selected");
                break;
            }
        }

        // Switch execution control back to the primary Opportunity window form
        driver.switchTo().window(parentWindow);
        
        // Select dropdown elements by indexing structures
        Select oppTypeDD = new Select(op.getOpportunityTypeDropdown());
        oppTypeDD.selectByIndex(1); 
        
        Select leadSourceDD = new Select(op.getLeadSourceDropdown());
        leadSourceDD.selectByIndex(2);

        // Fill data values parsed out from the re-aligned columns
        op.getAmount().sendKeys(amountData);
        op.getExpectedClosingDate().sendKeys(closingDateData);
        op.getNextStep().sendKeys(nextStepData);
        op.getProbability().sendKeys(probabilityData);
        op.getDescription().sendKeys(descriptionData);
        
        // Commit and save form data
        op.getSaveButton().click();
    }
}
