package introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class Git {
    
	@Test
	public void demoGit() throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\pushpam\\Downloads\\Project\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://github.com/login");
		
		//login using username and password
		driver.findElement(By.id("login_field")).sendKeys("kumarpushpam7");
		driver.findElement(By.id("password")).sendKeys("");
		
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		
		boolean pullreq = driver.findElement(By.xpath("//*[@aria-label='Pull requests you created']")).isDisplayed();
		
		if(pullreq){
			System.out.println("Login using username and password Passed");
		}
		else {
			System.out.println("Login using username and password Failed");
		}
		driver.findElement(By.xpath("//*[@aria-label='View profile and more']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[contains(text(), 'Sign out')]")).click();
		driver.findElement(By.xpath("//*[@href='/login']")).click();
		

		
		//login using email andd password
		driver.findElement(By.id("login_field")).sendKeys("kumarpushpam7@gmail.com");
		driver.findElement(By.id("password")).sendKeys("");
		
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		
		pullreq = driver.findElement(By.xpath("//*[@aria-label='Pull requests you created']")).isDisplayed();
		
		if(pullreq){
			System.out.println("Login using email andd password Passed");
		}
		else {
			System.out.println("Login using email andd password Failed");
		}
		
		//add new repository
		driver.findElement(By.xpath("//summary[@aria-haspopup='menu']")).click();
		driver.findElement(By.xpath("//*[contains(text(),'New repository')]")).click();
		
		boolean createRes = driver.findElement(By.xpath("//*[contains(text(),'Create repository')]")).isSelected();
		
		if(!createRes){
			System.out.println("add new repository 'Failed'; Enter Respository name");
		}
		
		driver.findElement(By.id("repository_name")).sendKeys("PeerDemo");
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[contains(text(),'Create repository')]")).click();
		
		Thread.sleep(2000);
		if(driver.getCurrentUrl().contains("PeerDemo")){
			System.out.println("add new repository- Passed");
		}
		else{
			System.out.println("add new repository- Failed");
		}
		

	}

}