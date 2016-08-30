
/**
 * Created by Michael-Sjogren on 2016-07-19.
 */
/** every instance of an entity subclass has access to this class it moves the entity and checks collision for it**/
public class Movement {
    public static final int SPEED = 2;
    private double prevX , prevY;
    private Entity entity;


    public Movement(Entity entity) {
        this.entity = entity;
    }

    public void move() {
        // get previous position
        prevX = entity.getX();
        prevY = entity.getY();
        // move object
        entity.setX(entity.getX() + entity.getXaxis() * SPEED);

        entity.setIsOnGround(false);
        entity.gravity();

        BBox.solidBBoxes.stream().filter(box -> box.isOnGround(entity.BBox())).forEach(box -> {
            entity.setIsOnGround(true);
            entity.gravity();
            entity.setY(prevY);
                entity.setX(entity.getX() + entity.getXaxis() * SPEED);
        });

        BBox.solidBBoxes.stream().filter(box -> box.isColliding(entity.BBox())).forEach(bBox -> {
            entity.setIsOnGround(false);
            entity.setX(prevX);

            // checks collision for right side and sets yaxis to zero to ensure that jumping while colliding on sides works
            if (entity.getX() - entity.getXaxis() <= bBox.getMinX()){
                entity.setXaxis(0);
                entity.setX(prevX);
            //    System.out.println("right side");
            }
           // checks collision for left side and sets yaxis to zero to ensure that jumping while colliding on sides works
            if (entity.getX() - entity.getXaxis() >= bBox.getMaxX()){
                entity.setXaxis(0);
                entity.setX(prevX);
             //   System.out.println("left side");
            }

        });

        BBox.solidBBoxes.stream().filter(box -> box.isCollidingBottom(entity.BBox())).forEach(bBox -> {
            entity.setIsOnGround(false);
            entity.setTempGrav(0.6);
            entity.setY(prevY);
        });
    }
}





