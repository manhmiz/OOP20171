package touhou.players;

import bases.GameObject;
import bases.physics.BoxCollider;
import touhou.enemies.Enemy;
import touhou.inputs.InputManager;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class PlayerCastSpell {

    boolean spellDisabled;
    final int COOL_DOWN_TIME = 5;
    int coolDownCount;

    public void run(Player owner) {
        if (spellDisabled) {
            coolDownCount++;
            if (coolDownCount >= COOL_DOWN_TIME) {
                spellDisabled = false;
                coolDownCount = 0;
            }
            return;
        }

        if (InputManager.instance.jPressed) {
            PlayerSpell newSpell = GameObject.recycle(PlayerSpell.class);
            newSpell.position.set(owner.position.subtract(0, 40 / 2));
            spellDisabled = true;
        }

    }
}
