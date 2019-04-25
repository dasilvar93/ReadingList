package ui;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Main extends Application implements EventHandler {

    Button addReading;
    private static List<Readable> readings = new ArrayList<>();
    public static final String TITLE = "Academic Reading List";
    public static final double WIDTH = 600;
    public static final double HEIGHT = 900;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle(TITLE);

        addReading = new Button();
        addReading.setText("Add Reading");

        addReading.setOnAction(this::handle);

        StackPane layout = new StackPane();
        layout.getChildren().add(addReading);

        Scene scene = new Scene(layout, WIDTH, HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    @Override
    public void handle(Event event) {
        if(event.getSource()==addReading){
            //add reading
            System.out.println("Reading Added");
        }
    }
}
