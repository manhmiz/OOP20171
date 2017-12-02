package game.scenes;

import bases.GameObject;
import bases.scenes.Scene;
import game.enemies.Enemy;
import game.players.Player;
import maps.Map;

public class SceneLvl2 implements Scene{
    Player player = new Player();
    Enemy enemy = new Enemy();

    @Override
    public void deinit() {
        GameObject.clearAll();
    }

    @Override
    public void init() {
        GameObject.add(player);
        GameObject.add(enemy);

        Map map = Map.load("assets/maps/mapTanks2.json");
        map.generate();
    }
}
