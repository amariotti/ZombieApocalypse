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
    
    
    
	public Person()
	{
		
	}
	
    public Person(boolean infectedStatus)
    {
    	name = "fakeName";
        health = RandNum.go(1,100);
        strength = RandNum.go(1,100);
        speed = RandNum.go(1,100);
        hunger = RandNum.go(1,100);
        fatigue = RandNum.go(1,100);
        infected = infectedStatus;
        ninjaSkill = RandNum.go(1,100);
    }

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

    public void setInfected(boolean infected) {
        this.infected = infected;
        if(infected)
        {
        	setStrength(getStrength()+PersonStatsTypes.zombieStrengthNumarator);
        	setSpeed(getSpeed()+PersonStatsTypes.zombieSpeedNumarator);
        	setHealth(getHealth()+ RandNum.go(1, 50));
        }
        
    }

    public int getNinjaSkill() {
        return ninjaSkill;
    }

    public void setNinjaSkill(int ninjaSkill) {
        this.ninjaSkill = ninjaSkill;
    }

}
