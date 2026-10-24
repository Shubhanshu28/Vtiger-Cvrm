package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class LeadPage {

    public LeadPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    // --- Header / Navigation Elements ---
    @FindBy(linkText = "Leads")
    private WebElement createLeadsLink;

    @FindBy(css = "[alt='Create Lead...']")
    private WebElement createLeadImg;

    // --- Lead Information Elements ---
    @FindBy(css = "[name='salutationtype']")
    private WebElement salutationDropdown;

    @FindBy(css = "[name='firstname']")
    private WebElement firstName;

    @FindBy(css = "[name='lastname']")
    private WebElement lastName;

    @FindBy(css = "[name='company']")
    private WebElement companyName;

    @FindBy(id = "designation")
    private WebElement designation;

    @FindBy(css = "[name='leadsource']")
    private WebElement leadSourceDropdown;

    @FindBy(css = "[name='industry']")
    private WebElement industryDropdown;

    @FindBy(css = "[name='annualrevenue']")
    private WebElement annualRevenue;

    @FindBy(css = "[name='noofemployees']")
    private WebElement noOfEmployees;

    @FindBy(id = "secondaryemail")
    private WebElement secondaryEmail;

    @FindBy(id = "phone")
    private WebElement phone;

    @FindBy(id = "mobile")
    private WebElement mobile;

    @FindBy(id = "fax")
    private WebElement fax;

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(css = "[name='website']")
    private WebElement website;

    @FindBy(css = "[name='leadstatus']")
    private WebElement leadStatusDropdown;

    @FindBy(css = "[name='rating']")
    private WebElement ratingDropdown;

    // --- Address & Description Elements ---
    @FindBy(css = "[name='lane']")
    private WebElement street;

    @FindBy(id = "pobox")
    private WebElement poBox;

    @FindBy(id = "code")
    private WebElement postalCode;

    @FindBy(id = "city")
    private WebElement city;

    @FindBy(id = "country")
    private WebElement country;

    @FindBy(id = "state")
    private WebElement state;

    @FindBy(css = "[name='description']")
    private WebElement description;

    @FindBy(css = "[type='submit']")
    private WebElement saveButton;

    // --- Getters ---
    public WebElement getLeadsLink() {
        return createLeadsLink;
    }

    public WebElement getCreateLeadImg() {
        return createLeadImg;
    }

    public WebElement getSalutationDropdown() {
        return salutationDropdown;
    }

    public WebElement getFirstName() {
        return firstName;
    }

    public WebElement getLastName() {
        return lastName;
    }

    public WebElement getCompanyName() {
        return companyName;
    }

    public WebElement getDesignation() {
        return designation;
    }

    public WebElement getLeadSourceDropdown() {
        return leadSourceDropdown;
    }

    public WebElement getIndustryDropdown() {
        return industryDropdown;
    }

    public WebElement getAnnualRevenue() {
        return annualRevenue;
    }

    public WebElement getNoOfEmployees() {
        return noOfEmployees;
    }

    public WebElement getSecondaryEmail() {
        return secondaryEmail;
    }

    public WebElement getPhone() {
        return phone;
    }

    public WebElement getMobile() {
        return mobile;
    }

    public WebElement getFax() {
        return fax;
    }

    public WebElement getEmail() {
        return email;
    }

    public WebElement getWebsite() {
        return website;
    }

    public WebElement getLeadStatusDropdown() {
        return leadStatusDropdown;
    }

    public WebElement getRatingDropdown() {
        return ratingDropdown;
    }

    public WebElement getStreet() {
        return street;
    }

    public WebElement getPoBox() {
        return poBox;
    }

    public WebElement getPostalCode() {
        return postalCode;
    }

    public WebElement getCity() {
        return city;
    }

    public WebElement getCountry() {
        return country;
    }

    public WebElement getState() {
        return state;
    }

    public WebElement getDescription() {
        return description;
    }

    public WebElement getSaveButton() {
        return saveButton;
    }
}