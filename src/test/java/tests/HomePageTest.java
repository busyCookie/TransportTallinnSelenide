/*
 * This project is licensed under the GNU General Public License v2.0 – see the LICENSE file for details.
 */
package tests;

/*
 * Using mostly specific imports, since this reduces chance of potential
 * interferance betwween objects from different APIs
 */
//Selenide
import com.codeborne.selenide.Configuration;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
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
        
        //homePage.title.should(exist).shouldBe(visible);
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
    @Order(2)
    public void RoutesSearch() {
        //for now tested with local variables
        //should be updated to use test data in future
        
        homePage.lineSearchInput.should(exist);
        homePage.lineSearchInput.val("viru");
        homePage.lineSerachResult.should(bePresent);
        homePage.lineSerachResultsTallinnCount.shouldHave(text("(21)"));
        homePage.lineSerachResultsTallinnStopsCount.shouldHave(text("(8)"));
        homePage.lineSerachResultsTallinnRoutesCount.shouldHave(text("(13)"));
    }
    
    @Test
    @Order(10)
    public void DefaultLanguage () {
        //$("#divHeader").shouldHave(Condition.text("Avaleht"));
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
