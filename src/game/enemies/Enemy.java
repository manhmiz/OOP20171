package game.enemies;

import bases.GameObject;
import bases.physics.BoxCollider;
import bases.physics.PhysicsBody;

public class Enemy extends GameObject implements PhysicsBody{
    @Override
    public BoxCollider getBoxCollider() {
        return null;
    }
}
