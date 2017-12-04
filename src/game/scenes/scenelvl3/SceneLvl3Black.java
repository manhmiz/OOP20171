package game.scenes.scenelvl3;

import bases.GameObject;
import game.players.playerblack.PlayerBlack;

public class SceneLvl3Black extends SceneLvl3{

    PlayerBlack playerBlack = new PlayerBlack();
    @Override
    public void init() {

        GameObject.add(playerBlack);

        super.init();
    }
}