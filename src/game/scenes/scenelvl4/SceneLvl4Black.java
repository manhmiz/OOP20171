package game.scenes.scenelvl4;

import bases.GameObject;
import game.players.playerblack.PlayerBlack;

public class SceneLvl4Black extends SceneLvl4{
    PlayerBlack playerBlack = new PlayerBlack();
    @Override
    public void init() {

        GameObject.add(playerBlack);

        super.init();
    }
}
