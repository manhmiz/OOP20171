package touhou.players;

import bases.GameObject;
import bases.Utils;
import bases.Vector2d;
import touhou.inputs.InputManager;

public class Sphere extends GameObject{
    final int S = 30;

    Player player = new Player();

    SphereCastSpell castSpell = new SphereCastSpell();

    public Sphere()
    {
        position.set(player.position.subtract(S,0));
        image = Utils.loadImage("assets/images/sphere/0.png");
        this.castSpell = new SphereCastSpell();
    }
    public void run(){
        move();
        this.castSpell.run(this);
    }
    Vector2d velocity = new Vector2d();
    private void move() {
        velocity.set(0, 0);
        InputManager inputManager = InputManager.instance;
        if (inputManager.rightPressed) {
            velocity.x += player.SPEED;
        }
        if (inputManager.leftPressed) {
            velocity.x -= player.SPEED;
        }
        if (inputManager.upPressed) {
            velocity.y -= player.SPEED;
        }
        if (inputManager.downPressed) {
            velocity.y += player.SPEED;
        }

        position.addUP(velocity);

        position.x = (int) clamp(position.x, player.LEFT - S, player.RIGHT - S);
        position.y = (int) clamp(position.y, player.TOP, player.BOTTOM);
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
    public void getHit(){
        isActive = false;
    }
}
