

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.util.Duration;

import java.util.ArrayList;


/**
 * Created by Michael-Sjogren on 2016-07-19.
 */
public class KeyInput implements EventHandler<KeyEvent> {

    private Entity entity;
    public static int LEFT = 0;
    public static int RIGHT = 0;
    private Timeline timeline;

	private int xaxis , prevXaxis;

    public KeyInput(Entity player) {
        this.entity = player;

        timeline = new Timeline(new KeyFrame(
                Duration.millis(1), ae ->  entity.setIsJumpPressed(true)

        ),new KeyFrame(Duration.millis(20), ae -> {
            entity.setIsJumpPressed(false);
        }));
    }

    public void checkInput(KeyEvent event){
        if(event.getEventType().equals(KeyEvent.KEY_PRESSED)) handleKeyPressed(event);
        if(event.getEventType().equals(KeyEvent.KEY_RELEASED)) handleKeyRealeased(event);
    }

    public void handleKeyPressed(KeyEvent event){

        switch (event.getCode())
        {
            case A: LEFT = -1; entity.setPrevXaxis(-1); break;
            case D: RIGHT = 1; entity.setPrevXaxis(1); break;
            case W: timeline.play();break;
            case SPACE: break;
		default:
			break;

        }

		entity.setXaxis( xaxis = LEFT + RIGHT);
    }

    public void handleKeyRealeased(KeyEvent event){
        switch (event.getCode())
        {
            case A: LEFT = 0; break;
            case D: RIGHT = 0; break;
            case W: timeline.stop();break;
            case SPACE:entity.attack(entity.getPrevXaxis(),entity);break;
            default:
            	break;
        }
		entity.setXaxis(xaxis = LEFT + RIGHT);
    }


    @Override
    public void handle(KeyEvent event) {
        checkInput(event);
    }
}

