package pages;

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

    public String legalAgeCheckGetText(){
        return legalAgeCheck.getText();
    }

    public void legalAgeCheckClick(){ legalAgeCheck.click(); }

    public void welcomeButtonClick(){ welcomeButton.click(); }

    public void selectValueCountryDropBox(String input){
        selectElement = new Select(regionDropBox);
        selectElement.selectByValue(input);
    }

    public MainPage navigateToMainPage(){
        legalAgeCheckClick();
        selectValueCountryDropBox("eu");
        welcomeButtonClick();
        return new MainPage();
    }

    public WebElement getLegalAgeCheck(){ return legalAgeCheck; }

    public WebElement getRegionDropBox() { return regionDropBox; }

    public WebElement getWelcomeButton() {
        return welcomeButton;
    }
}