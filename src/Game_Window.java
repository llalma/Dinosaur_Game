import javax.swing.*;

public class Game_Window extends JFrame {
    Game_Panel game;
    /**
     * Default Constructor
     */
    public Game_Window() {
        super("Dinosaur Game");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        game  = new Game_Panel();

        getContentPane().add(game,"Center");

        // Display the window.
        setLocation(300,200);

        pack();
        setVisible(true);
    }

    public int getScore(){
        return game.getScore();
    }
}
