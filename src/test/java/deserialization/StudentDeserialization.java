package deserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import pojoclass.Student;

public class StudentDeserialization {

	@Test
	public void readDetails() throws Throwable {
		
		ObjectMapper om=new ObjectMapper();
		Student details=om.readValue(new File("./stu.json"), Student.class);
		System.out.println(details.getName());
		System.out.println(details.getId());
		System.out.println(details.getContact());
	}
}
