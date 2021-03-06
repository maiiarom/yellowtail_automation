package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Constants;
import utils.Waiters;

public class CocktailDetailsPage extends AbstractPage{

    @FindBy (css = ".row>h3")
    private WebElement ingredientSection;

    public CocktailDetailsPage() {
        super();
        waitForLoad();
    }

    @Override
    public void waitForLoad(){
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
