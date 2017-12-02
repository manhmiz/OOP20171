package game.scenes;

import bases.GameObject;
import bases.scenes.Scene;
import bases.scenes.SceneManager;
import game.enemies.Enemy;
import game.players.Player;
import maps.Map;

public class ScenceLvl1 implements Scene{

    Player player = new Player();
    int CountEnemy = 9;
    @Override
    public void deinit() {
        GameObject.clearAll();
    }

    @Override
    public void init() {

        GameObject.add(player);
        addEnemy();
        addMap();

    }


    private void addMap() {
        Map map = Map.load("assets/maps/mapTanks.json");
        map.generate();
    }

    private void addEnemy() {

        Enemy enemy = GameObject.recycle(Enemy.class);
        enemy.position.set(300,80);

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
