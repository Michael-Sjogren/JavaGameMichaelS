import java.util.ArrayList;

public class Layer {

    private ArrayList<Integer> data = new ArrayList<>();

    private ArrayList<MapObject> ObjectList = new ArrayList<>();

    private Integer height;

    private String image;

    private String name;

    private Double offsetx;

    private Integer offsety;

    private Integer opacity;

    private String type;

    private Boolean visible;

    private Integer width;

    private Integer x;

    private Integer y;

    /**
     *
     * @return
     * The height
     */
    public Integer getHeight() {
        return height;
    }

    /**
     *
     * @param height
     * The height
     */
    public void setHeight(Integer height) {
        this.height = height;
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
     * The offsetx
     */
    public Double getOffsetx() {
        return offsetx;
    }

    /**
     *
     * @param offsetx
     * The offsetx
     */
    public void setOffsetx(Double offsetx) {
        this.offsetx = offsetx;
    }

    /**
     *
     * @return
     * The offsety
     */
    public Integer getOffsety() {
        return offsety;
    }

    /**
     *
     * @param offsety
     * The offsety
     */
    public void setOffsety(Integer offsety) {
        this.offsety = offsety;
    }

    /**
     *
     * @return
     * The opacity
     */
    public Integer getOpacity() {
        return opacity;
    }

    /**
     *
     * @param opacity
     * The opacity
     */
    public void setOpacity(Integer opacity) {
        this.opacity = opacity;
    }

    /**
     *
     * @return
     * The type
     */
    public String getType() {
        return type;
    }

    /**
     *
     * @param type
     * The type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     *
     * @return
     * The visible
     */
    public Boolean getVisible() {
        return visible;
    }

    /**
     *
     * @param visible
     * The visible
     */
    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    /**
     *
     * @return
     * The width
     */
    public Integer getWidth() {
        return width;
    }

    /**
     *
     * @param width
     * The width
     */
    public void setWidth(Integer width) {
        this.width = width;
    }

    /**
     *
     * @return
     * The x
     */
    public Integer getX() {
        return x;
    }

    /**
     *
     * @param x
     * The x
     */
    public void setX(Integer x) {
        this.x = x;
    }

    /**
     *
     * @return
     * The y
     */
    public Integer getY() {
        return y;
    }

    /**
     *
     * @param y
     * The y
     */
    public void setY(Integer y) {
        this.y = y;
    }

    public ArrayList<Integer> getData() {
        return data;
    }

    public void setData(ArrayList<Integer> data) {
        this.data = data;
    }

    public ArrayList<MapObject> getObjectList() {
        return ObjectList;
    }
}