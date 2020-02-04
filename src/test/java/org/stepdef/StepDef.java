package org.stepdef;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class StepDef {
	WebDriver driver;
	@Given("Launch the browser and open the Faballey Application")
	public void launch_the_browser_and_open_the_Faballey_Application() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\SONY\\eclipse-workspace\\Dinesh\\FaballeyDatatable\\Driver up\\chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.get("https://www.faballey.com/");
	    driver.manage().window().maximize();
	    Thread.sleep(5000);
	   driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div[1]/button[1]")).click(); 
	   Thread.sleep(7000);
	   driver.findElement(By.xpath("//a[@class='btnNoThanks']")).click(); 
	   driver.findElement(By.xpath("(//a[@href='/account/login'])[1]")).click();
	}

	@When("Click Login button and enter the Username and Password")
	public void click_Login_button_and_enter_the_Username_and_Password(io.cucumber.datatable.DataTable dataTable) {
	    List<String> as = dataTable.asList(String.class);
	    driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/form/div[1]/input")).sendKeys(as.get(0));
	    driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/form/div[4]/input[1]")).click();
	    driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/form/div[2]/input")).sendKeys(as.get(1));
	    
	}

	@When("Login the application")
	public void login_the_application() {
	    // Write code here that turns the phrase above into concrete actions
	    driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/form/div[4]/input[2]")).click();
	}

	@When("Seelect the product and add to bag")
	public void seelect_the_product_and_add_to_bag() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		WebElement winter=driver.findElement(By.xpath("//a[text()='Winter wear']"));
		WebElement jacket=driver.findElement(By.xpath("//a[text()='Jackets']"));
		Actions a = new Actions(driver);
		a.moveToElement(winter).perform();
		
		jacket.click();
		Thread.sleep(3000);
		 driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[2]/div[2]/div[5]/ul/li[1]/a/div[1]/img")).click();;
		 
			}

	@When("select the size and place the orderand move to payment page")
	public void select_the_size_and_place_the_orderand_move_to_payment_page() {
	    // Write code here that turns the phrase above into concrete actions
		String pwind = driver.getWindowHandle();
		System.out.println(pwind);
		Set<String> all= driver.getWindowHandles();
		System.out.println(all);
		for(String x:all)
		{
			if(!(x.equals(pwind)))
			{
				driver.switchTo().window(x);
			}
		}
		driver.findElement(By.xpath("/html/body/div[2]/div[4]/div/div[2]/div[2]/div[1]/ul/li[4]/a")).click();
	    driver.findElement(By.xpath("/html/body/div[2]/div[4]/div/div[2]/div[2]/div[3]/a[1]")).click();
	    driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[3]/div[2]")).click();
	    driver.findElement(By.xpath("/html/body/div[5]/div/div[2]/div/div[1]/div[2]/label/i")).click();
	    driver.findElement(By.xpath("/html/body/div[5]/div/div[2]/div/div[2]/div[2]/a")).click();
	}



}
