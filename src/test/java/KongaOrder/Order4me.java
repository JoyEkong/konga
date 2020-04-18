package KongaOrder;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ISelect;

import java.util.concurrent.TimeUnit;

public class Order4me {
    private WebDriver driver;


    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        //maximize the chromedriver
        driver.manage().window().maximize();
        driver.get("https://www.konga.com/");
        Thread.sleep(7000);

        System.out.println(driver.getTitle());
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(By.linkText("Login / Signup")).click();
        driver.findElement(By.name("username")).sendKeys("joyekong123@gmail.com");
        driver.findElement(By.id("password")).sendKeys("081joyekong4540");
        driver.findElement(By.xpath("//button[text()='Login']")).click();

        WebElement electronics = driver.findElement(By.linkText("Electronics"));

        Actions mouseover = new Actions(driver);

        mouseover.moveToElement(electronics).build().perform();
        driver.findElement(By.linkText("Digital Cameras")).click();
        //Thread.sleep(3000);
        // type item to be searched for
        driver.findElement(By.xpath("//form[@class='f6ed2_25oVd']//input[@id='jsSearchInput']")).sendKeys("Headset");
        // click on search button
        driver.findElement(By.cssSelector(".f6ed2_25oVd #jsSearchInput")).sendKeys(Keys.ENTER);
        Thread.sleep(3000);

        // add item to cart
        //driver.findElement(By.cssSelector("div.ais-InstantSearch__root section.d6575_J-kZm._1eecb_eqPMu div.c6dfe_HidJc:nth-child(5) section._0863a_3x99A main._050ef_K0hT7 section._9cac3_2I9l4:nth-child(3) section.fc90c_2fTuR section._06822_e7mpG section._588b5_3MtNs ul.b49ee_2pjyI._58c31_2R34y._22339_3gQb9 li.bbe45_3oExY._22339_3gQb9:nth-child(1) div.a2cf5_2S5q5.cf5dc_3HhOq div._4941f_1HCZm form:nth-child(2) div._2aac2_3bwnD._549f7_zvZ8u._49c0c_3Cv2D._977c5_2vBMq:nth-child(10) > button._0a08a_3czMG")).click();

        //add to cart
        try {
            WebElement addItem =  driver.findElement(By.cssSelector("#mainContent > section._9cac3_2I9l4 > section > section > section > section > ul > li:nth-child(1) > div > div > div._4941f_1HCZm > form > div._2aac2_3bwnD._549f7_zvZ8u._49c0c_3Cv2D._977c5_2vBMq > button"));
            addItem.click();
            //b49ee_2pjyI
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex)
        {
            WebElement addItem =  driver.findElement(By.cssSelector("#mainContent > section._9cac3_2I9l4 > section > section > section > section > ul > li:nth-child(1) > div > div > div._4941f_1HCZm > form > div._2aac2_3bwnD._549f7_zvZ8u._49c0c_3Cv2D._977c5_2vBMq > button"));
            addItem.click();
        }

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        // click on my cart
        driver.findElement(By.className("fccb0_2PhkY")).click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // increase number of items in cart to four
        driver.findElement(By.name("increment")).click();
        driver.findElement(By.name("increment")).click();
        driver.findElement(By.name("increment")).click();
        driver.findElement(By.xpath("//button[text()='Checkout']")).click();
        // proceed to make payment
        driver.findElement(By.name("selectPaymentMethod")).click();
        // continue to payment
        driver.findElement(By.name("placeOrder")).click();

        WebElement myframe = driver.findElement(By.xpath("//iframe[@id='kpg-frame-component']"));
        driver.switchTo().frame(myframe);

        // click on payment method
        driver.findElement(By.xpath("//span[text()='Make payments with your credit or debit card.']")).click();

        // click on add card pin
        driver.findElement(By.id("card-number")).sendKeys("5399012349089785");
        // input date
        driver.findElement(By.id("expiry")).sendKeys("0622");
        // type cvv number
        driver.findElement(By.id("cvv")).sendKeys("123");
        // click on pin field
        driver.findElement(By.xpath("(//button[text()='9'])[1]")).click();

        System.out.println(driver.findElement(By.id("card-number_unhappy")).getText());

    }

    public static void main(String args[]) throws InterruptedException {
        Order4me Order = new Order4me();
        Order.setUp();


    }
}
