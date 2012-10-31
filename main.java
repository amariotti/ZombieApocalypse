package ZombieApocalypse;

import java.util.ArrayList;
import java.util.Scanner;

public class main {

	static ArrayList<Person> alPerson = new ArrayList<Person>();
	static ArrayList<Person> alZombie = new ArrayList<Person>();
	
	public static void createIndividuals(int count, boolean infected)
    {
    	for (int i = 0; i < count; i++)
        {
    		Person individual = new Person(infected);
    		
    		if (infected == true)
    			alZombie.add(individual);
    		else
    			alPerson.add(individual);
		}
    }
    
    public static void outputIndividuals()
    {
    	System.out.println(); //Temporary hard return
    	for(Person d:alPerson) {
        	System.out.println("Person: -- Health: " + d.getHealth() + ", Strength: " + d.getStrength() + ", Fatigue: " + d.getFatigue() + ", Hunger: " + d.getHunger());
    	}
    	
    	System.out.println(); //Temporary hard return
    	
        for(Person d:alZombie) {
        	System.out.println("Zombie: -- Health: " + d.getHealth() + ", Strength: " + d.getStrength() + ", Fatigue: " + d.getFatigue() + ", Hunger: " + d.getHunger());
        }
    }
	
    public static void main(String[] args) {
    	
    	Scanner scan = new Scanner(System.in);
    	
    	System.out.println("Welcome to");
    	System.out.println("The Zombie Apocalypse Creator¨\n");
    	
    	System.out.println("How many zombies would you like to create?");
		int zCount = scan.nextInt();
		
		System.out.println("How many people would you like to create?");
		int pCount = scan.nextInt();
    	
		createIndividuals(zCount, true);
		createIndividuals(pCount, false);
        
		outputIndividuals();
		Encounter.encounter(alPerson, alZombie);		        
		outputIndividuals();
		
        //Encounter.encounter(listOne,listOne);
        //run an encounter
		
		
    }
}