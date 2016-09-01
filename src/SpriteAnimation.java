import javafx.animation.Interpolator;
import javafx.animation.Transition;

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
    private int index;


    public SpriteAnimation(Duration duration, int count, int columns) {

        this.duration = duration;
        this.count     = count;
        this.columns   = columns;


        setCycleDuration(duration);
        setInterpolator(Interpolator.LINEAR);
    }



    protected void interpolate(double k) {

        int index = Math.min((int) Math.floor(k * count), count - 1);
        if (index != lastIndex) {
            setIndex(index);
            lastIndex = index;
        }
    }

    public int getIndex(){
        return index;
    }

    public void setIndex(int index){
        this.index = index;
    }

}
