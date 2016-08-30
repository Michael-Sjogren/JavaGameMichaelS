
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application  {

    private View view;
    private Player player;
    private KeyInput keyInput;
   // private MapObjects map;
    public static int NUMBER_OF_INSTANCES = 0;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        player = new Player(600 ,50 , 6 * View.scale , 14 * View.scale, Color.RED);
        Player e1 = new Player(300,400,6*View.scale, 14 * View.scale , Color.ALICEBLUE);

        keyInput = new KeyInput(player);
       // map = new MapObjects();
        LoadMap map = new LoadMap();
        view = new View(map);
        map.createCollisionObjects();
        map.loadTilesetImages();
        stage.setScene(new Scene(view.createContent()));

        stage.setWidth(LoadMap.WIDTH+6);
        stage.setHeight(LoadMap.HEIGHT + 25);
        // adding event handler
        stage.addEventHandler(KeyEvent.ANY ,keyInput);

        stage.setResizable(false);
        stage.show();

    }






}
