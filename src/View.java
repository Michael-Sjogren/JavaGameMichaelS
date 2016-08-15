import javafx.animation.AnimationTimer;
import javafx.scene.Parent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;


/**
 * Created by Michael Sjögren on 2016-07-19.
 */
public class View {

    public static int scale = 3;
    public static final int WIDTH = 896;
    public static final int HEIGHT = 896;

    public static Pane root;
    private MapObjects map;
    private LoadMap l;
    private Canvas foregroundCanvas , backgroundCanvas;
    private GraphicsContext g , g2;
    private Image img;



        AnimationTimer engine = new AnimationTimer()
        {
            @Override
            public void handle(long now)
            {
                entity.tick();
                render();
            }
        };

    private Entity entity;

    public View(Entity entity, MapObjects map, LoadMap l) {
        this.entity = entity;
        this.map = map;
        this.l = l;
        createForegroundCanvas();
        createBackgroundCanvas();
    }

    public void createForegroundCanvas(){
        foregroundCanvas = new Canvas(WIDTH ,HEIGHT);
    }

    public Canvas getBackgroundCanvas() {
        return backgroundCanvas;
    }

    public void createBackgroundCanvas(){
        backgroundCanvas = new Canvas(WIDTH , HEIGHT);
    }

    public Canvas getForeground(){
        return foregroundCanvas;
    }

    public Parent createContent() {
        root = new Pane();
        root.setPrefSize(WIDTH , HEIGHT);
        g = getForeground().getGraphicsContext2D();
        g2 = getBackgroundCanvas().getGraphicsContext2D();

         img = new Image("Images/dark_background.png");

        root.getChildren().addAll(getBackgroundCanvas(),getForeground());

        engine.start();
        return root;
    }

   public void render(){
        g.clearRect(0, 0 , WIDTH , HEIGHT);
        // background
        g2.drawImage(img,0,0);
        l.drawTiles(g2);
       // visually represents all objects generated from 2dMap.json thease object are solid, The player cant move trough them.

       //  map.drawMap(g);

       // even though the tiles are being painted in layers
       // on the canvas i still have to figure out a way to draw the entities in a better way so it can be in accordance with layers
        entity.draw(g);
    }

}
