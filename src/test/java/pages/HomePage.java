/*
 * This project is licensed under the GNU General Public License v2.0 – see the LICENSE file for details.
 */
package pages;

//Selenide
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
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
    public SelenideElement travelPlanner = $("#divContentIndex.travel-planner");
    public SelenideElement lineSearchInput = $(byXpath("//div[@id='divContentRoutes']//div[@class='search-stop']//input"));
    public SelenideElement lineSerachResult = $(".searchData");
    public SelenideElement lineSerachResultsTallinnCount = lineSerachResult.find(byTitle("Tallinna Transport")).$(".total");
    public SelenideElement lineSerachResultsTallinnStopsCount = lineSerachResult.find(byClassName("stops-number"));
    public SelenideElement lineSerachResultsTallinnRoutesCount = lineSerachResult.find(byClassName("routes-number"));
    
    static {
        returnButton = homeButton;
    }
    
}
