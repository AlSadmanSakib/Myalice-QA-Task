import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage {
    static WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public static void URL(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        //driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://myalice-automation-test.netlify.app");
    }

    public static void Verifyloginpage() throws InterruptedException {
        Assert.assertTrue(driver.findElement(By.xpath("//input[@id='username']")).isDisplayed());
        Thread.sleep(2000);
    }

    public static void EnterUser() throws InterruptedException {
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("testuser");
        Thread.sleep(2000);
    }

    public static void EnterPassword() throws InterruptedException {
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("password");
        Thread.sleep(2000);
    }

    public static void LoginButton() throws InterruptedException {
        driver.findElement(By.xpath("//button[@id='login-btn']")).click();
        Thread.sleep(2000);
    }

    public static void VerifyMangaSearch() throws InterruptedException {
        Assert.assertTrue(driver.findElement(By.xpath("//input[@id='manga-search']")).isDisplayed());
    }


}
