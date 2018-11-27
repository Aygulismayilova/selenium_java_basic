package selenium.sample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Sample7Task {
    WebDriver driver;
    String base_url = "https://kristinek.github.io/site/examples/act";

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
    public void selectCheckBox() throws Exception {
//         TODO:
//        check that none of the checkboxes are ticked
//        tick  "Option 2"
//        check that "Option 1" and "Option 3" are not ticked, but "Option 2" is ticked
//        tick  "Option 3"
//        click result
//        check that text 'You selected value(s): Option 2, Option 3' is being displayed

        List<WebElement> checkBoxes = driver.findElements(By.cssSelector(".w3-check[type='checkbox']"));

        for (WebElement checkBox : checkBoxes) {
            assertFalse(checkBox.isSelected());
            checkBox.click();
            assertTrue(checkBox.isSelected());
            checkBox.click();
            assertFalse(checkBox.isSelected());
        }

       // driver.findElement(By.cssSelector(".w3-check[value='Option 2']")).click();
        WebElement option1 = driver.findElement(By.cssSelector("#vfb-6-0"));
        WebElement option2 = driver.findElement(By.cssSelector("#vfb-6-1"));
        WebElement option3 = driver.findElement(By.cssSelector("#vfb-6-2"));
        assertFalse(option2.isSelected());
        option2.click();
        assertTrue(option2.isSelected());

        assertFalse(option1.isSelected());
        assertFalse(option3.isSelected());

        option3.click();
        assertTrue(option3.isSelected());

        WebElement button = driver.findElement(By.id("result_button_checkbox"));
        WebElement text = driver.findElement(By.id("result_checkbox"));

        assertFalse(text.isDisplayed());
        assertTrue(button.isEnabled());

        button.click();

        assertTrue("You selected value(s): Option 2, Option 3", text.isDisplayed());


    }


    @Test
    public void selectRadioButton() throws Exception {
//         TODO:
//        check that none of the radio are selected
//        select  "Option 3"
//        check that "Option 1" and "Option 2' are not select, but "Option 3" is selected
//        select  "Option 1"
//        check that "Option 2" and "Option 3' are not select, but "Option 1" is selected
//        click result
//        check that 'You selected option: Option 1' text is being displayed

        List<WebElement> radioButtons = driver.findElements(By.cssSelector(".w3-check[type='radio']"));

        for (WebElement radioButton : radioButtons) {
            assertFalse(radioButton.isSelected());
        }

        //   radioButtons.get(2).click();
        //   assertFalse(radioButtons.get(0).isSelected());
        //   assertFalse(radioButtons.get(1).isSelected());
        //   assertTrue(radioButtons.get(2).isSelected());

            WebElement option1 = driver.findElement(By.id("vfb-7-1"));
            WebElement option2 = driver.findElement(By.id("vfb-7-2"));
            WebElement option3 = driver.findElement(By.id("vfb-7-3"));

            option3.click();
            assertTrue(option3.isSelected());

            assertFalse(option1.isSelected());
            assertFalse(option2.isSelected());

            option1.click();
            assertTrue(option1.isSelected());

            assertFalse(option2.isSelected());
            assertFalse(option3.isSelected());

            WebElement button = driver.findElement(By.id("result_button_ratio"));
            WebElement text = driver.findElement(By.id("result_radio"));

            assertFalse(text.isDisplayed());
            assertTrue(button.isEnabled());

            button.click();

            assertTrue("You selected option: Option 1", text.isDisplayed());

    }

    @Test
    public void selectOption() throws Exception {
//         TODO:
//        select "Option 3" in Select
//        check that selected option is "Option 3"
//        select "Option 2" in Select
//        check that selected option is "Option 2"
//        click result
//        check that 'You selected option: Option 2' text is being displayed

        Select dropdown = new Select(driver.findElement(By.id("vfb-12")));
        assertEquals("Choose your option", dropdown.getFirstSelectedOption().getText());
        dropdown.selectByVisibleText("Option 3");
        assertEquals("Option 3", dropdown.getFirstSelectedOption().getText());

        dropdown.selectByVisibleText("Option 2");
        assertEquals("Option 2", dropdown.getFirstSelectedOption().getText());

        WebElement button = driver.findElement(By.id("result_button_select"));
        WebElement text = driver.findElement(By.id("result_select"));

        assertFalse(text.isDisplayed());
        assertTrue(button.isEnabled());

        button.click();

        assertTrue("You selected option: Option 2", text.isDisplayed());
    }

    @Test
    public void chooseDateViaCalendarBonus() throws Exception {
//         TODO:
//        enter date '4 of July 2007' using calendar widget
//        check that correct date is added

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -4);
        cal.add(Calendar.DAY_OF_MONTH, -23);
        cal.add(Calendar.YEAR, -11);
        String result = new SimpleDateFormat("MM/dd/YYYY").format(cal.getTime());

        System.out.println(result);

        WebElement dateBox = driver.findElement(By.id("vfb-8"));
        assertEquals("", dateBox.getAttribute("value"));

        dateBox.click();
        WebElement dateWidget = driver.findElement(By.id("ui-datepicker-div"));
        WebElement year = driver.findElement(By.className("ui-datepicker-year"));

        for (int i = 0; i < 136; i++) {
            dateWidget.findElement(By.className("ui-datepicker-prev")).click();

        }

        dateWidget.findElement(By.xpath("//a[text()='4']")).click();

        assertEquals(result, dateBox.getAttribute("value"));
        dateBox.clear();
    }


    @Test
    public void chooseDateViaTextBoxBonus() throws Exception {
//         TODO:
//        enter date '2 of May 1959' using text
//        check that correct date is added
        String dateToEnter = "02/05/1959";

        WebElement dateBox = driver.findElement(By.id("vfb-8"));
        assertEquals("", dateBox.getAttribute("value"));

        dateBox.clear();
        dateBox.sendKeys(dateToEnter);
        assertEquals(dateToEnter, dateBox.getAttribute("value"));

    }
}
