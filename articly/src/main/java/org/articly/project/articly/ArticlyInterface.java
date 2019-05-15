package org.articly.project.articly;

import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.Group;
import javafx.stage.*;
import java.net.URI;
import java.awt.Desktop;

public class ArticlyInterface extends Application implements EventHandler<ActionEvent> {


    private int numDays;
    private int type;
    private String[] titles;
    private String[] urls;
    private String[] dates;
    private String[] sections;

    Text welcome;
    TextFlow articles;
    Button btDaily;
    Button btWeekly;
    Button btMonthly;
    TextField tfMetrics;
    Image image;
    Hyperlink hyperlink;
    ImageView imageview = new ImageView();

    @Override
    public void start(Stage primaryStage) {
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setHgap(10);
        pane.setVgap(3);

        HBox times = new HBox();
        VBox metrics  = new VBox();
        times.setSpacing(15.0);
        metrics.setSpacing(8.0);

        Group root = new Group();
        Scene scene = new Scene(root, 850, 835, Color.LIGHTGRAY);

        btDaily = new Button("Daily ");
        btDaily.setStyle("-fx-font-size: 12pt;");
        btWeekly = new Button("Weekly");
        btWeekly.setStyle("-fx-font-size: 12pt;");
        btMonthly = new Button("Monthly");
        btMonthly.setStyle("-fx-font-size: 12pt;");

        image = new Image(ArticlyInterface.class.getResourceAsStream("times.jpg"));
        imageview.setFitHeight(150);
        imageview.setFitWidth(825);
        imageview.setImage(image);

        welcome = new Text("Welcome to Articly. Enjoy browsing our vast collection of articles from the New York Times");
        welcome.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 22));
        welcome.setFill(Color.DARKBLUE);

        articles = new TextFlow();

        tfMetrics = new TextField();
        tfMetrics.setMaxWidth(300.0);
        tfMetrics.setAlignment(Pos.CENTER);
        tfMetrics.setFont(Font.font("Times New Roman", FontWeight.BOLD, 20));

        Label metric = new Label("Please Enter Most Viewed, Most Shared, or Most Emailed");
        metric.setTextFill(Color.DARKBLUE);
        metric.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 20));

        ScrollPane sp = new ScrollPane(articles);
        sp.setPrefSize(475.0, 500.0);
        sp.setStyle("-fx-background-color: transparent");

        times.getChildren().addAll(btDaily, btWeekly, btMonthly);
        times.setAlignment(Pos.CENTER);
        metrics.getChildren().addAll(metric, tfMetrics);
        metrics.setAlignment(Pos.CENTER);

        pane.setAlignment(Pos.BOTTOM_CENTER);
        pane.add(imageview, 1, 0);
        pane.add(welcome, 1, 1);
        pane.add(sp, 1, 2);
        pane.add(metrics, 1, 7, 2, 1);
        pane.add(times, 1, 8, 2, 1);

        btDaily.setOnAction(this);
        btWeekly.setOnAction(this);
        btMonthly.setOnAction(this);

        root.getChildren().add(pane);
        primaryStage.setTitle("ARTICLY");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public void openLink(String link){

                try{
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

                titles = Backend.getTitles(numDays, type);
                urls = Backend.getURLs(numDays, type);
                dates = Backend.getPublishedDates(numDays, type);
                sections = Backend.getSections(numDays, type);

        }
        catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void putChildren(){

        for (int i = 0; i < 20; i++) {

            Text separate1 = new Text(System.lineSeparator());
            Text separate2 = new Text(System.lineSeparator());
            Text title = new Text(titles[i]);
            title.setFont(Font.font("Times New Roman", FontWeight.BOLD, 16));
            Text date = new Text(dates[i]);
            date.setFont(Font.font("Times New Roman", FontWeight.BOLD, 16));
            Text section = new Text(sections[i]);
            section.setFont(Font.font("Times New Roman", FontWeight.BOLD, 16));
            hyperlink = new Hyperlink(urls[i]);
            final String link = hyperlink.toString();
            hyperlink.setFont(Font.font("Times New Roman", FontWeight.BOLD, 16));
            articles.getChildren().add(title);
            articles.getChildren().add(date);
            articles.getChildren().add(section);
            articles.getChildren().add(hyperlink);
            articles.getChildren().add(separate1);
            articles.getChildren().add(separate2);
            hyperlink.setOnAction(new EventHandler<ActionEvent>() {

                public void handle(ActionEvent t) {
                    openLink(link);
                }
            });

        }

    }

    public void handle(ActionEvent event) {

            if (tfMetrics.getText().equals("most viewed") || tfMetrics.getText().equals("Most Viewed") || tfMetrics.getText().equals("viewed")) {

                if (event.getSource() == btDaily) {
                    try {
                        type = 1;
                        numDays = 1;
                        populate();
                        articles.getChildren().clear();
                        putChildren();
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }

                if (event.getSource() == btWeekly) {
                    try {
                        type = 1;
                        numDays = 7;
                        populate();
                        articles.getChildren().clear();
                        putChildren();
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }

                if (event.getSource() == btMonthly) {
                    try {
                        type = 1;
                        numDays = 30;
                        populate();
                        articles.getChildren().clear();
                        putChildren();
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }

        if (tfMetrics.getText().equals("most shared") || tfMetrics.getText().equals("Most Shared") || tfMetrics.getText().equals("shared") ) {

            if (event.getSource() == btDaily) {
                try {
                    type = 2;
                    numDays = 1;
                    populate();
                    articles.getChildren().clear();
                    putChildren();
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

            if (event.getSource() == btWeekly) {
                try {
                    type = 2;
                    numDays = 7;
                    populate();
                    articles.getChildren().clear();
                    putChildren();
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

            if (event.getSource() == btMonthly) {
                try {
                    type = 2;
                    numDays = 30;
                    populate();
                    articles.getChildren().clear();
                    putChildren();
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }

        if (tfMetrics.getText().equals("most emailed") || tfMetrics.getText().equals("Most Emailed") || tfMetrics.getText().equals("emailed")) {

            if (event.getSource() == btDaily) {
                try {
                    type = 3;
                    numDays = 1;
                    populate();
                    articles.getChildren().clear();
                    putChildren();
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

            if (event.getSource() == btWeekly) {
                try {
                    type = 3;
                    numDays = 7;
                    populate();
                    articles.getChildren().clear();
                    putChildren();
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

            if (event.getSource() == btMonthly) {
                try {
                    type = 3;
                    numDays = 30;
                    populate();
                    articles.getChildren().clear();
                    putChildren();
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }

    public static void run(String[] args) {
        launch(args);
    }

}