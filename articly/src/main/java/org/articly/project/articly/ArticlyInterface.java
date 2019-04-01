package org.articly.project.articly;

import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
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

import javax.swing.*;


public class ArticlyInterface extends Application implements EventHandler<ActionEvent> {

    Text welcome;
    TextArea articles;
    Button btDaily;
    Button btWeekly;
    Button btMonthly;
    Image image;
    ImageView imageview = new ImageView();

    @Override
    public void start(Stage primaryStage) {
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setHgap(10);
        pane.setVgap(8);

        HBox hbox = new HBox();
        hbox.setSpacing(30.0);

        Group root = new Group();
        Scene scene = new Scene(root, 850, 700, Color.LIGHTGREEN);

        btDaily = new Button("Daily ");
        btDaily.setStyle("-fx-font-size: 12pt;");
        btWeekly = new Button("Weekly");
        btWeekly.setStyle("-fx-font-size: 12pt;");
        btMonthly = new Button("Monthly");
        btMonthly.setStyle("-fx-font-size: 12pt;");

        image = new Image(ArticlyInterface.class.getResourceAsStream("nytimes.jpg"));
        imageview.setFitHeight(150);
        imageview.setFitWidth(825);
        imageview.setImage(image);

        welcome = new Text("Welcome to Articly. Enjoy browsing our vast collection of articles from the New York Times");
        welcome.setFont(Font.font("Times New Roman", FontWeight.BOLD, 20));
        welcome.setFill(Color.CORNFLOWERBLUE);

        articles = new TextArea();
        articles.setMinSize(600.0, 400.0);

        hbox.getChildren().addAll(btDaily, btWeekly, btMonthly);
        hbox.setAlignment(Pos.CENTER);
        pane.setAlignment(Pos.BOTTOM_CENTER);
        pane.add(imageview, 1, 0);
        pane.add(welcome, 1, 1);
        pane.add(articles, 1, 2);
        pane.add(hbox, 1, 8, 2, 1);


        btDaily.setOnAction(this);
        btWeekly.setOnAction(this);
        btMonthly.setOnAction(this);

        ScrollPane sB = new ScrollPane(articles);


        root.getChildren().addAll(pane);
        primaryStage.setTitle("ARTICLY");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public void handle(ActionEvent event) {

        if(event.getSource() == btDaily) {
        	try {
        		int numDays = 1;
                String output = Backend.displayResults(numDays);
                articles.setText(output);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }

        if(event.getSource() == btWeekly) {
            try {
                int numDays = 7;
                String output = Backend.displayResults(numDays);
                articles.setText(output);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        if(event.getSource() == btMonthly) {
            try {
                int numDays = 30;
                String output = Backend.displayResults(numDays);
                articles.setText(output);

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
