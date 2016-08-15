import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Created by Michael Sjögren on 2016-07-20.
 */
public class MapObjects {

        /** creates a visual representation of collision objects , helper method to visualize bboxes**/
        public void drawMap(GraphicsContext g){
            for(int i = 0; i < BBox.dimension2Ds.size() ; i++){
                double x = BBox.bBoxes.get(i).getMinX();
                double y = BBox.bBoxes.get(i).getMinY();
                   double w = BBox.dimension2Ds.get(i).getWidth();
                   double h = BBox.dimension2Ds.get(i).getHeight();
                g.setFill(Color.GRAY);
                g.fillRect(x,y,w,h);
                // draws a red line witch represents the ground collision
                g.setFill(Color.RED);
                g.fillRect(x,y,w,h-h+1);
            }
        }

}
