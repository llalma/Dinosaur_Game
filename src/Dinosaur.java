public class Dinosaur {
    int x,y;
    final int width = 30;
    final int height = 60;
    final int jump_Height = 40;

    public Dinosaur(){
        this.x = 30;
        this.y = 360-height;
    }

    public void jump(){
        this.y = y - jump_Height;
    }
}
