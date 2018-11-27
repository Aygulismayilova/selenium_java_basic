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
        driver.get("https://kristinek.github.io/site/examples/loc");
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
        System.out.println("\t text of element with id 'heading_2' is '" +
                driver.findElement(By.xpath("//*[@id='heading_2']")).getText() + "'");
        System.out.println("\t text of element with id 'heading_2' is '" +
                driver.findElement(By.xpath("//h2[@id='heading_2']")).getText() + "'");
        //        1-2 ways to find text: "Test Text 1"
        System.out.println("\t text of element with class 'test' is '"
                + driver.findElement(By.xpath("//*[@class='test']")).getText() + "' ");
//        1-2 ways to find text: "Test Text 2"
        System.out.println("\t text of element with class 'twoTest' is '"
                + driver.findElement(By.xpath("//*[@class='twoTest']")).getText() + "' ");
//        1-2 ways to find text: "Test Text 3"
        System.out.println("\t text of element with id 'test3' direct child is '"
                + driver.findElement(By.xpath("//*[@id='test3']/p")).getText() + "' ");
//        1-2 ways to find text: "Test Text 4"
        System.out.println("\t text of element with id 'test3' second child is '"
                + driver.findElement(By.xpath("//*[@id='test3']/p[2]")).getText() + "' ");
        // //*[@id='test3']/p[@class='test'][2]
//        1-2 ways to find text: "Test Text 5"
        System.out.println("\t text of element with id 'test2' first child is '"
                + driver.findElement(By.xpath("//*[@id='test2']/p")).getText() + "' ");
//        1-2 ways to find text: "This is also a button"
        System.out.println("\t text of element with id 'buttonId' is '"
                + driver.findElement(By.xpath("//*[@id='buttonId']")).getAttribute("value") + "' ");
        System.out.println("\t text of element with value 'This is also a button' is '"
                + driver.findElement(By.xpath("//*[@value='This is also a button']")).getAttribute("value") + "' ");

    }

    @Test
    public void findElementByCssName() throws Exception {
//         TODO:
//        1-2 ways to find text: "Heading 2 text"
        System.out.println("\t text of element with id 'heading_2' is '" +
                driver.findElement(By.cssSelector("#heading_2")).getText() + "'");
//        1-2 ways to find text: "Test Text 1"
        System.out.println("\t text of element with id 'test1' and class 'test' is '"
                + driver.findElement(By.cssSelector("#test1 .test")).getText() + "' ");
//        1-2 ways to find text: "Test Text 2"
        System.out.println("\t text of element with class 'twoTest' is '"
                + driver.findElement(By.cssSelector(".twoTest")).getText() + "' ");
        //#test3 >p:nth-child(2)
//        1-2 ways to find text: "Test Text 3"
        System.out.println("\t text of element with id 'test3' direct child is '"
                + driver.findElement(By.cssSelector("#test3>p")).getText() + "' ");
//        1-2 ways to find text: "This is also a button"
        System.out.println("\t text of element with id 'buttonId' is '"
                + driver.findElement(By.cssSelector("#buttonId")).getAttribute("value") + "' ");
        System.out.println("\t text of element with value 'This is also a button' is '"
                + driver.findElement(By.cssSelector("[value='This is also a button']")).getAttribute("value") + "' ");
        // input:nth-child(10)

    }
}
