/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tests;

/*
 * Using mostly specific imports, since this reduces chance of potential
 * interferance betwween objects from different APIs
 */
//Selenide
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebElementCondition;
import com.codeborne.selenide.WebDriverRunner;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.Condition.and;
import static com.codeborne.selenide.Condition.be;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.WebDriverConditions.url;

//JUnit
//import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Order;

//local
import pages.HomePage;

/**
 *
 * @author busyCookie
 */

//Lnading open Home page in estonian language, but does not use same URL logic as every other page.
//so, it gets a separate specifc test. that works correctly.
public class LandingPageTest {
    private static HomePage homePage = new HomePage();
    
    public static WebElementCondition bePresent = and("be present", exist, be(visible));
    
    @BeforeAll
    public static void SetUp() {
       //HomePage;
        Configuration.baseUrl = "https://transport.tallinn.ee/";
        homePage.open();
        
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
}
