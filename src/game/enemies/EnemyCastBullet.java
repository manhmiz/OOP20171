package game.enemies;

import bases.GameObject;
import game.enemies.DownBullet;
import game.enemies.LeftBullet;
import game.enemies.RightBullet;
import game.enemies.UpBullet;

public class EnemyCastBullet {
//    boolean bulletDisabled;
//    final int COOL_DOWN_TIME = 40;
//    int coolDownCount;
    public void run(Enemy owner){
//        if (bulletDisabled){
//            coolDownCount++;
//            if (coolDownCount >= COOL_DOWN_TIME){
//                bulletDisabled = false;
//                coolDownCount = 0;
//                System.out.println("ngung ban");
//            }
//        }
            switch (Enemy.direction){
                case 0:
                    LeftBullet leftBullet = GameObject.recycle(LeftBullet.class);
                    leftBullet.position.set(owner.position.subtract(16,0));
//                    bulletDisabled = true;
                    break;
                case 1:
                    RightBullet rightBullet = GameObject.recycle(RightBullet.class);
                    rightBullet.position.set(owner.position.add(16,0));
//                    bulletDisabled = true;
                    break;
                case 2:
                    UpBullet upBullet = GameObject.recycle(UpBullet.class);
                    upBullet.position.set(owner.position.subtract(0,16));
//                    bulletDisabled = true;
                    break;
                case 3:
                    DownBullet downBullet = GameObject.recycle(DownBullet.class);
                    downBullet.position.set(owner.position.add(0,16));
//                    bulletDisabled = true;
                    break;
            }

    }
}
