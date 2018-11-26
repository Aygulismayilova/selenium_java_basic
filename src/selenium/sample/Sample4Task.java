package selenium.sample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.*;

public class Sample4Task {
    WebDriver driver;
    String base_url = "https://kristinek.github.io/site/examples/actions";

    // method which is being run before each test
    @Before
    public void startingTests() throws Exception {
        // from Sample 1:
        String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver.exe");
        // declaration above:
        driver = new ChromeDriver();
        //open page:
        driver.get(base_url);
    }

    // method which is being run after each test
    @After
    public void endingTests() throws Exception {
        driver.close();
    }

    @Test
    public void enterNumberWithInt() throws Exception {
//         TODO:

        WebElement numberInput = driver.findElement(By.id("number"));
        WebElement resultButton = driver.findElement(By.id("result_button_number"));
        WebElement clearResultButton = driver.findElement(By.id("clear_result_button_number"));
        WebElement text  = driver.findElement(By.id("result_number"));
        String originalTextInnumberArea = "5";
        String newTNumbertOne = "56";



        assertFalse(text.isDisplayed());
        assertTrue(resultButton.isEnabled());
        assertFalse(clearResultButton.isEnabled());

        resultButton.click();

        assertTrue(text.isDisplayed());
        assertEquals(text.getText() , "You entered number: \"5\"");
        assertEquals("5", originalTextInnumberArea);
        assertTrue(resultButton.isEnabled());
        assertTrue(clearResultButton.isEnabled());

        clearResultButton.click();

        assertFalse(text.isDisplayed());
        numberInput.sendKeys(newTNumbertOne);
        assertEquals(numberInput.getAttribute("value"),newTNumbertOne + originalTextInnumberArea);

        resultButton.click();
        assertEquals(text.getText() , "You entered number: \"565\"");


        numberInput.clear();

        assertEquals(numberInput.getAttribute("value"), "");


        clearResultButton.click();

        assertFalse(text.isDisplayed());
        assertTrue(resultButton.isEnabled());
        assertFalse(clearResultButton.isEnabled());





//        enter a number under "Number"
//        check that button is not clickable "Clear Result"
//        check that text is not displayed
//        click on "Result" button
//        check that text is displayed
//        check that the correct Text appears ("You entered number: "NUMBER YOU ENTERED"")
//        check that the button "Clear Result" is clickable now
//        click on "Clear Result"
//        check that the text is still (""), but it is not displayed
    }

    @Test
    public void enterNumber() throws Exception {
//         TODO:
//        enter a number under "Number"
//        check that button is not clickable "Clear Result"
//        check that text is not displayed
//        click on "Result" button
//        check that text is displayed
//        check that the correct Text appears ("You entered number: "NUMBER YOU ENTERED"")
//        check that the button "Clear Result" is clickable now
//        click on "Clear Result"
//        check that the text is still (""), but it is not displayed
    }

    @Test
    public void clickOnLink() throws Exception {
//         TODO:
        assertEquals(base_url, driver.getCurrentUrl());
//        check current url is base_url
        driver.findElement(By.id("homepage_link")).click();
//        click on "This is a link to Homepage"
        assertFalse(driver.getCurrentUrl().equals(base_url));
//        check that current url is not base_url
        assertEquals("https://kristinek.github.io/site/", driver.getCurrentUrl());
//        verify that current url is homepage
    }
}
