package pages;

import org.openqa.selenium.support.PageFactory;
import utils.Constants;

public abstract class AbstractPage {

    public AbstractPage() {
        PageFactory.initElements(ProviderForDriver.INSTANCE.getDriver(), this);
    }

    public abstract void waitForLoadableElement();
}
