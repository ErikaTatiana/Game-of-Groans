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
        DungeonMap map = new DungeonMap(10,10, this.player);
	}
	
	/* Main loop of the game, which handles
	non-combat related user input. Continues
	until the Player either wins or loses. */
    public void play() {
        this.player.introScene();
        System.out.print("");

    }
}
