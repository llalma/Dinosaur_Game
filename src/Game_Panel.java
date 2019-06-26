import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;

public class Game_Panel extends JPanel{
    Dinosaur dino;
    Ground ground;
    private ArrayList<Obstacle> obstacles = new ArrayList<>();
    Random rand = new Random();

    private final int screen_width = 800;
    private final int screen_height = 400;
    private final int num_obstacles = 4;

    public Game_Panel() {
        this.setBackground(new java.awt.Color(255, 255, 255));
        this.setName("game display");
        this.setPreferredSize(new Dimension(screen_width,screen_height));

        /**
         * Key events
         */
        //Get the input and action maps for drawing panel
        InputMap inputmap = this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionmap = this.getActionMap();

        //Add an input of left control and Z
        inputmap.put(KeyStroke.getKeyStroke(' '), "Jump" );

        //Action when left control and z is pressed
        actionmap.put("Jump", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                dino.jump();
            }
        });


        ground = new Ground();
        pop_obstacles();
    }

    private void pop_obstacles(){
        for(int i = 0;i<num_obstacles;i++){
            new_obstacle();
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        ground.draw(g);
        draw_Objects(g);
    }
    private void draw_Objects(Graphics g){

        //Scroll and draw obstacles
        for(int i = 0;i<obstacles.size();i++){
            obstacles.get(i).draw(g);
        }

        //Remove Object if it goes off screen and add new
        if(obstacles.get(0).x < -5){
            obstacles.remove(0);
            new_obstacle();
        }
    }

    private void new_obstacle(){
        if(rand.nextInt(2) == 0){
            //Add new cactus off screen
            obstacles.add(new Cactus(rand.nextInt(800)+screen_width));
        }else{
            //Add new bird off screen
            obstacles.add(new Bird(rand.nextInt(800)+screen_width, rand.nextInt(3)));
        }

        check_Distances();
    }

    private void check_Distances(){
       for(int i = 0;i<obstacles.size()-2;i++){
           if (obstacles.size() > 3) {
               final int min_Distance_Between_Objects = 200;

               //Check objects are spread out a bit change if if not fix it
               int obj1 = obstacles.get(i).x;
               int obj2 = obstacles.get(obstacles.size()-1).x;

               if (obj2 - obj1 < min_Distance_Between_Objects) {
                   Obstacle obj = obstacles.get(obstacles.size()-1);
                   obstacles.remove(obstacles.size()-1);

                   obj.x = obj2 + 100;

                   obstacles.add(obj);
               }
           }
       }
    }
}
