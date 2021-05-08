package pages;
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
        waitForLoadableElement();
    }

    @Override
    public void waitForLoadableElement(){
        Waiters.waitForElementToBeVisible(chinaMainPageWelcomeLabel, Constants.TIME_LOAD_ELEMENT);
    }

    public void weiboIconClick() {
        weiboIcon.click();
    }

    public WeiboChinaPage navigateToWeiboChinaPage() {
        weiboIconClick();


        int winHandleNum = ProviderForDriver.getDriver().getWindowHandles().size();
        if (winHandleNum > 1){
            for (String winHandle: ProviderForDriver.getDriver().getWindowHandles()){
                ProviderForDriver.getDriver().switchTo().window(winHandle);
            }
        }
        return new WeiboChinaPage();
    }

    public String getPageUrl(){
        return ProviderForDriver.getDriver().getCurrentUrl();
    }

    public WebElement getWeiboIcon() {
        return weiboIcon;
    }
}

