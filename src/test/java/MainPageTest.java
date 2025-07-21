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

/**
 *
 * @author mandrake
 */
public class MainPageTest {
    
    @Test
    public void openTransportTallinn() {
        open("https://transport.tallinn.ee//");
        
        $(".MapDisplayed.home").should(exist);
        $(".MapDisplayed.home").shouldBe(visible);

    }
    
}
