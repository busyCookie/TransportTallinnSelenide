/*
 * This project is licensed under the GNU General Public License v2.0 – see the LICENSE file for details.
 */
package tests;

/*
 * Using mostly specific imports, since this reduces chance of potential
 * interferance betwween objects from different APIs
 */
//Java
import java.util.regex.*;

//Selenide
import com.codeborne.selenide.Configuration;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.WebDriverConditions.url;


//JUnit
//import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import com.codeborne.selenide.junit5.TextReportExtension;

//local
import pages.HomePage;


/**
 *
 * @author busyCookie
 */
@ExtendWith({TextReportExtension.class})
@TestMethodOrder(OrderAnnotation.class)
public class HomePageTest extends BaseTest {
    private static HomePage homePage;
    
    static {
        currentPage = new HomePage();
        homePage = (HomePage) currentPage;
        Configuration.baseUrl = "https://transport.tallinn.ee/#/ee";   
    }
      
    @Test
    @Order(1)
    public void HomePageContent() {
        webdriver().shouldHave(url(Configuration.baseUrl));
                
        //check that home page is loaded
        homePage.homePageBody.should(bePresent);
        
        homePage.title.should(bePresent);
        homePage.lanugageSelection.should(bePresent);
        homePage.sidebar.should(bePresent);
        homePage.areaMenu.should(bePresent);
        homePage.homeButton.should(bePresent);
        homePage.transportMenu.should(bePresent);
        homePage.travelPlanner.should(bePresent);
        homePage.transportMenu.should(bePresent);
        homePage.mainMenu.should(bePresent);
        homePage.infoMenu.should(bePresent);
        homePage.travelPlanner.should(bePresent);
        homePage.map.should(bePresent);
        
    }
    
    @Test
    @Order(10)
    public void RoutesSearchTallinn() {
        // I just don't like keep variables unnecessary uninitiated.
        int searchStops = 0;
        int searchLines = 0;
        /* 
         * regex is used to extract actual numerical value from serach result.
         * it will brake if addutional numerical values will be added
         * to the same element.
         * intially I wanted to use more precise regex, like \([\d+]\)
         * but ultimatly decide that addition of other number in search result
         * is less likely than change of the sting format.
         * Pattern compilation is kept in the specific test, so to not waste time
         * running other tests, at least until it will not be required in other tests.
         * 
         * In real testing project it should be more practical to have
         * a staging enviroment with predictable test data, so it could be
         * used directly in the test/ picked up from config/ picked up from DB.
         */        
        Pattern searchCountPattern = Pattern.compile("[\\d]+");
        
        homePage.transportSearchInput.should(exist);
        homePage.transportSearchInput.val("viru");
        homePage.transportSearchResult.should(bePresent);
        
        String searchStopsCountText = homePage.transportSerachTallinnStopsCount.getText();
        String searchLinesCountText = homePage.transportSerachTallinnRoutesCount.getText();
             
        Matcher searchStopsMatcher = searchCountPattern.matcher(searchStopsCountText);
        Matcher searchLinesMatcher = searchCountPattern.matcher(searchLinesCountText);
        searchStopsMatcher.find();
        searchLinesMatcher.find();
        
        searchStops = Integer.parseInt(searchStopsMatcher.group());
        searchLines = Integer.parseInt(searchLinesMatcher.group());     
                
        homePage.transportSerachTallinnTotal.shouldHave(text(String.format("(%d)", searchStops + searchLines)));
        homePage.transportSearchStopsList.shouldHave(size(searchStops));
        homePage.transportSearchLinesList.shouldHave(size(searchLines));
        
        homePage.transportSearchStopsList.get(0).shouldBe(visible);
        homePage.transportSearchLinesList.get(0).shouldNotBe(visible);
        homePage.transportSearchAddressList.get(0).shouldNotBe(visible);
        homePage.transportSerachTallinnRoutesCount.click();
        homePage.transportSearchStopsList.get(0).shouldNotBe(visible);
        homePage.transportSearchLinesList.get(0).shouldBe(visible);
        homePage.transportSearchAddressList.get(0).shouldNotBe(visible);
        homePage.transportSerachTallinnAddresses.click();
        homePage.transportSearchStopsList.get(0).shouldNotBe(visible);
        homePage.transportSearchLinesList.get(0).shouldNotBe(visible);
        homePage.transportSearchAddressList.get(0).shouldBe(visible);

    }
    
    @Test
    @Order(99)
    public void DefaultLanguage () {
        homePage.title.shouldHave(text("Avaleht"));
        homePage.title.shouldNotHave(text("Home page"));
        homePage.title.shouldNotHave(text("Pääsivu"));
        homePage.title.shouldNotHave(text("Домашняя страницa"));
        //German version of the page uses engish "Home page" instead of correct "Startseite".
        homePage.title.shouldNotHave(text("Startseite")); 
        homePage.title.shouldNotHave(text("Pradinis puslapis"));
        //Latvian version of the page uses engish "Home page" instead of correct "Sākumslapa".
        homePage.title.shouldNotHave(text("Sākumlapa"));
        
    }
}
