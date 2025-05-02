public class GameLogic {
    public static boolean gameEndFX(char[][] board) {
        //rows and columns
        for(int i = 0; i < board.length; i++){
            //row
            if(connected(board[i][0], board[i])) return true;

            //column
            char[] col = new char[board.length];
            for (int j = 0; j < board.length; j++){
                col[j] = board[j][i];
                if (connected(board[0][i], col)) return true;
            }
        }

        //diagonals
        char[] diag1 = new char[board.length];
        char[] diag2 = new char[board.length];
        for(int i = 0; i < board.length; i++){
            //backward
            diag1[i] = board[i][i];
            //forward
            diag2[i] = board[i][board.length - 1 - i];
        }
        return connected(board[0][0], diag1) || connected(board[0][board.length - 1], diag2);
    }

    private static boolean connected(char player, char[] line){
        boolean answer = true;
        if(player == ' ') answer = false;

        for(char c : line){
            if(c != player) answer = false;
        }
        return answer;
    }

    public static char[][] generateGameBoard(int size){
        char[][] board = new char[size][size];
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                board[i][j] = ' ';
            }
        }
        return board;
    }
}
