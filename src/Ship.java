import java.awt.*;

public class Ship {

    int x, y;
    double direction;
    int dTheta = 4, speed = 12;

    public Ship(Screen screen){
        x = screen.getWidth()/2;
        y = screen.getHeight()/2;
        direction = 0.0;
    }

    public void paint(Graphics g){
        int[] initialX = {x-((int)(1*direction)), x, x+((int)(1*direction))};
        int[] initialY = {y, y-((int)(1*direction)), y};

        g.setColor(Color.WHITE);
        g.fillPolygon(initialX, initialY, 3 );
    }

    public double getDirection(){
        return direction;
    }

    public void turnLeft(){
        direction -= dTheta;
    }

    public void turnRight(){
        direction += dTheta;
    }

    public void move(){
        //move the ship along the angle Direction at speed Speed somehow
        x += (speed * (float)Math.cos(Math.toRadians(direction - 90)));
        y += (speed * (float)Math.sin(Math.toRadians(direction - 90)));
    }
}
