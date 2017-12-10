package game.scenes.scenelvl2;

import bases.GameObject;
import bases.scenes.Scene;
import game.enemies.Enemy;
import game.finish.FinishLvl1;
import game.finish.FinishLvl2;
import game.players.Player;
import game.players.playerblue.PlayerBlue;
import maps.Map;

public class SceneLvl2 implements Scene {

    int a = 19;

    @Override
    public void deinit() {
        GameObject.clearAll();
    }

    @Override
    public void init() {

        addEnemy();
        addFinish();

        Map map = Map.load("assets/maps/mapLvl2.json");
        map.generate();
    }

    private void addFinish() {
        FinishLvl2 finish = GameObject.recycle(FinishLvl2.class);
        finish.position.set(a * 16, a * 2);
    }

    private void addEnemy() {
        Enemy enemy = GameObject.recycle(Enemy.class);
        enemy.position.set(a * 8, a * 5);
        enemy.setHP(10);
        Enemy enemy1 = GameObject.recycle(Enemy.class);
        enemy1.position.set(a * 24, a * 5);
        enemy1.setHP(10);
        Enemy enemy2 = GameObject.recycle(Enemy.class);
        enemy2.position.set(a * 16, a * 5);
        enemy2.setHP(10);
        Enemy enemy3 = GameObject.recycle(Enemy.class);
        enemy3.position.set(a * 2, a * 8);
        enemy3.setHP(10);
        Enemy enemy4 = GameObject.recycle(Enemy.class);
        enemy4.position.set(a * 30, a * 8);
        enemy4.setHP(10);
        Enemy enemy5 = GameObject.recycle(Enemy.class);
        enemy5.position.set(a * 2, a * 14);
        enemy5.setHP(10);
        Enemy enemy6 = GameObject.recycle(Enemy.class);
        enemy6.position.set(a * 30, a * 14);
        enemy6.setHP(10);
        Enemy enemy7 = GameObject.recycle(Enemy.class);
        enemy7.position.set(a * 9, a * 25);
        enemy7.setHP(10);
        Enemy enemy8 = GameObject.recycle(Enemy.class);
        enemy8.position.set(a * 23, a * 25);
        enemy8.setHP(10);
        Enemy enemy9 = GameObject.recycle(Enemy.class);
        enemy9.position.set(a * 2, a * 22);
        enemy9.setHP(10);
        Enemy enemy10 = GameObject.recycle(Enemy.class);
        enemy10.position.set(a * 30, a * 22);
        enemy10.setHP(10);

    }
}
