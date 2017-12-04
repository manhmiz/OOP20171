package game.scenes.scenelvl2;

import bases.GameObject;
import bases.scenes.Scene;
import game.enemies.Enemy;
import game.enemies.bosslvl1.BossLvl1Blue;
import game.players.Player;
import game.players.playerblue.PlayerBlue;
import maps.Map;

public class SceneLvl2 implements Scene{


    @Override
    public void deinit() {
        GameObject.clearAll();
    }

    @Override
    public void init() {
        addEnemy();
        Map map = Map.load("assets/maps/mapTanks2.json");
        map.generate();
    }

    private void addEnemy() {
        Enemy enemy = GameObject.recycle(Enemy.class);
        enemy.position.set(300,80);

    }
}
