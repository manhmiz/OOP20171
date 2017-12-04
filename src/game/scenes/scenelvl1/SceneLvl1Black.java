package game.scenes.scenelvl1;

import bases.GameObject;
import game.finish.Finish;
import game.finish.FinishLvl1;
import game.players.playerblack.PlayerBlack;

public class SceneLvl1Black extends SceneLvl1{
    PlayerBlack playerBlack =  new PlayerBlack();
    @Override
    public void init() {

        GameObject.add(playerBlack);
        super.init();
    }
}
