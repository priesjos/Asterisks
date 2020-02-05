import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Screen extends JPanel implements ActionListener {

    Game game;
    Ship ship;
    Bullet bullet;
    Asterisk asterisk;
    Timer timer;
    Long bulletDelay;
    Long asteriskDelay;
    ArrayList<Bullet> bullets = new ArrayList<Bullet>();
    ArrayList<Asterisk> asterisks = new ArrayList<Asterisk>();
    /*Rocks and bullets are going to be in an array list*/

    public Screen(Game game) {
        this.game = game;
        setPreferredSize(new Dimension(1200, 800));
        setBackground(Color.BLACK);
        timer = new Timer(1000/60, this);
        timer.start();
    }

    //initialize objects in game
    public void init(){
        ship = new Ship(this);
        for (int i = 0; i < 3; i++){
            asterisks.add(new Asterisk(this));
        }

        asteriskDelay = System.currentTimeMillis();
        bulletDelay = System.currentTimeMillis();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        ship.paint(g);

        for (Asterisk asterisk: asterisks){
            asterisk.paint(g);
        }

        for (Bullet bullet: bullets){
            bullet.paint(g);
        }
    }

    public void checkCollisions(){

        for (int i = bullets.size()-1; i  >= 0; i--)
        {
            for (int j = 0; j < asterisks.size(); j++)
            {
                if (asterisks.get(j) != null)
                {
                    if(bullets.get(i).getBounds().intersects(asterisks.get(i).getBounds())){
                        bullets.get(i).setRemove(true);
                        asterisks.get(j).setRemove(true);
                    }
                }

                if (asterisks.get(j).getRemove())
                {
                    if (asterisks.get(j).getDiameter() > asterisks.get(j).getMIN_DIAMETER()){
                        int spawnDiameter = asterisks.get(j).getDiameter()/2;
                        int spawnX = asterisks.get(j).getX();
                        int spawnY = asterisks.get(j).getY();
                        asterisks.add(new Asterisk(spawnDiameter, spawnX, spawnY));
                        asterisks.add(new Asterisk(spawnDiameter, spawnX, spawnY));
                    }

                    asterisks.remove(asterisks.get(j));
                }
            }

            if (bullets.get(i).getRemove())
                bullets.remove(bullets.get(i));
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        long currentTime = System.currentTimeMillis();

        ship.wrap(this);
        checkCollisions();
        //a bunch of input code
        if (game.isSpacePressed() && currentTime - bulletDelay >= 250){
            bullets.add(new Bullet(ship));
            bullets.get(bullets.size()-1).bulletTime = System.currentTimeMillis();
            bulletDelay = System.currentTimeMillis();
        }

        if (game.isLeftPressed()){
            ship.turnLeft();
        }

        if (game.isRightPressed()){
            ship.turnRight();
        }

        if (game.isUpPressed()){
            ship.move();
        }
        //update bullets on screen
        for (int i = bullets.size()-1; i >= 0; i--){
            bullets.get(i).move(ship);
            bullets.get(i).wrap(this);

            if (currentTime - bullets.get(i).bulletTime >= 700){
                bullets.remove(bullets.get(i));
            }
        }
        //update asterisks on screen
        for (int i = asterisks.size()-1; i >= 0; i--){
            asterisks.get(i).move();
            asterisks.get(i).wrap(this);
        }

        if (currentTime - asteriskDelay >= 4800){
            asterisks.add(new Asterisk(this));
            asteriskDelay = System.currentTimeMillis();
        }


        repaint();
    }

}
