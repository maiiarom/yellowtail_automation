package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Constants;
import utils.Waiters;

import java.time.Duration;
import java.util.List;

import static utils.Constants.WELCOME_PAGE_URL;

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

    @Step("click location field")
    public void fieldLocationClick() {
        fieldLocation.click();
    }

    @Step("click search button")
    public void searchButtonClick() {
        searchButton.click();
    }

    @Step("send text {1} to element {0}")
    public void elementSendKeys(WebElement element, String input) {
        element.sendKeys(input);
    }

    @Step("get text of search result {0}")
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
