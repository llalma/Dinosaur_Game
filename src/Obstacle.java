import java.awt.*;

public abstract class Obstacle {
    int x,y,width,height;
    final int game_speed = 1;

    public Obstacle(int x, int y, int width, int height){
        this.x = x;
        this.y = y-height;
        this.width = width;
        this.height = height;
    }

   abstract public void draw(Graphics g);
}
