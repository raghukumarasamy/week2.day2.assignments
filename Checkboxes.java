package week2.day2.assignments;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Checkboxes {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/checkbox.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		

		// Select the languages that you know?
		driver.findElement(
				By.xpath("//label[text()='Select the languages that you know?']/following-sibling::div[1]//input"))
				.click();

		// Confirm Selenium is checked
		boolean isselected = driver
				.findElement(By.xpath("//label[text()='Confirm Selenium is checked']/following-sibling::div[1]//input"))
				.isSelected();
		if (isselected) {
			System.out.println("Selenium is selected");
		}

		// DeSelect only checked
		List<WebElement> deselect = driver
				.findElements(By.xpath("//label[text()='DeSelect only checked']/following-sibling::div//input"));
		for (WebElement unselect : deselect) {

			if (unselect.isSelected() == true) {
				unselect.click();
			}
		}

		// Select all below checkboxes
		List<WebElement> selectall = driver
				.findElements(By.xpath("//label[text()='Select all below checkboxes ']/following-sibling::div//input"));
		int size = selectall.size();
		for (int i = 0; i < size; i++) {
			selectall.get(i).click();
		}

	}

}
