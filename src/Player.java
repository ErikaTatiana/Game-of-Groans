import java.util.Random;
import java.util.Scanner;

public class Player {
    /**
     * Private Variables
     **/
    private int health;
    private int gold;
    private int damage;
    private String playerClass;
    private double lootModifier;
    private int maxHealth;
    private Random r = new Random();
    private Scanner s = new Scanner(System.in);

    /**
     * getters and setters
     **/
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

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    /**
     * Intro Secne is just the first 'page' to set the players class and thus the variables for the rest of the game
     */
    public void introScene() {
        System.out.println("=================================================");
        System.out.println("you are in a dungeon!!");
        System.out.println("There are monsters, bags of gold, and healing elixirs in each room.");
        System.out.println("Can you find 100 gold pieces and pay the evil professor to let you out before the monsters kill you?");
        System.out.println("Select your class:");
        System.out.println("[W] Warrior");
        System.out.println("[T] Thief");
        System.out.print("==> ");
        String playerClass = s.nextLine();
        System.out.println("=================================================");

        if (playerClass.equalsIgnoreCase("w")) {
            setPHealth(100);
            setPLootModifier(1.0);
            setPDamage(15);
            setPGold(0);
            setPlayerClass("W");
            setMaxHealth(100);
            setPHealth(getMaxHealth());
        } else if (playerClass.equalsIgnoreCase("t")) {
            setPHealth(70);
            setPLootModifier(1.2);
            setPDamage(10);
            setPGold(0);
            setPlayerClass("T");
            setMaxHealth(70);
            setPHealth(getMaxHealth());
        }
        else {
            /** This is the easy way of dealing with wrong input lol." **/
            System.out.println("Input not recognized. Game over.");
            System.exit(0);
        }

    }

    /**
     * Hits the targeted Monster
     *
     * @param target is the monster you target in the room
     */
    public void attack(Monster target) {
        System.out.println("You attack and hit " + target.getMonsterType() + " for " + getPDamage() + " damage!");
        target.onHit(getPDamage());
    }

    /**
     * Removes health from this Player when hit by a Monster
     * makes sure the minimum health is 0 where you lose the game
     *
     * @param damage is damage delt by the monster
     */
    public void onHit(int damage) {
        setPHealth(getPHealth() - damage);
        if(getPHealth() <= 0) {
            System.out.println("You have died! Game over! \n =================================================");
        }
    }

    /**
     * Adds health to this Player when healed
     * maxs sure the max health is maxed by the playerclass
     *
     * @param health health added by elixer
     */
    public void onHeal(int health) {
        if ((getPHealth() + health) >= getMaxHealth()) {
            setPHealth(getMaxHealth());
        } else {
            setPHealth(getPHealth() + health);
        }
    }

    /**
     * Adds gold to this Player when obtained
     *
     * @param gold determined by loot
     */
    public void onLoot(int gold) {
        setPGold(((int) getPLootModifier() * gold)+getPGold());
        if(getPGold() >= 100) {
            System.out.print("Congratulations, you have successfully exited the dungeon!");
        }
    }
}
