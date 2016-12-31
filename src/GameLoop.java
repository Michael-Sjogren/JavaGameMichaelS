import javafx.scene.canvas.GraphicsContext;

/**
 * Created by MichaelSjogren on 2016-12-31.
 */
public class GameLoop extends Thread {

    private final GraphicsContext g;
    private final GraphicsContext g2;
    private final GraphicsContext g3;
    private boolean running = true;
    public static Integer UPS = 60;
    public static Integer FPS = 60;
    public static boolean RENDER_TIME = true;
    private int currentFrame = 0;

    GameLoop(GraphicsContext g, GraphicsContext g2, GraphicsContext g3){
        this.g = g;
        this.g2 = g2;
        this.g3 = g3;
    }

    public void stopLoop(){
        running = false;
    }

    @Override
    public void run() {

        long initialTime = System.nanoTime();
        final double timeU = 1000000000 / UPS;
        final double timeF = 1000000000 / FPS;
        double deltaU = 0, deltaF = 0;
        int frames = 0, ticks = 0;
        long timer = System.currentTimeMillis();

        while (running) {
            long currentTime = System.nanoTime();
            deltaU += (currentTime - initialTime) / timeU;
            deltaF += (currentTime - initialTime) / timeF;
            initialTime = currentTime;

            if (deltaU >= 1) {
                update();
                ticks++;
                deltaU--;
            }

            if (deltaF >= 1) {
                render();
                frames++;
                deltaF--;
            }

            if (System.currentTimeMillis() - timer > 1000) {
                if (RENDER_TIME) {
                    System.out.println(String.format("UPS: %s, FPS: %s", ticks, frames));
                    currentFrame = frames;
                }
                frames = 0;
                ticks = 0;
                timer += 1000;
            }
        }
    }

    public void update(){
        Entity.entities.forEach(Entity::tick);
        if(!Entity.projectiles.isEmpty()){
            Entity.projectiles.forEach(Projectile::tick);
        }
    }

    public void render(){
        g3.clearRect(0, 0 , LoadMap.WIDTH , LoadMap.HEIGHT);
        g.clearRect(0,0,LoadMap.WIDTH,LoadMap.HEIGHT);
        g.strokeText(String.format("FPS: %s" , currentFrame) , 10 , 20);
        for (Entity e : Entity.entities){
            e.draw(g);
        }
    }
}
