public class RangedWeapon extends Weapon{
    private int reminingUses;

    public RangedWeapon(String shortName, String longName, int reminingUses){
        super(shortName,longName);
        this.reminingUses = reminingUses;
    }

    public int getReminingUses() {
        return reminingUses;
    }
}
