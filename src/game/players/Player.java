package game.players;

import bases.GameObject;
import bases.inputs.InputManager;
import bases.physics.BoxCollider;
import bases.physics.PhysicsBody;
import bases.physics.Vector2d;
import bases.renderers.ImageRenderer;

public class Player extends GameObject implements PhysicsBody{

    BoxCollider boxCollider = new BoxCollider(32,32);

    float SPEED = 2;

    PlayerAnimator animator;
    PlayerCastSpell castSpell;
    public Player(){
        position.set(500,500);

        animator = new PlayerAnimator();
        this.renderer = animator;

        this.castSpell = new PlayerCastSpell();
    }

    @Override
    public void run() {
        move();
        boxCollider.position.set(this.position);
        animator.run(this);
        this.castSpell.run(this);
    }


    Vector2d velocity = new Vector2d();

    private void move() {
        velocity.set(0, 0);
        InputManager inputManager = InputManager.instance;
        if (inputManager.rightPressed) {
            velocity.x += SPEED;
            velocity.y = 0;
        }
        if (inputManager.leftPressed) {
            velocity.x -= SPEED;
            velocity.y = 0;
        }
        if (inputManager.upPressed) {
            velocity.y -= SPEED;
            velocity.x = 0;
        }
        if (inputManager.downPressed) {
            velocity.y += SPEED;
            velocity.x = 0;
        }

        position.addUP(velocity);
    }

    @Override
    public BoxCollider getBoxCollider() {
        return boxCollider;
    }
}
