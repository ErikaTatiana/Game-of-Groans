import java.util.Random;
//test change

public class Monster {
    private int health;
    private int damage;
    private String monsterType;
    private Random r = new Random();

    public void setMDamage(int damage) {
        this.damage = damage;
    }

    public void setMHealth(int health){
        this.health=health;
    }
    public void setMonsterType(String monsterType) {
        this.monsterType = monsterType;
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
    public void MonsterChoice(){
        int rnum=r.nextInt(4);
        if(rnum==0){
            this.monsterType = "Goblin";
            setMDamage(10);
            setMHealth(6);
        }else if(rnum==1){
            this.monsterType = "Zombie";
            setMDamage(15);
            setMHealth(12);
        }else if(rnum==2){
            this.monsterType = "Orc";
            setMDamage(20);
            setMHealth(18);
        }else if(rnum==3){
            this.monsterType = "Deneke";
            setMDamage(5);
            setMHealth(55);
        }

    }
    /* Hits the targeted Player */
    public void attack(Player target) {
        target.setPHealth(target.getPHealth()-getMDamage());
    }

    /* Removes health from this Monster
    when hit by a Player */
    public void onHit(int damage) {
        setMHealth(getMHealth()-damage);
    }
}