/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pages;

//Selenide
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selectors.byId;

/**
 *
 * @author busyCookie
 */
public class BasePage {
    //public SelenideElement homePageBody = $(".MapDisplayed.home");
    public SelenideElement title = $("#divTitle");
    public SelenideElement lanugageSelection = $("#divHeader").find(byId("divLang"));
    public SelenideElement sidebar = $("#sidebar");
    public SelenideElement areaMenu = sidebar.find(byId("areaMenuContainer"));
    public SelenideElement homeButton = areaMenu.$(".icon_home");
    public SelenideElement mainMenu = sidebar.find(byId("mainMenu"));
    public SelenideElement infoMenu = sidebar.find(byId("infoMenu"));
    public SelenideElement map = $("#divMapWrapper");
  
    public BasePage open() {
        Selenide.open("");
        return this;
    }
         
   public BasePage refresh() {
        Selenide.refresh();
        return this;
    }
}
