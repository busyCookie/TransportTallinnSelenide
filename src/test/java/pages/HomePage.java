/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pages;

//Selenide
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selectors.byClassName;
import com.codeborne.selenide.SelenideElement;


/**
 *
 * @author busyCookie
 */
public class HomePage extends BasePage {
    public SelenideElement homePageBody = $(".MapDisplayed.home");
    public SelenideElement transportMenu = areaMenu.find(byClassName("transport-navigation"));
    public SelenideElement travelPlanner = $("#divContentIndex.travel-planner");
    
    /*
    public HomePage open(String address) {
        open(address);
        return this;
    }
    */
    
}
