import controller.ContentController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import model.Content;
import java.io.FileInputStream;
import java.io.FileReader;

import java.io.IOException;

public class Gui extends Application{

    Stage window;

    public static void main(String[] args) throws IOException {
        //Starter interfacet
        launch(args);
    }

    @Override
    //Her skrives alt der skal være i interfacet
    public void start(Stage primaryStage) throws Exception {
        //Det første er en test.
        ContentController test = new ContentController();

        test.initializeContent();
/*      test.customSort(8.5);
        test.search("k");*/
        System.out.println();
        System.out.println();


        window = primaryStage;
        window.setTitle("NemtFlix");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        //Name label
        Label nameLabel = new Label("Username");
        GridPane.setConstraints(nameLabel, 0,0);

        //Name input
        TextField nameInput = new TextField();
        nameInput.setPromptText("Username");
        GridPane.setConstraints(nameInput, 1, 0);

        //Password label
        Label passLabel = new Label("Password");
        GridPane.setConstraints(passLabel, 0,1);

        //Password input
        TextField passInput = new TextField();
        passInput.setPromptText("Password");
        GridPane.setConstraints(passInput, 1,1);

        Button loginButton = new Button("Log In");
        GridPane.setConstraints(loginButton, 1,2);

        grid.getChildren().addAll(nameLabel,nameInput,passLabel,passInput,loginButton);

        BorderPane bP1 = new BorderPane();
        bP1.setStyle("-fx-background-color: DC0505;");
        bP1.setCenter(grid);
        Image logo = new Image(new FileInputStream("C:\\Users\\Oskar\\filmplakater\\netflix-800x400.png"));
        bP1.setTop(new ImageView(logo));
        Scene logIn = new Scene(bP1, 1270, 720);



        ScrollPane scroll = new ScrollPane();

        FlowPane flow = new FlowPane();
        flow.setPadding(new Insets(5, 0, 5, 0));

        flow.setVgap(20);
        flow.setHgap(0);

        flow.setPrefWrapLength(170); // preferred width allows for two columns
        flow.setStyle("-fx-background-color: BLACK;");
        //flow.getChildren().addAll(scroll);

        scroll.setContent(flow);
        scroll.fitToHeightProperty().set(true);
        scroll.fitToWidthProperty().set(true);


        Scene startScene = new Scene(scroll,1300, 720);

        BorderPane bP2 = new BorderPane();
        bP2.setCenter(scroll);
        Button logUd = new Button("Log ud");
        logUd.setOnAction(e -> window.setScene(logIn));
        bP2.setTop(logUd);

        Scene startScene = new Scene(bP2,1270, 720);

        loginButton.setOnAction(e -> window.setScene(startScene));




        for (Content c : test.getContent()){
            Button newButton = new Button();
            newButton.setGraphic(new ImageView(c.getCover()));
            newButton.setStyle(" -fx-background-color: transparent");
            newButton.setOnAction(e -> {
                BorderPane newBorderPane = new BorderPane();
                Button newButton2 = new Button("Tryk her for at gå tilbage");
                newButton2.setStyle(" -fx-background-color: transparent");
                //newButton.setGraphic(new ImageView(c.getCover()));
                newButton2.setOnAction(f -> window.setScene(startScene));
                newBorderPane.setTop(newButton2);
                newBorderPane.setCenter(new ImageView(c.getCover()));

                Scene newScene = new Scene(newBorderPane,1270,720);

                window.setScene(newScene);
            });

            flow.getChildren().addAll(newButton);
        }


        window.setScene(startScene);

        window.setScene(logIn);

        window.show();

    }
}
