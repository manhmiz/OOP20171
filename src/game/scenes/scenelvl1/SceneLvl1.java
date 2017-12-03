package game.scenes.scenelvl1;

import bases.GameObject;
import bases.scenes.Scene;
import game.enemies.bosslvl1.BossLvl1Blue;
import game.enemies.Enemy;
import maps.Map;

public class SceneLvl1 implements Scene{


    @Override
    public void deinit() {
        GameObject.clearAll();
    }

    @Override
    public void init() {

        addEnemy();
        addMap();

    }


    private void addMap() {
        Map map = Map.load("assets/maps/mapTanks.json");
        map.generate();
    }

    private void addEnemy() {


        Enemy enemy0 = GameObject.recycle(Enemy.class);
        enemy0.position.set(100,150);

        Enemy enemy1 = GameObject.recycle(Enemy.class);
        enemy1.position.set(250,150);

        Enemy enemy2 = GameObject.recycle(Enemy.class);
        enemy2.position.set(350,150);

        Enemy enemy3 = GameObject.recycle(Enemy.class);
        enemy3.position.set(500,150);

        Enemy enemy4 = GameObject.recycle(Enemy.class);
        enemy4.position.set(50,265);

        Enemy enemy5 = GameObject.recycle(Enemy.class);
        enemy5.position.set(550,265);

        Enemy enemy6 = GameObject.recycle(Enemy.class);
        enemy6.position.set(50,400);

        Enemy enemy7 = GameObject.recycle(Enemy.class);
        enemy7.position.set(550,400);

    }

}
