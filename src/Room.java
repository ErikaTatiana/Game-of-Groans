import java.util.Random;
import java.util.Scanner;

/* Represents a Room in the Dungeon, where
encounters with Monsters and Loot occur */
public class Room {
    /* Indicates whether or not this Room
    instance has been visited already */
    private boolean visited;
    private final int avgGoldperRoom;

    public Room(int totalRooms) {
        this.visited = false;
        //This is how much gold per room will get you 100 gold if you get gold in 1/5 of the rooms
        this.avgGoldperRoom = (100/(totalRooms/5));
    }

    /* Handles encounter logic when a Player
    enters this Room. Includes combat resolution
    and obtaining loot. */
    public void enter(Player player) {
        System.out.println("You open a door and move to the next room...");
        if(!this.visited) {
            String encounter = randomEncounter();
            if(encounter.equals("Monster")) {
                Monster monster = new Monster();
                System.out.println("A " + monster.getMonsterType() + " has appeared!");
                fight(player, monster);
            }
            else if(encounter.equals("Loot")) {
                System.out.println("You have found gold!");
                Random random = new Random();
                int goldDeviation = 3 - random.nextInt(6);
                player.onLoot(goldDeviation + this.avgGoldperRoom);
                System.out.println("You found " + goldDeviation + this.avgGoldperRoom + " gold. This gives you a total of " + player.getPGold() + " gold!");
            }
            else {
                System.out.println("You have found a healing elixir! ");
                Random random = new Random();
                player.onHeal(30);
                System.out.println("You have gained 30 health! Your health is now: " + player.getPHealth());
            }
        }
        else {
            System.out.println("You have visited this room before. ");
        }
        this.setVisited();

    }

    // Setup for new Rooms
    public String randomEncounter()  {
        Random random = new Random();
        int randomNumber = random.nextInt(2);
        if(randomNumber == 0) {
            return "Monster";
        }
        else {
            randomNumber = random.nextInt(2);
            if (randomNumber == 0) {
                return "Loot";
            } else {
                return "Healing";
            }
        }
    }

    // Fight sequence
    public void fight(Player player, Monster monster) {
        Scanner scanner = new Scanner(System.in);
        if(player.getPHealth() > 0 && monster.getMHealth() > 0) {
            System.out.println("Would you like to run or fight the " + monster.getMonsterType() + " ? ([R] or [F])");
            String decision = scanner.nextLine();
            if (decision.equalsIgnoreCase("r")) {
                monster.attack(player);

            } else if (decision.equalsIgnoreCase("f")) {
                //fight sequence
                if (player.getPHealth() > 0 && monster.getMHealth() > 0) {
                    monster.attack(player);
                    if (player.getPHealth() > 0) {
                        player.attack(monster);
                        fight(player, monster);
                    }
                }
            } else {
                System.out.print("Input not recognized, please try again.");
                this.fight(player, monster);
            }
        }
    }


    /* Accessor for the visited field */
    public boolean hasVisited() {
        return this.visited;
    }

    public void setVisited() {
        this.visited = true;
    }
}