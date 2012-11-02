package ZombieApocalypse;

import java.util.ArrayList;



/**
 * Created with IntelliJ IDEA.
 * User: Lappy
 * Date: 10/9/12
 * Time: 8:26 PM
 * To change this template use File | Settings | File Templates.
 */
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
    		zombieVsPerson(Group2,Group1);
    	}
    	
    }
    
    //////////This is for when we people vs people now just zombie vs person
    private static void zombieVsPerson(ArrayList<Person> zombies,ArrayList<Person> people )
    {
    	System.out.println("start zombieVsPerson");
    	//this is if zombies2*people or military +people > zombie or45% random chance
    	while((((getMilitaryPeopleCount(people)*1.50) + getNormalPeopleCount(people)) > zombies.size() && zombies.size()>0)||people.size()*2<= zombies.size()||RandNum.go(1,100)<45)//fight
    	{
    		if(zombies.size() == 0 || people.size() == 0)//look to see if they are empty leave out
    		{
    			System.out.println("done");
    			return;
    		}
    		//System.out.println("start loop");
    		//
    		if( people.size() >0 && zombies.size()>0 )
    		{
    			//System.out.println("start if");
    			
    			//Grabs a random person and zombie to fight
    			int personIndex = RandNum.go(0, people.size()-1);
        		int zombieIndex = RandNum.go(0, zombies.size()-1);
        		
        		//The random person and zombie are fighting and the winner is returned in a string
        		String whoWon = personZombieFight(people.get(personIndex),zombies.get(zombieIndex));
        		
        		if(whoWon =="person")//if person won remove zombie and add
        		{
        			System.out.println("person won");
        			zombies.remove(zombieIndex);
        			//TODO: add experience when they win
        			people.get(personIndex).setNinjaSkill(people.get(personIndex).getNinjaSkill()+PersonStatsTypes.peopleFightExperience);
        		}
        		else //zombie won
        		{
        			System.out.println("zombie won");
        			//might want to look to see if we can not convert based on health after we add weapons
        			if(people.get(personIndex).getHealth()<-15) //Ripped apart
        			{
        				people.remove(personIndex);// take them out of person array
        			}
        			else//converted
        			{
        				people.get(personIndex).setInfected(true); //make them zombie
            			zombies.add(people.get(personIndex)); //add to zombie array
            			people.remove(personIndex); //take them out of person array
        				
        			}
        			
        		
        		}
        		//System.out.println("if");
    		}
    		//System.out.println("loop");
    	}
    	peopleRoundEnd(people); //People will rest and heal
    	System.out.println("done");
    	    	
    }
    private static void peopleRoundEnd(ArrayList<Person> people) //People will rest and heal
    {
    	 for(Person d:people) 
    	 {
    		 if(d.getHealth() <90 ) //People above 90 health won't heal anymore
    		 {
    			 d.setHealth(d.getHealth()+PersonStatsTypes.roundHealth);
    		 }    		
    		 d.setNinjaSkill(d.getNinjaSkill() + PersonStatsTypes.roundExperence); // gain experience for surviving the round
    	 }
    	
    }
    
    private static String personZombieFight(Person tempPerson, Person tempzombie) // Actual person vs zombie fight
    {
    	System.out.println("fight");
    	while(tempPerson.getHealth() > 0 && tempzombie.getHealth() > 0 )//tell person or zombie is dead
    	{
    		if(tempPerson.getSpeed()+tempPerson.getNinjaSkill() >= tempzombie.getSpeed()+tempzombie.getStrength()) //who goes first person has advantage zombies are slow
    		{
    			if(calculateDamage(tempPerson) != 0) // If they miss
    			{
    				//System.out.println("zombie attacks");
    				//person attacks
    				tempzombie.setHealth(tempzombie.getHealth()-(calculateDamage(tempPerson)));
    			}
    			else
    			{
    				//System.out.println("person attacks");
    				//zombie attacks
    				tempPerson.setHealth(tempPerson.getHealth()-(calculateDamage(tempzombie)));
    			}
    			
    		}
    		else
    		{    			
    			if(calculateDamage(tempzombie)!=0) // If they miss
    			{
    				//System.out.println("zombie attacks");
    				//zombie attacks
    				tempPerson.setHealth(tempPerson.getHealth()-(calculateDamage(tempzombie)));
    			}
    			else
    			{
    				//System.out.println("person attacks");
    				//person attacks
    				tempzombie.setHealth(tempzombie.getHealth()-(calculateDamage(tempPerson)));
    			}
    			
    		}
    	}
    	if(tempPerson.getHealth()>0) // Returns the winner
    	{
    		return "person";
    		
    	}
    	else
    	{
    		return "zombie";
    	}
    		
    }
   
    private static int calculateDamage(Person damagePerson) //Determines the damage from the person or zombie
    {
    	int tempint;
    	if(damagePerson.isInfected()) //zombie
    	{	
    		tempint = (damagePerson.getStrength()-(PersonStatsTypes.zombieDamageReducer+damagePerson.getSpeed())); //slow zombies hurt less
    		if(tempint >0) // Hit
    		{
    			return tempint;
    		}
    		else // Miss
    		{
    			return 0;
    		}
    		
    	}
    	else //person
    	{
    		
    		tempint = damagePerson.getNinjaSkill()+ getWeponDamage(damagePerson); // Checks for skill of person/zombie
    		if(tempint >0) // Hit
    		{
    			return tempint;
    		}
    		else // Miss
    		{
    			return 0;
    		}
    		
    	}
		
	}
    
    // Returns damage of the weapon if they have one
	private static int getWeponDamage(Person damagePerson) {
		Gun tempgun = damagePerson.getHasGun();
		if(tempgun!=null)
		{
			return tempgun.getPower();
		}
		else
		{
			return 0;
		}
		
	}
	
	//Gets the count of the military in the group
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
	
	//Gets the count of the normal people
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
    
    //Determines if they are zombies or people
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
