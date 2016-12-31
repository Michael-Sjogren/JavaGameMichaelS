import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.util.Duration;

import java.util.Iterator;

/**
 * Created by Michael Sjögren on 2016-07-19.
 */
public class Player extends Entity{

    private final Color playerColor;
    private final Image[] spriteSheet = new Image[5];
    private Timeline tl_animatePlayer;

    private Image playerImage;
    private double y;
    private double x;
    private int w;
    private int h;
    private boolean isOnGround = false;
    private boolean isAlive = true;
    private double tempGrav = 0;
    private Font f = new Font(16);

    public Player(int x , int y , int w , int h , Color c) {
        super(x,y,w,h);
        playerColor = c;
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    @Override
    public void draw(GraphicsContext g) {
        // x , y coordinates of player
        super.draw(g);
        g.setFont(f);
        g.setStroke(Color.LIMEGREEN);
        g.strokeText("X : " + Double.toString(getX()) + "\n" + "Y : "+ Double.toString(Math.round(getY())) + "\n" + "Entities: " + Integer.toString(Main.NUMBER_OF_INSTANCES), 50 , 50 );
        // draw player
    }

    @Override
    public void drawHealthBar(GraphicsContext g){
        super.drawHealthBar(g);
    }


    @Override
    public void tick() {
        super.tick();
    }

    @Override
    public void isEntityAlive() {
        super.isEntityAlive();
    }

    @Override
    public BBox BBox() {
        return super.BBox();
    }

    @Override
    public double getX() {
        return super.getX();
    }

    @Override
    public double getY() {
        return super.getY();
    }

    @Override
    public void setY(double y) {
        super.setY(y);
    }

    @Override
    public void setX(double x) {
        super.setX(x);
    }

    @Override
    public double getW() {
        return super.getW();
    }

    @Override
    public double getH() {
        return super.getH();
    }

    @Override
    public void gravity() {
        super.gravity();
    }

    @Override
    public int getXaxis() {
        return super.getXaxis();
    }

    @Override
    public void setXaxis(int xaxis) {
        super.setXaxis(xaxis);
    }

    @Override
    public void setIsOnGround(boolean isOnGround) {
        super.setIsOnGround(isOnGround);
    }

    @Override
    public boolean isOnGround() {
        return super.isOnGround();
    }

    @Override
    public void jump() {
        super.jump();
    }

    @Override
    public void setIsJumpPressed(boolean isJumpPressed) {
        super.setIsJumpPressed(isJumpPressed);
    }

    @Override
    public void setTempGrav(double tempGrav) {
        super.setTempGrav(tempGrav);
    }

    @Override
    public double getTempGrav() {
        return super.getTempGrav();
    }

    @Override
    public void attack(int xaxis , Entity entiy) {

        super.attack(xaxis , entiy);
    }

    @Override
    public void damage() {
        super.damage();
    }

    @Override
    public void setIsAlive(boolean isAlive) {
        super.setIsAlive(isAlive);
    }

    @Override
    public boolean isAlive() {
        return super.isAlive();
    }

    @Override
    public void drawEntity(GraphicsContext g){
        super.drawEntity(g);
    }

    @Override
    public Timeline getTl_damagePlayer() {
        return super.getTl_damagePlayer();
    }
}
