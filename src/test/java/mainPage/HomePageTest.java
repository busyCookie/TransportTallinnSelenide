package mainPage;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/SeleniumTests/SeleneseIT.java to edit this template
 */

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
//Selenide
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
//import static com.codeborne.selenide.Selenide.*;
//import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.refresh;



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
    
    @BeforeAll
    public static void SetUp() {
       //HomePage;
        Configuration.baseUrl = "https://transport.tallinn.ee/";
        homePage.open();
        
    }
    
    @AfterEach
    public void RefrehsPage() {
        //not really needed yet, but shoul be prudent to reduce flakiness
        //in futer more complicated tests
        refresh();
    }
    
    @Test
    @Order(1)
    public void HomePageContent() {    
        //check that home page is loaded
        homePage.homePageBody.should(exist).shouldBe(visible);
        
        homePage.title.should(exist).shouldBe(visible);
        homePage.lanugageSelection.should(exist).shouldBe(visible);
        homePage.sidebar.should(exist).shouldBe(visible);
        homePage.areaMenu.should(exist).shouldBe(visible);
        homePage.transportMenu.should(exist).shouldBe(visible);
        homePage.travelPlanner.should(exist).shouldBe(visible);
        homePage.transportMenu.should(exist).shouldBe(visible);
        homePage.mainMenu.should(exist).shouldBe(visible);
        homePage.infoMenu.should(exist).shouldBe(visible);
        homePage.travelPlanner.should(exist).shouldBe(visible);
        homePage.map.should(exist).shouldBe(visible);
        
    }
    
    @Test
    @Order(2)
    public void DefaultLanguage () {
        //$("#divHeader").shouldHave(Condition.text("Avaleht"));
        homePage.title.shouldHave(Condition.text("Avaleht"));
        homePage.title.shouldNotHave(Condition.text("Home page"));
        homePage.title.shouldNotHave(Condition.text("Pääsivu"));
        homePage.title.shouldNotHave(Condition.text("Домашняя страницa"));
        //German version of the page uses engish "Home page" instead of correct "Startseite".
        homePage.title.shouldNotHave(Condition.text("Startseite")); 
        homePage.title.shouldNotHave(Condition.text("Pradinis puslapis"));
        //Latvian version of the page uses engish "Home page" instead of correct "Sākumslapa".
        homePage.title.shouldNotHave(Condition.text("Sākumlapa"));
        
    }
}
