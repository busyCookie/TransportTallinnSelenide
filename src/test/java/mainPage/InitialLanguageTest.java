/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainPage;
//JUnit
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
//Selenium
//import org.openqa.selenium.*;
//Selenide
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.junit5.TextReportExtension;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;

/**
 *
 * @author busyCookie
 */
@ExtendWith({TextReportExtension.class})
public class InitialLanguageTest {
    
    @Test
    public void InitialLanguageTest() {
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
