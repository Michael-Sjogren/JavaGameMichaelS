/**
 * Created by Michael Sjogren on 2016-07-30.
 */

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import javafx.geometry.Dimension2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/** responsible for parsing the map files from Tiled program **/
public class LoadMap {
    private Gson gson = new Gson();
    private StringBuilder sb;
    private Scanner sc = null;
    private JsonObject json_obj;
    public static int map_cell_width, map_cell_height;

    public static int[][] layerData;
    private ArrayList<int[][]> layerDataList = new ArrayList<>();

    public ArrayList<Layer> layersList = new ArrayList<>();
    public ArrayList<TileSet> tilesetList = new ArrayList<>();
    public ArrayList<ArrayList<Image>> tiles = new ArrayList<>();
    // stores individual tiles of all tile sets according to layer hierarchy

    public LoadMap() {

        loadJsonData();
        fillLayerDataArray();
    }


    /**
     * reads the json data from a file and concatenates it into string witch is later turned into a json object
     **/
    public void loadJsonData() {
        try {
            InputStream is = LoadMap.class.getResourceAsStream("/maps/2dMap.json");

            sc = new Scanner(new BufferedReader(new InputStreamReader(is)));
            sb = new StringBuilder();

            while (sc.hasNextLine()) {
                sb.append(sc.next());
            }

            JsonArray layers , tilesets , object;

            json_obj = gson.fromJson(sb.toString(), JsonObject.class);
            // static variables
            map_cell_width = json_obj.getAsJsonObject().get("width").getAsInt();
            map_cell_height = json_obj.getAsJsonObject().get("height").getAsInt();

            tilesets = json_obj.getAsJsonArray("tilesets");
            layers = json_obj.getAsJsonArray("layers");

            for (int i = 0; i < layers.size(); i++){
                // parse layers
                Layer layerClass = gson.fromJson(layers.get(i),Layer.class);
                layersList.add(layerClass);



                // parse object
                if (json_obj.getAsJsonArray("layers").get(i).getAsJsonObject().getAsJsonArray("objects") != null){
                    object = json_obj.getAsJsonArray("layers").get(i).getAsJsonObject().getAsJsonArray("objects");
                    for (JsonElement e : object){
                        MapObject mapObj = gson.fromJson(e, MapObject.class);
                        layerClass.getObjectList().add(mapObj);
                    }
                }
            }
            for (int i = 0; i < tilesets.size(); i++){
                TileSet tileSet = gson.fromJson(tilesets.get(i), TileSet.class);
                tilesetList.add(tileSet);
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sc.close();
        }
    }


    /**
     * ------------ Tileset ------------
     * get all det relevant data from the result and makes them into java objects
     **/

        /** store each individual tile of each tileset in an array **/
    public void loadTilesetImages() {
        // in order for this to work all tileset images must be in the project file : src/tilesets/..
        for (int i = 0; i < tilesetList.size(); i++) {
            // i substring away the src/
            Image img = new Image(tilesetList.get(i).getImage().substring(3) ,0 ,0 , false ,false);
            int tile_width = tilesetList.get(i).getTilewidth();
            int tile_height = tilesetList.get(i).getTileheight();

            int img_cell_width = (int)  (img.getHeight() / tile_height );
            int img_cell_height = (int) (img.getWidth() / tile_width );

            ArrayList<Image> tile = new ArrayList<>();
          for (int row = 0; row < img_cell_width; row++){
              for (int col = 0; col < img_cell_height; col++){
                  WritableImage writableImg = new WritableImage(img.getPixelReader() , col * tile_width  , row * tile_height , tile_width , tile_height);
                  tile.add(writableImg);
              }
          }
            tiles.add(tile);
        }
    }

    public void fillLayerDataArray() {
        int itr = 0;
        for (Layer layer : layersList){
            layerData = new int[map_cell_width][map_cell_height];
                for (int row = 0; row < map_cell_width ; row++) {
                    for (int col = 0; col < map_cell_height ; col++) {
                        // fill a 2d array that hold all the tilesetImage values
                        if (!layer.getData().isEmpty()) {
                            layerData[row][col] = layer.getData().get(itr);
                            layerDataList.add(layerData);
                            itr++;
                        }
                    }
                }
                itr = 0;
            }
    }

    // draw the layers with tiles
    public void drawTiles(GraphicsContext g) {

            for (int row = 0; row < map_cell_width; row ++){
                for (int col = 0; col <  map_cell_height; col++){
                   // for loop that iterates over every layer with a data map and renders them in
                   for (int i = 0; i < layerDataList.size(); i++){
                        if (layerDataList.get(i)[row][col] > 0){
                            for (int k = 0; k < tiles.size(); k ++){
                                    g.drawImage(tiles.get(k).get(layerDataList.get(i)[row][col]-1),col*32 ,row*32);
                                }
                            }
                        }
                	}
                }
            }


    public void createCollisionObjects() {
            for (int i = 0; i < layersList.size(); i++){
                if(!layersList.get(i).getObjectList().isEmpty()) {
                    for (MapObject mapObject : layersList.get(i).getObjectList()){
                        int width = mapObject.getWidth();
                        int height = mapObject.getHeight();
                        int minX = mapObject.getX();
                        int minY = mapObject.getY();
                        BBox.dimension2Ds.add(new Dimension2D(width, height));
                        BBox.solidBBoxes.add(new BBox(minX, minX + width, minY, minY + height));
                    }
                }
            }
    }


}
