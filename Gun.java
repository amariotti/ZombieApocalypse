package ZombieApocalypse;

/**
 * Created with IntelliJ IDEA.
 * User: Lappy
 * Date: 10/9/12
 * Time: 8:16 PM
 * To change this template use File | Settings | File Templates.
 */
public class Gun extends Weapons{
    private int ammo;
    
    public Gun()
    {
    	super(RandNum.go(1,10), RandNum.go(25,50), RandNum.go(1,10));
        this.ammo = RandNum.go(1,40);
    }

    public Gun(int durability, int power, int range, int ammo) {
        super(durability, power, range);
        this.ammo = ammo;
    }

    public int getAmmo() {
        return ammo;
    }

    public void setAmmo(int ammo) {
        this.ammo = ammo;
    }
}
