import java.awt.*;

public class Cactus extends Obstacle{

    public Cactus(int x){
        super(x,360, 30,60);
    }

    public void draw(Graphics g){
        g.setColor(Color.cyan);
        this.x -= game_speed;
        g.fillRect(x,y,width,height);
    }

}
