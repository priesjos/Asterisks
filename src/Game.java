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

    public boolean isUpPressed() {
        return upPressed;
    }

    public boolean isLeftPressed() {
        return leftPressed;
    }

    public boolean isRightPressed() {
        return rightPressed;
    }

    public boolean isSpacePressed() {
        return spacePressed;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP){
            upPressed = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT){
            leftPressed = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT){
            rightPressed = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE){
            spacePressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP){
            upPressed = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT){
            leftPressed = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT){
            rightPressed = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE){
            spacePressed = false;
        }
    }
}
