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
public class View extends Canvas{

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
                render();
                entity.tick();

            }
        };

    private Entity entity;
	private Canvas middleGround;
	private GraphicsContext g3;

    public View(Entity entity, MapObjects map, LoadMap l) {
        this.entity = entity;
        this.map = map;
        this.l = l;
        createForegroundCanvas();
        createBackgroundCanvas();
        middleGround = new Canvas(WIDTH , HEIGHT);
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
    
    public Canvas getMiddleGround(){
    	return middleGround;
    }

    public Canvas getForeground(){
        return foregroundCanvas;
    }

    public Parent createContent() {
        root = new Pane();
        root.setPrefSize(WIDTH , HEIGHT);
        g = getForeground().getGraphicsContext2D();
        g2 = getBackgroundCanvas().getGraphicsContext2D();
        g3 = getMiddleGround().getGraphicsContext2D();
        
        img = new Image("Images/dark_background.png");
        // loads background image
        g2.drawImage(img,0,0);
        // loads background tiles
        l.drawTiles(g2);
        root.getChildren().addAll(getBackgroundCanvas(),getMiddleGround() ,getForeground());
        // starts animation timer
        engine.start();
        return root;
    }

   public void render(){
        g3.clearRect(0, 0 , WIDTH , HEIGHT);
        g.clearRect(0,0,WIDTH,HEIGHT);
        // TODO create a sense of depth , foreground , entity , background

        entity.draw(g3);

       
    }
}

