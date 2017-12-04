package game.scenes.scenelvl1;

import bases.GameObject;
import bases.scenes.SceneManager;
import game.enemies.bosslvl1.BossLvl1Blue;
import game.players.playerblue.PlayerBlue;
import game.scenes.scenelvl2.SceneLvl2Blue;

public class SceneLvl1Blue extends SceneLvl1{
    PlayerBlue playerBlue = new PlayerBlue();

    @Override
    public void init() {

        BossLvl1Blue enemy = GameObject.recycle(BossLvl1Blue.class);
        enemy.position.set(300,80);
        if (!enemy.isActive){
            SceneManager.changeScene(new SceneLvl2Blue());
        }
        GameObject.add(playerBlue);
        super.init();
    }
}
