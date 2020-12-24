package source;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Pair;

import static source.Main.numplayers;
import static source.Main.numturns;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main extends Application {
    private static final int WIDTH = 1280;
    private static final int HEIGHT = 720;
    private Stage window;
    private Scene titleScene, selectOptionScene, game2;
    private Pane titleRoot = new Pane();
    private VBox menuBox = new VBox(-5);
    private Pane selectRoot = new Pane();
    private VBox selectBox = new VBox(-5);

    
    FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
    public Pane paneTwo = loader.load();
    
    public static int numplayers;
    public static int numturns;

    private List<Pair<String, Runnable>> menuOptions = Arrays.asList(
            new Pair<String, Runnable>("Start Game", () -> {
                window.setScene(selectOptionScene);
            }),
            new Pair<String, Runnable>("Exit to Desktop", Platform::exit)
    );

    private List<Pair<String, Runnable>> selectionOptions = Arrays.asList(
            new Pair<String, Runnable>("2 players", () -> {
                numplayers = 2;
                numturns = 60;
                Controller controller2 = loader.<Controller>getController();
                controller2.initializeEngine(numplayers, numturns); 
                window.setScene(game2);
                window.setResizable(false);
            }), 
            new Pair<String, Runnable>("3 players", () -> {
                numplayers = 3;
                numturns = 90;
                Controller controller3 = loader.<Controller>getController();
                controller3.initializeEngine(numplayers, numturns); 
                window.setScene(game2);
                window.setResizable(false);
            }),
            new Pair<String, Runnable>("4 players", () -> {
                numplayers = 4;
                numturns = 120;
                Controller controller4 = loader.<Controller>getController();
                controller4.initializeEngine(numplayers, numturns); 
                window.setScene(game2);
                window.setResizable(false);
            }),
            new Pair<String, Runnable>("Go back", () -> {
                window.setScene(titleScene);
            })
    );



    public Main() throws IOException {
    }

    private Parent createTitleContent() throws IOException  {
        ImageView imageView = new ImageView(new Image(getClass().getResource("res/Monopoly-1280x720.png").toExternalForm()));
        imageView.setFitWidth(WIDTH);
        imageView.setFitHeight(HEIGHT);

        MonopolyTitleFont title = new MonopolyTitleFont("MONOPOLY");
        title.setTranslateX(WIDTH / 2 - title.getTitleWidth() / 2);
        title.setTranslateY(HEIGHT / 3);

        titleRoot.getChildren().addAll(imageView, title);

        addMenu(titleRoot, menuBox, menuOptions);

        return titleRoot;
    }

    private Parent createSelectContent() throws IOException {
        ImageView imageView = new ImageView(new Image(getClass().getResource("res/monopolySelection.jpg").toExternalForm()));
        imageView.setFitWidth(WIDTH);
        imageView.setFitHeight(HEIGHT);

        MonopolyTitleFont title = new MonopolyTitleFont("Player amount:");
        title.setTranslateX(WIDTH / 2 - title.getTitleWidth() / 2);
        title.setTranslateY(HEIGHT / 3);

        selectRoot.getChildren().addAll(imageView, title);

        addMenu(selectRoot, selectBox, selectionOptions);

        return selectRoot;
    }

    private void addMenu(Pane r, VBox v, List<Pair<String, Runnable>> o) throws IOException {
        double X = WIDTH / 2 - 100;
        double Y = HEIGHT / 3 + 125;

        v.setTranslateX(X + 5);
        v.setTranslateY(Y + 5);

        o.forEach(data -> {
            ButtonLook item = new ButtonLook(data.getKey());
            item.setOnAction(data.getValue());
            item.setTranslateX(0);

            Rectangle clip = new Rectangle(300, 30);
            clip.translateXProperty().bind(item.translateXProperty().negate());

            item.setClip(clip);

            v.getChildren().addAll(item);
        });
        r.getChildren().add(v);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;

        titleScene = new Scene(createTitleContent());
        selectOptionScene = new Scene(createSelectContent());
        game2 = new Scene(paneTwo, 720, 590);
        game2.getStylesheets().addAll(this.getClass().getResource("stylesheet.css").toExternalForm());
       
        


        window.setTitle("MONOPOLY");
        window.setScene(titleScene);
        window.show();




    }

    public static void main(String[] args) {
        launch(args);
    }



}










