
/**
 * Created by Michael-Sjogren on 2016-07-19.
 */
public class Movement {
    public static final int SPEED = 2;
    private double prevX , prevY;
    private Entity entity;
    private boolean regularCol , isOnGround = false;

    public Movement(Entity entity) {
        this.entity = entity;
    }

    public void move() {
        // get previous position
        prevX = entity.getX();
        prevY = entity.getY();
        // move object
        entity.setX(entity.getX() + entity.getXaxis() * SPEED);
        regularCol = false;
        entity.setIsOnGround(false);
        entity.gravity();

        BBox.bBoxes.stream().filter(box -> box.isOnGround(entity.BBox())).forEach(box -> {
            isOnGround = true;
            entity.setIsOnGround(true);
            entity.gravity();
            entity.setY(prevY);
                entity.setX(entity.getX() + entity.getXaxis() * SPEED);
        });

        BBox.bBoxes.stream().filter(box -> box.isColliding(entity.BBox())).forEach(bBox -> {
            regularCol = true;
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

        BBox.bBoxes.stream().filter(box -> box.isCollidingBottom(entity.BBox())).forEach(bBox -> {
            entity.setIsOnGround(false);
            entity.setTempGrav(0.6);
            entity.setY(prevY);
        });
    }
}





