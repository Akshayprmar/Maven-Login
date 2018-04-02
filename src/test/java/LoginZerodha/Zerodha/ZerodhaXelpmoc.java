package LoginZerodha.Zerodha;

import java.io.File;
import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.util.FileCopyUtils;
import org.testng.annotations.Test;

import net.sf.cglib.reflect.MulticastDelegate.Generator;

public class ZerodhaXelpmoc {
	WebDriver driver;
	  String answer1;
	  String answer2;
	  String answer;
	  String str1 ="What is your spouse's blood group? (e.g. A Plus, B Minus etc)";
	  String str2 ="Which company was your first life insurance provider? (e.g. LIC, Bajaj Allianz, etc.)";
	  String str3 ="Which is the theater nearest to your home?";
	  String str4 ="What is your birth place?";
	  String str5 ="What is the brand name of the first watch you owned? (e.g. Titan, Times, etc)";
	
	  public String Question(String FirstQuestion){
		  if(FirstQuestion.equalsIgnoreCase(str1)){
				 answer="B-";
								
			}
			else if(FirstQuestion.equalsIgnoreCase(str2)){
				 answer="ICICI";
								 
			}
			else if(FirstQuestion.equalsIgnoreCase(str3)){
				 answer="PVR";
								
			}
			else if(FirstQuestion.equalsIgnoreCase(str4)){
				 answer="Delhi";
								
			}
			else if(FirstQuestion.equalsIgnoreCase(str5)){
				 answer="Titan";
				
			}
		return answer;
		
	  }
	  
	public void screenShot(){
		File screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileCopyUtils.copy(screen, new File("E:\\Atul\\zerodha.jpg"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public void QuestionAnswer() throws InterruptedException{
			Thread.sleep(1000);
		 	String FirstQuestion = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[1]/div/div/div[2]/form/div[2]/div/label")).getText();		 
		    System.out.println("FirstQuestion:" +FirstQuestion);
		    String SecondQuestion= driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[1]/div/div/div[2]/form/div[3]/div/label")).getText();
		    Thread.sleep(1000);
			System.out.println("SecondQuestion:" +SecondQuestion);
			Thread.sleep(1000);
			
			String answer1=Question(FirstQuestion);
			Thread.sleep(1000);
			System.out.println("for Answer1: execution:" +answer1);
			String answer2=Question(SecondQuestion);
			Thread.sleep(1000);
			System.out.println("for Answer1: execution:" +answer2);
			Thread.sleep(1000);
				
			Thread.sleep(1000);
			driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[1]/div/div/div[2]/form/div[2]/div/input")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[1]/div/div/div[2]/form/div[2]/div/input")).sendKeys(answer1);
			Thread.sleep(1000);
			driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[1]/div/div/div[2]/form/div[3]/div/input")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[1]/div/div/div[2]/form/div[3]/div/input")).sendKeys(answer2);
			Thread.sleep(1000);
			driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[1]/div/div/div[2]/form/div[4]/button")).click();
			Thread.sleep(1000);
	}
	
  @Test
  public void Login()  {
	 System.setProperty("webdriver.chrome.driver","./Dependencies/chromedriver");
	 String formPath ;
	 String kiteUrl;
	  try {
	  driver = new ChromeDriver();
	  kiteUrl= "https://kite.trade/connect/login?v=3&api_key=qkexi19nbjdwf9jm";
	  driver.get(kiteUrl);
	  Thread.sleep(1000);
	  formPath = "/html/body/div[1]/div/div[2]/div[1]/div/div/div[2]/form";	
	  driver.findElement(By.xpath(formPath+"/div[1]/input")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath(formPath+"/div[1]/input")).sendKeys("XJ0825");
	  Thread.sleep(1000);
	  driver.findElement(By.xpath(formPath+"/div[2]/input")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath(formPath+"/div[2]/input")).sendKeys("xelpmoc@92");
	  Thread.sleep(1000);
	  driver.findElement(By.xpath(formPath+"/div[3]/button")).click();
	  System.out.println("Login Succesful");	  
	  Thread.sleep(5000);
	  QuestionAnswer();
	} catch (InterruptedException e) {		
		e.printStackTrace();
	}
	   
	
	  
	  
  }
}