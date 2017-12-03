package game.players;

import bases.GameObject;
import bases.inputs.InputManager;

public class PlayerCastBullet {
    boolean bulletDisabled;
    public int COOL_DOWN_TIME;
    int coolDownCount;
    public void run(Player owner){
        if (bulletDisabled){
            coolDownCount++;
            if (coolDownCount >= COOL_DOWN_TIME){
                bulletDisabled = false;
                coolDownCount = 0;
            }
            return;
        }
        if (InputManager.instance.jPressed){
            switch (InputManager.BULLET_MOVE){
                case 1:
                    LeftBullet leftBullet = GameObject.recycle(LeftBullet.class);
                    leftBullet.position.set(owner.position.subtract(16,0));
                    bulletDisabled = true;
                    break;
                case 2:
                    RightBullet rightBullet = GameObject.recycle(RightBullet.class);
                    rightBullet.position.set(owner.position.add(16,0));
                    bulletDisabled = true;
                    break;
                case 3:
                    UpBullet upBullet = GameObject.recycle(UpBullet.class);
                    upBullet.position.set(owner.position.subtract(0,16));
                    bulletDisabled = true;
                    break;
                case 4:
                    DownBullet downBullet = GameObject.recycle(DownBullet.class);
                    downBullet.position.set(owner.position.add(0,16));
                    bulletDisabled = true;
                    break;
            }
        }

    }
}
