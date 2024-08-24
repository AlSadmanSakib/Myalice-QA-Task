import org.apache.hc.core5.http.impl.HttpProcessors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MainTestpage {
    private WebDriver driver;
    private LoginPage LP;
    private MangaPage MP;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        LP = new LoginPage(driver);
        MP = new MangaPage(driver);
    }

    @Test
    public void testLoginProcess() throws InterruptedException {
        LP.URL();
        LP.Verifyloginpage();
        LP.EnterUser();
        LP.EnterPassword();
        LP.LoginButton();
        LP.VerifyMangaSearch();
    }

    @Test(dependsOnMethods = "testLoginProcess")
    public void testMangaSearchProcess() throws InterruptedException {
        MP.MangaSearch();
        MP.ClickOnSearch();
        MP.DisplayNaruto();
        MP.ClearSearchBox();
        MP.SearchOnePiece();
        MP.Searchbutton();
        MP.DisplayOnePiece();
        MP.ClearSearchBox();
        MP.SearchSevenDeadlySins();
        MP.Searchbutton();
        MP.ClearSearchBox();
        MP.searchWhole();
        MP.ClearSearchBox();

        // Make the final search and ensure it works correctly
        MP.Searchbutton();
        MP.DisplayMangaSearchPage();
        MP.ClickonDetails();
        MP.DisplayMangaInformation();
        MP.ClickonClose();
        MP.VerifyModalClosed();

    }

    @AfterClass
    public void tearDown() {
       if (driver != null) {
          driver.quit();
       }
    }
}
