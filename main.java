package ZombieApocalypse;

import java.util.ArrayList;

public class main {

    public static void main(String[] args) {
        ArrayList<Person> alZombie = new ArrayList<Person>();
        ArrayList<Person> alPerson = new ArrayList<Person>();
        
        for (int i = 0; i < 40; i++)
        {
        	int randomInfected = RandNum.go(1,2);
        	
        	if(randomInfected == 1)
        	{
        		Person zombie = new Person("zombie",100,100,100,100,100,true,100);
        		alZombie.add(zombie);
        	}
        	else
        	{
        		Person person = new Person("person",100,100,100,100,100,false,100);
        		alPerson.add(person);
        	}
		}
        
        System.out.println("Zombie Count: " + alZombie.size());
        System.out.println("Person Count: " + alPerson.size());
        
        //Encounter.encounter(listOne,listOne);
        //run an encounter
    }
}