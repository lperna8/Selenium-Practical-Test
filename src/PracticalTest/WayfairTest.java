package PracticalTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WayfairTest {
    String RatingofBook;
    String TotalAmount;
    /*@BeforeClass
    public void setDriver(){*/
    WebDriver driver;
    //}

    @BeforeClass
    public void setUp()
    {
        System.setProperty("webdriver.chrome.driver", "/Users/lperna/Downloads/Drivers/New/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://www.wayfair.com/");

    }


    @Test(priority = 1)
    public void furniture() {

        System.out.println("This is the first test case");


        driver.findElement(By.xpath("//a[@class='DepartmentItem-link' and contains(text(),'Furniture')]")).click();
        //driver.findElement(By.xpath("//a[@class='CategoryCarousel-imageTitle' and contains(text(),'Sectional')]")).click();

    }

    @Test(priority = 2)
    public void sectionals() {
        System.out.println("This is the second test case");
        driver.findElement(By.xpath("//p[@class='CategoryCarousel-imageTitle' and contains(text(),'Sectional')]")).click();

    }

    @Test(priority = 3)
    public void item12() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        RatingofBook = driver.findElement(By.xpath("//a[@data-click-location='product12']//p[@class='pl-VisuallyHidden']")).getAttribute("innerText");
        System.out.println(RatingofBook);
        driver.findElement(By.xpath("//a[@data-click-location='product12']//*[@class='ProductCard-name']")).click();
    }

    @Test(priority = 4)
    public void cart()
    {

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String ParentTab=driver.getWindowHandle();
        System.out.println(driver.getTitle());

        for (String ChildTab:driver.getWindowHandles())
        {
            driver.switchTo().window(ChildTab);
            System.out.println("Switched to Child Tab: "+driver.getTitle());
        }
        driver.findElement(By.xpath("//button[@id='btn-add-to-cart']")).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//a[@data-enzyme-id='continueToCartCta']")).click();
    }
    @Test (priority = 5)
    public void Total()
    {
        TotalAmount = driver.findElement(By.xpath("//span[@class='BasketTotalHeader-price']")).getAttribute("innerText");
        System.out.println(TotalAmount);
    }
}
