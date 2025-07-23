/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/SeleniumTests/SeleneseIT.java to edit this template
 */

//JUnit
import org.junit.jupiter.api.*;
//Selenium
import org.openqa.selenium.*;
//Selenide
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;

/**
 *
 * @author mandrake
 */
public class MainPageTest {
    
    @Test
    public void openTransportTallinn() {
        open("https://transport.tallinn.ee//");
        
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
    
}
