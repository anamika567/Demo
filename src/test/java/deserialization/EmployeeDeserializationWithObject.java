package deserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import pojoclass.EmployeeWithObject;

public class EmployeeDeserializationWithObject {
  
	@Test
    public void readData() throws Throwable {
	
	ObjectMapper omp=new ObjectMapper();
	EmployeeWithObject data = omp.readValue(new File("./emp.json"), EmployeeWithObject.class);
	System.out.println(data.getSpouse().getName());
	System.out.println(data.getSpouse().getPhone()[1]);

}
}
