public class Enemy {
    private String name;
    private String description;
    private int enemyHealthPoints;
    private Weapon weapon;

    public Enemy(String name, String description, int enemyHealthPoints, Weapon weapon){
        this.name=name;
        this.description = description;
        this.enemyHealthPoints = enemyHealthPoints;
        this.weapon= weapon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getEnemyHealthPoints() {
        return enemyHealthPoints;
    }

    public void setEnemyHealthPoints(int enemyHealthPoints) {
        this.enemyHealthPoints = enemyHealthPoints;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
    // Metode til fjendens angreb
    public void attack(Player player){
        if(weapon != null){
            int damage = weapon.getDamagePoints();
        }
    }

}
