/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pages;

//Selenide
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selectors.byTitle;
import static com.codeborne.selenide.Selectors.byClassName;





/**
 *
 * @author busyCookie
 */
public class HomePage extends BasePage {
    public SelenideElement homePageBody = $(".MapDisplayed.home");
    public SelenideElement transportMenu = areaMenu.find(byClassName("transport-navigation"));
    public SelenideElement travelPlanner = $("#divContentIndex.travel-planner");
    //public SelenideElement lineSearchInput = $("#divContentRoutes").find(byClassName("search-stop")).find(byXpath(".input"));
    public SelenideElement lineSearchInput = $(byXpath("//div[@id='divContentRoutes']//div[@class='search-stop']//input"));
    public SelenideElement lineSerachResult = $(".searchData");
    public SelenideElement lineSerachResultsTallinnCount = lineSerachResult.find(byTitle("Tallinna Transport"));
    public SelenideElement lineSerachResultsTallinnStopsCount = lineSerachResult.find(byClassName("stops-number"));
    public SelenideElement lineSerachResultsTallinnRoutesCount = lineSerachResult.find(byClassName("routes-number"));
    
    //public SelenideElement lineSearchButton = $("#divContentIndex.travel-planner");
    
}
