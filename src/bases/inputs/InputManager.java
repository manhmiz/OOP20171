package bases.inputs;

import java.awt.event.KeyEvent;

public class InputManager {
    //Tracking user input
    //Provide inphut states for other classses
    //Singleton
    public boolean isLeft;
    public boolean isRight;
    public boolean isUp;
    public boolean isDown;
    public boolean jPressed;
    public boolean spacePressed;
    public boolean kPressed;
    public boolean xPressed;

    public static int BULLET_MOVE =3;
//    public static int BULLET_MOVE ;

    public static final InputManager instance = new InputManager();

    public InputManager() {

    }

    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_J) {
            jPressed = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_K){
            kPressed = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_X){
            xPressed = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE){
            spacePressed = true;
        }
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_A:
                isLeft = true;
                BULLET_MOVE = 1;
                break;
            case KeyEvent.VK_D:
                isRight = true;
                BULLET_MOVE = 2;
                break;
            case KeyEvent.VK_W:
                isUp = true;
                BULLET_MOVE = 3;
                break;
            case KeyEvent.VK_S:
                isDown = true;
                BULLET_MOVE = 4;
                break;
        }

    }

    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_J) {
            jPressed = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_K){
            kPressed = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_X){
            xPressed = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE){
            spacePressed = false;
        }
        int keyCode = e.getKeyCode();

        switch (keyCode) {
            case KeyEvent.VK_A:
                isLeft = false;
                break;
            case KeyEvent.VK_D:
                isRight = false;
                break;
            case KeyEvent.VK_W:
                isUp = false;
                break;
            case KeyEvent.VK_S:
                isDown = false;
                break;
        }

    }
}
