package game.players;

import bases.GameObject;
import bases.Utils;
import bases.physics.BoxCollider;
import bases.physics.PhysicsBody;
import bases.physics.Vector2d;
import bases.renderers.Animation;
import game.enemies.Enemy;

import game.platforms.Brick;
import game.platforms.Rock;

import java.awt.image.BufferedImage;

public class PlayerBullet extends GameObject implements PhysicsBody {
    BoxCollider boxCollider;
    Vector2d velocity;

    final int SPEED = 5;

    public PlayerBullet() {
        boxCollider = new BoxCollider(8, 8);
        BufferedImage[] images = new BufferedImage[]{Utils.loadImage("assets/images/player-bullet/bullet.png")};
        this.renderer = new Animation(images);
        velocity = new Vector2d();


    }

    public void run() {
        boxCollider.position.set(this.position.subtract(10, 10));
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
        Enemy enemy = GameObject.collideWith(boxCollider, Enemy.class);
        if (enemy != null) {
            enemy.getHit();
            this.isActive = false;
        }
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
//        return null;
    }
}
