import java.awt.*;
import java.net.URL;

public class Ship {

    final int WIDTH = 10;
    final int FIRE_RATE = 150; //measured in ms
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
        int turretX = x;
        int turretY = y;

        turretX += (24 * (float)Math.cos(Math.toRadians(direction -90)));
        turretY += (24 * (float)Math.sin(Math.toRadians(direction -90)));

        g.setColor(Color.WHITE);
        g.fillRect(x, y, WIDTH, WIDTH);
        g.drawRect(turretX, turretY, WIDTH/4, WIDTH/4);
    }

    public Rectangle getBounds(){
        return new Rectangle(x, y, WIDTH, WIDTH);
    }

    public int getFIRE_RATE() {
        return FIRE_RATE;
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
