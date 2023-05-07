package serialization;

import java.io.File;

import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import pojoclass.Employee;
import pojoclass.EmployeeNew;
import pojoclass.EmployeeWithObject;
import pojoclass.Spouse;

public class EmployeeSerializationWithObject {

	@Test
public void emplyseri() throws Throwable{
		
		int phno[]= {4478,9633};
		Spouse sp=new Spouse("neha",phno);
		EmployeeWithObject emp=new EmployeeWithObject("ekta",sp);
		ObjectMapper omp=new ObjectMapper();
		omp.writeValue(new File("./emp.json"), emp);

	}
}
