import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Michael Sjögren on 2016-07-21.
 */
public class Entity {

    private Movement movement;
    private double x;
    private double y;
    private double w;
    private double h;
    private int xaxis;
    private boolean isOnGround , isJumpPressed;
    private double tempGrav = 0;
    private Projectile projectile;
    private double gravity = 1;
    public static ArrayList<Projectile> projectiles = new ArrayList<>();
    public static ArrayList<Entity> entities = new ArrayList<>();
    public static final double velocityFall = 0.1 / 90 ;
    public static final double velocityJump = 15;


    public Entity(double x , double y , double w , double h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        movement = new Movement(this);
        entities.add(this);
        Main.NUMBER_OF_INSTANCES = projectiles.size() + entities.size();
    }
    public void draw(GraphicsContext g ){
        if(!projectiles.isEmpty()){
            for (Projectile p :projectiles) {
                p.draw(g);
            }
        }
    }

    public void moveProjectiles(){
        if(!projectiles.isEmpty()){
            for (Projectile p :projectiles) {
                p.tick();
            }
        }
    }

    public void tick()
    {
        moveProjectiles();
        movement.move();
    }

    public Movement getMovement() {
        return movement;
    }

    public BBox BBox(){
        return new BBox(x,x+w,y,y+h);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setX(double x) {this.x = x;}

    public double getW() {
        return w;
    }

    public double getH() {
        return h;
    }

    public void gravity(){
        if(!isOnGround()) {
            tempGrav += gravity + velocityFall;
            setY(getY() + tempGrav);
            if(tempGrav >= 10){
                tempGrav = 10;
            }
        } if(isOnGround()){
            tempGrav = 0;
        } if(isOnGround() && isJumpPressed){
            jump();
        }
    }


    public int getXaxis() {
        return xaxis;
    }

    public void setXaxis(int xaxis) {
        this.xaxis = xaxis;
    }



    public void setIsOnGround(boolean isOnGround){
        this.isOnGround = isOnGround;
    }
    public boolean isOnGround(){
        return isOnGround;
    }

    public void jump() {
        tempGrav -= gravity + velocityJump;
        setY(getY() + tempGrav);
        if(tempGrav <= -10){
            isJumpPressed = false;
            setIsOnGround(false);
        }
    }

    public void setIsJumpPressed(boolean isJumpPressed) {
        this.isJumpPressed = isJumpPressed;
    }

    public void setTempGrav(double tempGrav) {
        this.tempGrav = tempGrav;

    }

    public double getTempGrav() {
        return tempGrav;
    }


    public synchronized void createProjectile(int xaxis) {
            projectiles.add(new Projectile( getX(),getY(), xaxis));

        Iterator<Projectile> iter = projectiles.iterator();

        while (iter.hasNext()) {
            Projectile p = iter.next();
            if (p.isOutOfBounds()){
                System.out.println(projectiles.size());
                iter.remove();
            }
        }
    }
}
