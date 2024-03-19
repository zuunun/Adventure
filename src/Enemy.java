public class Enemy {
    private String name;
    private String description;
    private int health;
    private Weapon weapon;

    public Enemy(String name, String description, int health, Weapon weapon){
        this.name=name;
        this.description = description;
        this.health = health;
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

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
    public void attack(Player player){
        if(weapon != null){
            int damage = weapon.getDamagePoints();
        }
    }
    public void takeDamage(int damage){
        health -= damage;
        if(health<=0){
            die();
        }
    }
    private void die(){
        System.out.println("The " + name + " has been defeated");
        // Drop weapon to room

        // Remove enemy from room

    }
}
