package game.scenes.scenelvl4;

import bases.GameObject;
import bases.scenes.Scene;
import game.enemies.Enemy;
import game.finish.FinishLvl3;
import game.finish.FinishLvl4;
import maps.Map;

public class SceneLvl4 implements Scene{
    int a = 19;

    @Override
    public void deinit() {
        GameObject.clearAll();
    }

    @Override
    public void init() {

        addEnemy();
        addFinish();

        Map map = Map.load("assets/maps/mapLvl4.json");
        map.generate();
    }

    private void addFinish() {
        FinishLvl4 finish = GameObject.recycle(FinishLvl4.class);
        finish.position.set(a * 16, a * 18);
    }

    private void addEnemy() {
        Enemy enemy = GameObject.recycle(Enemy.class);
        enemy.position.set(a * 2, a * 2);
        enemy.setHP(20);
        Enemy enemy1 = GameObject.recycle(Enemy.class);
        enemy1.position.set(a * 16, a * 2);
        enemy1.setHP(20);
        Enemy enemy2 = GameObject.recycle(Enemy.class);
        enemy2.position.set(a * 30, a * 2);
        enemy2.setHP(20);
        Enemy enemy3 = GameObject.recycle(Enemy.class);
        enemy3.position.set(a * 4, a * 6);
        enemy3.setHP(20);
        Enemy enemy4 = GameObject.recycle(Enemy.class);
        enemy4.position.set(a * 5, a * 12);
        enemy4.setHP(15);
        Enemy enemy5 = GameObject.recycle(Enemy.class);
        enemy5.position.set(a * 27, a * 12);
        enemy5.setHP(15);
        Enemy enemy6 = GameObject.recycle(Enemy.class);
        enemy6.position.set(a * 4, a * 26);
        enemy6.setHP(15);
        Enemy enemy7 = GameObject.recycle(Enemy.class);
        enemy7.position.set(a * 28, a * 26);
        enemy7.setHP(15);
        Enemy enemy8 = GameObject.recycle(Enemy.class);
        enemy8.position.set(a * 14, a * 20);
        enemy8.setHP(10);
        Enemy enemy9 = GameObject.recycle(Enemy.class);
        enemy9.position.set(a * 28, a * 20);
        enemy9.setHP(10);
        Enemy enemy10 = GameObject.recycle(Enemy.class);
        enemy10.position.set(a * 2, a * 30);
        enemy10.setHP(10);
        Enemy enemy11 = GameObject.recycle(Enemy.class);
        enemy11.position.set(a * 30, a * 30);
        enemy11.setHP(10);

    }
}
