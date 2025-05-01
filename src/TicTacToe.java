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

        GameLogic.printGameBoard(gameBoard);

        while(!GameLogic.gameEnd(gameBoard)){
            System.out.print("Enter chosen tile (1-9): ");
            int tileNo = userInput.nextInt();
            
            System.out.print("Draw your symbol: ");
            String symbol = userInput.next().toLowerCase();

            int[] coords = GameLogic.chosenTile(tileNo);
            int x = coords[0]; int y = coords[1];
            gameBoard[x][y] = symbol.charAt(0);

            GameLogic.printGameBoard(gameBoard);
        }
        
        userInput.close();
    }
}