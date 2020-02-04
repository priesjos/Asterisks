import java.awt.*;

public class Bullet {
    int x, y, diameter = 10;
    int speed = 24, dx, dy = 10;
    long bulletTime = 0;

    public Bullet(Ship ship){
        x = ship.getX() - ship.getWIDTH()/2;
        y = ship.getY();
    }

    public void move(Ship ship){
        x += (speed * (float)Math.cos(Math.toRadians(ship.getDirection() - 90)));
        y += (speed * (float)Math.sin(Math.toRadians(ship.getDirection() - 90)));
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

    public void paint(Graphics g){
        g.setColor(Color.WHITE);
        g.fillOval(x, y, diameter, diameter/2);
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public long getBulletTime(){
        return bulletTime;
    }
}
