package week2.day2.assignments;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RedBus {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement From = driver.findElement(By.xpath("//input[contains(@data-message,'source')]"));
		From.click();
		From.sendKeys("Chennai");
		From.sendKeys(Keys.ENTER);
		WebElement To = driver.findElement(By.xpath("//input[contains(@data-message,'destination')]"));
		To.click();
		To.sendKeys("Bangalore");
		To.sendKeys(Keys.ENTER);

		driver.findElement(By.id("onward_cal")).click();
		driver.findElement(By.xpath("//td[@class='current day']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='Search Buses']")).click();
		Thread.sleep(5000);
		WebElement close = driver.findElement(By.xpath("//i[@class='icon icon-close c-fs']"));
		if (close.isDisplayed()) {
			close.click();
		}
		WebElement sleeper = driver.findElement(By.xpath("(//label[@for='bt_SLEEPER'])[1]"));
		sleeper.click();
		List<WebElement> allBus = driver.findElements(By.xpath("//div[@class='clearfix bus-item-details']/.."));
		int size = allBus.size();
		int sumBus = 0;
		for (int i = 0; i < size; i++) {
			sumBus += i;

		}
		System.out.println(sumBus);

		driver.findElement(By.xpath("(//label[@for='bt_AC'])[1]")).click();

		int size1 = allBus.size();
		int sumBus1 = 0;
		for (int i = 0; i < size1; i++) {
			sumBus1 += i;

		}

		System.out.println(sumBus1);

		sleeper.clear();

		int size2 = allBus.size();
		int sumBus2 = 0;
		for (int i = 0; i < size2; i++) {
			sumBus2 += i;

		}

		System.out.println(sumBus2);
	}

}
