import java.awt.*;
import java.net.URL;

public class Ship {

    final int WIDTH = 10;
    int x, y;
    double direction;
    boolean turning;
    boolean remove;
    int dTheta = 4, speed = 8 ;

    public Ship(Screen screen){
        x = screen.getWidth()/2;
        y = screen.getHeight()/2;
        direction = 0.0;
    }

    public void paint(Graphics g, Screen screen){
        int[] pointsX = {x-WIDTH/2, x, x+WIDTH/2};
        int[] pointsY = {y+WIDTH, y-WIDTH, y+WIDTH};
        if (turning){
            pointsX[1] += (24 * (float)Math.cos(Math.toRadians(direction - 90)));
            pointsY[1] += (24 * (float)Math.sin(Math.toRadians(direction - 90)));
            pointsX[0] += (24 * (float)Math.cos(Math.toRadians(direction + 130)));
            pointsY[0] += (24 * (float)Math.sin(Math.toRadians(direction + 130)));
            pointsX[2] += (24 * (float)Math.cos(Math.toRadians(direction + 105)));
            pointsY[2] += (24 * (float)Math.sin(Math.toRadians(direction + 105)));
        }

        g.setColor(Color.WHITE);
        g.drawRect(x, y, WIDTH, WIDTH);
        g.drawPolygon(pointsX, pointsY, 3);
    }

    public Rectangle getBounds(){
        return new Rectangle(x, y, WIDTH, WIDTH);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWIDTH(){
        return WIDTH;
    }

    public double getDirection(){
        return direction;
    }

    public boolean getRemove() {
        return remove;
    }

    public void setRemove(boolean val) {
        remove = val;
    }

    public void turnLeft(){
        turning = true;
        direction -= dTheta;
    }

    public void turnRight(){
        turning = true;
        direction += dTheta;
    }

    public void move(){
        //move the ship along the angle Direction at speed Speed somehow
        x += (speed * (float)Math.cos(Math.toRadians(direction - 90)));
        y += (speed * (float)Math.sin(Math.toRadians(direction - 90)));
    }

    public void wrap(Screen screen){
        if (x <= 0){
            x = screen.getWidth();
        }
        if (x > screen.getWidth()){
            x = 0;
        }
        if (y <= 0){
            y = screen.getHeight();
        }
        if (y > screen.getHeight()){
            y = 0;
        }
    }
}
