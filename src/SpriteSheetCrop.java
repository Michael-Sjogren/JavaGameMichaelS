import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;



/**
 * Created by MichaelSjogren on 2016-08-29.
 */
public class SpriteSheetCrop {


    public Image[] cropSpriteSheet(Image spriteSheet , int columns , int width , int height){
        // crop images
       Image[] sprites = new Image[columns];
        for (int i = 0 ; i < columns; i ++){
            WritableImage w = new WritableImage(spriteSheet.getPixelReader(),i * width , 0 , width , height);
            sprites[i] = w;
        }
        return sprites;
    }


}
