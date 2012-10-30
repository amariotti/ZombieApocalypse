package ZombieApocalypse;

import java.util.ArrayList;



/**
 * Created with IntelliJ IDEA.
 * User: Lappy
 * Date: 10/9/12
 * Time: 8:26 PM
 * To change this template use File | Settings | File Templates.
 */
//Push test
public class Encounter {
	
	
	
	

		
    public static void encounter(ArrayList<Person> Group1,ArrayList<Person> Group2 )
    {
    	  	
    	///////////////////This is for zombie vs person//////////////////////
    	if(isZombieGroup(Group1)&& !isZombieGroup(Group2))
    	{
    		zombieVsPerson(Group1,Group2);
    	}
    	 ///////////////////This is for person vs person//////////////////////
    	else if(!isZombieGroup(Group1)&& !isZombieGroup(Group2))
    	{
    		
    	}
    	 ///////////////////This is for zombie vs zombie//////////////////////
    	else if(isZombieGroup(Group1)&& isZombieGroup(Group2))
    	{
    		
    	}
    	 ///////////////////This is for person vs zombie//////////////////////
    	else if(!isZombieGroup(Group1)&& isZombieGroup(Group2))
    	{
    		zombieVsPerson(Group2,Group1);
    	}
    	
    }
    private static void zombieVsPerson(ArrayList<Person> zombies,ArrayList<Person> people )
    {
    	if((getMilitaryPeopleCount(people)*2)+getNormalPeopleCount(people)> zombies.size())
    	{
    		
    	}
    	else
    	{
    		
    	}
    	
    }
   
    private static int getMilitaryPeopleCount(ArrayList<Person> tempGroup)
    {
    	int count = 0;
    	for(int i=0;i<tempGroup.size();i++)
    	{
    		Person tempPerson = tempGroup.get(i);    		
    		if(tempPerson.getNinjaSkill() >= PersonStatsTypes.militaryClass)
    		{
    			count++;
    		}
    	}
    	return count;
    }
    private static int getNormalPeopleCount(ArrayList<Person> tempGroup)
    {
    	int count = 0;
    	for(int i=0;i<tempGroup.size();i++)
    	{
    		Person tempPerson = tempGroup.get(i);    		
    		if(tempPerson.getNinjaSkill() <= PersonStatsTypes.militaryClass)
    		{
    			count++;
    		}
    	}
    	return count;
    }
    private static boolean isZombieGroup(ArrayList<Person> tempGroup)
    {
    	if(tempGroup.size()>0)
    	{
    		if(((Person)tempGroup.get(0)).isInfected() == true)
    		{
    			return true;
    		}
    		else
    		{
    			return false;
    		}
    	}
    	else
    	{
    		return false;
    	}
    	
    	
    }

}
