package source;

import javafx.beans.binding.Bindings;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class ButtonLook extends Pane {
    private Text text;

    public ButtonLook(String name) {
        Polygon bg = new Polygon(0, 0, 200, 0, 215, 15, 200, 30, 0, 30);
        bg.setStroke(Color.BLACK);

        bg.fillProperty().bind(Bindings.when(pressedProperty()).then(Color.BLACK).otherwise(Color.WHITE));

        text = new Text(name);
        text.setTranslateX(5);
        text.setTranslateY(20);
        text.setFont(Font.loadFont(Main.class.getResource("res/ITCKabelStd-Book.otf").toExternalForm(), 18));
        text.setFill(Color.WHITE);
        text.setStroke(Color.BLACK);

        getChildren().addAll(bg, text);
    }

    public void setOnAction(Runnable action) {
        setOnMouseClicked(e -> action.run());
    }

}
