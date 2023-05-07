package GenericUtility;

import io.restassured.response.Response;

/**
 * consist of methods of restassured
 * @author hp
 *
 */
public class RestAssuredLibrary {
	
	/**
	 * this method will return json data from the corresponding response body
	 * @param response
	 * @param path
	 * @return
	 */
	
	public String getJsonData(Response response ,String path)
	{
		String jsonData=response.jsonPath().get(path);
		return jsonData;
	}

}
