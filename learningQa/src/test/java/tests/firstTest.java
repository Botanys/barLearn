package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class firstTest {

private WebDriver driver;
private WebDriverWait wait;

@Before
    public void start(){
    driver = new ChromeDriver();
    wait = new WebDriverWait(driver, 10);
    driver.manage().window().fullscreen();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);;

}

    @Test
    public void test() {
        driver.get("https://www.google.com.ua");

        WebElement q = driver.findElement(By.xpath("//div/input[@id='lst-ib']"));
        q.sendKeys("youtube");
        driver.findElement(By.xpath("//div/center/input[@value='Поиск в Google']")).click();
        wait.until(titleIs("youtube фильмы - Поиск в Google"));


    }

    @After
       public void stop(){

        driver.quit();
        driver = null;



        }



}


