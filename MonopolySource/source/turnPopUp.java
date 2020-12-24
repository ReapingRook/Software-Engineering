package source;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;

import javafx.stage.Stage;

public class turnPopUp extends Application {

    //@Override
    public void start(Stage primaryStage) throws Exception {

        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Turn Options");


        Button rollDice = new Button("Roll");
        Button trade = new Button("Trade");
        Button buyProperty = new Button("Buy Current Property");
        Button buyHousesOrHotels = new Button("Buy House or Hotel");
        Button mortgageProperty = new Button("Mortgage Properties");
        Button endTurn = new Button("End Turn");


        HBox buttonSet = new HBox(rollDice, trade, buyProperty, buyHousesOrHotels, mortgageProperty, endTurn);

        rollDice.setMaxSize(200, 200);
        trade.setMaxSize(200, 200);
        buyProperty.setMaxSize(200, 200);
        buyHousesOrHotels.setMaxSize(200, 200);
        mortgageProperty.setMaxSize(200, 200);
        endTurn.setMaxSize(200, 200);

        rollDice.setOnAction(value -> {
            System.out.println("ROLLING DICE");
        });
        trade.setOnAction(value -> {
            System.out.println("TRADING");
        });
        buyProperty.setOnAction(value -> {
            System.out.println("BUYING PROPERTY");
        });
        buyHousesOrHotels.setOnAction(value -> {
            System.out.println("BUYING HOUSES OR HOTELS");
        });
        mortgageProperty.setOnAction(value -> {
            System.out.println("MORTGAGING PROPERTIES");
        });
        endTurn.setOnAction(value -> {
            System.out.println("ENDING TURN");
        });
        

        primaryStage.setScene(new Scene(buttonSet, 600, 200));


        primaryStage.show();


    }

}
