/*
 * This project is licensed under the GNU General Public License v2.0 – see the LICENSE file for details.
 */
package tests;

/*
 * Using mostly specific imports, since this reduces chance of potential
 * interferance betwween objects from different APIs
 */
// Selenide
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebElementCondition;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.Condition.and;
import static com.codeborne.selenide.Condition.be;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.WebDriverConditions.url;

// JUnit
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Order;

//local
import pages.HomePage;

/**
 *
 * @author busyCookie
 */

//Lnading open Home page in estonian language, but does not use same URL logic as every other page.
//so, it gets a separate specifc test. that works correctly.
public class LandingPageTest extends BaseTest {
    private static HomePage landingPage;
    
    public static WebElementCondition bePresent = and("be present", exist, be(visible));
    
    static {
        //landing page just uses HomePage, so it does not requre a searate page classe to describe it
        currentPage = new HomePage();
        landingPage = (HomePage) currentPage;
        Configuration.baseUrl = "https://transport.tallinn.ee/";   
    }
    
    @Test
    @Order(1)
    public void HomePageContent() {
        webdriver().shouldHave(url(Configuration.baseUrl));
                
        //check that home page is loaded
        landingPage.homePageBody.should(bePresent);
        
        landingPage.title.should(bePresent);
        landingPage.lanugageSelection.should(bePresent);
        landingPage.sidebar.should(bePresent);
        landingPage.areaMenu.should(bePresent);
        landingPage.areaMenuHomeButton.should(bePresent);
        landingPage.transportMenu.should(bePresent);
        landingPage.travelPlanner.should(bePresent);
        landingPage.transportMenu.should(bePresent);
        landingPage.mainMenu.should(bePresent);
        landingPage.infoMenu.should(bePresent);
        landingPage.travelPlanner.should(bePresent);
        landingPage.map.should(bePresent);
        
    }
}
