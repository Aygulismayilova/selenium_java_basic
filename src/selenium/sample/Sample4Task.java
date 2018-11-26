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
        WebElement numberArea = driver.findElement(By.id("number"));
        WebElement numberText = driver.findElement(By.id("result_number"));
        WebElement resultButton = driver.findElement(By.id("result_button_number"));
        WebElement clearResultButton = driver.findElement(By.id("clear_result_button_number"));
        String originalNumber = "5";
        String newNumberOne = "20";

        assertEquals(numberArea.getAttribute("value"), originalNumber);

        numberArea.clear();
        assertEquals(numberArea.getText(), "");
        //enter a number under "Number"
        numberArea.sendKeys("20");
        assertEquals(numberArea.getAttribute("value"), newNumberOne);
        //check that button is not clickable "Clear Result"
        assertFalse(clearResultButton.isEnabled());
        //check that text is not displayed
        assertFalse(numberText.isDisplayed());
        //click on "Result" button
        resultButton.click();
        //check that text is displayed
        assertTrue(numberText.isDisplayed());
        //check that the correct Text appears ("You entered number: "NUMBER YOU ENTERED"")
        assertEquals("You entered number: \"20\"", numberText.getText());
        //check that the button "Clear Result" is clickable now
        assertTrue(clearResultButton.isEnabled());
        //click on "Clear Result"
        clearResultButton.click();
        //check that the text is still (""), but it is not displayed
        assertEquals("", numberText.getText());
        assertFalse(numberText.isDisplayed());
    }

//    @Test
//    public void enterNumber() throws Exception {
//        enter a number under "Number"
//        check that button is not clickable "Clear Result"
//        check that text is not displayed
//        click on "Result" button
//        check that text is displayed
//        check that the correct Text appears ("You entered number: "NUMBER YOU ENTERED"")
//        check that the button "Clear Result" is clickable now
//        click on "Clear Result"
//        check that the text is still (""), but it is not displayed
//    }

    @Test
    public void clickOnLink() throws Exception {
//         TODO:
//        check current url is base_url
        assertEquals(base_url, driver.getCurrentUrl());
//        click on "This is a link to Homepage"
        driver.findElement(By.id("homepage_link")).click();
//        check that current url is not base_url
        assertFalse(driver.getCurrentUrl().equals(base_url));
//        verify that current url is homepage
        assertEquals("https://kristinek.github.io/site/", driver.getCurrentUrl());
    }
}
