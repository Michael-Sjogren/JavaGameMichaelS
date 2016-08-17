import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 * Created by Michael Sjögren on 2016-07-19.
 */
public class Player extends Entity{

    private Image playerImage;
    public static final int OFFSET_X = 13;
    public static final int OFFSET_Y = 11;
    private double y;
    private double x;
    private int w;
    private int h;
    private boolean isOnGround = false;
    private double tempGrav = 0;
    private Font f = new Font(16);

    public Player(int x , int y , int w , int h) {
        super(x,y,w,h);
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        playerImage = new Image("images/sprite_player_badass_down1.png",32 * View.scale,32 * View.scale,true,false);
    }

    public void draw(GraphicsContext g ){
        super.draw(g);
        g.drawImage( playerImage , x - OFFSET_X * View.scale , y - OFFSET_Y * View.scale );
         g.setFill(Color.rgb(0,255,255 , 0.9));
        //  representation of bounding box for player
        // g.fillRect(x,y,w,h);

         // x , y coordinates of player
        g.setFont(f);
        g.setStroke(Color.LIMEGREEN);
        g.strokeText("X : " + Double.toString(getX()) + "\n" + "Y : "+ Double.toString(Math.round(getY())) + "\n" + "Entities: " + Integer.toString(Main.NUMBER_OF_INSTANCES), 50 , 50 );
    }

    public BBox BBox(){
        return new BBox(x,x+w,y,y+h);
    }

    public void setX(double x) {
        this.x = x;
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

    public double getW() {
        return w;
    }

    public double getH() {
        return h;
    }

    @Override
    public void tick() {
        super.tick();
    }

    @Override
    public void jump(){
        super.jump();
    }

    public void setTempGrav(double tempGrav){
        super.setTempGrav(tempGrav);
    }

    public double getTempGrav() {
        return tempGrav;
    }

    public void setIsJumpPressed(boolean jumpPressed) {
        super.setIsJumpPressed(jumpPressed);
    }

    public boolean isOnGround(){
        return isOnGround;
    }

    public void setIsOnGround(boolean isOnGround){
        this.isOnGround = isOnGround;
    }
    
    @Override
    public void gravity(){
         super.gravity();
        }

}
