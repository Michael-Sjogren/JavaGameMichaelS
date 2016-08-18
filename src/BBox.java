import javafx.geometry.Dimension2D;

import java.util.ArrayList;

/**
 * Created by Michael-Sjogren on 2016-07-21.
 */
public class BBox {


    public static ArrayList<BBox> solidBBoxes = new ArrayList<>();
    public static ArrayList<Dimension2D> dimension2Ds = new ArrayList<>();

    private double minX , maxX , minY , maxY;

    public double getMinY() {
        return minY;
    }
    public double getMinX() {
        return minX;
    }
    public double getMaxX() {
        return maxX;
    }
    public double getMaxY() { return maxY; }

    /** For non moving collision objects like walls etc..*/
    public BBox(double minX, double maxX, double minY, double maxY) {
        this.minX = minX;
        this.maxX = maxX;
        this.minY = minY;
        this.maxY = maxY;
    }
    /** **/

    /** @param other
     *  @return returns True if
     *  checks if player is colliding on the top part of the object in question
     *  if it does this returns true
     * **/
    public boolean isOnGround(BBox other){
            if(maxX >= other.getMinX() && minX  <= other.getMaxX()
               && minY  >= other.getMinY() // maxY is minY + 1
                && minY <= other.getMaxY()) {
                return true;
            }
        return false;
    }

    /** @param other
     *  @return
     *  checks if player is colliding on the bottom part of the object in question
     *  if it does this returns true else false
     * **/
    public boolean isCollidingBottom(BBox other){
        if(maxX - 1>= other.getMinX() && minX +1 <= other.getMaxX()
                && maxY >= other.getMinY() // maxY is minY + 1
                && maxY <= other.getMaxY()) {
          //  System.out.println("roof");
            return true;
        }
        return false;
    }


    public boolean isColliding(BBox other){
            if(maxX >= other.getMinX() && minX <= other.getMaxX() && maxY >= other.getMinY() && minY <= other.getMaxY()) {
                return true;
            }
        return false;
    }

    /** for moving collision objects such as bullets and other things**/
    public static boolean checkProjectileCollision(double minX, double maxX, double minY, double maxY, Entity entity){
        // checks for solids
        for (BBox bBox : solidBBoxes)
        {
            if(maxX >= bBox.getMinX() && minX <= bBox.getMaxX() && maxY >= bBox.getMinY() && minY <= bBox.getMaxY()) {
                return true;
            }
        }

        // checks for entities
        for (Entity e : Entity.entities)
        {
            double eMinX = e.getX();
            double eMaxX = e.getX() + e.getW();
            double eMinY = e.getY();
            double eMaxY = e.getY() + e.getH();

            // entity that shoots cannot hurt itself
            if(e != entity){
                if(maxX >= eMinX && minX <= eMaxX && maxY >= eMinY && minY <= eMaxY ) {
                    // timeline , timeline for some short invincibility frames.
                    // this timeline calls damage() and checks if entity is dead.
                    e.getTl_damagePlayer().play();
                    return true;
                }
            }
        }
        return false;
    }

}
