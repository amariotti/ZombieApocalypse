package ZombieApocalypse;

import java.util.Random;

/**
 * Class containing the method to generate a random number
 * @author Andrew Ariotti
 *
 */
public class RandNum
{
	/**
	 * Method to retrieve a random number below the int passed in
	 * @param Maximum value that you'd like the number to be limited to
	 * @return
	 */
	public static int go(int min, int max)
	{
		Random num = new Random();
		return num.nextInt(max - min + 1) + min;
	}
	
	/**
	 * Method to retrieve a random boolean
	 * @return
	 */
	public static boolean goBool()
	{
		Random num = new Random();
		int randomInt = num.nextInt(2);
		
		return (randomInt == 0) ? false : true;
	}
}