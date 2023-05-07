import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumWebSignUpTest {

    //import the selenium WebDriver
    private WebDriver driver;

    public void start() throws InterruptedException {
        //locate where the chromedriver is
        System.setProperty("webdriver.chrome.driver", "Resources/chromedriver.exe");
        //1. Open your chrome browser
        driver = new ChromeDriver();
        //2. Input your Selenium Demo page URL (https://selenium-blog.herokuapp.com)
        driver.get("http://selenium-blog.herokuapp.com");
        Thread.sleep(10000);
        //3. Maximize the browser
        driver.manage().window().maximize();
       //4. Click on the signup button to open the signup page
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        //5. Input your username on the username field
        driver.findElement(By.id("user_username")).sendKeys("adel21");
        //6. Input your email address in the email address field
        driver.findElement(By.id("user_email")).sendKeys("adel21@mailinator.com");
        //7. Input your password in the password field
        driver.findElement(By.id("user_password")).sendKeys("eyinju");
        //8. Click on the signup button
        driver.findElement(By.id("submit")).click();
        Thread.sleep( 10000);
        //9. Click on User1 item on the list page
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/ul/div/div/li[1]/a"));
        //10. Search for an item (Using Python with Selenium) and confirm it is present
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/div[2]")).click();
        //11. Click on logout
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[3]/a"));
        //12. Close the browser
        driver.quit();


    }




    public void setUp() throws InterruptedException {




    }


}
