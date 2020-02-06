import java.awt.*;

public class Bullet {
    int x, y, diameter = 20;
    int speed = 24, dx, dy = 10;
    double direction;
    long bulletTime = 0;
    boolean remove;

    public Bullet(Ship ship){
        x = ship.getX() - ship.getWIDTH()/2;
        y = ship.getY();
    }

    public void move(){
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

    public void paint(Graphics g){
        g.setColor(Color.WHITE);
        g.fillOval(x, y, diameter/2, diameter);
    }

    public Rectangle getBounds(){
        return new Rectangle(x, y, diameter, diameter);
    }

    public void checkHit(Asterisk target){
        if (getBounds().intersects(target.getBounds())){
            target.setRemove(true);
            //setRemove(true); //sometimes disabled for op penetrating shot
        }
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

    public double getDirection() { return direction; }

    public void setDirection(double val) { direction = val; }

    public boolean getRemove(){
        return remove;
    }

    public void setRemove(boolean val){
        remove = val;
    }
}
