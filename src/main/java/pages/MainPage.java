package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Constants;
import utils.Waiters;

import java.time.Duration;

public class MainPage extends AbstractPage{

    // page elements
    @FindBy(css=".-one .large-mobile")
    private WebElement welcomeLabel;
    @FindBy(css=".fa-bars")
    private WebElement menuButton;
    @FindBy(css=".-one>.home-button")
    private WebElement findYourWineButton;
    @FindBy(css=".primary-footer")
    private WebElement footer;
    @FindBy(css=".-one>h2")
    private WebElement welcomeToWorldYellowTailLabel;
    @FindBy(css=".-one>.header-sub-copy")
    private WebElement enjoyLabel;

    // menu elements
    @FindBy(css=".top-nav .yt-logo")
    private WebElement menuYellowTail;
    @FindBy(css=".main-nav [href*=\"wines\"]")
    private WebElement menuWines;
    @FindBy(css=".main-nav [href*=\"stores\"]")
    private WebElement menuWhereToBuy;
    @FindBy(css=".main-nav [href*=\"cocktails\"]")
    private WebElement menuCocktails;
    @FindBy(css=".main-nav [href*=\"our-story\"]")
    private WebElement menuOurStory;
    @FindBy(css=".main-nav [href*=\"faqs\"]")
    private WebElement menuFAQS;
    @FindBy(css=".main-nav [href*=\"contact\"]")
    private WebElement menuContact;
    @FindBy(css=".country-select span")
    private WebElement menuLanguage;
    @FindBy(css="[data-key=\"CN\"]")
    private WebElement menuChinaLanguage;

    public MainPage() {
        super();
        waitForLoadableElement();
    }

    @Override
    public void waitForLoadableElement(){
        Waiters.waitForElementToBeVisible(welcomeLabel, Constants.TIME_LOAD_ELEMENT);
    }

    @Step("get text from welcome label")
    public String welcomeLabelGetText(){
        return welcomeLabel.getText();
    }

    @Step("click menu button")
    public void menuButtonClick(){
        menuButton.click();
        Waiters.waitForElementToBeVisible(menuLanguage, Constants.TIME_LOAD_ELEMENT);
    }

    @Step("click menu YellowTail")
    public void menuYellowTailClick(){
        menuYellowTail.click();
    }

    @Step("click menu Language")
    public void menuLanguageClick(){
        menuLanguage.click();
    }

    @Step("click menu ChinaLanguage")
    public void menuChinaLanguageClick() { menuChinaLanguage.click(); }

    @Step("click menu WhereToBuy")
    public void menuWhereToBuyClick() { menuWhereToBuy.click(); }

    @Step("click menu Cocktails")
    public void menuCocktailsClick() { menuCocktails.click(); }

    @Step("navigate to chineMain page")
    public ChineMainPage navigateToChineMainPage(){
        menuButtonClick();
        Waiters.waitForElementToBeVisible(menuLanguage, Constants.TIME_LOAD_ELEMENT);
        menuLanguageClick();
        Waiters.waitForElementToBeVisible(menuChinaLanguage, Constants.TIME_LOAD_ELEMENT);
        menuChinaLanguageClick();
        return new ChineMainPage();
    }

    @Step("navigate to whereToBuy page")
    public WhereToBuyPage navigateToWhereToBuyPage(){
        menuButtonClick();
        menuWhereToBuyClick();
        return new WhereToBuyPage();
    }

    @Step("navigate to cocktails page")
    public CocktailsPage navigateToCocktailsPage() {
        menuButtonClick();
        menuCocktailsClick();
        return new CocktailsPage();
    }

    public WebElement getWelcomeLabel() {
        return welcomeLabel;
    }

    public WebElement getMenuButton() {
        return menuButton;
    }

    public WebElement getFindYourWineButton() {
        return findYourWineButton;
    }

    public WebElement getFooter() {
        return footer;
    }

    public WebElement getWelcomeToWorldYellowTailLabel() {
        return welcomeToWorldYellowTailLabel;
    }

    public WebElement getEnjoyLabel() {
        return enjoyLabel;
    }

    public WebElement getMenuYellowTail() {
        return menuYellowTail;
    }

    public WebElement getMenuWines() {
        return menuWines;
    }

    public WebElement getMenuWhereToBuy() {
        return menuWhereToBuy;
    }

    public WebElement getMenuCocktails() {
        return menuCocktails;
    }

    public WebElement getMenuOurStory() {
        return menuOurStory;
    }

    public WebElement getMenuFAQS() {
        return menuFAQS;
    }

    public WebElement getMenuContact() {
        return menuContact;
    }

    public WebElement getMenuLanguage() {
        return menuLanguage;
    }

    public WebElement getChinaLanguage() {
        return menuChinaLanguage;
    }
}
