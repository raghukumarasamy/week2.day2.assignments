package week2.day2.assignments;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RadioButton {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/radio.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.id("yes")).click();

		boolean default_unchecked = driver
				.findElement(By.xpath("//label[text()='Find default selected radio button']/following::label[1]"))
				.isSelected();

		if (default_unchecked == true) {
			System.out.println("unchecked is selected");
		} else {
			System.out.println("checked is selected");
		}

		List<WebElement> allAge = driver
				.findElements(By.xpath("//label[contains(text(),'age')]/following-sibling::input"));

		for (WebElement age : allAge) {
			if (age.isSelected() == true) {

			}

		}

	}

}
