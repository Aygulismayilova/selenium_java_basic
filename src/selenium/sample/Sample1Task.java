package selenium.sample;


import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sample1Task {
    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";

    @Test
    public void goToHomepage() throws Exception {
//         TODO:
//         define driver
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //driver.get("https://google.com");
        driver.get( "https://kristinek.github.io/site/index2.html");
        System.out.println(driver.findElement(By.id("h1")).getText());
//         go to https://kristinek.github.io/site/index2.html
//         get title of page
        System.out.println(driver.getTitle());
//         get URL of current page
        System.out.println(driver.getCurrentUrl());
        Thread.sleep(10000);

//         close browser
        driver.close();
    }
}
