
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application  {

    private View view;
    private Player player;
    private KeyInput keyInput;
   // private MapObjects map;
    public static int NUMBER_OF_INSTANCES = 0;
    public static Image[] ninjaStarSprites;
    public static Image[] ninjaSpritesLeft;
    public static Image[] ninjaSpritesRight;

    public static Image[] ninjaAttackLeft;
    public static Image[] ninjaAttackRight;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        player = new Player(600 ,50 , 6 * View.scale , 14 * View.scale, Color.RED);
        Player e1 = new Player(300,400,6*View.scale, 14 * View.scale , Color.ALICEBLUE);

        // instantiate imageCropper class
        SpriteSheetCrop sprCrop = new SpriteSheetCrop();
        Image right = new Image("Images/sprite-enemy-right-sheet.png" , (32 * 8) * View.scale  , 32 * View.scale ,true , false);
        Image left = new Image("Images/sprite-enemy-left1-sheet.png", (32 * 8) * View.scale  , 32 * View.scale ,true , false);
        int colums = 8;
        ninjaSpritesRight = sprCrop.cropSpriteSheet(right,colums, (int) right.getWidth() / colums,(int) right.getHeight());
        ninjaSpritesLeft = sprCrop.cropSpriteSheet(left,colums, (int) left.getWidth() / colums,(int) left.getHeight());
        ninjaStarSprites = sprCrop.cropSpriteSheet(new Image("Images/ninja-star2.png"),10,32,32);

        ninjaAttackLeft = sprCrop.cropSpriteSheet(new Image("Images/ninja-attack-left.png"),8,32,32);
        ninjaAttackRight = sprCrop.cropSpriteSheet(new Image("Images/ninja-attack-rightt.png"),8,32,32);

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
