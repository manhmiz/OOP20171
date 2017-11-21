package game.players;

import bases.GameObject;
import bases.physics.BoxCollider;
import bases.physics.PhysicsBody;

public class PlayerSpell extends GameObject implements PhysicsBody{
    @Override
    public BoxCollider getBoxCollider() {
        return null;
    }
}
