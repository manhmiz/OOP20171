package game.enemies;

import bases.GameObject;
import bases.inputs.InputManager;
import bases.physics.BoxCollider;
import bases.physics.PhysicsBody;
import bases.physics.Vector2d;
import game.platforms.Brick;
import game.platforms.Rock;
import game.platforms.Water;

public class Enemy extends GameObject implements PhysicsBody{
    BoxCollider boxCollider = new BoxCollider(32,32);

    float SPEED = 2;
    EnemyAnimator animator;

    Vector2d velocity;
    public Enemy(){
        this.position.set(400,550);
        velocity = new Vector2d();

        animator = new EnemyAnimator();
        this.renderer = animator;

    }

    @Override
    public void run() {

        boxCollider.position.set(this.position.subtract(10,10));

        animator.run();

        moveVertical();
        moveHorizontal();

        position.addUP(velocity);
    }


    private void moveVertical() {

        BoxCollider nextBoxCollider = this.boxCollider.shift(0,velocity.y);

        Brick brick = GameObject.collideWith(nextBoxCollider,Brick.class);
        Rock rock = GameObject.collideWith(nextBoxCollider,Rock.class);
        Water water = GameObject.collideWith(nextBoxCollider,Water.class);
        if (brick != null || rock !=null || water != null){
            boolean moveContinue = true;
            float shiftDistance = Math.signum(velocity.y);
            while (moveContinue){
                if (GameObject.collideWith(this.boxCollider.shift(0,shiftDistance),Brick.class) != null
                        || GameObject.collideWith(this.boxCollider.shift(0,shiftDistance),Rock.class) != null
                        || GameObject.collideWith(this.boxCollider.shift(0,shiftDistance),Water.class) != null){
                    moveContinue = false;
                }else {
                    shiftDistance +=Math.signum(velocity.y);
                    this.position.addUP(0,Math.signum(velocity.y));
                }

            }
            velocity.y = 0;
        }
    }

    private void moveHorizontal() {
        BoxCollider nextBoxCollider = this.boxCollider.shift(velocity.x,0);

        Brick brick = GameObject.collideWith(nextBoxCollider,Brick.class);
        Rock rock = GameObject.collideWith(nextBoxCollider,Rock.class);
        Water water = GameObject.collideWith(nextBoxCollider,Water.class);
        if (brick != null || rock !=null || water != null){
            boolean moveContinue = true;
            float shiftDistance = Math.signum(velocity.x);
            while (moveContinue){
                if (GameObject.collideWith(this.boxCollider.shift(shiftDistance,0),Brick.class) != null
                        || GameObject.collideWith(this.boxCollider.shift(shiftDistance,0),Rock.class) != null
                        || GameObject.collideWith(this.boxCollider.shift(shiftDistance,0),Water.class) != null){
                    moveContinue = false;
                }else {
                    shiftDistance += Math.signum(velocity.x);
                    this.position.addUP(Math.signum(velocity.x),0);
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
