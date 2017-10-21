package touhou.players;

import bases.GameObject;
import bases.Utils;
import bases.Vector2d;
import touhou.players.PlayerSpell;

import java.awt.event.KeyEvent;

public class Player extends GameObject{

    boolean rightPressed;
    boolean leftPressed;
    boolean downPressed;
    boolean upPressed;

    final int SPEED = 5;
    final int LEFT = 0;
    final int RIGHT = 384;
    final int TOP = 0;
    final int BOTTOM = 550;
    boolean xPressed;


    boolean spellDisabled;
     final int COOL_DOWN_TIME = 5;


    public Player() {
        position.set(182,500);
        image = Utils.loadImage("assets/images/players/straight/0.png");
    }


    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            rightPressed = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            leftPressed = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            upPressed = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            downPressed = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_X) {
            xPressed = true;
        }
    }

    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            rightPressed = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            leftPressed = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            upPressed = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            downPressed = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_X) {
            xPressed = false;
        }
    }

    public void run() {
        move();
        shoot();
    }
    Vector2d velocity = new Vector2d();
    private void move() {
        velocity.set(0,0);
        if (rightPressed) {
            velocity.x += SPEED;
        }
        if (leftPressed) {
            velocity.x -= SPEED;
        }
        if (upPressed) {
            velocity.y -= SPEED;
        }
        if (downPressed) {
            velocity.y += SPEED;
        }

        position.addUP(velocity);

        position.x = (int) clamp(position.x, LEFT, RIGHT);
        position.y = (int) clamp(position.y, TOP, BOTTOM);
    }

    int coolDownCount;


    public void shoot(){
        if ( spellDisabled){
            coolDownCount++;
            if (coolDownCount >= COOL_DOWN_TIME){
                spellDisabled = false;
                coolDownCount = 0;
            }
            return;
        }
        if (xPressed){
            PlayerSpell newSpell = new PlayerSpell();
            newSpell.position.set(this.position.subtract(0,image.getHeight()/2));
            GameObject.add(newSpell);
            spellDisabled = true;
        }
    }

    private float clamp(float value, float min, float max) {
        if (value < min) {
            return min;
        }
        if (value > max) {
            return max;
        }
        return value;
    }

}
