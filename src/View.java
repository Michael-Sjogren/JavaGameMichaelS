import javafx.animation.AnimationTimer;
import javafx.scene.Parent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;


/**
 * Created by Michael Sjögren on 2016-07-19.
 */
public class View {

    public static int scale = 3;


    public static Pane root;
    private LoadMap l;
    private Canvas foregroundCanvas , backgroundCanvas , middleGround;
    private GraphicsContext g , g2 , g3;
    private GameLoop loop;

    public View(LoadMap l ) {
        this.l = l;
        createForegroundCanvas();
        createBackgroundCanvas();
        middleGround = new Canvas(LoadMap.WIDTH , LoadMap.HEIGHT);
    }

    public void createForegroundCanvas(){
        foregroundCanvas = new Canvas(LoadMap.WIDTH ,LoadMap.HEIGHT);
    }

    public Canvas getBackgroundCanvas() {
        return backgroundCanvas;
    }

    public void createBackgroundCanvas(){
        backgroundCanvas = new Canvas(LoadMap.WIDTH , LoadMap.HEIGHT);
    }
    
    public Canvas getMiddleGround(){
    	return middleGround;
    }

    public Canvas getForeground(){
        return foregroundCanvas;
    }

    public Parent createContent() {
        root = new Pane();
        root.setPrefSize(LoadMap.WIDTH , LoadMap.HEIGHT);

        // background image
        Image background = new Image("Images/tile-bg896x896.png");
        g = getForeground().getGraphicsContext2D();
        g2 = getBackgroundCanvas().getGraphicsContext2D();
        g3 = getMiddleGround().getGraphicsContext2D();
        
         loop = new GameLoop(g , g2 , g3);
        // background color
        g2.setFill(Color.rgb(82, 135, 221));
        g2.fillRect(0 , 0 , LoadMap.WIDTH , LoadMap.HEIGHT);
      //  g2.drawImage(background , 0 , 0);

        // loads background tiles
        l.drawTiles(g2);
        root.getChildren().addAll(getBackgroundCanvas(),getMiddleGround() ,getForeground());
        // starts loop
        return root;
    }

    public void startgame(){
        loop.start();
    }

    public void endgame(){
        loop.stopLoop();
        try {
            loop.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

