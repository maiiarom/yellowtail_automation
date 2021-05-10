package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import utils.Constants;
import utils.Waiters;

public class WelcomePage extends AbstractPage{

    @FindBy(css = "[for=\"confirm\"]")
    private WebElement legalAgeCheck;
    @FindBy(css = "#agegate-selector-options")
    private WebElement regionDropBox;
    @FindBy(css = "[type=\"submit\"]")
    private WebElement welcomeButton;
    private Select selectElement;

    public WelcomePage() {
        super();
        waitForLoadableElement();
    }

    @Override
    public void waitForLoadableElement(){
        Waiters.waitForElementToBeVisible(legalAgeCheck, Constants.TIME_LOAD_ELEMENT);
    }
    @Step("get legalAgeCheck text")
    public String legalAgeCheckGetText(){
        return legalAgeCheck.getText();
    }

    @Step("click legalAgeCheck")
    public void legalAgeCheckClick(){ legalAgeCheck.click(); }

    @Step("click on welcome button")
    public void welcomeButtonClick(){ welcomeButton.click(); }

    @Step("enter value into country dropbox {0}")
    public void enterValueCountryDropBox(String input){
        selectElement = new Select(regionDropBox);
        selectElement.selectByValue(input);
    }

    @Step("navigate to main page")
    public MainPage navigateToMainPage(){
        legalAgeCheckClick();
        enterValueCountryDropBox("eu");
        welcomeButtonClick();
        return new MainPage();
    }

    public WebElement getLegalAgeCheck(){ return legalAgeCheck; }

    public WebElement getRegionDropBox() { return regionDropBox; }

    public WebElement getWelcomeButton() {
        return welcomeButton;
    }
}