/*
 * This project is licensed under the GNU General Public License v2.0 – see the LICENSE file for details.
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
    //can not be filled in a template calss, because each page would have different button.
    public static SelenideElement returnButton;
    
    public static SelenideElement title = $("#divTitle");
    public static SelenideElement lanugageSelection = $("#divHeader").find(byId("divLang"));
    public static SelenideElement sidebar = $("#sidebar");
    public static SelenideElement areaMenu = sidebar.find(byId("areaMenuContainer"));
    public static SelenideElement homeButton = areaMenu.$(".icon_home");
    public static SelenideElement mainMenu = sidebar.find(byId("mainMenu"));
    public static SelenideElement infoMenu = sidebar.find(byId("infoMenu"));
    public static SelenideElement map = $("#divMapWrapper");
  
    public BasePage open() {
        Selenide.open("");
        return this;
    }
         
   public BasePage refresh() {
        Selenide.refresh();
        return this;
    }
}
