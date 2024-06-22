package TricentisProject;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC2Truck {

	public static void main(String[] args) throws IOException {
		WebDriver  driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://sampleapp.tricentis.com/101/index.php#");
		
		//Truck
		driver.findElement(By.id("nav_truck")).click();
			
		//Page 1
		Select model = new Select(driver.findElement(By.id("make")));
		List<WebElement> Truck = model.getOptions();
		model.selectByValue("Porsche");
				
		driver.findElement(By.id("engineperformance")).sendKeys("2000");
				
		driver.findElement(By.id("opendateofmanufacturecalender")).click();
		driver.findElement(By.xpath("/html/body/div[2]/div/a[1]")).click();
		driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr[2]/td[2]/a")).click();
		
//		driver.findElement(By.id("numberofseats")).click();
//		driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/form/div/section[1]/div[4]/select/option[5]")).click();
		Select seat = new Select(driver.findElement(By.id("numberofseats")));
		List<WebElement> truck = seat.getOptions();
		seat.selectByValue("4");
		
		Select fuel = new Select(driver.findElement(By.id("fuel")));
		List<WebElement> truc = fuel.getOptions();
		fuel.selectByValue("Petrol");
		
		driver.findElement(By.id("payload")).sendKeys("700");
		
		driver.findElement(By.id("totalweight")).sendKeys("3000");
		
		driver.findElement(By.id("listprice")).sendKeys("100000");
		
		driver.findElement(By.id("licenseplatenumber")).sendKeys("UP78DE4971");
		
		driver.findElement(By.id("annualmileage")).sendKeys("150");
		
		driver.findElement(By.id("nextenterinsurantdata")).click();
		
		//Page 2
				driver.findElement(By.id("firstname")).sendKeys("Nazma");
				
				driver.findElement(By.id("lastname")).sendKeys("Masumdar");
				
				driver.findElement(By.id("birthdate")).sendKeys("07/08/1996");
				//driver.findElement(By.id("opendateofbirthcalender")).click();
				
				List<WebElement> gender = driver.findElements(By.xpath("/html/body/div[1]/div/div[1]/div/div/form/div/section[2]/div[4]/p/label[1]/span"));
				gender.get(0).click();
				
//				driver.findElement(By.id("country")).click();
//				driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/form/div/section[2]/div[6]/select/option[103]")).click();
				Select count = new Select(driver.findElement(By.id("country")));
				List<WebElement> In = count.getOptions();
				count.selectByValue("India");

				driver.findElement(By.id("zipcode")).sendKeys("226002");
				
				Select ocupation = new Select(driver.findElement(By.id("occupation")));
				List<WebElement> ocup = ocupation.getOptions();
				ocupation.selectByValue("Selfemployed");
				
				driver.findElement(By.xpath("//*[@id=\"insurance-form\"]/div/section[2]/div[10]/p/label[1]")).click();
				driver.findElement(By.xpath("//*[@id=\"insurance-form\"]/div/section[2]/div[10]/p/label[2]")).click();
				driver.findElement(By.xpath("//*[@id=\"insurance-form\"]/div/section[2]/div[10]/p/label[4]")).click();
				
				driver.findElement(By.id("nextenterproductdata")).click();
				
				//Page 3 
				driver.findElement(By.id("openstartdatecalender")).click();
				driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[2]")).click();
				driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[2]/td[4]/a")).click();
				
				Select ins = new Select(driver.findElement(By.id("insurancesum")));
				List<WebElement> sum = ins.getOptions();
				ins.selectByValue("5000000");
				
				Select insurance = new Select(driver.findElement(By.id("damageinsurance")));
				List<WebElement> damage = insurance.getOptions();
				insurance.selectByValue("Full Coverage");
				
				driver.findElement(By.xpath("//*[@id=\"insurance-form\"]/div/section[3]/div[4]/p/label[2]/span")).click();
				
				driver.findElement(By.id("nextselectpriceoption")).click();
				
				//Page 4 
				String expeAm="1,864.00",actAm=null,expeClaim="Submit",actClaim=null,expeDiscount="5",actDiscount=null,expeCover="Limited",actCover=null;
				
				WebElement actam = driver.findElement(By.id("selectplatinum_price"));
				actAm = actam.getText();
				
				
				WebElement actclaim = driver.findElement(By.xpath("//*[@id=\"priceTable\"]/tbody/tr[2]/td[4]"));
				actClaim = actclaim.getText();
				
				WebElement actdiscount = driver.findElement(By.xpath("//*[@id=\"priceTable\"]/tbody/tr[3]/td[4]"));
				actDiscount = actdiscount.getText();
				
				WebElement actcover = driver.findElement(By.xpath("//*[@id=\"priceTable\"]/tbody/tr[4]/td[4]"));
				actCover = actcover.getText();
				
				
				if(expeAm.equals(actAm) && expeClaim.equals(actClaim) && expeDiscount.equals(actDiscount) && expeCover.equals(actCover) )
				{
					driver.findElement(By.xpath("//*[@id=\"priceTable\"]/tfoot/tr/th[2]/label[3]")).click();
				}
				else
				{
					System.out.println("Data did not match with expected");
				}
				
				
				driver.findElement(By.id("nextsendquote")).click();
				
				//Page 5
				driver.findElement(By.id("email")).sendKeys("Nazmamail87@gmail.com");
				driver.findElement(By.id("username")).sendKeys("Nazma");
				driver.findElement(By.id("password")).sendKeys("Nazma@12345");
				driver.findElement(By.id("confirmpassword")).sendKeys("Nazma@12345");
				driver.findElement(By.id("Comments")).sendKeys("a b c d e f g h i j kk l m n o p q r s t u");
				
				driver.findElement(By.id("sendemail")).click();
				
				WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]")));
				
				File srcfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(srcfile, new File("C:\\Users\\deepa\\OneDrive\\Pictures\\screen2.png"));
				
				driver.findElement(By.xpath("/html/body/div[4]/div[7]/div/button")).click();
				
				driver.findElement(By.xpath("//*[@id=\"backmain\"]/span")).click();
				
				driver.close();
	}

}
