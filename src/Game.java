import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game extends JFrame implements KeyListener {

    Screen screen;
    boolean upPressed, leftPressed, rightPressed, spacePressed;

    public Game(){
        setTitle("ASTERISKS");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        screen = new Screen(this);
        add(screen);
        addKeyListener(this);
        pack();
        screen.init();

        setLocationRelativeTo(null);
    }

    public static void main(String[] args){
        new Game();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
