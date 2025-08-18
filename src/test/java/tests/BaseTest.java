/*
 * This project is licensed under the GNU General Public License v2.0 – see the LICENSE file for details.
 */
package tests;

/*
 * Using mostly specific imports, since this reduces chance of potential
 * interferance betwween objects from different APIs
 */
//Selenide
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.WebElementCondition;
import com.codeborne.selenide.ex.UIAssertionError;
import static com.codeborne.selenide.Condition.and;
import static com.codeborne.selenide.Condition.be;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;

//JUnit
//import org.junit.jupiter.api.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.TestInstance;

//local
import pages.BasePage;


/**
 *
 * @author busyCookie
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {
    public static BasePage currentPage;
    public static WebElementCondition bePresent = and("be present", exist, be(visible));
    
    @BeforeAll
    public void SetUp() {
        try {
            currentPage.open();
        } catch (Exception e) {
            System.out.println("Page for testing can not be opened");
            e.printStackTrace();
        }
        
    }
    
    @AfterEach
    public void ReturnToTestPage() {
        if ( !WebDriverRunner.url().equals(Configuration.baseUrl) ) {
            try {
                if (currentPage.returnButton.isDisplayed()) {
                    currentPage.returnButton.click();
                } else {
                    currentPage.returnButtonFallback.click();
                }
            } catch (UIAssertionError e) {
                System.out.println("Page return button is not defined or absent from page");
                e.printStackTrace();
                System.out.println("Reopening the page");
                currentPage.reopen();
            }
        }
    }
}
