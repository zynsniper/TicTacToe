import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.geometry.Pos;

public class TicTacToeFX extends Application {
    private int boardSize;
    private char currentPlayer = 'X';
    private char[][] gameBoard;
    private GridPane boardPane = new GridPane();
    private Label statusLabel = new Label("Enter board size to start:");
    private TextField sizeInput = new TextField();
    private Button startButton = new Button("Start Game");

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);

        HBox inputBox = new HBox(10, new Label("Board size (min 3):"), sizeInput, startButton);
        inputBox.setAlignment(Pos.CENTER);

        startButton.setOnAction(e -> {
            try {
                boardSize = Integer.parseInt(sizeInput.getText());
                if (boardSize < 3) {
                    statusLabel.setText("Size must be at least 3.");
                    return;
                }
                gameBoard = GameLogic.generateGameBoard(boardSize);
                buildBoard();
                statusLabel.setText("Player X's turn.");
            } catch (NumberFormatException ex) {
                statusLabel.setText("Invalid input.");
            }
        });

        root.getChildren().addAll(inputBox, statusLabel, boardPane);
        primaryStage.setScene(new Scene(root, 600, 600));
        primaryStage.setTitle("Tic-Tac-Toe FX");
        primaryStage.show();
    }

    private void buildBoard() {
        boardPane.getChildren().clear();
        boardPane.setGridLinesVisible(true);

        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                Button tile = new Button(" ");
                tile.setPrefSize(80, 80);
                int row = i;
                int col = j;

                tile.setOnAction(e -> {
                    if (gameBoard[row][col] == ' ') {
                        gameBoard[row][col] = currentPlayer;
                        tile.setText(String.valueOf(currentPlayer));

                        if (GameLogic.gameEndFX(gameBoard)) {
                            statusLabel.setText("Player " + currentPlayer + " wins!");
                            disableBoard();
                        } else {
                            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                            statusLabel.setText("Player " + currentPlayer + "'s turn.");
                        }
                    }
                });

                boardPane.add(tile, j, i);
            }
        }
    }

    private void disableBoard() {
        boardPane.setDisable(true);
    }

    public static void main(String[] args) {
        launch(args);
    }
}