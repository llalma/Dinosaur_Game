import javax.imageio.ImageIO;
import java.awt.*;

public class Cactus extends Obstacle{
    Image scaled_img;

    public Cactus(int x){
        super(x,360, 30,60);

        try {
            Image img = ImageIO.read(getClass().getResource("images/cactus.png"));
            scaled_img = img.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
        }catch (Exception E){

        }
    }

    public void draw(Graphics g){
        g.setColor(Color.cyan);
        this.x -= game_speed;
//        g.fillRect(x,y,width,height);
        g.drawImage(scaled_img,x,y,width,height,null);
    }

}
