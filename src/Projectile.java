import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Material;


/**
 * Created by MichaelSjogren on 2016-08-16.
 */
public class Projectile  {

    public static final int BULLET_WIDTH = 4;
    public static final int BULLET_HEIGHT = 4;
    public static final int PROJECTILE_SPEED = 10;
    private boolean isOutOfBounds = false;
    private double x , y ;
    private int xaxis;
    private Entity entity;
    private double right;

    public Projectile(double x, double y, int xaxis, Entity entity) {
        this.y = y + entity.getH()/2;
        getBulletStartPos(x);
        this.xaxis = xaxis;
        this.entity = entity;
    }


    public void getBulletStartPos(double x){

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
           if(BBox.checkProjectileCollision(x,x+BULLET_WIDTH,y,y+BULLET_HEIGHT , entity))
           {
               isOutOfBounds = true;
           }
    }


   public void draw(GraphicsContext g){
       if(!isOutOfBounds){
           g.setFill(Color.DARKGOLDENROD);
           g.fillOval(getX(),getY(),BULLET_WIDTH,BULLET_HEIGHT);
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

    public double getY() {
        return y;
    }

    public void setY(double y) {
       this.y = y;
    }
    public int getXaxis() {
        return xaxis;
    }
}
