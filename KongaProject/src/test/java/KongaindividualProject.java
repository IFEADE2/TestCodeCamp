import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class KongaindividualProject {
    //import selenium driver
    private WebDriver driver;

    @BeforeTest
    public void start() throws InterruptedException {
        //locate where chromedriver is
        System.setProperty("webdriver.chrome.driver", "Resources/chromedriver.exe");
        //1 open chrome browser
        driver = new ChromeDriver();
        //2 input the Konga URL
        driver.get("https://www.konga.com/");
        Thread.sleep(10000);
        //3 maximize the browser
        driver.manage().window().maximize();
        Thread.sleep(10000);
        //4 click on login button
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/a")).click();

    }

    @Test(priority = 0)
    public void positiveLogin() throws InterruptedException {
        //5 locate email address in the email address field
        driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("adelodun.emmanuel@mailinator.com");
        //7. locate the password on the password field
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("password");
        Thread.sleep(5000);
        //8.click login button to sign in to konga successfully
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();
        Thread.sleep(5000);
    }

    @Test (priority = 1)
    public void selectCategory() throws InterruptedException {
        //9 From the Categories, click on the “Computers and Accessories”
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[2]/div/a[2]")).click();
        Thread.sleep(30000);
        //10 click on Laptop in subcategory
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/div/section/div[2]/div[2]/ul/li[3]/a/label/span")).click();
        Thread.sleep(17000);
        //11 Select on Apple Macbook
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/div/section/div[2]/div[2]/ul/li[3]/a/ul/li[1]/a/label/span")).click();
        Thread.sleep(15000);
    }

    @Test (priority = 2)
    public void addToCart() throws InterruptedException {
        //12 click on add to cart to select the item of interest
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/section/section/section/ul/li[2]/div/div/div[2]/form/div[3]/button")).click();
        Thread.sleep(15000);
        //13.click on my cart button
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/a[2]")).click();
        Thread.sleep(10000);
        //14 click on checkout button
        driver.findElement(By.xpath(" //*[@id=\"app-content-wrapper\"]/div[3]/section/section/aside/div[3]/div/div[2]/button")).click();
        Thread.sleep(8000);
    }

    @Test (priority = 3)
    public void DeliveryOption() throws InterruptedException {
        //15. click on change
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[1]/div/div/div[1]/div[2]/div/button")).click();
        Thread.sleep(5000);
        //17. click on add delivery address
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[1]/div/div/div[2]/div[1]/div[2]/div[1]/div/button")).click();
        Thread.sleep(5000);
        //18. select address
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/section/section/aside/div[2]/div/div/div[2]/div[2]/form/button")).click();
        Thread.sleep(5000);
        //19. click on use this address
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/section/section/aside/div[3]/div/div/div/a")).click();
        Thread.sleep(5000);
    }

    @Test (priority = 4 )
    public void selectPaymentOption() throws InterruptedException {
        //20 click on paynow
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[2]/div/div[2]/div[1]/div[1]/span/input")).click();
        Thread.sleep(5000);
        //21. click on continue payment
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[2]/div/div[2]/div[3]/div[2]/div/button")).click();
        Thread.sleep(5000);
    }

    @Test (priority = 5)
    public void SelectPaymentMethod() throws InterruptedException {
        //22. locate iframe element
        WebElement iFrame = driver.findElement(By.tagName("iframe"));
        Thread.sleep(5000);
        //23. switch focus to iFrame
        driver.switchTo().frame("kpg-frame-component");
        Thread.sleep(5000);
        //click on the card button the iframe
        WebElement cardbutton = driver.findElement(By.className("Card"));
        // click on card
        cardbutton.click();
        Thread.sleep(5000);
        //click card number filed
        WebElement cardnumber = driver.findElement(By.id("card-number"));
        // input card number
        cardnumber.sendKeys("503670930786676");
        Thread.sleep(5000);
        //click on date field
        WebElement datebutton = driver.findElement(By.id("expiry"));
        Thread.sleep(5000);
        //input date
        datebutton.sendKeys("06/23");
        Thread.sleep(5000);
        //click on cvv field
        WebElement cvvbutton = driver.findElement(By.id("cvv"));
        Thread.sleep(5000);
        //input cvv number
        cvvbutton.sendKeys("456");
        Thread.sleep(5000);
        //print the error message
        WebElement errormessage = driver.findElement(By.id("card-number_unhappy"));
        System.out.println(errormessage.getText());
        Thread.sleep(5000);
        //close iframe
        WebElement closeiframe = driver.findElement(By.className("data-card__close"));
        closeiframe.click();
        Thread.sleep(5000);
        //switch out of iframe
        driver.switchTo().defaultContent();
        Thread.sleep(5000);
    }


    @AfterTest
    public void closebrowser() {
        //close browser
        driver.quit();
    }
}
