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

public class ManagePopup {
	public static Property display(String title, String message, Property[] props) {
		
        Stage window = new Stage();
        int i;
        class ValueHolder { Property value ; }
        ValueHolder valueHolder = new ValueHolder();
        valueHolder.value = null ;
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);
        Label label = new Label();
        label.setText(message);
        Button[] buttons = new Button[props.length + 1];
        for(i = 0; i < props.length; i++) {
        	System.out.println("Initializing button " + i + ": " + props[i].name);
        	buttons[i] = new Button(props[i].name);
        	final Property currentProp = props[i];
        	buttons[i].setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>()
            {

                @Override
                public void handle(ActionEvent event)
                {
                    valueHolder.value = currentProp;
                    window.close();
                }

            });
        	
        }
        System.out.println("Initializing cancel button.");
        buttons[i] = new Button("Cancel");
        buttons[i].setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>()
        {

            @Override
            public void handle(ActionEvent event)
            {
                valueHolder.value = null;
                window.close();
            }

        });

        VBox layout = new VBox(10);
        
        layout.getChildren().add(label);
        layout.getChildren().addAll(buttons);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();

        return valueHolder.value;
    }
}