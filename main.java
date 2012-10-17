package ZombieApocalypse;

import java.util.ArrayList;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {
    	
    	Scanner scan = new Scanner(System.in);
    	
    	System.out.println("Welcome to");
    	System.out.println("The Zombie Apocalypse Creator¨\n");
    	
    	System.out.println("How many zombies would you like to create?");
		int zCount = scan.nextInt();
		
		System.out.println("How many people would you like to create?");
		int pCount = scan.nextInt();
    	
		Person.createIndividuals(zCount, true);
		Person.createIndividuals(pCount, false);
        
		Person.outputIndividuals();
		
        //Encounter.encounter(listOne,listOne);
        //run an encounter
    }
}