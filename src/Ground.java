import javax.swing.*;
import java.awt.*;

public class Ground {
    public Ground(){
    }

    public void draw(Graphics g){
        final int screen_width = 800;
        final int screen_height = 400;
        final double Ground_thicness = 0.1;

        g.setColor(Color.GREEN);
        g.fillRect(0,(int)(screen_height-(screen_height*0.1)),screen_width,(int)(screen_height*Ground_thicness));
    }
}
