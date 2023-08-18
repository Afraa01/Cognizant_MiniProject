package Project;

import java.lang.*;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class Upload_image {

	public static void main(String[] args) throws Exception {

		// Set the path to the ChromeDriver
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\2278567\\java_prog_files_2278567\\MiniProject\\Drivers\\chromedriver.exe");

		// Launching Chrome browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		// Opening Google search
		driver.get("http://www.google.com");

		// Clicking on the Images link
		WebElement imagesLink = driver.findElement(By.linkText("Images"));
		imagesLink.click();
		Thread.sleep(1000);

		// Clicking on the camera icon to search by image
		WebElement cameraIcon = driver.findElement(By.xpath("//div [@data-base-lens-url=\"https://lens.google.com\"]"));
		cameraIcon.click();
		Thread.sleep(1000);

		// Select the "Upload an image" option link
		WebElement uploadOption = driver.findElement(By.xpath("//span[contains(text(),'upload a file  ')]"));
		uploadOption.click();
		Thread.sleep(1000);

		// Uploading image
		Robot robot = new Robot();
		StringSelection stringselection = new StringSelection(
				"C:\\Users\\2278567\\OneDrive - Cognizant\\Pictures\\download.png");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringselection, null);
		robot.setAutoDelay(1000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.setAutoDelay(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);

		// Click on the image
		WebElement image = driver.findElement(By.xpath("//img[@class='bn6k9b']"));
		image.click();
		System.out.println(image.getText());
		Thread.sleep(1000);

		// Saving old window
		String oldwindow = driver.getWindowHandle();

		// Clicking Search
		driver.findElement(By.xpath("(//span[@class='VfPpkd-rOvkhd-jPmIDe-dgl2Hf'])[9]")).click();
		Thread.sleep(1000);

		// Navigating to newly opened tab
		Set<String> handles = driver.getWindowHandles();
		for (String newwindow : handles) {
			driver.switchTo().window(newwindow);
		}

		// Clicking tools button
		driver.findElement(By.xpath("//div[@id='hdtb-tls']")).click();
		Thread.sleep(1000);

		// Selecting 'Anytime' dropdown
		WebElement anytime = driver.findElement(By.xpath("//span[@class= 'gTl8xb']"));
		anytime.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//div[@class='y0fQ9c'])[3]")).click();
		Thread.sleep(1000);

		// Sending keys to from input tag
		WebElement from = driver.findElement(By.xpath("//input[@class='OouJcb']"));
		from.sendKeys("7/21/2023");
		Thread.sleep(2000);

		// SEnding keys to 'to' input tag
		WebElement to = driver.findElement(By.xpath("//input[@class='rzG2be']"));
		to.sendKeys("8/21/2023");
		Thread.sleep(2000);

		// Clicking Go Button
		WebElement GoBtn = driver.findElement(By.xpath("//g-button[@class='Ru1Ao BwGU8e fE5Rge']"));
		GoBtn.click();
		Thread.sleep(2000);

		// Validating date for results displayed
		String dateTxt = driver.findElement(By.xpath("//div[@class='KTBKoe']")).getText();
		System.out.println("Validation of Date:" + dateTxt);

		// Taking screenshot
		TakesScreenshot capture = (TakesScreenshot) driver;
		File src = capture.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshot.png");
		Files.copy(src, dest);

		// Closing driver
		driver.quit();

	}
}
