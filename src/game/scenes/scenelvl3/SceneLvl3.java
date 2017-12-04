package game.scenes.scenelvl3;

import bases.GameObject;
import bases.scenes.Scene;
import game.enemies.Enemy;
import game.finish.FinishLvl2;
import game.finish.FinishLvl3;
import maps.Map;

public class SceneLvl3 implements Scene{
    int a = 19;

    @Override
    public void deinit() {
        GameObject.clearAll();
    }

    @Override
    public void init() {

        addEnemy();
        addFinish();

        Map map = Map.load("assets/maps/mapLvl3.json");
        map.generate();
    }

    private void addFinish() {
        FinishLvl3 finish = GameObject.recycle(FinishLvl3.class);
        finish.position.set(a * 13, a * 14);
    }

    private void addEnemy() {
        Enemy enemy = GameObject.recycle(Enemy.class);
        enemy.position.set(a * 7, a * 7);

        Enemy enemy1 = GameObject.recycle(Enemy.class);
        enemy1.position.set(a * 25, a * 7);

        Enemy enemy2 = GameObject.recycle(Enemy.class);
        enemy2.position.set(a * 7, a * 20);

        Enemy enemy3 = GameObject.recycle(Enemy.class);
        enemy3.position.set(a * 21, a * 20);

        Enemy enemy4 = GameObject.recycle(Enemy.class);
        enemy4.position.set(a * 25, a * 25);

        Enemy enemy5 = GameObject.recycle(Enemy.class);
        enemy5.position.set(a * 8, a * 23);

        Enemy enemy6 = GameObject.recycle(Enemy.class);
        enemy6.position.set(a * 2, a * 25);

        Enemy enemy7 = GameObject.recycle(Enemy.class);
        enemy7.position.set(a * 2, a * 2);

        Enemy enemy8 = GameObject.recycle(Enemy.class);
        enemy8.position.set(a * 8, a * 4);

        Enemy enemy9 = GameObject.recycle(Enemy.class);
        enemy9.position.set(a * 30, a * 2);

        Enemy enemy10 = GameObject.recycle(Enemy.class);
        enemy10.position.set(a * 28, a * 8);

        Enemy enemy11 = GameObject.recycle(Enemy.class);
        enemy11.position.set(a * 30, a * 30);


    }
}
