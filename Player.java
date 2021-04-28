import java.util.Random;
import java.util.Scanner;

public class Player {
    /* Private Variables*/
    private int health;
    private int gold;
    private int damage;
    private String playerClass;
    private double lootModifier;
    private Random r = new Random();
    private Scanner s = new Scanner(System.in);

    //setters
    public void setPHealth(int health) {
        this.health = health;
    }

    public void setPGold(int gold) {
        this.gold = gold;
    }

    public void setPDamage(int damage) {
        this.damage = damage;
    }

    public void setPLootModifier(double lootModifier) {
        this.lootModifier = lootModifier;
    }

    public void setPlayerClass(String playerClass) {
        this.playerClass = playerClass;
    }

    //getters
    public int getPHealth() {
        return this.health;
    }

    public int getPGold() {
        return this.gold;
    }

    public int getPDamage() {
        return this.damage;
    }

    public double getPLootModifier() {
        return this.lootModifier;
    }

    public String getPlayerClass(){
        return this.playerClass;
    }


    public void introScene(){
        System.out.println("=================================================");
        System.out.println("you are in a dungeon!!");
        System.out.println("There are monsters, bags of gold, and healing elixirs in each room.");
        System.out.println("Can you find 100 gold pieces and pay the evil professor to let you out before the monsters kill you?");
        System.out.println("Select your class:");
        System.out.println("[1] Warrior");
        System.out.println("[2] Thief");
        System.out.print("==> ");
        int playerClass = s.nextInt();
        System.out.println("=================================================");

        if (playerClass == 1){
            setPHealth(100);
            setPLootModifier(1.0);
            setPDamage(15);
            setPGold(0);
            setPlayerClass("Warrior");
        }else if (playerClass ==2){
            setPHealth(70);
            setPLootModifier(1.2);
            setPDamage(10);
            setPGold(0);
            setPlayerClass("Thief");
        }

    }

    /* Hits the targeted Monster */
    public void attack(Monster target) {
        target.setMHealth(target.getMHealth()- getPDamage());
    }

    /* Removes health from this Player
    when hit by a Monster */
    public void onHit(int damage) {
        setPHealth(getPHealth()-damage);
    }

    /* Adds health to this Player when healed */
    public void onHeal(int health) {
        setPHealth(getPHealth()+health);
    }

    /* Adds gold to this Player when obtained */
    public void onLoot(int gold) {
        setPGold((int)getPLootModifier()*r.nextInt());
    }
}
