import javax.swing.*;

public class Game_Window extends JFrame {

    /**
     * Default Constructor
     */
    public Game_Window() {
        super("Dinosaur Game");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel game  = new Game_Panel();

        getContentPane().add(game,"Center");

        // Display the window.
        setLocation(300,200);

        pack();
        setVisible(true);
    }
}
