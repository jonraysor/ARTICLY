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



public class ArticlyInterface extends Application implements EventHandler<ActionEvent> {

    Text welcome;
    TextField tfNumberOfDays;
    Button btSubmit;
    Image image;
    ImageView imageview = new ImageView();

    @Override
    public void start(Stage primaryStage) {
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setHgap(10);
        pane.setVgap(8);

        HBox hbox = new HBox();
        hbox.setSpacing(10.0);

        Group root = new Group();
        Scene scene = new Scene(root, 850, 700, Color.LIGHTGREEN);

        welcome = new Text();
        tfNumberOfDays = new TextField();
        tfNumberOfDays.setMaxSize(50, Region.USE_PREF_SIZE);
        btSubmit = new Button("Submit ");
        btSubmit.setStyle("-fx-font-size: 8pt;");

        image = new Image(ArticlyLogin.class.getResourceAsStream("nytimes.jpg"));
        imageview.setFitHeight(150);
        imageview.setFitWidth(825);
        imageview.setImage(image);

        welcome = new Text("Welcome to Articly. Enjoy browsing our vast collection of articles from the New York Times");
        welcome.setFont(Font.font("Times New Roman", FontWeight.BOLD, 20));
        welcome.setFill(Color.CORNFLOWERBLUE);

        Label numberOfDays = new Label("Please enter a number 1, 7, or 30 to view articles from previous day, week, or month");
        numberOfDays.setTextFill(Color.CORNFLOWERBLUE);
        numberOfDays.setFont(Font.font("Times New Roman", FontWeight.BOLD, 16));

        hbox.getChildren().addAll(btSubmit);
        pane.setAlignment(Pos.BOTTOM_CENTER);
        pane.add(imageview, 1, 0);
        pane.add(welcome, 1, 1);
        pane.add(numberOfDays, 1, 5);
        pane.add(tfNumberOfDays, 1, 6);
        pane.add(hbox, 1, 8, 2, 1);

        btSubmit.setOnAction(this);

        root.getChildren().add(pane);
        primaryStage.setTitle("ARTICLY");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void handle(ActionEvent event) {

        if(event.getSource() == btSubmit) {
        	try {
        		int numDays = Integer.parseInt(tfNumberOfDays.getText());				
        		Backend.runBackend(numDays);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }

    }

    public static void run(String[] args) {
        launch(args);
    }

}
