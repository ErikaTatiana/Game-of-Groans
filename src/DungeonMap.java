/*Contains the Rooms in the dungeon
        and logic for Player movement **/
public class DungeonMap {
    /* Rooms in the dungeon */
    private Room[][] rooms;
    private int rows;
    private int columns;
    private int playerXPos = 0;
    private int playerYPos = 0;

    /* Reference to the Player in the dungeon */
    private Player player;

    public int getPlayerXPos() {
        return this.playerXPos;
    }
    public int getPlayerYPos() {
        return this.playerYPos;
    }
    public void setPlayerXPos(int xPos) {
        this.playerXPos = xPos;
    }
    public void setPlayerYPos(int yPos) {
        this.playerYPos = yPos;
    }

    /* Initializes the rooms and shared Player reference */
    public DungeonMap (int rows, int columns, Player player){
        rooms = new Room[rows][columns];
        this.rows = rows;
        this.columns = columns;
        this.player = player;
        // New rooms for each row and column
        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < columns; c++) {
                rooms[r][c] = new Room((this.rows)*(this.columns));
            }
        }
        //Does the room we add the player in start a new encounter or is that marked as visited?
    }

    /* Displays the dungeon's rooms, walls,
    and player's current location */
    public void print() {

        //Top Walls
        System.out.print("+");
        for(int i = 0; i < this.rows; i++){
            System.out.print("-");
        }
        System.out.println("+");

        //Side walls and Rooms
        for(int r = 0; r < this.rows; r++) {
            System.out.print("|");
            for(int c = 0; c < this.columns; c++) {
                if (rooms[r][c].hasVisited()) {
                    //Visited room
                    System.out.print("*");
                }
                else if(r == this.playerXPos && c == this.playerYPos) {
                    // Player position
                    System.out.print(player.getPlayerClass());
                    // Not sure if the getClass method is going to give the symbol or the name of the class
                }
                else {
                    //unvisited room
                    System.out.print(" ");
                }
            }
            System.out.println("|");
        }

        // Bottom Walls
        System.out.print("+");
        for(int i = 0; i < this.rows; i++){
            System.out.print("-");
        }
        System.out.println("+");

    }

    //TODO: method(s) to move player
}