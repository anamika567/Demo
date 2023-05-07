package ThreeLayertesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Testscript7 {

	@Test
	public void project() throws Throwable 
	{
		// add from database
		
				Random ran=new Random();
				int value=ran.nextInt(100);
				
				String actualProject="Life_Insurance_Management"+value;
				String pid="TY_Project_"+value;
				Connection con=null;
				int result=0;
			try {
		         Driver driver =new Driver();
				
					DriverManager.registerDriver(driver);
				
					con=DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%", "root");
				
					Statement state = con.createStatement();
					String query="insert into project values('"+pid+"','AnamikaSingh','21/03/2023','"+actualProject+"','created',3)";
					
					result=state.executeUpdate(query);
			}
			catch(Exception e)
			{
						
			}
			finally
			{
				if(result==1)
				{
					System.out.println("Data inserted successfully");
				}
				else
				{
					System.out.println("Data not inserted");
				}
				
				con.close();		

		}
			
			// delete from restassured
			
			baseURI="http://rmgtestingserver";
			port=8084;
			
			Response resp= when().delete("/projects/"+pid);
			resp.then().assertThat().statusCode(204).log().all();
			System.out.println("deleted");


			// check from selenium it is deleted or not
			
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get("http://rmgtestingserver:8084");
			driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
			driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
			driver.findElement(By.xpath("//button[text()='Sign in']")).click();
			driver.findElement(By.linkText("Projects")).click();
			try 
			{
		      String projects = driver.findElement(By.xpath("//td[text()='"+actualProject+"']")).getText();
			}
			catch(Exception e)
			{
				Reporter.log("project is not present",true);
				driver.close();

			}
		
	}
}
