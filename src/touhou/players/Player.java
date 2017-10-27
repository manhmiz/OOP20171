package touhou.players;

import bases.GameObject;
import bases.Utils;
import bases.Vector2d;
import bases.physics.BoxCollider;
import bases.physics.PhysicsBody;
import touhou.inputs.InputManager;
import touhou.players.PlayerSpell;

import java.awt.event.KeyEvent;

public class Player extends GameObject implements PhysicsBody {


     public final int SPEED = 5;
     public final int LEFT = 0;
     public  int RIGHT = 384;
     public  int TOP = 0;
     public  int BOTTOM = 550;


    public BoxCollider boxCollider;

    PlayerCastSpell castSpell = new PlayerCastSpell();

    public Player() {
        position.set(182, 500);
        image = Utils.loadImage("assets/images/players/straight/0.png");
        boxCollider = new BoxCollider(5, 5);
        this.castSpell = new PlayerCastSpell();
    }



    public void run() {
        move();
        boxCollider.position.set(this.position);
        this.castSpell.run(this );
    }

    Vector2d velocity = new Vector2d();

    private void move() {
        velocity.set(0, 0);
        InputManager inputManager = InputManager.instance;
        if (inputManager.rightPressed) {
            velocity.x += SPEED;
        }
        if (inputManager.leftPressed) {
            velocity.x -= SPEED;
        }
        if (inputManager.upPressed) {
            velocity.y -= SPEED;
        }
        if (inputManager.downPressed) {
            velocity.y += SPEED;
        }

        position.addUP(velocity);

        position.x = (int) clamp(position.x, LEFT, RIGHT);
        position.y = (int) clamp(position.y, TOP, BOTTOM);
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

    public void getHit() {
        isActive = false;
    }

    @Override
    public BoxCollider getBoxCollider() {
        return boxCollider;
    }
}
