package game.players;

import bases.GameObject;
import bases.Utils;
import bases.physics.BoxCollider;
import bases.physics.PhysicsBody;
import bases.physics.Vector2d;
import bases.renderers.Animation;
import game.enemies.bosslvl1.BossLvl1Black;
import game.enemies.bosslvl1.BossLvl1Blue;
import game.enemies.Enemy;
import game.enemies.bosslvl2.BossLvl2Black;
import game.enemies.bosslvl2.BossLvl2Blue;
import game.platforms.Brick;
import game.platforms.Rock;

import java.awt.image.BufferedImage;

public class PlayerBullet extends GameObject implements PhysicsBody {
    BoxCollider boxCollider;
    Vector2d velocity;

    final int SPEED = 5;

    public PlayerBullet() {
        boxCollider = new BoxCollider(8, 8);
        BufferedImage[] images = new BufferedImage[]{Utils.loadImage("assets/images/player-bullets/bullet.png")};
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
        BossLvl1Blue bossLvl1 = GameObject.collideWith(boxCollider,BossLvl1Blue.class);
        if (bossLvl1 != null){
            bossLvl1.getHit();
            this.isActive = false;
        }
        BossLvl1Black bossLvl1Black = GameObject.collideWith(boxCollider,BossLvl1Black.class);
        if (bossLvl1Black != null){
            bossLvl1Black.getHit();
            this.isActive = false;
        }
        BossLvl2Blue bossLvl2 = GameObject.collideWith(boxCollider,BossLvl2Blue.class);
        if (bossLvl2 != null){
            bossLvl2.getHit();
            this.isActive = false;
        }
        BossLvl2Black bossLvl2Black = GameObject.collideWith(boxCollider,BossLvl2Black.class);
        if (bossLvl2Black != null){
            bossLvl2Black.getHit();
            this.isActive = false;
        }
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
//        return null;
    }
}
