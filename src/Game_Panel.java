import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
    public int score = 0;

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

        //jump
        actionmap.put("Jump", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                dino.jump();
            }
        });

        pop_obstacles();
    }

    public int getScore(){
        return score;
    }

    private void pop_obstacles(){
        ground = new Ground();
        dino = new Dinosaur();

        for(int i = 0;i<num_obstacles;i++){
            new_obstacle();
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        ground.draw(g);

        dino.update_height();
        dino.draw(g);

        draw_Objects(g);

        if(collision_check()){
            game_over();
        }else{
            score++;
            System.out.println(score);
        }
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

        obstacles.add(new Cactus(rand.nextInt(800)+screen_width));

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

    private boolean collision_check(){
        int left_dino = dino.x;
        int right_dino = dino.x + (int)dino.dino_width;
        int top_dino = (int)dino.y;
        int bottom_dino = (int)(dino.y + dino.dino_height);

        boolean check = false;

        for (Obstacle obj: obstacles) {
            int left_obj = obj.x;
            int right_obj = obj.x + (int)obj.width;
            int top_obj = (int)obj.y;
            int bottom_obj = (int)(obj.y + obj.height);

            if(!check) {
                if (right_dino >= left_obj && right_dino <= right_obj) check = true;
                if (left_dino >= left_obj && left_dino <= right_obj) check = true;

                if(check){
                    if (bottom_dino > top_obj){
                        check = true;
                    }else{
                        check = false;
                    }
                }

            }
        }

       return check;
    }

    private void game_over(){
        score = -1;
    }

}
