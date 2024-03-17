public class RangedWeapon extends Weapon {
    private int remainingUses;

    public RangedWeapon(String shortName, String longName, int remainingUses) {
        super(shortName, longName);
        this.remainingUses = remainingUses;
    }

    public int getRemainingUses() {
        return remainingUses;
    }
    // Override method to get remaining uses for ranged weapons
    @Override
    public int remainingUses() {
        return remainingUses;
    }

    // Method to decrement remaining uses
    public void decrementRemainingUses() {
        remainingUses--;
    }
}

