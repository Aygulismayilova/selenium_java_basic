package selenium.sample;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static jdk.nashorn.internal.objects.NativeString.toLowerCase;
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
        int expected = 5;
        int actual = driver.findElements(By.className("test")).size();
//         check how many element with class "test" there are on page (5)
//         check that value of second button is "This is also a button"
        assertEquals("There is not the same text",expected, actual);

    }

    @Test
    public void assertTrueTask() throws Exception {
//         TODO:
        String expectedstr = "this is also a button";
        String actualstr = (driver.findElement(By.name("randomButton2")).getAttribute("value"));
        assertEquals("Here is error message",expectedstr, actualstr.toLowerCase());
//         check that it is True that value of second button is
//         "this is Also a Button" if you ignore Caps Locks
//         fail with custom error message:
    }

    @Test
    public void assertFalseTask() throws Exception {
//         TODO:
        String element = driver.findElement(By.id("ButtonID")).getAttribute("value");
        assertFalse(element.equals("This is a button"));

//        check that it is False that value of second button is "This is a button"
    }

    @Test
    public void failTask() throws Exception {
//        TODO:
        List<WebElement> elements = driver.findElements(By.className("test"));
            for (WebElement elem : elements){
                assertTrue(!elem.getText().contains("190"));
            }
//        check that none of items with class "test"
//        contain number 190
    }
}
