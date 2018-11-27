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
        System.out.println("xPath:");
//        1-2 ways to find text: "Heading 2 text"
        System.out.println("Heading 2 text xPath way 1: " + driver.findElement(By.xpath("//*[@id='heading_2']")).getText());
        System.out.println("Heading 2 text xPath way 2: " + driver.findElement(By.xpath("//body//h2[@id='heading_2']")).getText());
//        1-2 ways to find text: "Test Text 1"
        System.out.println("Test Text 1 xPath way 1: " + driver.findElement(By.xpath("//p[@class='test']")).getText());
        System.out.println("Test Text 1 xPath way 2: " + driver.findElement(By.xpath("//div[@id='test1']/p")).getText());
//        1-2 ways to find text: "Test Text 2"
        System.out.println("Test Text 2 xPath way 1: " + driver.findElement(By.xpath("//p[@class='twoTest']")).getText());
        System.out.println("Test Text 2 xPath way 2: " + driver.findElement(By.xpath("//div[@id='test1']/p[2]")).getText());
//        1-2 ways to find text: "Test Text 3"
        System.out.println("Test Text 3 xPath way 1: " + driver.findElement(By.xpath("//div[@id='test3']/p[1]")).getText());
        System.out.println("Test Text 3 xPath way 2: " + driver.findElement(By.xpath("//div[@id='test3']/p[@class='test'][1]")).getText());
//        1-2 ways to find text: "Test Text 4"
        System.out.println("Test Text 4 xPath way 1: " + driver.findElement(By.xpath("//div[@id='test3']/p[2]")).getText());
        System.out.println("Test Text 3 xPath way 2: " + driver.findElement(By.xpath("//div[@id='test3']/p[@class='test'][2]")).getText());
//        1-2 ways to find text: "Test Text 5"
        System.out.println("Test Text 5 xPath way 1: " + driver.findElement(By.xpath("//div[@id='test2']/p[1]")).getText());
        System.out.println("Test Text 5 xPath way 2: " + driver.findElement(By.xpath("//p[@class='Test']")).getText());
//        1-2 ways to find text: "This is also a button"
        System.out.println("This is also a button xPath way 1: " + driver.findElement(By.xpath("//*[@name='randomButton2']")).getAttribute("value"));
        System.out.println("This is also a button xPath way 2: " +
                driver.findElement(By.xpath("//*[@id='buttonId' and @name='randomButton2']")).getAttribute("value"));
    }

    @Test
    public void findElementByCssName() throws Exception {
//         TODO:
        System.out.println("Css:");
//        1-2 ways to find text: "Heading 2 text"
        System.out.println("Heading 2 text Css way 1: " + driver.findElement(By.cssSelector("#heading_2")).getText());
        System.out.println("Heading 2 text Css way 2: " + driver.findElement(By.cssSelector("[id='heading_2'")).getText());
//        1-2 ways to find text: "Test Text 1"
        System.out.println("Test Text 1 Css way 1: " + driver.findElement(By.cssSelector("[class='test'")).getText());
        System.out.println("Test Text 1 Css way 2: " + driver.findElement(By.cssSelector(".test:nth-child(1)")).getText());
//        1-2 ways to find text: "Test Text 2"
        System.out.println("Test Text 2 Css way 1: " + driver.findElement(By.cssSelector(".twoTest")).getText());
        System.out.println("Test Text 2 Css way 2: " + driver.findElement(By.cssSelector("[class='twoTest']")).getText());
//        1-2 ways to find text: "Test Text 3"
        System.out.println("Test Text 3 Css way 1: " + driver.findElement(By.cssSelector("div#test3 .test:nth-child(1)")).getText());
        System.out.println("Test Text 3 Css way 2: " + driver.findElement(By.cssSelector("div#test3 [class='test']")).getText());
//        1-2 ways to find text: "This is also a button"
        System.out.println("This is also a button Css way 1: " + driver.findElement(By.cssSelector("[name='randomButton2']")).getAttribute("value"));
        System.out.println("This is also a button Css way 2: " +
                driver.findElement(By.cssSelector("[value='This is also a button']")).getAttribute("value"));
    }
}
