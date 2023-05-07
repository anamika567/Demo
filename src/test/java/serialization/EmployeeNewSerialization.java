package serialization;

import java.io.File;

import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import pojoclass.Employee;
import pojoclass.EmployeeNew;

public class EmployeeNewSerialization {
	
	@Test
   public void emplyseri() throws Throwable{
		
		int phno[]= {4478,9633};
		EmployeeNew emp=new EmployeeNew("anamika","1552",phno);
		ObjectMapper omp=new ObjectMapper();
		omp.writeValue(new File("./emp.json"), emp);
	
	}

}
