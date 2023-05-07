package serialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import pojoclass.Employee;

public class EmployeeSerialization {

	@Test
	public void emplyseri() throws Throwable{
		
		Employee emp=new Employee("Anamika","10232",2121);
		ObjectMapper omp=new ObjectMapper();
		omp.writeValue(new File("./emp.json"), emp);
	}
}
