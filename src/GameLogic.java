public class GameLogic {
    public static boolean gameEndFX(char[][] board) {
        int N = board.length;

        // Rows and Columns
        for (int i = 0; i < N; i++) {
            if (checkLine(board[i][0], board[i])) return true;
            char[] col = new char[N];
            for (int j = 0; j < N; j++) col[j] = board[j][i];
            if (checkLine(board[0][i], col)) return true;
        }

        // Diagonals
        char[] diag1 = new char[N];
        char[] diag2 = new char[N];
        for (int i = 0; i < N; i++) {
            diag1[i] = board[i][i];
            diag2[i] = board[i][N - 1 - i];
        }
        return checkLine(board[0][0], diag1) || checkLine(board[0][N - 1], diag2);
    }

    private static boolean checkLine(char player, char[] line) {
        if (player == ' ') return false;
        for (char c : line) {
            if (c != player) return false;
        }
        return true;
    }

    public static char[][] generateGameBoard(int size) {
        char[][] board = new char[size][size];
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                board[i][j] = ' ';
        return board;
    }
}