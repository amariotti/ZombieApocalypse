package ZombieApocalypse;

/**
 * Created with IntelliJ IDEA.
 * User: Lappy
 * Date: 10/9/12
 * Time: 8:19 PM
 * To change this template use File | Settings | File Templates.
 */
public class Melee extends Weapons {
    private int length;
    private int throwDamage;

    public Melee(int durability, int power, int range, int length, int throwDamage) {
        super(durability, power, range);
        this.length = length;
        this.throwDamage = throwDamage;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getThrowDamage() {
        return throwDamage;
    }

    public void setThrowDamage(int throwDamage) {
        this.throwDamage = throwDamage;
    }
}
