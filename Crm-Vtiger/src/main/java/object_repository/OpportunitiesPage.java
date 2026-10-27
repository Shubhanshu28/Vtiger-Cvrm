package object_repository;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class OpportunitiesPage {
public OpportunitiesPage(WebDriver driver) {
PageFactory.initElements(driver, this);
}
@FindBy(linkText = "Opportunities")
private WebElement oppLink;
@FindBy(css = "[title='Create Opportunity...']")
private WebElement createNewOppBtn;
@FindBy(css = "[name='potentialname']")
private WebElement opportunityName;
@FindBy(id = "related_to_type")
private WebElement relatedToDropdown;
@FindBy(xpath = "//img[@title='Select']")
private WebElement relatedToLookupImg;
@FindBy(css = "[name='opportunity_type']")
private WebElement opportunityTypeDropdown;
@FindBy(css = "[name='leadsource']")
private WebElement leadSourceDropdown;
@FindBy(xpath = "//input[@name='amount']")
private WebElement amount;
@FindBy(xpath = "//input[@name='closingdate']")
private WebElement expectedClosingDate;
@FindBy(id = "nextstep")
private WebElement nextStep;
@FindBy(id = "probability")
private WebElement probability;
@FindBy(xpath = "//textarea[@name='description']")
private WebElement description;
@FindBy(xpath = "//input[@accesskey='S' and @title='Save [Alt+S]']")
private WebElement saveButton;
// --- Getters ---
public WebElement getOppLink() {
return oppLink;
}
public WebElement getCreateNewOppBtn() {
return createNewOppBtn;
}
public WebElement getOpportunityName() {
return opportunityName;
}
public WebElement getRelatedToDropdown() {
return relatedToDropdown;
}
public WebElement getRelatedToLookupImg() {
return relatedToLookupImg;
}
public WebElement getOpportunityTypeDropdown() {
return opportunityTypeDropdown;
}
public WebElement getLeadSourceDropdown() {
return leadSourceDropdown;
}
public WebElement getAmount() {
return amount;
}
public WebElement getExpectedClosingDate() {
return expectedClosingDate;
}
public WebElement getNextStep() {
return nextStep;
}
public WebElement getProbability() {
return probability;
}
public WebElement getDescription() {
return description;
}
public WebElement getSaveButton() {
return saveButton;
}
}