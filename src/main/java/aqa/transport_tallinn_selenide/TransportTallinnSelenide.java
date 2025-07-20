/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package aqa.transport_tallinn_selenide;
//JUnit
import org.junit.jupiter.api.*;
//Selenum
//import org.openqa.selenium.*;
//Selenide
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

/**
 *
 * @author busyCookie
 */
public class TransportTallinnSelenide {
//TODO: figure out why the hell Selenide element does not work as expected.
    public static void main(String[] args) {
        System.out.println("Testing...");
        
        openTransportTallinn();
        
        System.out.println("Test completed");        
    }
    
    @Test
    public static void openTransportTallinn() {
        open("https://transport.tallinn.ee//");
              
        $(".MapDisplayed.home").should(exist);
        $(".MapDisplayed.home").shouldBe(visible);
    }
}
