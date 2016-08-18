import javafx.animation.Timeline;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.util.Iterator;

/**
 * Created by Michael Sjögren on 2016-07-19.
 */
public class Player extends Entity{

    private final Color playerColor;
    private Image playerImage;
    public static final int OFFSET_X = 13;
    public static final int OFFSET_Y = 11;
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
        playerImage = new Image("images/sprite_player_badass_down1.png",32 * View.scale,32 * View.scale,true,false);
    }

    @Override
    public void draw(GraphicsContext g) {
        // x , y coordinates of player
        ;
        g.setFont(f);
        g.setStroke(Color.LIMEGREEN);
        g.strokeText("X : " + Double.toString(getX()) + "\n" + "Y : "+ Double.toString(Math.round(getY())) + "\n" + "Entities: " + Integer.toString(Main.NUMBER_OF_INSTANCES), 50 , 50 );
        g.setFill(playerColor);
        g.fillRect(getX(),getY(),getW(),getH());
    }

    @Override
    public void moveProjectiles() {
        super.moveProjectiles();
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
    public void createProjectile(int xaxis) {
        super.createProjectile(xaxis);
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
    public Timeline getTl_damagePlayer() {
        return super.getTl_damagePlayer();
    }
}
