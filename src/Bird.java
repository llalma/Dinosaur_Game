import java.awt.*;

public class Bird extends Obstacle{

    public Bird(int x, int y){
        super(x,360-(y*30), 30,20);
    }

    public void draw(Graphics g){
        g.setColor(Color.red);
        this.x -= game_speed;
        g.fillRect(x,y,width,height);
    }

}
