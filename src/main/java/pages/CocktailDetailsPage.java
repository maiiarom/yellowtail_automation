package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Constants;
import utils.Waiters;

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

    public String getPageUrl(){
        return ProviderForDriver.getDriver().getCurrentUrl();
    }

    public WebElement getIngredientSection() {
        return ingredientSection;
    }
}
