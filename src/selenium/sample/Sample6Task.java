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
    public void startingTests() throws Exception {
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
    public void endingTests() throws Exception {
        driver.close();
    }

    @Test
    public void findElementByXPath() throws Exception {
//         TODO:
//        1-2 ways to find text: "Heading 2 text"
//        1-2 ways to find text: "Test Text 1"
//        1-2 ways to find text: "Test Text 2"
//        1-2 ways to find text: "Test Text 3"
//        1-2 ways to find text: "Test Text 4"
//        1-2 ways to find text: "Test Text 5"
//        1-2 ways to find text: "This is also a button"
        System.out.println("Find elements using xPath:");
        System.out.println("----------------------------------");
        System.out.println(driver.findElement(By.xpath("//*[@id='heading_2']")).getText());
        System.out.println(driver.findElement(By.xpath("//h2[2]")).getText());
        System.out.println("----------------------------------");
        System.out.println(driver.findElement(By.xpath("//*[@class='test']")).getText());
        System.out.println(driver.findElement(By.xpath("//*[contains(text(), 'Test')]")).getText());
        System.out.println("----------------------------------");
        System.out.println(driver.findElement(By.xpath("//*[@id='test1']")).getText());
        System.out.println("----------------------------------");
        System.out.println(driver.findElement(By.xpath("//*[@id='test3']")).getText());
        System.out.println("----------------------------------");
        System.out.println(driver.findElement(By.xpath("//*[@class='Test']")).getText());
        System.out.println(driver.findElement(By.xpath("//*[@id='test2']/p")).getText());
        System.out.println("----------------------------------");
        System.out.println(driver.findElement(By.xpath("//*[@name='randomButton2']")).getAttribute("value"));

    }

    @Test
    public void findElementByCssName() throws Exception {
//         TODO:
//        1-2 ways to find text: "Heading 2 text"
//        1-2 ways to find text: "Test Text 1"
//        1-2 ways to find text: "Test Text 2"
//        1-2 ways to find text: "Test Text 3"
//        1-2 ways to find text: "This is also a button"
        System.out.println("Find element by 1 of nth class using CSS:");
        System.out.println("----------------------------------");
        System.out.println(driver.findElement(By.cssSelector("#heading_2")).getText());
        System.out.println(driver.findElement(By.cssSelector("h2:nth-of-type(2)")).getText());
        System.out.println("----------------------------------");
        System.out.println(driver.findElement(By.cssSelector(".test")).getText());
        System.out.println("----------------------------------");
        System.out.println(driver.findElement(By.cssSelector("#test1")).getText());
        System.out.println("----------------------------------");
        System.out.println(driver.findElement(By.cssSelector(".twoTest")).getText());
        System.out.println("----------------------------------");
        System.out.println(driver.findElement(By.cssSelector("#test3 p:nth-child(1)")).getText());
        System.out.println("----------------------------------");
        System.out.println(driver.findElement(By.cssSelector("input:nth-of-type(2)")).getAttribute("value") );
        System.out.println(driver.findElement(By.cssSelector("#buttonId")).getAttribute("value"));


    }
}
