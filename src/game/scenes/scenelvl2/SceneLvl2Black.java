package game.scenes.scenelvl2;

import bases.GameObject;
import game.players.playerblack.PlayerBlack;

public class SceneLvl2Black extends SceneLvl2{

    PlayerBlack playerBlack = new PlayerBlack();
    @Override
    public void init() {

        GameObject.add(playerBlack);

        super.init();
    }
}
