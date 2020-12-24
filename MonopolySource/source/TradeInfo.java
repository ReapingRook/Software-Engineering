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

public class TradeInfo {

    public static int display(String title, String message) {
        Stage window = new Stage();
        final int res = 1;
        final int retres = 0;
        window.initModality(Modality.NONE);
        window.setTitle(title);
        window.setMinWidth(250);
        Label label = new Label();
        label.setText(message);
        Button Yes = new Button("Yes");
        class ValueHolder { int value ; }
        ValueHolder valueHolder = new ValueHolder();
        valueHolder.value = -1 ;
        Yes.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>()
        {

            @Override
            public void handle(ActionEvent event)
            {
                valueHolder.value = res;
                window.close();
            }

        });
        Button No = new Button("No");
        No.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>()
        {

            @Override
            public void handle(ActionEvent event)
            {
                valueHolder.value = retres ;
                window.close();
            }

        });


        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, Yes, No);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();

        return valueHolder.value;
    }
}
