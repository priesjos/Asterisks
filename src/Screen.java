import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Screen extends JPanel implements ActionListener {

    Game game;
    Ship ship;
    Timer timer;
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
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        ship.paint(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (game.isLeftPressed()){
            ship.turnLeft();
        }

        if (game.isRightPressed()){
            ship.turnRight();
        }

        if (game.isUpPressed()){
            ship.move();
        }

        repaint();
    }

}
