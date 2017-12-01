package game.players;

import bases.GameObject;
import bases.inputs.InputManager;

public class PlayerCastBullet {
    boolean spellDisabled;
    final int COOL_DOWN_TIME = 40;
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
            switch (InputManager.BULLET_MOVE){
                case 1:
                    LeftBullet leftBullet = GameObject.recycle(LeftBullet.class);
                    leftBullet.position.set(owner.position);
                    spellDisabled = true;
                    break;
                case 2:
                    RightBullet rightBullet = GameObject.recycle(RightBullet.class);
                    rightBullet.position.set(owner.position);
                    spellDisabled = true;
                    break;
                case 3:
                    UpBullet upBullet = GameObject.recycle(UpBullet.class);
                    upBullet.position.set(owner.position);
                    spellDisabled = true;
                    break;
                case 4:
                    DownBullet downBullet = GameObject.recycle(DownBullet.class);
                    downBullet.position.set(owner.position);
                    spellDisabled = true;
                    break;
            }
        }

    }
}
