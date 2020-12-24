package source;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class MonopolyTitleFont extends Pane {
    private Text text;

    public MonopolyTitleFont(String name) {
        String spaceTitle = "";
        for (char c : name.toCharArray()) {
            spaceTitle += c + " ";
        }

        text = new Text(spaceTitle);
        text.setFont(Font.loadFont(Main.class.getResource("res/ITCKabelStd-Book.otf").toExternalForm(), 85));
        text.setFill(Color.WHITE);
        text.setStroke(Color.BLACK);

        getChildren().addAll(text);
    }

    public double getTitleWidth() {
        return text.getLayoutBounds().getWidth();
    }

    public double getTitleHeight() {
        return text.getLayoutBounds().getHeight();
    }

}
