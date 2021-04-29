/**Contains the Rooms in the dungeon
        and logic for Player movement **/
public class DungeonMap {
    /* Rooms in the dungeon */
    private Room[][] rooms;
    private int rows;
    private int columns;
    private int playerRow = 0;
    private int playerCol = 0;

    /** Reference to the Player in the dungeon */
    private Player player;

    public int getPlayerCol() {
        return this.playerCol;
    }
    public int getPlayerRow() {
        return this.playerRow;
    }
    public void setPlayerCol(int xPos) {
        this.playerCol = xPos;
    }
    public void setPlayerRow(int yPos) {
        this.playerRow = yPos;
    }

    /** Initializes the rooms and shared Player reference */
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
        rooms[getPlayerRow()][getPlayerCol()].setVisited();
    }

    /** Displays the dungeon's rooms, walls,
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
                if(r == this.playerRow && c == this.playerCol) {
                    // Player position
                    System.out.print(player.getPlayerClass());
                }
                else if (rooms[r][c].hasVisited()) {
                    //Visited room
                    System.out.print("*");
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

    /**
     * Player movement
     * @param direction which way the player wishes to go
     */
    public void move(String direction) {
        if(direction.equalsIgnoreCase("W")) {
            if(this.playerRow == 0) {
                System.out.println("You can't move up! There is a wall!");
            }
            else {
                setPlayerRow(this.getPlayerRow()-1);
            }
        }
        else if(direction.equalsIgnoreCase("A")) {
            if(this.playerCol == 0) {
                System.out.println("You can't move Left! There is a wall!");
            }
            else {
                setPlayerCol(getPlayerCol()-1);
            }
        }
        else if(direction.equalsIgnoreCase("S")) {
            if(this.playerRow == this.rows-1) {
                System.out.println("You can't move Down! There is a wall!");
            }
            else {
                setPlayerRow(getPlayerRow()+1);
            }
        }
        else if(direction.equalsIgnoreCase("D")) {
            if(this.playerCol == this.columns-1) {
                System.out.println("You can't move Right! There is a wall!");
            }
            else {
                setPlayerCol(getPlayerCol()+1);
            }
        }
        else {
            System.out.println("Input not recognized");
        }
        rooms[this.playerRow][this.playerCol].enter(this.player);
    }
}