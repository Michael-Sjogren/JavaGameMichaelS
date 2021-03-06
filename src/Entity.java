import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Michael Sjögren on 2016-07-21.
 */

// TODO make this class abstract
public abstract class Entity {


    // delay on the damage since the collision detects too quickly
    private Timeline tl_damageEntity;

    private Movement movement;
    private double x;
    private double y;
    private double w;
    private double h;
    private int xaxis;
    private boolean isOnGround , isJumpPressed;
    private double tempGrav = 0;
    private double gravity = 1;
    public static ArrayList<Projectile> projectiles = new ArrayList<>();
    public static ArrayList<Entity> entities = new ArrayList<>();
    private static final double velocityFall = 0.1 ;
    private static final double velocityJump = 15;
    private final static int ENTITY_MAX_HP = 5;
    private int hp = ENTITY_MAX_HP;

    private boolean isAlive = true;

    private SpriteAnimation animation;

    public static final int LEFT = -1;
    public static final int RIGHT = 1;
    public static final int IDLE = 0;

    private int imageIndex;
    private int prevXaxis = 1;

    public Entity(double x , double y , double w , double h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        movement = new Movement(this);

        entities.add(this);
        Main.NUMBER_OF_INSTANCES++;

        tl_damageEntity = new Timeline(new KeyFrame(
                Duration.millis(200)

        ), new KeyFrame(Duration.millis(21), ae -> {
            damage();
            isEntityAlive();
        }));



        animation = new SpriteAnimation(Duration.millis(750),8,8);
        animation.setCycleCount(Animation.INDEFINITE);
        animation.play();

    }

    public void draw(GraphicsContext g ){
        if(!projectiles.isEmpty()){
            for (Projectile p :projectiles) {
                p.draw(g);
            }
        }
        drawEntity(g);
        drawHealthBar(g);


    }
    public void drawHealthBar(GraphicsContext g)
    {
        // TODO make constants for these offsets
        g.setFill(Color.rgb(138,7,7));
        g.fillRect(x  ,y-Main.ninjaSpritesRight[0].getHeight()/2,3*ENTITY_MAX_HP,5);
        g.setFill(Color.LIMEGREEN);
        g.fillRect(x , y-Main.ninjaSpritesRight[0].getHeight()/2,3*hp,5);

    }

    public void drawEntity(GraphicsContext g){

        if(isAlive){
           animateSelf(g);
        }
    }

    public void animateSelf(GraphicsContext g){
      // TODO make constants for these offsets
        if(xaxis == RIGHT ){
            g.drawImage(Main.ninjaSpritesRight[animation.getIndex()] , x - 39  , y - 32);
        }
        
        if(xaxis == IDLE && prevXaxis == RIGHT){

            g.drawImage(Main.ninjaSpritesRight[0] , x - 39  , y - 32);
        }

        if(xaxis == LEFT ){
            g.drawImage(Main.ninjaSpritesLeft[animation.getIndex()] , x - 39  , y - 32);
        }

        if(xaxis == IDLE && prevXaxis == LEFT ){

            g.drawImage(Main.ninjaSpritesLeft[0] , x - 39  , y - 32);
        }
    }




    public void tick()
    {
        movement.move();
    }

    public void isEntityAlive(){

        Iterator<Entity> iter = entities.iterator();
        while (iter.hasNext()) {
            Entity e = iter.next();
            if (this == e && !e.isAlive()){
                iter.remove();
            }
        }
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


    public void attack(int xaxis , Entity entity) {
        projectiles.add(new Projectile( getX(),getY(), xaxis, entity));
        Main.NUMBER_OF_INSTANCES++;
        // checks if projectile is out of bounds , if it is it will removed the object from the list.
        Iterator<Projectile> iter = projectiles.iterator();
        while (iter.hasNext()) {
            Projectile p = iter.next();
            if (p.isOutOfBounds()){
                iter.remove();
                Main.NUMBER_OF_INSTANCES--;
            }
        }
    }

    public void damage() {
        hp --;
        System.out.println("Entity hp: " + hp);
        if(hp == 0){
            setIsAlive(false);
            Main.NUMBER_OF_INSTANCES--;
        }
    }

    public void setIsAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public Timeline getTl_damagePlayer() {
        return tl_damageEntity;
    }

    public void setImageIndex(int imageIndex) {
        this.imageIndex = imageIndex;
    }

    public void setPrevXaxis(int prevXaxis) {
        this.prevXaxis = prevXaxis;
    }

    public int getPrevXaxis() {
        return prevXaxis;
    }
}
