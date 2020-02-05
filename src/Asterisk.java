import java.awt.*;

public class Asterisk {
    final int MAX_DIAMETER = 128, MIN_DIAMETER = 32, MIN_SPEED = 256;
    int x, y, diameter;
    double direction;
    int speed, dx, dy;
    boolean remove;

    public Asterisk(int diameter, int x, int y){
        this.x = x;
        this.y = y;
        this.diameter = diameter;
        direction = (int)(Math.random()*361);
        speed = MIN_SPEED/diameter;
    }

    public Asterisk(Screen screen){
        x = screen.getWidth()*(int)(Math.random()*2);
        y = screen.getHeight()*(int)(Math.random()*2);
        diameter = MIN_DIAMETER*(int)(Math.ceil(Math.random()*4));
        direction = (int)(Math.random()*361);
        speed = MIN_SPEED/diameter;
    }

    public void spawn(int spawnX, int spawnY){
        x = spawnX;
        y = spawnY;
    }

    public void move(){
        //dx and dy move along some random angle
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

    public Rectangle getBounds(){
        return new Rectangle(x, y, diameter, diameter);
    }

    public void paint(Graphics g){
        g.setColor(Color.WHITE);
        g.drawLine(x+diameter/2, y, x-diameter/2, y);
        g.drawLine(x+diameter/3, y-diameter/3, x-diameter/3, y+diameter/3);
        g.drawLine(x-diameter/3, y-diameter/3, x+diameter/3, y+diameter/3);
    }

    public int getDiameter(){
        return diameter;
    }

    public int getMIN_DIAMETER(){
        return MIN_DIAMETER;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public void setX(int newX){
        x = newX;
    }

    public void setY(int newY){
        y = newY;
    }

    public boolean getRemove(){
        return remove;
    }

    public void setRemove(boolean val){
        remove = val;
    }


}
