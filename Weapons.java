package ZombieApocalypse;

/**
 * Created with IntelliJ IDEA.
 * User: Lappy
 * Date: 10/9/12
 * Time: 8:09 PM
 * To change this template use File | Settings | File Templates.
 */
    abstract class Weapons {
    private int durability;
    private int power;
    private int range;

    protected Weapons() {
    }

    public Weapons(int durability, int power, int range) {
        this.durability = durability;
        this.power = power;
        this.range = range;
    }

    public int getDurability() {
        return durability;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }
}
