import javafx.animation.Interpolator;
import javafx.animation.Transition;

import javafx.scene.image.Image;
import javafx.util.Duration;



/**
 * Created by MichaelSjogren on 2016-08-19.
 */
public class SpriteAnimation extends Transition {


    private final Duration duration;
    private  int count;
    private  int columns;
    private Entity e;

    private int lastIndex;


    public SpriteAnimation(Duration duration, int count, int columns , Entity e) {

        this.duration = duration;
        this.count     = count;
        this.columns   = columns;
        this.e = e;


        setCycleDuration(duration);
        setInterpolator(Interpolator.LINEAR);
    }



    protected void interpolate(double k) {

        int index = Math.min((int) Math.floor(k * count), count - 1);
        if (index != lastIndex) {
            e.setImageIndex(index);
            lastIndex = index;
        }
    }

}
