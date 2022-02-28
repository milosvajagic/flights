package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class FlightsPage extends BasePage {
    WebDriver driver;

    public FlightsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[contains(text(),'Flights')]")
    WebElement flights;

    @FindBy(css = ".css-k008qs")
    WebElement startingPoint;

    @FindBy(css = ".css-1tl2oa1")
    WebElement fromPoint;

//    @FindBy(xpath = "//div[@data-testid=\"searchbox_destination\"]")
//    WebElement endingPoint;

    @FindBy(css = ".css-bwf0ll")
    WebElement checkBox;

    @FindBy(xpath = "//input[@data-testid=\"searchbox_destination_input\"]")
    WebElement toPoint;

    @FindBy(xpath = "//div[@class='css-1eii3rq']")
    WebElement clear;

    @FindBy(xpath = "(//div[@class=\"css-164c9py\"])[2]//..")
    WebElement dateTo;

    @FindBy(xpath = "(//span[@class='InputRadio-module__field___16hZ8'])[2]")
    WebElement stopCheckBox;

    @FindBy(xpath = "(//span[@class='InputCheckbox-module__field___1mRcZ'])[3]")
    WebElement departTimeCheckBox;

    @FindBy(xpath = "//button[@data-testid=\"flight_card_bound_select_flight\"][1]")
    WebElement seeFlights;

    @FindBy(xpath = "(//div[@data-testid='flight_details_inner_modal_select_button'])//button")
    WebElement select;

    @FindBy(xpath = "//div[@class='css-b07tw6']//button")
    WebElement  next;

    @FindBy(xpath = "//input[@name='email']")
    WebElement email;

    @FindBy(css = "#phone")
    WebElement phone;

    @FindBy(xpath = "//input[@name=\"passengers.0.firstName\"]")
    WebElement firstName;

    @FindBy(xpath = "//input[@name=\"passengers.0.lastName\"]")
    WebElement lastName;

    @FindBy(xpath = "//button[@data-testid=\"searchbox_submit\"]")
    WebElement search;

    WebElement keyAction;

    public void addStartingPoint(String fromPointText) throws InterruptedException {
        clickElement(startingPoint);
        clickElement(clear);
        typeText(fromPoint,fromPointText);
        clickElement(checkBox);
        keyAction = driver.findElement(By.cssSelector(".css-1tl2oa1"));
        keyAction.sendKeys(Keys.TAB);
       }

    public void addEndingPoint(String toPointText) throws InterruptedException {
       typeText(toPoint,toPointText);
       clickElement(checkBox);
        keyAction = driver.findElement(By.xpath("//input[@data-testid=\"searchbox_destination_input\"]"));
        keyAction.sendKeys(Keys.TAB);
    }

    public void addDates(String departureDate, String returnDate) throws InterruptedException {
        //Check is date today's date or futures date
        //check is check out after check in date
        //Check is date displayed if not click next
        clickElement(dateTo);
        clickElement(driver.findElement(By.xpath("//span[@data-date-cell='" + departureDate + "']")));
        clickElement(driver.findElement(By.xpath("//span[@data-date-cell='" + returnDate + "']")));
    }

    public void clickSearch() throws InterruptedException {
        clickElement(search);
    }

    public void clickFlights() throws  InterruptedException{
        clickElement(flights);
    }

    public void selectStopCheckBox() throws InterruptedException{
        clickElement(stopCheckBox);
    }

    public void selectDepartTimeheckBox() throws InterruptedException {
        clickElement(departTimeCheckBox);
    }

    public void clickSeeFlights() throws InterruptedException {
        clickElement(seeFlights);
    }

    public void clickSelectButton() throws InterruptedException {
        clickElement(select);
    }

    public void clickNextButton() throws InterruptedException {
        clickElement(next);
    }
    public void enterContactDetails(String emailText, String firstNameText, String lastNameText, String gender, String phoneText) throws InterruptedException {
        typeText(email,emailText);
        typeText(phone, phoneText);
        typeText(firstName,firstNameText);
        typeText(lastName,lastNameText);
        WebElement dropDown = driver.findElement(By.xpath("//select[@name=\"passengers.0.gender\"]"));
        Select dropdown = new Select(dropDown);
        dropdown.selectByVisibleText(gender);
    }
}
