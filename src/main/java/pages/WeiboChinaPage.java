package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Constants;
import utils.Waiters;

public class WeiboChinaPage extends AbstractPage{

    @FindBy(css = ".logo")
    private WebElement weiboIcon;

    public WeiboChinaPage() {
        super();
        waitForLoadableElement();
    }

    @Override
    public void waitForLoadableElement(){
        Waiters.waitForElementToBeVisible(weiboIcon, Constants.TIME_LOAD_WEIBOPAGE_ELEMENT);
    }

    @Step("get page url")
    public String getPageUrl(){
        return ProviderForDriver.INSTANCE.getDriver().getCurrentUrl();
    }
}
