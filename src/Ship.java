import java.awt.*;

public class Ship {

    int x;
    int y;
    double direction;
    boolean moving;
    int dTheta = 4, speed = 12;

    public Ship(Screen screen){
        x = screen.getWidth()/2;
        y = screen.getHeight()/2;
        direction = 0.0;
    }

    public void paint(Graphics g){
        int[] pointsX = {x-10, x, x+10};
        int[] pointsY = {y, y-30, y};
        if (moving){
            for (int i= 0; i < pointsX.length; i++){
                pointsX[i] += speed*(float)Math.cos(Math.toRadians(direction - 90));
            }
            for (int i = 0; i < pointsY.length; i++){
                pointsY[i] += speed*(float)Math.sin(Math.toRadians(direction - 90));
            }
            //pointsX[0] += 10*(float)Math.cos(Math.toRadians(direction - 90));
            //pointsX[1] += 10*(float)Math.cos(Math.toRadians(direction - 90));
            ///pointsX[2] += 10*(float)Math.cos(Math.toRadians(direction - 90));
        }
        g.setColor(Color.WHITE);
        g.fillPolygon(pointsX, pointsY, 3 );
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
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
}
