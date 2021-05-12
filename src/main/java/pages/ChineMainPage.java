package pages;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Constants;
import utils.Waiters;

public class ChineMainPage extends AbstractPage{

    @FindBy (css = ".heading-editable>font:first-child")
    private WebElement chinaMainPageWelcomeLabel;
    @FindBy (css = ".sgg-comp-social-icon>.fa.fa-weibo")
    private WebElement weiboIcon;
    public ChineMainPage() {
        super();
        waitForLoad();
    }

    @Override
    public void waitForLoad(){
        Waiters.waitForElementToBeVisible(chinaMainPageWelcomeLabel, Constants.TIME_LOAD_ELEMENT);
    }

    @Step("click weibo icon")
    public void weiboIconClick() {
        weiboIcon.click();
    }

    @Step("navigate to weibo china page")
    public WeiboChinaPage navigateToWeiboChinaPage() {
        weiboIconClick();
        int winHandleNum = ProviderForDriver.INSTANCE.getDriver().getWindowHandles().size();
        if (winHandleNum > 1){
            for (String winHandle: ProviderForDriver.INSTANCE.getDriver().getWindowHandles()){
                ProviderForDriver.INSTANCE.getDriver().switchTo().window(winHandle);
            }
        }
        return new WeiboChinaPage();
    }

    @Step("get page url")
    public String getPageUrl(){
        return ProviderForDriver.INSTANCE.getDriver().getCurrentUrl();
    }

    public WebElement getWeiboIcon() {
        return weiboIcon;
    }
}

