package game.scenes.scenelvl2;

import bases.GameObject;
import game.enemies.bosslvl2.BossLvl2Blue;
import game.players.playerblue.PlayerBlue;

public class SceneLvl2Blue extends SceneLvl2{
    PlayerBlue player = new PlayerBlue();
    BossLvl2Blue bossLvl2Blue = new BossLvl2Blue();
    @Override
    public void init() {
        GameObject.add(bossLvl2Blue);
        bossLvl2Blue.position.set(250,50);

        GameObject.add(player);
        super.init();
    }
}
