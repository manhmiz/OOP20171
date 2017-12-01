package game.players;

import bases.GameObject;
import bases.Utils;
import bases.inputs.InputManager;
import bases.physics.BoxCollider;
import bases.physics.PhysicsBody;
import bases.physics.Vector2d;
import bases.renderers.Animation;
import bases.renderers.ImageRenderer;
import game.platforms.Brick;
import game.platforms.Rock;

import java.awt.image.BufferedImage;

public class PlayerSpell extends GameObject implements PhysicsBody {
    BoxCollider boxCollider;
    Vector2d velocity;

    final int SPEED = 5;

    public PlayerSpell() {
        boxCollider = new BoxCollider(8, 8);
        BufferedImage[] images = new BufferedImage[]{Utils.loadImage("assets/images/player-bullets/bullet.png")};
        this.renderer = new Animation(images);
        velocity = new Vector2d();
        InputManager inputManager = InputManager.instance;
        switch (inputManager.BULLET_MOVE) {
            case 1:
                this.velocity.x = -SPEED;
                this.velocity.y = 0;
                break;
            case 2:
                this.velocity.x = SPEED;
                this.velocity.y = 0;
                break;
            case 3:
                this.velocity.y = -SPEED;
                this.velocity.x = 0;
                break;
            case 4:
                this.velocity.y = SPEED;
                this.velocity.x = 0;
                break;

        }

    }

    public void run() {
        boxCollider.position.set(this.position.subtract(10,10));
        if (position.x < 0 || position.x > 600 || position.y < 0 || position.y > 600) {
            this.isActive = false;
        }

        this.position.addUP(this.velocity);

        Brick brick = GameObject.collideWith(boxCollider, Brick.class);
        if (brick != null) {
            brick.getHit();
            this.isActive = false;
        }
        Rock rock = GameObject.collideWith(boxCollider, Rock.class);
        if (rock != null) {
            this.isActive = false;
        }


    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
//        return null;
    }
}
