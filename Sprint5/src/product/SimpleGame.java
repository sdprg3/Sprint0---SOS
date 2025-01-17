package product;

import javafx.scene.layout.GridPane;

public class SimpleGame extends Game {

    // Constructor for the SimpleGame class, which initializes the game with the provided GameController and board visual.
    // It calls the superclass constructor to set up the game environment and visual board elements.
    public SimpleGame(GameController gameController, GridPane boardVisual) {
        super(gameController, boardVisual);
    }

    // Implements the game logic for the simple mode
    @Override
    public void handleGameModeLogic(boolean didPlayerScore) {
        gameController.refreshScoreBoard(); // Update score display
        
        if (didPlayerScore) {
            // Display win message for the current player and disable board buttons
            gameController.infoDisplay.setText("Game Over! \n" + gameController.getCurrentPlayer().getPlayerColor() + " Player wins!");
            board.setButtonsDisabled(true);
            endGame(); // Call endGame() when a player wins
            
        } else if (getGameLogic().isBoardFull()) {
            // Display draw message if the board is full and no player scored
            gameController.infoDisplay.setText("Game Over! \nIt's a draw");
            board.setButtonsDisabled(true);
            endGame(); // Call endGame() when theres a draw
        } else {
            // Switch to the next player and display the current turn
            gameController.switchPlayer();
            gameController.infoDisplay.setText("Current Turn: " + gameController.getCurrentPlayer().getPlayerColor() + " Player");
        }
    }
}