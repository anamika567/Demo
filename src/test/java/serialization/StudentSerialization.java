package serialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import pojoclass.Student;

public class StudentSerialization {

	@Test
	
	public void writeDetails() throws Throwable
	{
		Student stu=new Student("Divya",102,8896352);
		ObjectMapper om=new ObjectMapper();
		om.writeValue(new File("./stu.json"), stu);
	}
}
