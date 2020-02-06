import java.awt.*;
import java.net.URL;

public class Ship {

    Image shipSprite;
    final int WIDTH = 10;
    int x, y;
    double direction;
    boolean moving;
    int dTheta = 4, speed = 8 ;

    public Ship(Screen screen){
        x = screen.getWidth()/2;
        y = screen.getHeight()/2;
        direction = 0.0;
    }

    public void paint(Graphics g, Screen screen){
        int[] pointsX = {x-10, x, x+10};
        int[] pointsY = {y, y-30, y};
        g.setColor(Color.WHITE);
        g.drawRect(x, y, WIDTH, WIDTH);
        g.drawImage(shipSprite, x, y, screen);

        //g.fillPolygon(pointsX, pointsY, 3 );
    }

    public Rectangle getBounds(){
        return new Rectangle(x, y, WIDTH, WIDTH);
    }

    public void loadImage(){
        ClassLoader cl = getClass().getClassLoader();
        URL imageURL = cl.getResource("red_ship.png");
        if (imageURL != null){
            shipSprite = Toolkit.getDefaultToolkit().createImage(imageURL);
        }
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

    public void turnLeft(){
        direction -= dTheta;
    }

    public void turnRight(){
        direction += dTheta;
    }

    public void move(){
        //move the ship along the angle Direction at speed Speed somehow
        //pointsX[0] += (float)Math.cos(Math.toRadians(direction - 90));
        moving = true;
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
