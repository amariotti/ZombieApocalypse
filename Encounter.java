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
    	if(isZombieGroup(Group1) && !isZombieGroup(Group2))
    	{
    		zombieVsPerson(Group1,Group2);
    	}
    	 ///////////////////This is for person vs person//////////////////////
    	else if(!isZombieGroup(Group1) && !isZombieGroup(Group2))
    	{
    		
    	}
    	 ///////////////////This is for zombie vs zombie//////////////////////
    	else if(isZombieGroup(Group1) && isZombieGroup(Group2))
    	{
    		
    	}
    	 ///////////////////This is for person vs zombie//////////////////////
    	else if(!isZombieGroup(Group1) && isZombieGroup(Group2))
    	{
    		zombieVsPerson(Group2,Group1);
    	}
    	else{
    		return;
    	}
    	
    }
    private static void zombieVsPerson(ArrayList<Person> zombies,ArrayList<Person> people )
    {
    	while(people.size() >0 && zombies.size()>0)//fight
    	{
    		//((getMilitaryPeopleCount(people)*2) + getNormalPeopleCount(people)) > zombies.size()
    		if( people.size() >0 && zombies.size()>0 )
    		{
    			int personIndex = RandNum.go(0, people.size()-1);
        		int zombieIndex = RandNum.go(0, zombies.size()-1);
        		String whoWon = personZombieFight(people.get(personIndex),zombies.get(zombieIndex));
        		
        		if(whoWon =="person")//if person won remove zombie and add
        		{
        			zombies.remove(zombieIndex);
        			//TODO: add experience when they win
        			people.get(personIndex).setNinjaSkill(people.get(personIndex).getNinjaSkill()+PersonStatsTypes.peopleRoundExperience);
        		}
        		else
        		{
        			//TODO: might want to look to see if we can not convert based on health after we add weapons
        			people.get(personIndex).setInfected(true);//make them zombie
        			zombies.add(people.get(personIndex));//add to zombie array
        			people.remove(personIndex);// take them out of person array
        		
        		}
        		System.out.println("if");
    		}
    		System.out.println("loop");
    	}
    	System.out.println("done");
    	    	
    }
    
    private static String personZombieFight(Person tempPerson, Person tempzombie)
    {
    	while(tempPerson.getHealth() > 0 && tempzombie.getHealth() > 0 )//tell person or zombie is dead
    	{
    		if(tempPerson.getSpeed() >= tempzombie.getSpeed())//who goes first person has advanatage zombies are slow
    		{
    			//person attacks 
    			tempzombie.setHealth(tempzombie.getHealth()-(calculateDamage(tempPerson)));
    		}
    		else
    		{
    			//zombie attacks
    			tempPerson.setHealth(tempPerson.getHealth()-(calculateDamage(tempzombie)));
    		}
    	}
    	if(tempPerson.getHealth()>0)
    	{
    		return "person";
    		
    	}
    	else
    	{
    		return "zombie";
    	}
    		
    }
   
    private static int calculateDamage(Person damagePerson)
    {
    	int tempint;
    	if(damagePerson.isInfected())//zombie
    	{	//slow zombies hurt less
    		tempint = (damagePerson.getStrength()-(PersonStatsTypes.zombieDamageReducer+damagePerson.getSpeed()));
    		if(tempint >0)
    		{
    			return tempint;
    		}
    		else
    		{
    			return 0;
    		}
    		
    	}
    	else//person
    	{
    		
    		tempint = damagePerson.getNinjaSkill()+ getWeponDamage(damagePerson);
    		if(tempint >0)
    		{
    			return tempint;
    		}
    		else
    		{
    			return 0;
    		}
    		
    	}
		
	}
	private static int getWeponDamage(Person damagePerson) {
		// TODO: Auto-generated method stub
		return 0;
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
