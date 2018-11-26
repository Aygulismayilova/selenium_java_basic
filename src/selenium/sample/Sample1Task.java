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
//         go to https://kristinek.github.io/site/index2.html
//         get title of page
//         get URL of current page
//         close browser

        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //open test homepage
        driver.get("https://google.com");
        driver.get("https://kristinek.github.io/site/index2.html");

        //get title of page
        System.out.println(driver.getTitle());

        //get URL of current page
        System.out.println(driver.getCurrentUrl());

        //Sleep for 10 seconds
        Thread.sleep(10000);

        //Close browser
        driver.close();
    }
}
