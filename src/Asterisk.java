import java.awt.*;

public class Asterisk {
    final int MAX_DIAMETER = 128, MIN_DIAMETER = 32;
    int x, y, diameter;
    int speed, dx, dy;

    public Asterisk(){
        x = 50;
        y = 50;
        diameter = MAX_DIAMETER;
    }

    public void move(){
        //dx and dy move along some random angle
    }

    public void paint(Graphics g){
        int pointsX[] = {};
        int pointsY[] = {};
        g.setColor(Color.WHITE);
        g.drawLine(x+diameter/2, y, x-diameter/2, y);
        g.drawLine(x+diameter/3, y-diameter/3, x-diameter/3, y+diameter/3);
        g.drawLine(x-diameter/3, y-diameter/3, x+diameter/3, y+diameter/3);

    }


}
