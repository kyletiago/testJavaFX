package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    Stage window;
    Button button;
    Scene scene1, scene2, scene3, scene4, scene5, scene6;

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{

        window = primaryStage;

        window.setOnCloseRequest(event -> {
            event.consume();
            closeProgram();
        });

        //First page
        HBox topMenu = new HBox();
        Button button1 = new Button("change the title");
        button1.setOnAction(event -> window.setTitle("nigga"));

        Button button2 = new Button("click me");
        button2.setOnAction(event -> window.setScene(scene2));

        Button button5 = new Button("Close program");
        button5.setOnAction(event -> closeProgram());

        topMenu.getChildren().addAll(button1, button2, button5);
        scene1 = new Scene(topMenu, 300,250);


        //Second Page
        VBox leftMenu = new VBox();
        Button button3 = new Button("bet u wont");
        button3.setOnAction(event -> window.setScene(scene1));

        Button button4 = new Button("click for alert");
        button4.setOnAction(event -> {
            boolean result = ConfirmationBox.display("title","are you a nigga?");
            System.out.println(result);
        });

        Button button6 = new Button("login page");
        button6.setOnAction(event -> window.setScene(scene3));

        leftMenu.getChildren().addAll(button3, button4, button6);
        leftMenu.setAlignment(Pos.CENTER);
        scene2 = new Scene(leftMenu, 600,500);


        //Third page
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        Label nameLabel = new Label("Username");
        GridPane.setConstraints(nameLabel, 0, 0);
        TextField nameInputNew = new TextField();
        GridPane.setConstraints(nameInputNew, 1, 0);

        Label passLabel = new Label("Password");
        GridPane.setConstraints(passLabel, 0, 1);
        TextField passInput = new TextField();
        passInput.setPromptText("password");
        GridPane.setConstraints(passInput, 1, 1);

        Button loginButton = new Button("Login");
        GridPane.setConstraints(loginButton,1,2);
        loginButton.setOnAction(event -> ConfirmationBox.display("Login Page","Are you a bot?"));

        Button button7 = new Button("Integer Verification");
        button7.setOnAction(event -> window.setScene(scene4));
        GridPane.setConstraints(button7, 2,2);

        grid.getChildren().addAll(nameLabel,nameInputNew,passLabel,passInput,loginButton,button7);

        scene3 = new Scene(grid, 300, 350);

        //Fourth Page
        VBox layout3 = new VBox();
        TextField numInput = new TextField();
        Button numConfirm = new Button("Confirm new button");
        numConfirm.setOnAction(event -> isInt(numInput, numInput.getText()));

        Button button8 = new Button("Checkbox");
        button8.setOnAction(event -> window.setScene(scene5));

        layout3.getChildren().addAll(numInput,numConfirm, button8);
        scene4 = new Scene(layout3, 400,500);

        //Fifth Page
        VBox layout4 = new VBox();
        CheckBox box1 = new CheckBox("bacon");
        CheckBox box2 = new CheckBox("eggs");

        Button checkConfirm = new Button("Confirm Food");
        checkConfirm.setOnAction(event -> handleOptions(box1,box2));

        Button button9 = new Button("Drop down menu");
        button9.setOnAction(event -> window.setScene(scene6));


        layout4.getChildren().addAll(box1,box2,checkConfirm, button9);
        scene5 = new Scene(layout4,500,600);

        //Sixth Page
        VBox layout5 = new VBox();

        ChoiceBox<String> choiceBox = new ChoiceBox<>();

        Label desc1 = new Label("Who's ur favourite");
        choiceBox.getItems().addAll("Catherine","Food","Sleep");
        choiceBox.setValue("Catherine");

        Button choiceConfirm = new Button("Confirm Choice");
        choiceConfirm.setOnAction(event -> getChoice(choiceBox));

        layout5.getChildren().addAll(desc1, choiceBox, choiceConfirm);
        scene6 = new Scene(layout5, 500, 600);

        //Start window
        window.setScene(scene1);
        window.setTitle("yeetmobile");
        window.show();
    }

    private void closeProgram(){
        Boolean answer = ConfirmationBox.display("title","Do you want to exit?");
        if(answer == true){
            window.close();
        }

    }

    private boolean isInt(TextField input, String message){
        try{
            int age = Integer.parseInt(input.getText());
            System.out.println("Number: "+ age);
            return true;
        }catch(NumberFormatException event){
            System.out.println("Error: " + message + " is not a number");
            return false;
        }
    }

    private void handleOptions(CheckBox box1, CheckBox box2){
        String message = "Order:\n";

        if(box1.isSelected())
            message += "Bacon\n";


        if(box2.isSelected())
            message += "Eggs\n";

        System.out.println(message);
    }

    private void getChoice(ChoiceBox<String> choiceBox){
        String food = choiceBox.getValue();
        System.out.println("you get: " + food);
    }
}