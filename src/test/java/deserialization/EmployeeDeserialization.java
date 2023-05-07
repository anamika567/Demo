package deserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import pojoclass.Employee;

public class EmployeeDeserialization {

	@Test
	public void emplyDes() throws Throwable {
		
		ObjectMapper omp=new ObjectMapper();
		Employee data=omp.readValue(new File("./emp.json"), Employee.class);
		
		System.out.println(data.getName());
		System.out.println(data.getId());
		System.out.println(data.getPhone());
	}
}
