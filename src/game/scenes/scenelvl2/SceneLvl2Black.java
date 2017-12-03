package game.scenes.scenelvl2;

import bases.GameObject;
import game.enemies.bosslvl2.BossLvl2Black;
import game.players.playerblack.PlayerBlack;

public class SceneLvl2Black extends SceneLvl2{
    PlayerBlack playerBlack = new PlayerBlack();
    BossLvl2Black bossLvl2Black = new BossLvl2Black();
    @Override
    public void init() {
        GameObject.add(playerBlack);

        GameObject.add(bossLvl2Black);
        bossLvl2Black.position.set(250,50);
        super.init();
    }
}
