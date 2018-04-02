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
	  String str1 = "Question 1"; //"What is your spouse's blood group? (e.g. A Plus, B Minus etc)";
	  String str2 = "Question 2"; //"Which company was your first life insurance provider? (e.g. LIC, Bajaj Allianz, etc.)";
	  String str3 = "Question 3"; //"Which is the theater nearest to your home?";
	  String str4 = "Question 4"; //"What is your birth place?";
	  String str5 = "Question 5"; // "What is the brand name of the first watch you owned? (e.g. Titan, Times, etc)";
	
	  public String Question(String FirstQuestion){
		  if(FirstQuestion.equalsIgnoreCase(str1)){
				 answer="B-"; // your Answer								
			}
			else if(FirstQuestion.equalsIgnoreCase(str2)){
				 answer="ICICI TST"; // your Answer								 
			}
			else if(FirstQuestion.equalsIgnoreCase(str3)){
				 answer="PVR Cinema"; // your Answer								
			}
			else if(FirstQuestion.equalsIgnoreCase(str4)){
				 answer="Delhi-Muma"; // your Answer								
			}
			else if(FirstQuestion.equalsIgnoreCase(str5)){
				 answer="Titan"; // your Answer		 
			}
		return answer;		
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
	  kiteUrl= "YOUR LINK";
	  driver.get(kiteUrl);
	  Thread.sleep(1000);
	  formPath = "/html/body/div[1]/div/div[2]/div[1]/div/div/div[2]/form";	
	  driver.findElement(By.xpath(formPath+"/div[1]/input")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath(formPath+"/div[1]/input")).sendKeys("XXXX"); //userId
	  Thread.sleep(1000);
	  driver.findElement(By.xpath(formPath+"/div[2]/input")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath(formPath+"/div[2]/input")).sendKeys("XXXXXX"); //Password
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