package GenericUtility;

import java.util.Random;

public class JavaUtility {

	/**
	 * this method will return random number.
	 * @return
	 */
	public int getRandomNo()
	{
		Random ran=new Random();
		int random=ran.nextInt(500);
		return random;
		
	}
}
