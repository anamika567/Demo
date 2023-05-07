package GenericUtility;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class BaseClass1 {
	
	public  WebDriver driver;

	public DatabaseLibrary dLib=new DatabaseLibrary();
	public JavaUtility jLib=new JavaUtility();
	public RestAssuredLibrary rLib=new RestAssuredLibrary();
	public WebdriverUtility wLib=new WebdriverUtility();
	public RequestSpecification reqst;
	public ResponseSpecification resp;
	
	
	@BeforeSuite
	public void bsConfig() throws SQLException {
		
		dLib.connectToDB();
		
	//	baseURI="http://rmgtestingserver";
	//	port=8084;
		reqst =new RequestSpecBuilder().setBaseUri("http://rmgtestingserver:8084").setContentType(ContentType.JSON).build();
		
	}
	
	@AfterSuite
	public void asConfig() throws SQLException {
		
		dLib.closeDB();
		resp=new ResponseSpecBuilder().expectContentType("application/json").expectStatusCode(201).build();
	}
	

}
