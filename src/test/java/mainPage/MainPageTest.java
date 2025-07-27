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
//Selenium
//import org.openqa.selenium.*;
//Selenide
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.junit5.TextReportExtension;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Condition.*;


/**
 *
 * @author busyCookie
 */
@ExtendWith({TextReportExtension.class})
public class MainPageTest {
    @BeforeAll
    public static void SetUp() {
        open("https://transport.tallinn.ee//");
    }
    
    @AfterEach
    public void RefrehsPage() {
        refresh();
    }
    
    @Test
    @Order(1)
    public void openTransportTallinn() {
        //check that page is loaded
        $(".MapDisplayed.home").should(exist);
        $(".MapDisplayed.home").shouldBe(visible);

        //check that page contains correct basic elements
        //Header with lanugae selction menu
        $("#divHeader").should(exist);
        $("#divHeader").shouldBe(visible);
        
        $("#divTitle").should(exist);
        $("#divTitle").shouldBe(visible);
        $("#divTitle").shouldHave(text("Avaleht"));
        
        $("#divHeader").find(byId("divLang")).should(exist);
        $("#divHeader").find(byId("divLang")).shouldBe(visible);
        
        //Sidebar menus
        $("#sidebar").should(exist);
        $("#sidebar").shouldBe(visible);
        
        $("#sidebar").find(byId("areaMenuContainer")).should(exist);
        $("#sidebar").find(byId("areaMenuContainer")).shouldBe(visible);
        
        $("#sidebar").find(byId("mainMenu")).should(exist);
        $("#sidebar").find(byId("mainMenu")).shouldBe(visible);
        
        $("#sidebar").find(byId("infoMenu")).should(exist);
        $("#sidebar").find(byId("infoMenu")).shouldBe(visible);
        
        //Travel planner
        $("#divContentIndex.travel-planner").should(exist);
        $("#divContentIndex.travel-planner").shouldBe(visible);
        
        //Map
        $("#divMapWrapper").should(exist);
        $("#divMapWrapper").shouldBe(visible);
        
    }
    
    @Test
    @Order(3)
    public void VerifyInitialLanguage() {
        open("https://transport.tallinn.ee//");
        
        $("#divHeader").shouldHave(Condition.text("Avaleht"));
        $("#divHeader").shouldNotHave(Condition.text("Home page"));
        $("#divHeader").shouldNotHave(Condition.text("Pääsivu"));
        $("#divHeader").shouldNotHave(Condition.text("Домашняя страницa"));
        //German version of the page uses engish "Home page" instead of correct "Startseite".
        $("#divHeader").shouldNotHave(Condition.text("Startseite")); 
        $("#divHeader").shouldNotHave(Condition.text("Pradinis puslapis"));
        //Latvian version of the page uses engish "Home page" instead of correct "Sākumslapa".
        $("#divHeader").shouldNotHave(Condition.text("Sākumlapa"));
        
    }
}
