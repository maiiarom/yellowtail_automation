package pages;

import org.openqa.selenium.support.PageFactory;

import static utils.Constants.WELCOME_PAGE_URL;

public abstract class AbstractPage {

    public AbstractPage() {
        PageFactory.initElements(ProviderForDriver.INSTANCE.getDriver(), this);
    }

    public abstract void waitForLoadableElement();
}
