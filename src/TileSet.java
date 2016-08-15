/**
 * Created by Michael Sjögren on 2016-07-24.
 */
/*
public class TileSet {

    private int firstGid;
    private String imageName;
    private int tileWidth;
    private int tileHeight;
    private String imageSource;
    private double imageWidth;
    private double imageHeight;
    public static ArrayList<TileSet> tileSets = new ArrayList<>();



}
*/


public class TileSet {

    private Integer columns;
    private Integer firstgid;
    private String image;
    private Integer imageheight;
    private Integer imagewidth;
    private Integer margin;
    private String name;
    private Integer spacing;
    private Integer tilecount;
    private Integer tileheight;
    private Integer tilewidth;

    /**
     *
     * @return
     * The columns
     */
    public Integer getColumns() {
        return columns;
    }

    /**
     *
     * @param columns
     * The columns
     */
    public void setColumns(Integer columns) {
        this.columns = columns;
    }

    /**
     *
     * @return
     * The firstgid
     */
    public Integer getFirstgid() {
        return firstgid;
    }

    /**
     *
     * @param firstgid
     * The firstgid
     */
    public void setFirstgid(Integer firstgid) {
        this.firstgid = firstgid;
    }

    /**
     *
     * @return
     * The image
     */
    public String getImage() {
        return image;
    }

    /**
     *
     * @param image
     * The image
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     *
     * @return
     * The imageheight
     */
    public Integer getImageheight() {
        return imageheight;
    }

    /**
     *
     * @param imageheight
     * The imageheight
     */
    public void setImageheight(Integer imageheight) {
        this.imageheight = imageheight;
    }

    /**
     *
     * @return
     * The imagewidth
     */
    public Integer getImagewidth() {
        return imagewidth;
    }

    /**
     *
     * @param imagewidth
     * The imagewidth
     */
    public void setImagewidth(Integer imagewidth) {
        this.imagewidth = imagewidth;
    }

    /**
     *
     * @return
     * The margin
     */
    public Integer getMargin() {
        return margin;
    }

    /**
     *
     * @param margin
     * The margin
     */
    public void setMargin(Integer margin) {
        this.margin = margin;
    }

    /**
     *
     * @return
     * The name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     * The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     * The spacing
     */
    public Integer getSpacing() {
        return spacing;
    }

    /**
     *
     * @param spacing
     * The spacing
     */
    public void setSpacing(Integer spacing) {
        this.spacing = spacing;
    }

    /**
     *
     * @return
     * The tilecount
     */
    public Integer getTilecount() {
        return tilecount;
    }

    /**
     *
     * @param tilecount
     * The tilecount
     */
    public void setTilecount(Integer tilecount) {
        this.tilecount = tilecount;
    }

    /**
     *
     * @return
     * The tileheight
     */
    public Integer getTileheight() {
        return tileheight;
    }

    /**
     *
     * @param tileheight
     * The tileheight
     */
    public void setTileheight(Integer tileheight) {
        this.tileheight = tileheight;
    }

    /**
     *
     * @return
     * The tilewidth
     */
    public Integer getTilewidth() {
        return tilewidth;
    }

    /**
     *
     * @param tilewidth
     * The tilewidth
     */
    public void setTilewidth(Integer tilewidth) {
        this.tilewidth = tilewidth;
    }

}