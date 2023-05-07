package deserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import pojoclass.PetsStore;

public class PetDeserialization {

	
	@Test
	public void deserial() throws Throwable
	{
		ObjectMapper omp=new ObjectMapper();
		PetsStore pt=omp.readValue(new File("./pet.json"), PetsStore.class);
		System.out.println(pt.getId());
		System.out.println(pt.getCategory().getId());
		System.out.println(pt.getCategory().getName());
		System.out.println(pt.getName());
		System.out.println(pt.getPhotourl()[0]);
		System.out.println(pt.getTags()[0].getId());
		System.out.println(pt.getTags()[0].getName());
		System.out.println(pt.getStatus());
	}
}
