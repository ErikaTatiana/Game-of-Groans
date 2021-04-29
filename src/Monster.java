import java.util.Random;

public class Monster {
    /**
     * private variables
     */
    private int health;
    private int damage;
    private String monsterType;
    private Random r = new Random();

    /**
     * getters and setters
     */
    public void setMDamage(int damage) {
        this.damage = damage;
    }

    public void setMHealth(int health) {
        this.health = health;
    }

    public int getMDamage() {
        return damage;
    }

    public int getMHealth() {
        return health;
    }

    public String getMonsterType() {
        return monsterType;
    }

    public Monster() {
    /**
     * random choice of what kind of monster appears
     */
        int rnum = r.nextInt(4);
        if (rnum == 0) {
            this.monsterType = "Goblin";
            setMDamage(10);
            setMHealth(6);
        } else if (rnum == 1) {
            this.monsterType = "Zombie";
            setMDamage(15);
            setMHealth(12);
        } else if (rnum == 2) {
            this.monsterType = "Orc";
            setMDamage(20);
            setMHealth(18);
        } else if (rnum == 3) {
            this.monsterType = "Deneke";
            setMDamage(5);
            setMHealth(55);
        }

    }

    /**
     * Hits the targeted Player
     * @param target which player is being targetted
     */
    public void attack(Player target) {
        System.out.println("The " + this.monsterType + " attacks and hits you for " + getMDamage() + " damage!");
        target.onHit(getMDamage());
    }

    /**
     * Removes health from this Monster when hit by a Player
     * @param damage damage taken in by monster
     */
    public void onHit(int damage) {
        setMHealth(getMHealth() - damage);
        if(getMHealth() <= 0) {
            System.out.println("The " + this.monsterType+ " dies!");
        }
    }
}
