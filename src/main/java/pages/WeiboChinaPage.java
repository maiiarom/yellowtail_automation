package pages;

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

    public String getPageUrl(){
        return ProviderForDriver.getDriver().getCurrentUrl();
    }
}
