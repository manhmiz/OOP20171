package game.scenes;

import bases.GameObject;
import bases.scenes.Scene;
import game.BackGround;
import game.enemies.Enemy;
import game.players.Player;
import maps.Map;

import java.awt.*;

public class ScenceLvl1 implements Scene{

    Player player = new Player();
    Enemy enemy = new Enemy();

    @Override
    public void deinit() {

    }

    @Override
    public void init() {
        GameObject.add(player);
        GameObject.add(enemy);

        Map map = Map.load("assets/maps/mapTanks.json");
        map.generate();
    }
}
