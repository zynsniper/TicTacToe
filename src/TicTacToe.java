import java.util.*;

public class TicTacToe{
    public static void main(String[] args) {
        char[][] gameBoard = {
            {' ', '|', ' ', '|', ' '},
            {'-', '+', '-', '+', '-'},
            {' ', '|', ' ', '|', ' '},
            {'-', '+', '-', '+', '-'},
            {' ', '|', ' ', '|', ' '}
        };

        Scanner userInput = new Scanner(System.in);

        for(int i = 0; i < gameBoard.length; i++){
            for(int j = 0; j < gameBoard[i].length; j++){
                System.out.print(gameBoard[i][j] + " ");
            }
            System.out.println(); 
        }

        while(!GameLogic.gameEnd(gameBoard)){
            System.out.print("Enter chosen tile (1-9): ");
            int tileNo = userInput.nextInt();
            
            System.out.print("Draw your symbol: ");
            String symbol = userInput.next().toLowerCase();

            int[] coords = GameLogic.chosenTile(tileNo);
            int x = coords[0]; int y = coords[1];
            gameBoard[x][y] = symbol.charAt(0);

            for(int i = 0; i < gameBoard.length; i++){
                for(int j = 0; j < gameBoard[i].length; j++){
                    System.out.print(gameBoard[i][j] + " ");
                }
                System.out.println(); 
            }
        }
        
        userInput.close();
    }
}