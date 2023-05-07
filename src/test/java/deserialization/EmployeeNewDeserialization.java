package deserialization;

import java.io.File;

import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import pojoclass.Employee;
import pojoclass.EmployeeNew;

public class EmployeeNewDeserialization {

	@Test
public void emplyDes() throws Throwable {
		
		ObjectMapper omp=new ObjectMapper();
		EmployeeNew data=omp.readValue(new File("./emp.json"), EmployeeNew.class);
		
		System.out.println(data.name);
		System.out.println(data.id);
		System.out.println(data.phno[1]);
	}
}
