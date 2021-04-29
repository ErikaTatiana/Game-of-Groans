import java.util.Scanner;

public class DungeonGame {
    /* Reference to the DungeonMap the Player is in */
    private DungeonMap map;

    /* Reference to the Player in the dungeon */
    private Player player;

    /* Initializes the size of the dungeon */
	public DungeonGame(int rows, int columns) {
	    Player player1 = new Player();
	    this.player = player1;
        this.map = new DungeonMap(10,10, this.player);
	}
	
	/* Main loop of the game, which handles
	non-combat related user input. Continues
	until the Player either wins or loses. */
    public void play() {
        this.player.introScene();
        this.map.print();
        System.out.println("GP = " + this.player.getPGold());
        System.out.println("HP = " + this.player.getPHealth());
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select a door: [W] up, [S] down, [A] left, [D] right ==> ");
        String direction = scanner.nextLine();
        this.map.move(direction);




    }
}
