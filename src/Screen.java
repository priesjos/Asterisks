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
        asterisk = new Asterisk();
        bulletDelay = System.currentTimeMillis();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        ship.paint(g);
        asterisk.paint(g);

        for (Bullet bullet: bullets){
            bullet.paint(g);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        long currentTime = System.currentTimeMillis();

        if (game.isSpacePressed() && currentTime - bulletDelay >= 250){
            bullets.add(new Bullet(ship));
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

        for (int i = bullets.size()-1; i >= 0; i--){
            bullets.get(i).move(ship);
        }

        repaint();
    }

}
