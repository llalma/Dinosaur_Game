import javax.imageio.ImageIO;
import java.awt.*;

public class Dinosaur {
    public final int x = 30;
    private final double jump_accel = 5;
    private final double G = 0.1;

    public double y,dino_width,dino_height,y_accel;

    final int screen_height = 400;
    final double Ground_thicness = 0.1;
    Image scaled_img;


    public Dinosaur(){
        dino_width = 40;
        dino_height = 60;

        y = screen_height - (screen_height*Ground_thicness)-dino_height;

        try {
            Image img = ImageIO.read(getClass().getResource("images/dino.jpg"));
            scaled_img = img.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
        }catch (Exception E){

        }
    }

    public void draw(Graphics g){
        g.setColor(Color.BLACK);
//        g.fillRect(x,(int)y,(int)dino_width,(int)dino_height);
        g.drawImage(scaled_img,x,(int)y,(int)dino_width,(int)dino_height,null);
    }

    public void jump(){
        if(ground()){
            y_accel = jump_accel;
        }
    }

    public void update_height(){
        y -= y_accel;

        //Change vertical velocity if not touching the ground
        if(ground()){
            y_accel = 0;
        }else{
            y_accel -= G;
        }

        //make sure it cant go below ground
        if(y > screen_height - ((screen_height*Ground_thicness) + dino_height)){
            y = screen_height - ((screen_height*Ground_thicness)+ dino_height);
        }
    }

    private boolean ground(){
        if(y + dino_height == screen_height - (screen_height*Ground_thicness)){
            return true;
        }
        return false;
    }
}
