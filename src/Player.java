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
    int maxHealth = 0;

    public int getPHealth() {
        return this.health;
    }

    public void setPHealth(int health) {
        this.health = health;
    }

    public int getPGold() {
        return this.gold;
    }

    public void setPGold(int gold) {
        this.gold = gold;
    }

    public int getPDamage() {
        return this.damage;
    }

    public void setPDamage(int damage) {
        this.damage = damage;
    }

    public double getPLootModifier() {
        return this.lootModifier;
    }

    public void setPLootModifier(double lootModifier) {
        this.lootModifier = lootModifier;
    }

    public String getPlayerClass() {
        return this.playerClass;
    }

    public void setPlayerClass(String playerClass) {
        this.playerClass = playerClass;
    }

    public void introScene() {
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

        if (playerClass == 1) {
            setPHealth(100);
            setPLootModifier(1.0);
            setPDamage(15);
            setPGold(0);
            setPlayerClass("W");
            maxHealth = 100;
        } else if (playerClass == 2) {
            setPHealth(70);
            setPLootModifier(1.2);
            setPDamage(10);
            setPGold(0);
            setPlayerClass("T");
            maxHealth = 70;
        }

    }

    /* Hits the targeted Monster */
    public void attack(Monster target) {
        target.setMHealth(target.getMHealth() - getPDamage());
    }

    /* Removes health from this Player
    when hit by a Monster */
    public void onHit(int damage) {
        if ((getPHealth() + health) < 0) {
            setPHealth(0);
        } else {
            setPHealth(getPHealth() - damage);
        }

    }

    /* Adds health to this Player when healed */
    public void onHeal(int health) {
        if ((getPHealth() + health) >= maxHealth) {
            setPHealth(maxHealth);
        } else {
            setPHealth(getPHealth() + health);
        }
    }

    /* Adds gold to this Player when obtained */
    public void onLoot(int gold) {
        setPGold((int) getPLootModifier() * r.nextInt());
    }
}
