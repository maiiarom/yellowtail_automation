package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Constants;
import utils.Waiters;

import java.time.Duration;
import java.util.List;

public class WhereToBuyPage extends AbstractPage{

    @FindBy(css = "#locationName")
    private WebElement fieldLocation;
    @FindBy(css = ".search-submit")
    private WebElement searchButton;
    @FindBy(css = "div.address")
    private List<WebElement> searchResults;

    public WhereToBuyPage() {
        super();
        waitForLoadableElement();
    }

    @Override
    public void waitForLoadableElement(){
        Waiters.waitForElementToBeVisible(fieldLocation, Constants.TIME_LOAD_ELEMENT);
    }

    public void fieldLocationClick() {
        fieldLocation.click();
    }

    public void searchButtonClick() {
        searchButton.click();
    }

    public void elementSendKeys(WebElement element, String input) {
        element.sendKeys(input);
    }

    public String searchResultsGetText(WebElement element){
        return element.getText();
    }

    public WebElement getFieldLocation() {
        return fieldLocation;
    }

    public List<WebElement> getSearchResults() {
        return searchResults;
    }
}
