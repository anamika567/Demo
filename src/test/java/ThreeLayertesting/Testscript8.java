package ThreeLayertesting;

import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Testscript8 {

	@Test 
	public void project() throws Throwable {
		
		// add from selenium
		
				WebDriver driver=new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

				Random ran=new Random();
				int value=ran.nextInt(100);
				String Project="LifeInsuranceManagement"+value;

				driver.get("http://rmgtestingserver:8084");
				driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
				driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
				driver.findElement(By.xpath("//button[text()='Sign in']")).click();
				driver.findElement(By.linkText("Projects")).click();
				driver.findElement(By.xpath("//span[text()='Create Project']")).click();
				driver.findElement(By.xpath("//input[@name='projectName']")).sendKeys(Project);
				driver.findElement(By.xpath("//input[@name='createdBy']")).sendKeys("Anamika");
				WebElement st = driver.findElement(By.xpath("(//select[@name='status'])[2]"));
				Select s=new Select(st);
				s.selectByIndex(1);
				driver.findElement(By.xpath("//input[@type='submit']")).click();
				String proId=driver.findElement(By.xpath("//td[text()='"+Project+"']/preceding-sibling::td")).getText();
				System.out.println(proId);

				// update from restassured
				
				baseURI="http://rmgtestingserver";
				port=8084;
				
				JSONObject jObj=new JSONObject();
				jObj.put("createdBy", "Anamikasingh");
				jObj.put("projectName", "LifeInsuranceManagement"+value);
				jObj.put("status", "updated");
				jObj.put("teamSize", 5);
				
				Response resp= given().body(jObj).contentType(ContentType.JSON)
				.when().put("/projects/"+proId);
				resp.then().assertThat().statusCode(200).log().all();
				
				String actualProj=resp.jsonPath().getString("projectName");
				
				// check in database it is updated or not
				
				Connection con=null;
				try {
						
			    Driver driver1=new Driver();
			    DriverManager.registerDriver(driver1);
			    con=DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%", "root");
				Statement state = con.createStatement();
				String query="select * from project where project_Name='"+actualProj+"';";
				ResultSet result = state.executeQuery(query);
				
				boolean flag=false;
				while(result.next())
				{
					String Projectname=result.getString(4);
					System.out.println(Projectname);
					
					if(Projectname.equalsIgnoreCase(actualProj))
					{
						flag=true;
						break;
						
					}
				}
				if(flag)
				{
					System.out.println("project is updated");
				}
				else
				{
					System.out.println("project is not updated");
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}

			finally
			{
				con.close();
				System.out.println("database is closed");
			}
	
driver.close();
			
				
	}
}
