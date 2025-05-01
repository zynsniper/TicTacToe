import java.util.*;

public class TicTacToe{
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        int N;
        do{
            System.out.print("Enter desired board dimension (Min 3): ");
            N = userInput.nextInt();
            if(N < 3)
                System.out.println("Board dimension must be at least 3.");
        }while (N < 3);

        char[][] gameBoard = GameLogic.generateGameBoard(N);
        GameLogic.printGameBoard(gameBoard);

        int turn = 0;
        while(!GameLogic.gameEnd(gameBoard)){
            char playerSymbol = 'X';
            char botSymbol = 'O';
            int tileNo;

            if(turn % 2 == 0){
                System.out.println("Player's turn."); 
                System.out.print("Enter chosen tile (1-9): ");
                tileNo = userInput.nextInt();
                int[] coords = GameLogic.chosenTile(tileNo, N);
                int x = coords[0]; int y = coords[1];
                
                if(gameBoard[x][y] == ' '){
                    gameBoard[x][y] = playerSymbol;
                    turn++;}
                else{ System.out.println("Tile is occupied, pick another tile."); }

                GameLogic.printGameBoard(gameBoard);
            }
            else{
                System.out.println("Bot's turn.");
                tileNo = BotLogic.RandomNumberGenerator();
                int[] coords = GameLogic.chosenTile(tileNo, N);
                int x = coords[0]; int y = coords[1];

                System.out.printf("Bot chose tile %d\n", tileNo);
                if(gameBoard[x][y] == ' '){
                    gameBoard[x][y] = botSymbol;
                    turn++;}
                else{ System.out.println("Tile is occupied, pick another tile."); }

                GameLogic.printGameBoard(gameBoard);
            }
        }
        
        userInput.close();
    }
}