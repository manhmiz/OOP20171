package game.players;

import bases.GameObject;
import bases.inputs.InputManager;
import bases.renderers.Animation;

public class PlayerCastSpell {
    boolean spellDisabled;
    final int COOL_DOWN_TIME = 20;
    int coolDownCount;
    public void run(Player owner){
        if (spellDisabled){
            coolDownCount++;
            if (coolDownCount >= COOL_DOWN_TIME){
                spellDisabled = false;
                coolDownCount = 0;
            }
            return;
        }
        if (InputManager.instance.jPressed){
            PlayerSpell newSpell = GameObject.recycle(PlayerSpell.class);
            newSpell.position.set(owner.position);
            spellDisabled = true;
        }

    }
}
