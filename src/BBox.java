import javafx.geometry.Dimension2D;

import java.util.ArrayList;

/**
 * Created by Michael-Sjogren on 2016-07-21.
 */
public class BBox {

    public double getMinX() {
        return minX;
    }
    public static ArrayList<BBox> solidBBoxes = new ArrayList<>();
    public static ArrayList<Dimension2D> dimension2Ds = new ArrayList<>();
    public static ArrayList<BBox> projectileBBoxes = new ArrayList<>();
    public double getMinY() {
        return minY;
    }
    private double minX , maxX , minY , maxY;

    public double getMaxX() {
        return maxX;
    }


    /**For solid collision objects like walls etc..*/
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
            if(maxX >= other.minX && minX  <= other.maxX
               && minY  >= other.minY // maxY is minY + 1
                && minY <= other.maxY) {
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
        if(maxX - 1>= other.minX && minX +1 <= other.maxX
                && maxY >= other.minY // maxY is minY + 1
                && maxY <= other.maxY) {
          //  System.out.println("roof");
            return true;
        }
        return false;
    }


    public boolean isColliding(BBox other){
            if(maxX >= other.minX && minX <= other.maxX && maxY >= other.minY && minY <= other.maxY) {
                return true;
            }
        return false;
    }

    public static boolean checkBounds(double minX ,double  maxX,double minY ,double maxY){
        for (BBox bBox : solidBBoxes)
        {
            if(maxX >= bBox.minX && minX <= bBox.maxX && maxY >= bBox.minY && minY <= bBox.maxY) {
                return true;
            }
        }
        return false;
    }



}
