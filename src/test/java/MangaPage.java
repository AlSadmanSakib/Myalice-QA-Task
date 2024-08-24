import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class MangaPage {
    private static WebDriver driver;

    public MangaPage(WebDriver driver) {
        this.driver = driver;
    }

    public static void MangaSearch() throws InterruptedException {
        driver.findElement(By.cssSelector("#manga-search")).sendKeys("Naruto");
        //Thread.sleep(2000);
    }

    public static void ClickOnSearch() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[normalize-space()='Search']")).click();
    }

    public static void DisplayNaruto() {
        Assert.assertTrue(driver.findElement(By.xpath("//h3[@id='manga-name']")).isDisplayed());
    }

    public static void ClearSearchBox() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='manga-search']")).clear();
    }

    public static void SearchOnePiece() {
        driver.findElement(By.cssSelector("#manga-search")).sendKeys("One Piece");
    }

    public static void Searchbutton() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[normalize-space()='Search']")).click();
    }

    public static void DisplayOnePiece() {
        Assert.assertTrue(driver.findElement(By.xpath("//h3[@id='manga-name']")).isDisplayed());
    }

    public static void SearchSevenDeadlySins() {
        driver.findElement(By.cssSelector("#manga-search")).sendKeys("Seven Deadly Sins");
    }

    public static void DisplayNoMangaFound() throws InterruptedException {
        Assert.assertTrue(driver.findElement(By.cssSelector(".text-red-500")).isDisplayed());
        Thread.sleep(2000);
    }

    public static void searchWhole() {
        driver.findElement(By.cssSelector("#manga-search")).sendKeys(" ");
    }

    public static void DisplayMangaSearchPage() throws InterruptedException {
        Assert.assertTrue(driver.findElement(By.xpath("//h1[normalize-space()='Manga You Should Read']")).isDisplayed());
        Thread.sleep(2000);
    }

    public static void ClickonDetails(){
        driver.findElement(By.xpath("//p[contains(text(),'Humanity fights for survival against giant humanoi')]//span[@class='text-blue-500 cursor-pointer'][normalize-space()='Details']")).click();
    }

    public static void DisplayMangaInformation() throws InterruptedException {
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='bg-white p-6 rounded-lg shadow-lg w-96']//img[@alt='Attack on Titan']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='bg-white p-6 rounded-lg shadow-lg w-96']//h3[@class='text-xl font-bold mb-2'][normalize-space()='Attack on Titan']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='text-gray-600 mb-4']")).isDisplayed());
        Thread.sleep(2000);
    }

    public static void ClickonClose(){
        driver.findElement(By.xpath("//button[normalize-space()='Close']")).click();
    }

    public static void VerifyModalClosed() throws InterruptedException {
        Assert.assertTrue(driver.findElement(By.xpath("//h1[normalize-space()='Manga You Should Read']")).isDisplayed());
        Thread.sleep(2000);
    }

}
