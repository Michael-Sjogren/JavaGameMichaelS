import javafx.animation.Animation;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.Material;
import javafx.util.Duration;


/**
 * Created by MichaelSjogren on 2016-08-16.
 */
public class Projectile  {

    public static final int BULLET_WIDTH = 16;
    public static final int BULLET_HEIGHT = 16;
    public static final int PROJECTILE_SPEED = 10;
    private boolean isOutOfBounds = false;

    private double x , y ;
    private int xaxis;
    private Entity entity;
    private double rotation = 0;
    private double rotSpeed = 1;
    private SpriteAnimation animation;

    public Projectile(double x, double y, int xaxis, Entity entity) {
        this.y = y - entity.getH() / 2 + 10;
        setBulletStartPos(x);
        this.xaxis = xaxis;
        this.entity = entity;
        animation = new SpriteAnimation(Duration.millis(150),10,10);
        animation.setCycleCount(Animation.INDEFINITE);
        animation.play();

    }


    public void setBulletStartPos(double x){

        if(xaxis == 1)
        {
            this.x = x + entity.getW();
        }
        else
        {
            this.x = x;
        }

    }

    /** makes bullet travel**/
    public void tick(){
        // if its inside the screen render and move the bullet
           setX(getX() + PROJECTILE_SPEED * getXaxis());

           if(BBox.checkProjectileCollision(x,x+BULLET_WIDTH,y,y+BULLET_HEIGHT , entity) && (x < LoadMap.WIDTH && x > 0 ))
           {
               isOutOfBounds = true;
           }
    }


   public void draw(GraphicsContext g){
       if(!isOutOfBounds){
           g.setFill(Color.BLACK);
           g.drawImage(Main.ninjaStarSprites[animation.getIndex()],x,y);
       }else {
           return;
       }
   }

    public boolean isOutOfBounds() {
        return isOutOfBounds;
    }



    public double getX() {
        return x;
    }

    public void setX(double x){
        this.x = x;
    }

    public int getXaxis() {
        return xaxis;
    }
}
