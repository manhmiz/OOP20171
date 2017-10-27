package touhou.enemies;

import bases.GameObject;
import bases.Utils;
import bases.physics.BoxCollider;
import bases.physics.PhysicsBody;
import touhou.enemies.EnemyBullet;

public class Enemy extends GameObject implements PhysicsBody {

    public BoxCollider boxCollider;

    final int yTurn = 200;
    final int SPEED = 2;

    boolean bulletDisabled;
    final int COOL_DOWN_TIME = 30;
    int coolDownTime;

    PlayerDamge playerDamge = new PlayerDamge();

    public Enemy() {
        boxCollider = new BoxCollider(30, 30);
        this.image = Utils.loadImage("assets/images/enemies/level0/blue/0.png");
        this.playerDamge = new PlayerDamge();
    }


    public void run() {
        boxCollider.position.set(this.position);
        shoot();
        move();
        this.playerDamge.run(this);
    }


    public void move() {
        if (position.y != yTurn) {
            position.addUP(0, SPEED);
        } else position.addUP(SPEED, 0);
        deactiveIfNeeded();
    }

    private void deactiveIfNeeded() {
        if (position.x > 384){
            this.isActive = false;
        }
    }

    private void shoot() {
        if (bulletDisabled) {
            coolDownTime++;
            if (coolDownTime >= COOL_DOWN_TIME) {
                bulletDisabled = false;
                coolDownTime = 0;
            }
            return;
        }
        EnemyBullet newBullet = GameObject.recycle(EnemyBullet.class);
        newBullet.position.set(position);
        bulletDisabled = true;
    }

    public void getHit() {
        isActive = false;
    }

    @Override
    public BoxCollider getBoxCollider() {
        return boxCollider;
    }
}