import java.util.Scanner;
public class ConnectFour{
  public static void main(String[] args){ 
  Scanner sc = new Scanner(System.in);
    //Setting up a 6x7 grid for the Connect 4 game
    char[][] grid = new char[6][7];

    //Filling the board with dots to mark empty spaces. Later, the displayBoard method will divide the board and make it look "cleaner."
    for (int i = 0; i < grid.length; i++){
      for (int j = 0; j < grid.length; j++){
        grid[i][j] = '.';
      }
    }

    //Setting up the red player (R for red), who will go first, and setting a turn value to 1 and a winner boolean value to false, as there is no winner yet.
    int turn = 1;
    char player = 'R';
    boolean winner = false;

    //Main while loop for the program. While there is no winner declared by the program and the program hasn't run 42 turns (6 * 7), then the while loop will continue.
    while (winner == false && turn <= 42){
      boolean validPlay = false;
      int play = 0;

      do{
        //Displaying the board
        displayBoard(grid);

        //Asking the player to choose a column to play in (in Connect 4, you can only play with columns). Then, the validateTurn method will determine whether or not the move is valid.
        System.out.println("Player "  + player + ", choose a column to make your move in: ");
        play = sc.nextInt();

        //This uses the validPlay value from earlier and the validateTurn method defined later in the program to determine whether or not the player's move was valid. If it wasn't the player is asked to play another move.
        validPlay = validateTurn(play, grid);
        if (validPlay == false){
          System.out.println("Sorry, that was an invalid column number to move in. You can only choose between columns 0 and 6. Please choose a valid column: ");
          play = sc.nextInt();
      }
        
        //Uses the isWinner method to determine if there is a winner.
        winner = isWinner(play, grid);

        //Essentially switches the players, so the yellow player can now move.
        if (player == 'R'){
          player = 'Y';
        }
        else{
          player = 'R';
        }
        turn++;
        }

      //If the isWinner method returned a true value, then the game ends. The game could also result in a tie.
      if (winner == true){
        if (player == 'R'){
          System.out.println("Red won!");
        }
        else{
          System.out.println("Yellow won!");
        }
      }
      else{
        System.out.println("It's a tie!? Play again!");
      }
    }

//The displayBoard method decorates the board and makes it neater. It uses the board that was created in the main method and makes it easier to view for the players while playing the game.
public void displayBoard(char[][] grid){
     System.out.println("------------------");
     for (int i = 0; i < grid.length; i++){
       System.out.println("|");
       for (int j = 0; j < grid[0].length; j++){
         System.out.print(grid[row][col]);
         System.out.print("|");
       }
       System.out.println();
       System.out.println("------------------");
     }
     System.out.println();
   }

  //This method validates the player's turn. If there was anything wrong with the player's turn (their move was about of boudns, for example), the turn would be invalidated.
  public static boolean validateTurn(int c, char[][] grid){
    if (c < 0 || c > grid[0].length){
      return false;
    }

    if (grid[0][c] != '.'){
       return false;     
    }
    return true;
  }

  //The isWinner method determines whether or not there's a winner in the game. It tests out every possibility of winning, including up/down, upwards and diagonally, and downwards and diagonally.
  public static boolean isWinner(char player, char[][] grid){
    for (int i = 0; i < grid.length; i++){
      for (int j = 0; j < grid[0].length - 3; j++){
        if (grid[i][j] == player && grid[i][j + 1] == player && grid[i][j + 2] == player && grid[i][j + 3] == player){
          return true;
        }
      }
    }

    for (int i = 0; i < grid.length - 3; i++){
      for (int j = 0; j < grid[0].length; j++){
        if (grid[i][j] == player && grid[i + 1][j] == player && grid[i + 2][j] == player && grid[i + 3][j] == player){
          return true;
        }
      }
    }

    for (int i = 3; i < grid.length; i++){
      for (int j = 0; j < grid[0].length - 3; j++){
        if (grid[i][j] == player && grid[i - 1][j + 1] == player && grid[i -2][j + 2] == player && grid[i - 3][j + 3] == player){
          return true;
        }
      }
    }
    for (int i = 0; i < grid.length - 3; i++){
      for (int j = 0; j < grid[0].length - 3; j++){
        if (grid[i][j] == player && grid[i + 1][j + 1] == player && grid[i + 2][j + 2] == player && grid[i + 3][j + 3] == player){
          return true;
        }
      }
    }
    return false;
  }
  }
  }
