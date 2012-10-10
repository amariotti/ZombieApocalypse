package ZombieApocalypse;

/**
 * Created with IntelliJ IDEA.
 * User: Lappy
 * Date: 10/9/12
 * Time: 8:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class Explosive extends Weapons {
    private int blastRadius;
    private int type;

    public Explosive(int durability, int power, int range, int blastRadius, int type) {
        super(durability, power, range);
        this.blastRadius = blastRadius;
        this.type = type;
    }

    public int getBlastRadius() {
        return blastRadius;
    }

    public void setBlastRadius(int blastRadius) {
        this.blastRadius = blastRadius;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
