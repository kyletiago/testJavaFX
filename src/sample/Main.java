package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    Stage window;
    Button button;
    Scene scene1, scene2;

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{

        window = primaryStage;

        Button button1 = new Button("change the title");
        button1.setOnAction(event -> window.setTitle("nigga"));

        Button button2 = new Button("click me");
        button2.setOnAction(event -> window.setScene(scene2));


        VBox layout1 = new VBox();
        layout1.getChildren().addAll(button1, button2);
        scene1 = new Scene(layout1, 300,250);

        Button button3 = new Button("bet u wont");
        button3.setOnAction(event -> window.setScene(scene1));


        StackPane layout2 = new StackPane();
        layout2.getChildren().addAll(button3);
        scene2 = new Scene(layout2, 600,500);

        window.setScene(scene1);
        window.setTitle("yeetmobile");
        window.show();
    }

}