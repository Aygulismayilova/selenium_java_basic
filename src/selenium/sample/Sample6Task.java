package selenium.sample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sample6Task {
    WebDriver driver;

    // method which is being run before each test
    @Before
    public void startingTests() {
        // from Sample 1:
        String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver.exe");
        // declaration above:
        driver = new ChromeDriver();
        //open page:
        driver.get("https://kristinek.github.io/site/examples/locators");
    }

    // method which is being run after each test
    @After
    public void endingTests() {
        driver.close();
    }

    @Test
    public void findElementByXPath() {
//         TODO:
//        1-2 ways to find text: "Heading 2 text"
        System.out.println("\t class of element with text 'Heading 2 text' is '" +
          driver.findElement(By.xpath("//*[@id='heading_2']")).getText());
//        1-2 ways to find text: "Test Text 1"
        System.out.println("\t class of element with text 'p[1]' is '" +
          driver.findElement(By.xpath("//*[@class='test']")).getText());
//        1-2 ways to find text: "Test Text 2"
        System.out.println("\t class of element with text 'p[2]' is '" +
          driver.findElement(By.xpath("//*[@id='test1']/p[2]")).getText());
//        1-2 ways to find text: "Test Text 3"
        System.out.println("\t class of element with text 'p[3]' is '" +
          driver.findElement(By.xpath("//*[@class='twoTest']")).getText());
//        1-2 ways to find text: "Test Text 4"
        System.out.println("\t class of element with text 'p[4]' is '" +
                driver.findElement(By.xpath("@id='test3']/p[2]")).getText());
//        1-2 ways to find text: "Test Text 5"
        System.out.println("\t class of element with text 'p[5]' is '" +
          driver.findElement(By.xpath("//*[@id='test2']/p[1]")).getText());
//        1-2 ways to find text: "This is also a button"
        System.out.println("\t class of element with text 'buttonId' is '" +
          driver.findElement(By.xpath("//*[@id='buttonId']")).getAttribute("value"));
    }

    @Test
    public void findElementByCssName() {
//         TODO:
//        1-2 ways to find text: "Heading 2 text"
            System.out.println("\t text of element with id 'heading_1' is '" +
           driver.findElement(By.cssSelector("#Heading_2")).getText());
//        1-2 ways to find text: "Test Text 1"
        System.out.println("\t text of element with class 'Test Text 1' is '" +
                driver.findElement(By.cssSelector(".test")).getText());
//        1-2 ways to find text: "Test Text 2"
        System.out.println("\t text of element with class 'Test Text 2' is '" +
                driver.findElement(By.cssSelector(".twoTest")).getText());
//        1-2 ways to find text: "Test Text 3"
        System.out.println("\t text of element with class 'Test Text 3' is '" +
                driver.findElement(By.cssSelector("#test3 > p:nth-child(1)")).getText());
//        1-2 ways to find text: "This is also a button"
        System.out.println("\t text of element with id 'button1' is '" +
                driver.findElement(By.cssSelector("#button1")).getText());
    }
}
