package com.techelevator.fbn;

import static org.junit.Assert.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;


public class MortgageCalculatorFunctionalTestWithoutPageObject {

	private static WebDriver webDriver;
	
	/* Creating an instance of the WebDriver is time consuming
	 * since it opens up a browser window. Therefore, we do this
	 * only once at the start of the class and reuse the same
	 * browser window for all tests. */
	@BeforeClass
	public static void openWebBrowserForTesting() {

		String homeDir = System.getProperty("user.home"); // ~ or $HOME
		/* The ChromeDriver requires a system property with the name "webdriver.chrome.driver" that
		 * contains the directory path to the ChromeDriver executable. The following line assumes
		 * we have installed the ChromeDriver in a known location (in our home directory) */
		System.setProperty("webdriver.chrome.driver", homeDir + "\\chromedriver.exe");
		webDriver = new ChromeDriver();
	}

	@Before
	public void openHomePage() {
		webDriver.get("http://localhost:8080/");
	}
	
	@AfterClass
	public static void closeWebBrowser() {
		webDriver.quit();
	}
	
	/* In order for Selenium to interact with a web page, it needs to be
	 * able to locate elements within the page. It does this using the 
	 * WebDriver.findElementBy(...) and WebDriver.findElementsBy(...)
	 * methods. Both of these elements take a org.openqa.selenium.By
	 * object as an argument. The following static methods return
	 * By objects for different kinds of element queries:
	 * 
	 *  - By.className(String className) .
	 *  - By.cssSelector(String selector) 
	 *  - By.id(String id)  #
	 *  - By.linkText(String linkText)  
	 *  - By.name(String name)      name='whatever'
	 *  - By.tagName(String name)  <tag>
	 */
	
	@Test
	/* Whenever possible, it is best to find page elements using the
	 * HTML id attribute since this is the most efficient. Remember
	 * that the element id is supposed to be unique per page */
	public void elements_can_be_found_by_id() {
		WebElement savingsH2 = webDriver.findElement(By.id("savings"));  // #savings
		WebElement checkingH2 = webDriver.findElement(By.id("checkings"));
		WebElement loansH2 = webDriver.findElement(By.id("loans"));
		
		assertEquals("Start Saving", savingsH2.getText());
		assertEquals("Open Checking", checkingH2.getText());
		assertEquals("Loans", loansH2.getText());
	}

	@Test
	public void single_elements_can_be_found_by_tag_name() {
		WebElement header = webDriver.findElement(By.tagName("header")); // header
		WebElement footer = webDriver.findElement(By.tagName("footer")); // returns first if multiple
		assertNotNull(header);
		assertNotNull(footer);
	}
	
	@Test
	public void multiple_elements_can_be_found_by_tag_name() {
		List<WebElement> sections = webDriver.findElements(By.tagName("section"));
		assertEquals(3, sections.size());
		for(WebElement section : sections) {
			assertEquals("account", section.getAttribute("class"));
		}
	}
	
	@Test
	public void pages_can_be_navigated_by_clicking_on_links() {
		// Link elements (i.e. <a> tags) can be found based on their text
		WebElement calculatorLink = webDriver.findElement(By.linkText("Mortgage Payment Calculator")); // <a href="www.whatever.com"> THIS IS THE LINK TEXT</a>
		calculatorLink.click();
		
//		JavascriptExecutor ex = (JavascriptExecutor)webDriver;
//		ex.executeScript("arguments[0].click();", calculatorLink);
		
		// The getTitle() method returns the value of the page title
		assertTrue(webDriver.getTitle().endsWith("Mortgage Calculator"));
		WebElement h2 = webDriver.findElement(By.tagName("h2"));
		assertEquals("Mortgage Calculator", h2.getText());
	}
	
	@Test
	public void forms_can_be_edited_and_submitted() throws InterruptedException {
		WebElement calculatorLink = webDriver.findElement(By.linkText("Mortgage Payment Calculator"));
		calculatorLink.click();
//		JavascriptExecutor ex = (JavascriptExecutor)webDriver;
//		ex.executeScript("arguments[0].click();", calculatorLink);

		TimeUnit.SECONDS.sleep(3);

		WebElement amountField = webDriver.findElement(By.name("loanAmount"));
		// The sendKeys(...) method can be used to simulate typing in a field
		amountField.sendKeys("100000");
		TimeUnit.SECONDS.sleep(3);
		// To interact with a <select> element, wrap the WebElement in a Select object
		Select termField = new Select(webDriver.findElement(By.name("loanTerm")));
		termField.selectByVisibleText("15 Years");
		TimeUnit.SECONDS.sleep(3);
		
		
		
		WebElement interestField = webDriver.findElement(By.name("rate"));
		interestField.sendKeys("4.5");
		TimeUnit.SECONDS.sleep(3);
		
		WebElement submitButton = webDriver.findElement(By.className("formSubmitButton"));

		//ex.executeScript("arguments[0].click();", submitButton);
		submitButton.click();
		TimeUnit.SECONDS.sleep(3);
		
		/* Elements without an id can be found using an xPath expression.
		 * However, finding elements by xPath should generally be avoided 
		 * as it is slow and makes for brittle tests. */
		//*[@id="loanPaymentCalculationResults"]/tbody/tr[4]/td
		WebElement paymentValueTd = webDriver.findElement(By.xpath("//table[@id=\"loanPaymentCalculationResults\"]//tr[4]/td"));
		assertEquals("$764.99", paymentValueTd.getText());
	}
}
