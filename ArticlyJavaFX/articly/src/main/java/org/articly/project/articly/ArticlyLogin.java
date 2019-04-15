package org.articly.project.articly;

import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.Group;
import javafx.stage.*;



public class ArticlyLogin extends Application implements EventHandler<ActionEvent> {

    Text welcome;
    TextField tfUsername;
    TextField tfPassword;
    Button btSubmit;
    Button btExit;
    Image image;
    ImageView imageview = new ImageView();

    @Override
    public void start(Stage primaryStage) {

        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER_LEFT);
        pane.setHgap(10);
        pane.setVgap(8);

        HBox hbox = new HBox();
        hbox.setSpacing(10.0);

        Group root = new Group();
        Scene scene = new Scene(root, 425, 325, Color.LIGHTGREEN);

        welcome = new Text();
        tfUsername = new TextField();
        tfPassword = new TextField();
        btSubmit = new Button("Submit ");
        btSubmit.setStyle("-fx-font-size: 12pt;");
        btExit = new Button("Exit");

        image = new Image(ArticlyLogin.class.getResourceAsStream("nytimes.jpg"));
        imageview.setFitHeight(100);
        imageview.setFitWidth(400);
        imageview.setImage(image);

        welcome = new Text("Welcome to Articly. Please Enter Login Credentials");
        welcome.setFont(Font.font("Times New Roman", FontWeight.BOLD, 18));
        welcome.setFill(Color.CORNFLOWERBLUE);

        Label username = new Label("Username: ");
        username.setTextFill(Color.CORNFLOWERBLUE);
        username.setFont(Font.font("Times New Roman", FontWeight.BOLD, 14));
        Label password = new Label("Password: ");
        password.setTextFill(Color.CORNFLOWERBLUE);
        password.setFont(Font.font("Times New Roman", FontWeight.BOLD, 14));

        hbox.getChildren().addAll(btSubmit, btExit);
        pane.add(welcome, 1,1);
        pane.add(imageview, 1,0);
        pane.add(username, 1, 3);
        pane.add(tfUsername, 1,4);
        pane.add(password, 1,5);
        pane.add(tfPassword,1,6);
        pane.add(hbox, 1, 8,2,1);

        btSubmit.setOnAction(this);
        btExit.setOnAction(this);

        root.getChildren().add(pane);
        primaryStage.setTitle("ARTICLY");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public void handle(ActionEvent event) {

        if(event.getSource() == btExit) {
            System.exit(0);
        }

    }

    public static void main(String[] args) {
        launch(args);
    }

}