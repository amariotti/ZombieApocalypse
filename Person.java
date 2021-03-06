package ZombieApocalypse;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Lappy
 * Date: 10/9/12
 * Time: 8:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class Person {
    private String name;
    private int health;
    private int strength;
    private int speed;
    private int hunger;
    private int fatigue;
    private boolean infected;
    private int ninjaSkill;
    private Gun hasGun;
    
    
    // Default constructor
	public Person()
	{
		
	}
	
	// Makes random person with a pre-set infected status
    public Person(boolean infectedStatus)
    {
    	name = "fakeName";
        health = RandNum.go(1,100); // Random health
        if(infectedStatus)// Zombies have specific health and speed
        {
        	 strength = RandNum.go(PersonStatsTypes.zombieStrengthNumerator,100);
        	 speed = RandNum.go(1,100)+PersonStatsTypes.zombieSpeedNumerator;
        }
        else // People have specific strength and speed
        {
        	 strength = RandNum.go(1,100);
        	 speed = RandNum.go(1,50);
        	 if (RandNum.goBool()) //Random bool to determine if this person has a weapon or not
         		{
        		 setHasGun(new Gun());
         		}
        	 else
        	 {
        		 setHasGun(null);
        	 }
        }
       
        hunger = RandNum.go(1,100);
        fatigue = RandNum.go(1,100);
        infected = infectedStatus;
        ninjaSkill = RandNum.go(1,100); // Fighting skill, this was kind of a joke
    }
    
    // Person constructor that takes all parameters
    public Person(String name, int health, int strength, int hunger, int speed, int fatigue, boolean infected, int ninjaSkill) {
        this.name = name;
        this.health = health;
        this.strength = strength;
        this.hunger = hunger;
        this.speed = speed;
        this.fatigue = fatigue;
        this.infected = infected;
        this.ninjaSkill = ninjaSkill;
    }
    
    ////////// getters and setters //////////////////////
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getHunger() {
        return hunger;
    }

    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    public int getFatigue() {
        return fatigue;
    }

    public void setFatigue(int fatigue) {
        this.fatigue = fatigue;
    }

    public boolean isInfected() {
        return infected;
    }

    public void setInfected(boolean infected) { // This is for when the person turns to a zombie
        this.infected = infected;
        if(infected)
        {
        	setStrength(getStrength()+PersonStatsTypes.zombieStrengthNumerator);
        	setSpeed(getSpeed()+PersonStatsTypes.zombieSpeedNumerator);
        	if(getHealth() > 0)//if - then make posotive first
        	{
        		setHealth((getHealth()*-1) + RandNum.go(1, 50));
        	}
        	else
        	{
        		setHealth(getHealth()+ RandNum.go(1, 50));
        	}
        	
        }
        
    }

    public int getNinjaSkill() {
        return ninjaSkill;
    }

    public void setNinjaSkill(int ninjaSkill) {
        this.ninjaSkill = ninjaSkill;
    }

	public Gun getHasGun() {
		return hasGun;
	}

	public void setHasGun(Gun hasGun) {
		this.hasGun = hasGun;
	}

}
