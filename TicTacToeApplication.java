package ticTacToe;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class TicTacToeApplication extends Application {
    private Button[] buttons;
    private Label turn;
    private int turnCount;

    public static void main(String[] args) {
        System.out.println("Hello world!");
        
        launch(TicTacToeApplication.class);
        
        
    }
    
    public TicTacToeApplication() {
        this.buttons = new Button[9];
        this.turn = new Label("Turn: X");
        
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = createButton();
        }
        
        this.turnCount = 0;
    }
    
    public void start(Stage window) throws Exception {
        BorderPane pane = new BorderPane();
        GridPane grid = new GridPane();
        
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setHgap(10);
        grid.setVgap(10);
        
        pane.setTop(this.turn);
        pane.setCenter(grid);
        
        Scene view = new Scene(pane);
        
        grid.add(buttons[0], 0, 0);
        grid.add(buttons[1], 1, 0);
        grid.add(buttons[2], 2, 0);
        grid.add(buttons[3], 0, 1);
        grid.add(buttons[4], 1, 1);
        grid.add(buttons[5], 2, 1);
        grid.add(buttons[6], 0, 2);
        grid.add(buttons[7], 1, 2);
        grid.add(buttons[8], 2, 2);
        
        
//        int k = 0;
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; i < 3; j++) {
//                if ( k < 9) {
//                    grid.add(buttons[k], j, i);
//                    k++;                    
//                }
//            }
//        }
//        
        window.setTitle("TicTacToe");
        window.setScene(view);
        window.show();
    }
    
    private Button createButton() {
        Button button = new Button("");
        button.setFont(Font.font("Monospaced", 40));
        button.setPrefSize(90, 90);
        
        button.setOnAction((event) -> {
            if (this.turn.getText().equals("Turn: X")) {
                button.setText("X");
                button.setDisable(true);
                this.turn.setText("Turn: O");
                this.turnCount++;
                gameOver();
                
            } else {
                button.setText("O");
                button.setDisable(true);
                this.turn.setText("Turn: X");
                this.turnCount++;
                gameOver();
            }
        });
        
        
        return button;
    }
    
    private void gameOver() {
        // check rows
        
        if (this.turnCount == 9) {
            gameOverLabel();
        }
        // check rows
        if ((!buttons[0].getText().isEmpty() && buttons[0].getText().equals(buttons[1].getText()) && buttons[0].getText().equals(buttons[2].getText())) || 
            (!buttons[3].getText().isEmpty() && buttons[3].getText().equals(buttons[4].getText()) && buttons[3].getText().equals(buttons[5].getText())) ||
            (!buttons[6].getText().isEmpty() && buttons[6].getText().equals(buttons[7].getText()) && buttons[6].getText().equals(buttons[8].getText())) ||
            // check columns    
            (!buttons[0].getText().isEmpty() && buttons[0].getText().equals(buttons[3].getText()) && buttons[0].getText().equals(buttons[6].getText())) ||
            (!buttons[1].getText().isEmpty() && buttons[1].getText().equals(buttons[4].getText()) && buttons[4].getText().equals(buttons[7].getText())) ||
            (!buttons[2].getText().isEmpty() && buttons[2].getText().equals(buttons[5].getText()) && buttons[2].getText().equals(buttons[8].getText())) ||
            // check diagonals        
            (!buttons[0].getText().isEmpty() && buttons[0].getText().equals(buttons[4].getText()) && buttons[0].getText().equals(buttons[8].getText())) ||
            (!buttons[2].getText().isEmpty() && buttons[2].getText().equals(buttons[4].getText()) && buttons[2].getText().equals(buttons[6].getText()))){
                gameOverLabel();
        }
    }
    
    private void gameOverLabel() {
        this.turn.setText("The end!");
    }  

}
