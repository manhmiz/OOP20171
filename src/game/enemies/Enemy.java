package game.enemies;

import bases.GameObject;
import bases.inputs.InputManager;
import bases.physics.BoxCollider;
import bases.physics.PhysicsBody;
import bases.physics.Vector2d;
import game.platforms.Brick;
import game.platforms.Rock;
import game.platforms.Water;

import java.util.Random;

public class Enemy extends GameObject implements PhysicsBody {
    BoxCollider boxCollider = new BoxCollider(32, 32);

    float SPEED = 2;
    EnemyAnimator animator;

    Vector2d velocity;

    protected static int direction;

    protected static final int LEFT = 0;
    protected static final int RIGHT = 1;
    protected static final int UP = 2;
    protected static final int DOWN = 3;

    public Enemy() {
        this.position.set(400, 550);
        velocity = new Vector2d();

        animator = new EnemyAnimator();
        this.renderer = animator;
        this.direction = LEFT;
    }

    @Override
    public void run() {

        boxCollider.position.set(this.position.subtract(10, 10));

        animator.run(this);

        move();
        moveVertical();
        moveHorizontal();

        position.addUP(velocity);


    }

    private void move() {
        switch (direction) {
            case LEFT:
                velocity.x =- SPEED;
                velocity.y = 0;
                Random rd = new Random();
                int rdInt = rd.nextInt(10000);
                if (rdInt > 9800) {
                    changeDirection();
                }
                break;
            case RIGHT:
                velocity.x = SPEED;
                velocity.y = 0;
                Random rd2 = new Random();
                int rdInt2 = rd2.nextInt(10000);
                if (rdInt2 > 9800) {
                    changeDirection();
                }
                break;
            case UP:
                velocity.y =- SPEED;
                velocity.x = 0;
                Random rd3 = new Random();
                int rdInt3 = rd3.nextInt(10000);
                if (rdInt3 > 9800) {
                    changeDirection();
                }
                break;
            case DOWN:
                velocity.y = SPEED;
                velocity.x = 0;
                Random rd4 = new Random();
                int rdInt4 = rd4.nextInt(10000);
                if (rdInt4 > 9800) {
                    changeDirection();
                }
                break;
        }

    }

    private void changeDirection() {
        Random rd = new Random();
        int i = rd.nextInt(3) + 1;
        direction = (direction + i) % 4;
    }


    private void moveVertical() {

        BoxCollider nextBoxCollider = this.boxCollider.shift(0, velocity.y);

        Brick brick = GameObject.collideWith(nextBoxCollider, Brick.class);
        Rock rock = GameObject.collideWith(nextBoxCollider, Rock.class);
        Water water = GameObject.collideWith(nextBoxCollider, Water.class);
        if (brick != null || rock != null || water != null) {
            boolean moveContinue = true;
            float shiftDistance = Math.signum(velocity.y);
            while (moveContinue) {
                if (GameObject.collideWith(this.boxCollider.shift(0, shiftDistance), Brick.class) != null
                        || GameObject.collideWith(this.boxCollider.shift(0, shiftDistance), Rock.class) != null
                        || GameObject.collideWith(this.boxCollider.shift(0, shiftDistance), Water.class) != null) {
                    moveContinue = false;
                    changeDirection();
                } else {
                    shiftDistance += Math.signum(velocity.y);
                    this.position.addUP(0, Math.signum(velocity.y));
                }

            }
            velocity.y = 0;
        }
    }

    private void moveHorizontal() {
        BoxCollider nextBoxCollider = this.boxCollider.shift(velocity.x, 0);

        Brick brick = GameObject.collideWith(nextBoxCollider, Brick.class);
        Rock rock = GameObject.collideWith(nextBoxCollider, Rock.class);
        Water water = GameObject.collideWith(nextBoxCollider, Water.class);
        if (brick != null || rock != null || water != null) {
            boolean moveContinue = true;
            float shiftDistance = Math.signum(velocity.x);
            while (moveContinue) {
                if (GameObject.collideWith(this.boxCollider.shift(shiftDistance, 0), Brick.class) != null
                        || GameObject.collideWith(this.boxCollider.shift(shiftDistance, 0), Rock.class) != null
                        || GameObject.collideWith(this.boxCollider.shift(shiftDistance, 0), Water.class) != null) {
                    moveContinue = false;
                    changeDirection();
                } else {
                    shiftDistance += Math.signum(velocity.x);
                    this.position.addUP(Math.signum(velocity.x), 0);
                }

            }
            velocity.x = 0;
        }
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }

    public void getHit() {
        this.isActive = false;
    }
}
