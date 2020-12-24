package source;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PlayerPopup {
	public static int display(String title, String message, int currPlayerNum) {
		
        Stage window = new Stage();
        final int p1 = 0;
        final int p2 = 1;
        final int p3 = 2;
        final int p4 = 3;
        int buttonCounter = 0;
        class ValueHolder { int value ; }
        ValueHolder valueHolder = new ValueHolder();
        valueHolder.value = -1 ;
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);
        Label label = new Label();
        label.setText(message);
        Button player1 = new Button("Player 1");
        player1.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>()
        {

            @Override
            public void handle(ActionEvent event)
            {
                valueHolder.value = p1;
                window.close();
            }

        });
        
        Button player2 = new Button("Player 2");
        player2.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>()
        {

            @Override
            public void handle(ActionEvent event)
            {
                valueHolder.value = p2 ;
                window.close();
            }

        });

        Button player3 = new Button("Player 3");
        player3.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>()
        {

            @Override
            public void handle(ActionEvent event)
            {
                valueHolder.value = p3 ;
                window.close();
            }

        });
        
        Button player4 = new Button("Player 4");
        player4.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>()
        {

            @Override
            public void handle(ActionEvent event)
            {
                valueHolder.value = p4 ;
                window.close();
            }

        });
        
        Button cancel = new Button("Cancel");
        cancel.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>()
        {

            @Override
            public void handle(ActionEvent event)
            {
                valueHolder.value = -1 ;
                window.close();
            }

        });
        
        VBox layout = new VBox(10);
        layout.getChildren().add(label);
        
        if(currPlayerNum != 0) { layout.getChildren().add(player1); }
        if(currPlayerNum != 1) { layout.getChildren().add(player2); }
        if(currPlayerNum != 2 && GameEngine.numPlayers > 2) { layout.getChildren().add(player3); }
        if(currPlayerNum != 3 && GameEngine.numPlayers > 3) { layout.getChildren().add(player4); }
        layout.getChildren().add(cancel);
        
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();

        return valueHolder.value;
    }
}