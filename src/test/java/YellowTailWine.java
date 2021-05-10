import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import pages.*;

public class YellowTailWine extends JunitRunner{
    @Story("All required elements are displayed")
    @Description("Case 1: Welcome page: all required elements are displayed")
    @Test
    //Case 1: Welcome page: all required elements are displayed
    //1. Go to Welcome page: https://www.yellowtailwine.com
    //2. Verify that “I am of legal drinking age in” is displayed
    //3. Verify that checkbox before “I am of legal drinking age in” is displayed
    //4. Verify that dropdown with Select is displayed
    //5. Verify that “Welcome” button is displayed and is inactive
    public void verifyWelcomePageElementsDisplayed() {
        WelcomePage welcomePage = new WelcomePage();

        Assertions.assertEquals("I am of legal drinking age in", welcomePage.legalAgeCheckGetText(), "case 1, legalAgeLabel does not have expected text");
        Assertions.assertTrue(welcomePage.getLegalAgeCheck().isDisplayed(), "case 1, legalAgeCheck is not displayed");
        Assertions.assertTrue(welcomePage.getRegionDropBox().isDisplayed(), "case 1, selectDropBox is not displayed");
        Assertions.assertTrue(welcomePage.getWelcomeButton().isDisplayed(), "case 1, welcomeButton is not displayed");
        Assertions.assertFalse(welcomePage.getWelcomeButton().isEnabled(), "case 1, welcomeButton should be disabled but it is enabled");
    }

    @Story("Navigation functionality")
    @Description("Case 2: Main page: navigate to main page as European customer")
    @Test
    //Case 2: Main page: navigate to main page as European customer
    //1. Tick on checkbox
    //2. Select “Europe” from dropbox
    //3. Press “Welcome” button
    //4. Main page should be displayed
    public void verifyMainPageDisplayed() {
        WelcomePage welcomePage = new WelcomePage();
        MainPage mainPage = welcomePage.navigateToMainPage();

        Assertions.assertTrue(mainPage.welcomeLabelGetText().contains("Welcome".toUpperCase()), "case 2, Welcome label on main page is not appears");
    }

    @Story("All required elements are displayed")
    @Description("Case 3: Main page: all required elements are displayed")
    @Test
    //Case 3: Main page: all required elements are displayed
    //1. Navigate to main page
    //2. Verify that the following elements are displayed:
    //   - menu button
    //   - WELCOME TO THE WORLD OF [Yellow tail]
    //   - We are passionate about creating great tasting, quality wines for everyone to enjoy
    //   - find your wine button
    //   - footer
    public void verifyMainPageElementsDisplayed() {
        WelcomePage welcomePage = new WelcomePage();
        MainPage mainPage = welcomePage.navigateToMainPage();

        Assertions.assertTrue(mainPage.getWelcomeToWorldYellowTailLabel().isDisplayed(), "case 3, WelcomeToWorldYellowTailLabel is not displayed");
        Assertions.assertTrue(mainPage.getEnjoyLabel().isDisplayed(), "case 3, EnjoyLabel is not displayed");
        Assertions.assertTrue(mainPage.getMenuButton().isDisplayed(),"case 3, MenuButton is not displayed");
        Assertions.assertTrue(mainPage.getFindYourWineButton().isDisplayed(), "case 3, FindYourWineButton is not displayed");
        Assertions.assertTrue(mainPage.getFooter().isDisplayed(), "case 3, footer is not displayed");
    }

    @Story("Menu functionality")
    @Description("Case 4: Main page: Menu button logic (open header)")
    @Test
    //Case 4: Main page: Menu button logic (open header)
    //1. Navigate to main page
    //2. Click on Menu button
    //3. Verify that header with all needed links is appeared
    //4. Click on [yellow tail]
    //5. Verify that Menu button is visible
    public void verifyMenuButtonOpenLogic() {
        WelcomePage welcomePage = new WelcomePage();
        MainPage mainPage = welcomePage.navigateToMainPage();
        mainPage.menuButtonClick();

        Assertions.assertTrue(mainPage.getMenuYellowTail().isDisplayed(), "case 4, menu item Yellow Tail issue");
        Assertions.assertTrue(mainPage.getMenuWines().getText().contains("Wines".toUpperCase()), "case 4, menu item Wines issue");
        Assertions.assertTrue(mainPage.getMenuWhereToBuy().getText().contains("Where To Buy".toUpperCase()), "case 4, menu item Where To Buy issue");
        Assertions.assertTrue(mainPage.getMenuCocktails().getText().contains("Cocktails".toUpperCase()), "case 4, menu item Cocktails issue");
        Assertions.assertTrue(mainPage.getMenuOurStory().getText().contains("Our Story".toUpperCase()), "case 4, menu item Our Story issue");
        Assertions.assertTrue(mainPage.getMenuFAQS().getText().contains("FAQs".toUpperCase()), "case 4, menu item FAQs issue");
        Assertions.assertTrue(mainPage.getMenuContact().getText().contains("Contact".toUpperCase()),"case 4, menu item Contacts issue");
        Assertions.assertTrue(mainPage.getMenuLanguage().isDisplayed(), "case 4, menu item Language issue");

        mainPage.menuYellowTailClick();

        Assertions.assertTrue(mainPage.getMenuButton().isDisplayed(), "case 4, menu button issue");
    }

    @Story("Menu functionality")
    @Description("Case 5: Main page: Menu button logic (close header)")
    @Test
    //Case 5: Main page: Menu button logic (close header)
    //1. Navigate to main page
    //2. Click on Menu button
    //3. Click on [yellow tail]
    //4. Verify that Menu button is visible
    public void verifyMenuButtonCloseLogic() {
        WelcomePage welcomePage = new WelcomePage();
        MainPage mainPage = welcomePage.navigateToMainPage();
        mainPage.menuButtonClick();

        Assertions.assertTrue(mainPage.getMenuButton().isDisplayed(), "case 5, menu button issue");
    }

    @Story("Global Navigation functionality")
    @Description("Case 6: Main page: Global Nav logic")
    @Test
    //Case 6: Main page: Global Nav logic
    //1. Navigate to main page
    //2. Click on Menu button
    //3. Click on Globe icon
    //4. Select China in popup and click on it
    //5. Verify that language is changed
    public void verifyNavigationToChinaMainPage() {
        WelcomePage welcomePage = new WelcomePage();
        MainPage mainPage = welcomePage.navigateToMainPage();
        ChineMainPage chineMainPage = mainPage.navigateToChineMainPage();

        Assertions.assertTrue(chineMainPage.getPageUrl().contains(".cn"), "case 6, page does not contain .cn");
    }

    @Story("Global Navigation functionality")
    @Description("Case 7: Main page: Global Nav logic (CHINA - separate site is open)")
    @Test
    //Case 7: Main page: Global Nav logic (CHINA - separate site is open)
    //1. Navigate to main page
    //2. Click on Menu button
    //3. Click on Globe icon
    //4. Select China in popup and click on it
    //5. Click on icon (in white square on screenshot)
    //6. Verify that “https://www.weibo.com/yellowtailChina” site is open in new tab
    public void verifyNavigationToWeiboChinaPage() {
        WelcomePage welcomePage = new WelcomePage();
        MainPage mainPage = welcomePage.navigateToMainPage();
        ChineMainPage chineMainPage = mainPage.navigateToChineMainPage();
        WeiboChinaPage weiboChinaPage = chineMainPage.navigateToWeiboChinaPage();

        Assertions.assertTrue(weiboChinaPage.getPageUrl().contains("weibo.com/yellowtailChina"), "case 7, https://www.weibo.com/yellowtailChina site is not open");
    }

    @Story("Where to buy location search functionality")
    @Description("Case 8: Where to buy: enter valid postal code")
    @Test
    //Case 8: Where to buy: enter valid postal code
    //1. Navigate to “Where to buy” page
    //2. Enter valid data in “Your location” field
    //3. Click on Search button
    //4. Verify that the results of search are displayed
    public void verifyValidPostalCodeForWhereToBuyPage() {
        WelcomePage welcomePage = new WelcomePage();
        MainPage mainPage = welcomePage.navigateToMainPage();
        WhereToBuyPage whereToBuyPage = mainPage.navigateToWhereToBuyPage();
        whereToBuyPage.fieldLocationClick();
        whereToBuyPage.elementSendKeys(whereToBuyPage.getFieldLocation(), "Sydney NSW, Australia");
        whereToBuyPage.searchButtonClick();

        String result1 = "SYDNEY NSW";
        String result2 = "Darlinghurst NSW";
        String result3 = "BARANGAROO NSW";
        for (WebElement item: whereToBuyPage.getSearchResults()){
            Assertions.assertTrue(whereToBuyPage.searchResultsGetText(item).contains((result1))
                    || whereToBuyPage.searchResultsGetText(item).contains((result2))
                    || whereToBuyPage.searchResultsGetText(item).contains((result3)),
                    "case 8, details of search results are false");
        }
    }

    @Story("Cocktails functionality")
    @Description("Case 9: Cocktails: Select one wine")
    @Test
    //Case 9: Cocktails: Select one wine
    //1. Navigate to “Cocktails” page
    //2. Select “Red wine cocktails”
    //3. Verify that 7 recipes are displayed
    public void verifyRedWineCocktailsList() {
        WelcomePage welcomePage = new WelcomePage();
        MainPage mainPage = welcomePage.navigateToMainPage();
        CocktailsPage cocktailsPage = mainPage.navigateToCocktailsPage();
        cocktailsPage.selectCocktailsDropBoxClick();
        cocktailsPage.redWineCocktailItemClick();

        int searchResult = 1;
        Assertions.assertEquals(searchResult, cocktailsPage.elementsCount(cocktailsPage.getSearchResults()), "case 9, count of results of red wines does not equal expected count");
    }

    @Story("Cocktails details functionality")
    @Description("Case 10: Cocktails: Navigate to Cocktail recipe page")
    @Test
    //Case 10: Cocktails: Navigate to Cocktail recipe page
    //1. Navigate to “Cocktails” page
    //2. Scroll to “RASPBERRY ROSÉ” recipe
    //3. Click on “RASPBERRY ROSÉ” recipe
    //4. Verify that new page is displayed:
    //- ingredients section is displayed
    public void verifyCocktailsDetailsPage() {
        WelcomePage welcomePage = new WelcomePage();
        MainPage mainPage = welcomePage.navigateToMainPage();
        CocktailsPage cocktailsPage = mainPage.navigateToCocktailsPage();
        cocktailsPage.scrolling(cocktailsPage.getRaspberryRoseWine());
        cocktailsPage.raspberryRoseWineClick();
        CocktailDetailsPage cocktailDetailsPage = cocktailsPage.navigateToCocktailDetailsPage();

        Assertions.assertEquals("https://www.yellowtailwine.com/recipe/raspberry-rose/", cocktailDetailsPage.getPageUrl(), "case 10, new page is not displayed");
        Assertions.assertTrue(cocktailDetailsPage.getIngredientSection().isDisplayed(), "case 10, ingredient section is not displayed");
    }

    @Story("Cocktails functionality")
    @Description("Case 11: Cocktails: Select several wines")
    @Test
    //Case 11: Cocktails: Select several wines
    //1. Navigate to “Cocktails” page
    //2. Select “Red wine cocktails”
    //3. Select “Sparkling wine cocktails”
    //4. Verify that “Multiple” word is displayed in “Type” dropdown
    //5. Verify that 18 recipes are displayed
    public void verifySparklingWineCocktailsList() {
        WelcomePage welcomePage = new WelcomePage();
        MainPage mainPage = welcomePage.navigateToMainPage();
        CocktailsPage cocktailsPage = mainPage.navigateToCocktailsPage();
        cocktailsPage.selectCocktailsDropBoxClick();
        cocktailsPage.redWineCocktailItemClick();
        cocktailsPage.sparklingWineCocktailItemClick();

        int searchResult = 18;
        Assertions.assertTrue(cocktailsPage.cocktailsTypeFieldGetText().contains("Multiple"), "case 11, CocktailsTypeField does not contains Multiple");
        Assertions.assertEquals(searchResult, cocktailsPage.elementsCount(cocktailsPage.getSearchResults()), "case 11, count of results for sparkling wines does not equal expected count");
    }
}
