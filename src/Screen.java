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
    }

    //initialize objects in game
    public void init(){
        Gamestates.setMENU(true);
        ship = new Ship(this);
        for (int i = 0; i < 3; i++){
            asterisks.add(new Asterisk(this));
        }

        asteriskDelay = System.currentTimeMillis();
        bulletDelay = System.currentTimeMillis();
    }

    public void paintComponent(Graphics g){
        timer.start();
        super.paintComponent(g);

        if (!Gamestates.isDEAD()){
            ship.paint(g, this);
            for (Asterisk asterisk: asterisks){
                asterisk.paint(g);
            }
            for (Bullet bullet: bullets){
                bullet.paint(g);
            }
        }

    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        long currentTime = System.currentTimeMillis();

        if (!Gamestates.isDEAD()){
            ship.wrap(this);
            if (ship.getRemove()){
                System.out.println("die");
                Gamestates.setDEAD(true);
            }

            //a bunch of input code
            if (game.isSpacePressed() && currentTime - bulletDelay >= ship.getFIRE_RATE()){
                bullets.add(new Bullet(ship));
                bullets.get(bullets.size()-1).bulletTime = System.currentTimeMillis();
                bullets.get(bullets.size()-1).direction = ship.getDirection();
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
                bullets.get(i).move();
                bullets.get(i).wrap(this);
                for (int j = asterisks.size()-1; j >= 0; j--){
                    bullets.get(i).checkHit(asterisks.get(j));
                }

                if (currentTime - bullets.get(i).bulletTime >= 700 || bullets.get(i).getRemove()){
                    bullets.remove(bullets.get(i));
                }
            }

            //update asterisks on screen
            for (int i = asterisks.size()-1; i >= 0; i--){
                asterisks.get(i).wrap(this);
                asterisks.get(i).move();
                asterisks.get(i).checkHit(ship);

                if (asterisks.get(i).getRemove())
                {
                    if (asterisks.get(i).getDiameter() > asterisks.get(i).getMIN_DIAMETER()){
                        int spawnDiameter = asterisks.get(i).getDiameter()/2;
                        int spawnX = asterisks.get(i).getX();
                        int spawnY = asterisks.get(i).getY();
                        asterisks.add(new Asterisk(spawnDiameter, spawnX, spawnY));
                        asterisks.add(new Asterisk(spawnDiameter, spawnX, spawnY));
                    }

                    asterisks.remove(asterisks.get(i));
                }
            }

            if (currentTime - asteriskDelay >= 2400){
                asterisks.add(new Asterisk(this));
                asteriskDelay = System.currentTimeMillis();
            }
        }


        repaint();
    }




}
