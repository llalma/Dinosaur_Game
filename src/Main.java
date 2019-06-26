import javax.swing.*;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class Main {
    /**
     * Create game window
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {
        JFrame.setDefaultLookAndFeelDecorated(false);
        Game_Window game = new Game_Window();

        while(true){
            game.repaint();
            sleep(10);
        }
    }
}
