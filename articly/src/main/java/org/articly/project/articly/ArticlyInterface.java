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
import javafx.scene.text.TextFlow;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.Group;
import javafx.stage.*;
import java.net.URL;
import java.net.URI;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class ArticlyInterface extends Application implements EventHandler<ActionEvent> {


    private int numDays;
    private String[] titles;
    private String[] urls;

    Text welcome;
    TextFlow articles;
    Button btDaily;
    Button btWeekly;
    Button btMonthly;
    Image image;
    Hyperlink hyperlink;
    ImageView imageview = new ImageView();

    @Override
    public void start(Stage primaryStage) {
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setHgap(10);
        pane.setVgap(5);

        HBox hbox = new HBox();
        hbox.setSpacing(20.0);

        Group root = new Group();
        Scene scene = new Scene(root, 850, 800, Color.SLATEGRAY);

        btDaily = new Button("Daily ");
        btDaily.setStyle("-fx-font-size: 12pt;");
        btWeekly = new Button("Weekly");
        btWeekly.setStyle("-fx-font-size: 12pt;");
        btMonthly = new Button("Monthly");
        btMonthly.setStyle("-fx-font-size: 12pt;");

        image = new Image(ArticlyInterface.class.getResourceAsStream("./times.jpg"));
        imageview.setFitHeight(150);
        imageview.setFitWidth(825);
        imageview.setImage(image);

        welcome = new Text("Welcome to Articly. Enjoy browsing our vast collection of articles from the New York Times");
        welcome.setFont(Font.font("Times New Roman", FontWeight.BOLD, 20));
        welcome.setFill(Color.DARKBLUE);

        articles = new TextFlow();
        articles.setMaxWidth(300.0);

        ScrollPane sp = new ScrollPane(articles);
        sp.setPrefSize(150.0, 500.0);

        hbox.getChildren().addAll(btDaily, btWeekly, btMonthly);
        hbox.setAlignment(Pos.CENTER);
        pane.setAlignment(Pos.BOTTOM_CENTER);
        pane.add(imageview, 1, 0);
        pane.add(welcome, 1, 1);
        pane.add(sp, 1, 2);
        pane.add(hbox, 1, 8, 2, 1);

        btDaily.setOnAction(this);
        btWeekly.setOnAction(this);
        btMonthly.setOnAction(this);

        root.getChildren().addAll(pane);
        primaryStage.setTitle("ARTICLY");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public void openLink(String link){

                try{
                    System.out.println(hyperlink.toString());
                    Desktop desktop = java.awt.Desktop.getDesktop();
                    URI oURL = new URI(link.substring(link.indexOf("https"), link.length() - 1));
                    desktop.browse(oURL);
                }

                catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
    }

    private void populate(){
        try {

                titles = Backend.getTitles(numDays);
                urls = Backend.getURL(numDays);

        }
        catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    public void handle(ActionEvent event) {

        if (event.getSource() == btDaily) {
            try {
                numDays = 1;
                populate();
                articles.getChildren().clear();
                for (int i = 0; i < 20; i++) {

                    Text text = new Text(titles[i]);
                    text.setFont(Font.font("Times New Roman", FontWeight.BOLD, 16));

                    hyperlink = new Hyperlink(urls[i]);
                    final String link = hyperlink.toString();
                    hyperlink.setFont(Font.font("Times New Roman", FontWeight.BOLD, 14));
                    articles.getChildren().add(text);
                    articles.getChildren().add(hyperlink);

                    hyperlink.setOnAction(new EventHandler<ActionEvent>() {

                        public void handle(ActionEvent t) {
                            openLink(link);
                        }
                    });
                }
            }
            catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }




        if (event.getSource() == btWeekly) {
            try {
                numDays = 7;
                populate();

                articles.getChildren().clear();
                for (int i = 0; i < 20; i++) {
                    Text text = new Text(titles[i]);
                    text.setFont(Font.font("Times New Roman", FontWeight.BOLD, 16));

                    hyperlink = new Hyperlink(urls[i]);
                    final String link = hyperlink.toString();
                    hyperlink.setFont(Font.font("Times New Roman", FontWeight.BOLD, 14));
                    articles.getChildren().add(text);
                    articles.getChildren().add(hyperlink);

                    hyperlink.setOnAction(new EventHandler<ActionEvent>() {

                        public void handle(ActionEvent t) {
                            openLink(link);
                        }
                    });

                }
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        if (event.getSource() == btMonthly) {
            try {
                numDays = 30;
                populate();
                articles.getChildren().clear();
                for (int i = 0; i < 20; i++) {
                    Text text = new Text(titles[i]);
                    text.setFont(Font.font("Times New Roman", FontWeight.BOLD, 16));
                    hyperlink = new Hyperlink(urls[i]);
                    final String link = hyperlink.toString();
                    hyperlink.setFont(Font.font("Times New Roman", FontWeight.BOLD, 14));
                    articles.getChildren().add(text);
                    articles.getChildren().add(hyperlink);

                    hyperlink.setOnAction(new EventHandler<ActionEvent>() {

                        public void handle(ActionEvent t) {
                            openLink(link);
                        }
                    });
                }
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