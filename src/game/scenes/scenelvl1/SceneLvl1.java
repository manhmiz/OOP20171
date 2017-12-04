package game.scenes.scenelvl1;

import bases.GameObject;
import bases.scenes.Scene;
import game.enemies.Enemy;
import game.finish.Finish;
import game.finish.FinishLvl1;
import maps.Map;

public class SceneLvl1 implements Scene{

    int a = 19;

    @Override
    public void deinit() {
        GameObject.clearAll();
    }

    @Override
    public void init() {

        adFinish();
        addEnemy();
        addMap();

    }

    public void adFinish() {
        FinishLvl1 finish = GameObject.recycle(FinishLvl1.class);
        finish.position.set(a*16,a*4);
    }


    private void addMap() {
        Map map = Map.load("assets/maps/mapLvl1.json");
        map.generate();
    }

    private void addEnemy() {


        Enemy enemy = GameObject.recycle(Enemy.class);
        enemy.position.set(a*16,a*8);

        Enemy enemy1 = GameObject.recycle(Enemy.class);
        enemy1.position.set(a*5,a*8);

        Enemy enemy2 = GameObject.recycle(Enemy.class);
        enemy2.position.set(a*27,a*8);

        Enemy enemy3 = GameObject.recycle(Enemy.class);
        enemy3.position.set(a*2,a*14);

        Enemy enemy4 = GameObject.recycle(Enemy.class);
        enemy4.position.set(a*30,a*14);

        Enemy enemy5 = GameObject.recycle(Enemy.class);
        enemy5.position.set(a*2,a*20);

        Enemy enemy6 = GameObject.recycle(Enemy.class);
        enemy6.position.set(a*30,a*20);

        Enemy enemy7 = GameObject.recycle(Enemy.class);
        enemy7.position.set(a*30,a*24);

        Enemy enemy8 = GameObject.recycle(Enemy.class);
        enemy8.position.set(a*30,a*24);
    }

}
