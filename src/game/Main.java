package game;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application{
    private @FXML Button button_one;
    private @FXML Button button_two;
    private @FXML Button button_three;
    private @FXML Button button_four;
    private @FXML Button button_five;
    private @FXML Button button_six;
    private @FXML Button button_seven;
    private @FXML Button button_eight;
    private @FXML Button button_nine;
    private @FXML Canvas canvas;

    private GameBoard gameBoard;
    private int selectedRow;
    private int selectedColumn;

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sudoku.fxml"));
        loader.setController(this);

        Parent root = loader.load();
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/game/sudoku.css");

        initGame();

        primaryStage.setTitle("Sudoku");
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }


    private void initGame(){
        gameBoard = new GameBoard();
        GraphicsContext context = canvas.getGraphicsContext2D();
        drawCanvas(context);

        selectedColumn = 0;
        selectedRow = 0;


    }

    public void drawCanvas(GraphicsContext context){
        context.clearRect(0, 0, 450, 450);

        for(int row = 0; row<9; row++) {
            for(int col = 0; col<9; col++) {

                int positionY = row * 50 + 2;
                int positionX = col * 50 + 2;

                int width = 46;
                context.setFill(Color.WHITE);

                context.fillRoundRect(positionX, positionY, width, width, 8, 8);
            }
        }

        context.setStroke(Color.RED);
        context.setLineWidth(2);
        context.strokeRoundRect(selectedColumn * 50 + 2, selectedRow * 50 + 2, 46, 46, 10, 10);

        initBoard(context);
        setPlayerNumbers(context);
        setFinished(context);
    }

    private void initBoard(GraphicsContext context){
        int[][] initial = gameBoard.getInitial();

        // for loop is the same as before
        for(int row = 0; row<9; row++) {
            for(int col = 0; col<9; col++) {

                int positionY = row * 50 + 30;
                int positionX = col * 50 + 20;

                context.setFill(Color.BLACK);
                context.setFont(new Font(20));

                if(initial[row][col]!=0) {
                    context.fillText(initial[row][col] + "", positionX, positionY);
                }
            }
        }
    }

    private void setPlayerNumbers(GraphicsContext context){
        int[][] player = gameBoard.getPlayer();

        for(int row = 0; row<9; row++) {
            for(int col = 0; col<9; col++) {

                int positionY = row * 50 + 30;
                int positionX = col * 50 + 20;

                context.setFill(Color.PURPLE);
                context.setFont(new Font(20));

                if(player[row][col]!=0) {
                    context.fillText(player[row][col] + "", positionX, positionY);
                }
            }
        }
    }

    private void setFinished(GraphicsContext context){
        if(gameBoard.checkForSuccess()) {
            context.clearRect(0, 0, 450, 450);
            context.setFill(Color.GREEN);
            context.setFont(new Font(36));
            context.fillText("SUCCESS!", 150, 250);
        }
    }

    @FXML
    private void canvasBoxSelected(){

        canvas.setOnMouseClicked(event -> {

            int mouseX = (int) event.getX();
            int mouseY = (int) event.getY();

            selectedRow = (mouseY / 50); // update player selected row
            selectedColumn = (mouseX / 50); // update player selected column

            //get the canvas graphics context and redraw
            drawCanvas(canvas.getGraphicsContext2D());
        });
    }

    @FXML
    public void buttonOneClicked() {
        gameBoard.modifyPlayer(1, selectedRow, selectedColumn);
        drawCanvas(canvas.getGraphicsContext2D());
    }

    @FXML
    public void buttonTwoClicked() {
        gameBoard.modifyPlayer(2, selectedRow, selectedColumn);
        drawCanvas(canvas.getGraphicsContext2D());
    }

    @FXML
    public void buttonThreeClicked() {
        gameBoard.modifyPlayer(3, selectedRow, selectedColumn);
        drawCanvas(canvas.getGraphicsContext2D());
    }

    @FXML
    public void buttonFourClicked() {
        gameBoard.modifyPlayer(4, selectedRow, selectedColumn);
        drawCanvas(canvas.getGraphicsContext2D());
    }

    @FXML
    public void buttonFiveClicked() {
        gameBoard.modifyPlayer(5, selectedRow, selectedColumn);
        drawCanvas(canvas.getGraphicsContext2D());
    }

    @FXML
    public void buttonSixClicked() {
        gameBoard.modifyPlayer(6, selectedRow, selectedColumn);
        drawCanvas(canvas.getGraphicsContext2D());
    }

    @FXML
    public void buttonSevenClicked() {
        gameBoard.modifyPlayer(7, selectedRow, selectedColumn);
        drawCanvas(canvas.getGraphicsContext2D());
    }

    @FXML
    public void buttonEightClicked() {
        gameBoard.modifyPlayer(8, selectedRow, selectedColumn);
        drawCanvas(canvas.getGraphicsContext2D());
    }

    @FXML
    public void buttonNineClicked() {
        gameBoard.modifyPlayer(9, selectedRow, selectedColumn);
        drawCanvas(canvas.getGraphicsContext2D());
    }

}
