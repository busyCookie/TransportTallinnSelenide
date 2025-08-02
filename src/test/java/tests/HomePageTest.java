package tests;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/SeleniumTests/SeleneseIT.java to edit this template
 */



//Selenide
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebElementCondition;
import static com.codeborne.selenide.Condition.and;
import static com.codeborne.selenide.Condition.be;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.refresh;

//JUnit
//import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import com.codeborne.selenide.junit5.TextReportExtension;

//Selenium
//import org.openqa.selenium.*;


//local
import pages.HomePage;


/**
 *
 * @author busyCookie
 */
@ExtendWith({TextReportExtension.class})
@TestMethodOrder(OrderAnnotation.class)
public class HomePageTest {
    private static HomePage homePage = new HomePage();
    
    public static WebElementCondition bePresent = and("be present", exist, be(visible));
    
    @BeforeAll
    public static void SetUp() {
       //HomePage;
        Configuration.baseUrl = "https://transport.tallinn.ee/";
        homePage.open();
        
    }
    
    @AfterEach
    public void RefrehsPage() {
        //not really needed yet, but shoul be prudent to reduce flakiness
        //in future more complicated tests
        refresh();
    }
    
    @Test
    @Order(1)
    public void HomePageContent() {    
        //check that home page is loaded
        homePage.homePageBody.should(bePresent);
        
        //homePage.title.should(exist).shouldBe(visible);
        homePage.title.should(bePresent);
        homePage.lanugageSelection.should(bePresent);
        homePage.sidebar.should(bePresent);
        homePage.areaMenu.should(bePresent);
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
    public void DefaultLanguage () {
        //$("#divHeader").shouldHave(Condition.text("Avaleht"));
        homePage.title.shouldHave(exactText("Avaleht"));
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
