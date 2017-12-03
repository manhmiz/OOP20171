package game.scenes.scenelvl1;

import bases.GameObject;
import game.enemies.bosslvl1.BossLvl1Black;
import game.players.playerblack.PlayerBlack;

public class SceneLvl1Black extends SceneLvl1{
    PlayerBlack playerBlack =  new PlayerBlack();
    @Override
    public void init() {

        BossLvl1Black enemy = GameObject.recycle(BossLvl1Black.class);
        enemy.position.set(300,80);

        GameObject.add(playerBlack);
        super.init();
    }
}
