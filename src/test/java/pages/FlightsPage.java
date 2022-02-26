package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Map;

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


   // @FindBy(css = ".xp__guests__count")
   // WebElement guestCount;
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
}
