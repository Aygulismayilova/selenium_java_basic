package selenium.sample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.Assert.*;

public class Sample3Task {
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
    public void assertEqualsTask() throws Exception {
//         TODO:
//         check how many element with class "test" there are on page (5)
//         check that value of second button is "This is also a button"
        int expectedNumberOfElements = 5;
        int actualNumberOfElements = driver.findElements(By.className("test")).size();
        assertEquals(expectedNumberOfElements, actualNumberOfElements);

        String expected = "This is also a button";
        String actual = driver.findElement(By.id("buttonId")).getAttribute("value");

        assertEquals(expected, actual);
    }

    @Test
    public void assertTrueTask() throws Exception {
//         TODO:
//         check that it is True that value of second button is
//         "this is Also a Button" if you ignore Caps Locks
//         fail with custom error message:
        String elementTextOnPage = driver.findElement(By.name("randomButton2")).getAttribute("value");

        assertTrue("Custom message", elementTextOnPage.equalsIgnoreCase("this is Also a Button"));

        assertTrue(true);

    }

    @Test
    public void assertFalseTask() throws Exception {
//         TODO:
//        check that it is False that value of second button is "This is a button"
        String elementTextOnPage = driver.findElement(By.name("randomButton2")).getAttribute("value");
        assertFalse(elementTextOnPage.equals("This is a button"));

        assertFalse(false);
    }

    @Test
    public void failTask() throws Exception {
//        TODO:
//        check that none of items with class "test"
//        contain number 190
        List<WebElement> elements = driver.findElements(By.className("test"));
        //   boolean exist = elements.stream().anyMatch(s -> s.getText().contains("4"));
        //  assertTrue(exist);
    for (WebElement elem : elements) {
          assertTrue(!elem.getText().contains("190"));
     //     assertTrue("Expecting " + elem.getText() + " to not have 4", !elem.getText().contains("4"));
       }
    }
}
