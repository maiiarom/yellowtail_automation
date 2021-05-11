package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Constants;
import utils.Waiters;

import static utils.Constants.WELCOME_PAGE_URL;

public class CocktailDetailsPage extends AbstractPage{

    @FindBy (css = ".row>h3")
    private WebElement ingredientSection;

    public CocktailDetailsPage() {
        super();
        waitForLoadableElement();
    }

    @Override
    public void waitForLoadableElement(){
        Waiters.waitForElementToBeVisible(ingredientSection, Constants.TIME_LOAD_ELEMENT);
    }

    @Step("get page url")
    public String getPageUrl(){
        return ProviderForDriver.INSTANCE.getDriver().getCurrentUrl();
    }

    public WebElement getIngredientSection() {
        return ingredientSection;
    }
}
