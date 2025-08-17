/*
 * This project is licensed under the GNU General Public License v2.0 – see the LICENSE file for details.
 */
package pages;

//Selenide
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ElementsCollection;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selectors.byTitle;
import static com.codeborne.selenide.Selectors.byClassName;

import pages.BasePage;


/**
 *
 * @author busyCookie
 */
public class HomePage extends BasePage {
    public SelenideElement homePageBody = $(".MapDisplayed.home");
    public SelenideElement transportMenu = areaMenu.find(byClassName("transport-navigation"));
    //public SelenideElement transportMenu = areaMenu.$(".transport-navigation");
    public SelenideElement travelPlanner = $("#divContentIndex.travel-planner");
    public SelenideElement transportSearchInput = $(byXpath("//div[@id='divContentRoutes']//div[@class='search-stop']//input"));
    public SelenideElement transportSearchResult = $(".searchData");
    public SelenideElement transportSerachTallinnTotal = transportSearchResult.find(byTitle("Tallinna Transport")).$(".total");
    public SelenideElement transportSerachTallinnStopsCount = transportSearchResult.find(byClassName("stops-number"));
    public SelenideElement transportSerachTallinnRoutesCount = transportSearchResult.find(byClassName("routes-number"));
    public SelenideElement transportSerachTallinnAddresses = transportSearchResult.find(by("data-filter", "addresses"));
    public ElementsCollection transportSearchStopsList = transportSearchResult.$$(".stop");
    public ElementsCollection transportSearchLinesList = transportSearchResult.$$(".line");
    public ElementsCollection transportSearchAddressList = transportSearchResult.$$(".place");
    
    static {
        returnButton = homeButton;
    }
    
}
