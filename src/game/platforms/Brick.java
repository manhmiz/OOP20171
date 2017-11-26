package game.platforms;

import bases.GameObject;
import bases.physics.BoxCollider;
import bases.physics.PhysicsBody;
import bases.renderers.ImageRenderer;

public class Brick extends GameObject implements PhysicsBody{
    BoxCollider boxCollider = new BoxCollider(19,19);
    public Brick(){
        this.renderer = new ImageRenderer("assets/images/platforms/brick.png");
        this.boxCollider.position.set(this.position);
    }

    @Override
    public BoxCollider getBoxCollider() {
        return null;
    }
}
