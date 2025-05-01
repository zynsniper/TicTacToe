public class GameLogic {
    public static boolean gameEnd(char[][] gameBoard){
        char winner = connected(gameBoard);
        if(winner != ' '){
            System.out.printf("Player %c wins!\n", winner);
            return true;
        }
        return false;
    }

    public static char connected(char[][] gameBoard){
        int boardSize = gameBoard.length;

        //column check
        for(int i = 0; i < boardSize; i += 2){
            if(gameBoard[i][0] == gameBoard[i][2] && gameBoard[i][2] == gameBoard[i][4])
                return gameBoard[i][0];
        }

        //row check
        for (int i = 0; i < boardSize; i += 2){
            if(gameBoard[0][i] == gameBoard[2][i] && gameBoard[2][i] == gameBoard[4][i])
                return gameBoard[0][i];
        }

        //backward diagonal
        if(gameBoard[0][0] == gameBoard[2][2] && gameBoard[2][2] == gameBoard[4][4]){
            return gameBoard[0][0];
        }

        //forward diagonal
        if(gameBoard[0][4] == gameBoard[2][2] && gameBoard[2][2] == gameBoard[4][0]){
            return gameBoard[0][4];
        }
        
        return ' ';
    }

    public static int[] chosenTile(int tileNo){
        switch (tileNo) {
            case 1:
                return new int[]{0,0};
            case 2:
                return new int[]{0,2};
            case 3:
                return new int[]{0,4};
            case 4:
                return new int[]{2,0};
            case 5:
                return new int[]{2,2};
            case 6:
                return new int[]{2,4};
            case 7:
                return new int[]{4,0};
            case 8:
                return new int[]{4,2};
            case 9:
                return new int[]{4,4};
            
            default:
                return new int[]{-1,-1};
        }
    }

    public static void printGameBoard(char[][] gameBoard){
        for(int x = 0; x < gameBoard.length; x++){
            for(int y = 0; y < gameBoard[x].length; y++){
                System.out.print(gameBoard[x][y] + " ");
            }
            System.out.println(); 
        }
    }

    public static char[][] generateGameBoard(int size){
        int boardSize = size*2 - 1;
        char[][] gameBoard = new char[boardSize][boardSize];

        for(int x = 0; x < boardSize; x++){
            for(int y = 0; y < boardSize; y++){
                if(x % 2 == 0 && y % 2 == 0){
                    gameBoard[x][y] = ' ';
                }
                else if(x % 2 == 0){
                    gameBoard[x][y] = '|';
                }
                else if(y % 2 == 0){
                    gameBoard[x][y] = '-';
                }
                else{
                    gameBoard[x][y] = '+';
                }
            }
        }

        return gameBoard;
    }
}
