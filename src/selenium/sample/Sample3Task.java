package selenium.sample;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

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
        int expecetedElements = 5;
        int actualElements = driver.findElements(By.className("test")).size();
        assertEquals(expecetedElements,actualElements);

//         check that value of second button is "This is also a button"
        String expectedElementsString = "This is also a button";
        String actualElementString = driver.findElement(By.name("randomButton2")).getAttribute("value");
        assertEquals(expectedElementsString,actualElementString);
    }

    @Test
    public void assertTrueTask() throws Exception {
//         TODO:
        String elementTextOnPage = driver.findElement(By.name("randomButton2")).getAttribute("value");
        Assert.assertTrue(elementTextOnPage.equals("this is Also a Button"));
        Assert.assertTrue("Expecting the element with class 'randomButton2' to have text 'this is Also a Button'", elementTextOnPage.contains("this is Also a Button"));
        Assert.assertTrue(elementTextOnPage.equalsIgnoreCase("this is AlsO a BUTton"));
        //         check that it is True that value of second button is
//         "this is Also a Button" if you ignore Caps Locks
//         fail with custom error message:
        Assert.assertTrue(true);
        fail("Custom error message");
    }

    @Test
    public void assertFalseTask() throws Exception {
//         TODO:
//        check that it is False that value of second button is "This is a button"
        String elementTextOnPage = driver.findElement(By.name("randomButton2")).getAttribute("value");
        assertFalse(!elementTextOnPage.equals("this is Also a Button"));
        assertFalse(elementTextOnPage.equals("This is a button"));
        assertFalse(elementTextOnPage.contains("This is a button"));
        assertFalse(false);

    }

    @Test
    public void failTask() throws Exception {
//        TODO:
//        check that none of items with class "test"
//        contain number 190
    }
}
