package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Constants;
import utils.Waiters;

import java.util.List;

public class CocktailsPage extends AbstractPage{

    @FindBy(css = ".selected")
    private WebElement selectCocktailsDropBox;
    @FindBy(css = "[data-value=\"red\"]")
    private WebElement redWineCocktailItem;
    @FindBy(css = "[data-value=\"bubbles\"]")
    private WebElement sparklingWineCocktailItem;
    @FindBy(css = ".selected>span")
    private WebElement cocktailsTypeField;
    @FindBy(css = "[href=\"raspberry-rose\"]")
    private WebElement raspberryRoseWine;
    @FindBy(xpath = "//div[@class=\"tile recipe-tile\"]")
    private List<WebElement> searchResults;

    public CocktailsPage() {
        super();
        waitForLoad();
    }

    @Override
    public void waitForLoad(){
        Waiters.waitForElementToBeVisible(selectCocktailsDropBox, Constants.TIME_LOAD_ELEMENT);
    }
    @Step("click selectCocktails drop box")
    public void selectCocktailsDropBoxClick() {
        selectCocktailsDropBox.click();
    }

    @Step("click redWineCocktail item")
    public void redWineCocktailItemClick() {
        redWineCocktailItem.click();
    }

    @Step("click raspberryRoseWine item")
    public void raspberryRoseWineClick() {
        raspberryRoseWine.click();
    }

    @Step("click sparklingWineCocktail item")
    public void sparklingWineCocktailItemClick() {
        sparklingWineCocktailItem.click();
    }

    @Step("count result elements")
    public int elementsCount(List<WebElement> elements) {
        return elements.size();
    }

    @Step("navigate to cocktail details page")
    public CocktailDetailsPage navigateToCocktailDetailsPage(){
        int winHandleNum = ProviderForDriver.INSTANCE.getDriver().getWindowHandles().size();
        if (winHandleNum > 1){
            for (String winHandle: ProviderForDriver.INSTANCE.getDriver().getWindowHandles()){
                ProviderForDriver.INSTANCE.getDriver().switchTo().window(winHandle);
            }
        }
        return new CocktailDetailsPage();
    }

    @Step("get text from cocktailsType field")
    public String cocktailsTypeFieldGetText() {
        return cocktailsTypeField.getText();
    }

    @Step("scrolling to element {0}")
    public void scrolling(WebElement element) {
        ((JavascriptExecutor) ProviderForDriver.INSTANCE.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public WebElement getSelectCocktailsDropBox() {
        return selectCocktailsDropBox;
    }

    public WebElement getRedWineCocktailItem() {
        return redWineCocktailItem;
    }

    public WebElement getSparklingWineCocktailItem() {
        return sparklingWineCocktailItem;
    }

    public WebElement getRaspberryRoseWine() {
        return raspberryRoseWine;
    }

    public List<WebElement> getSearchResults() {
        return searchResults;
    }
}
