package touhou.players;

import bases.GameObject;
import bases.Utils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class PlayerSpell extends GameObject{

    final int SPEED = 10;

    public PlayerSpell()
    {
        image = Utils.loadImage("assets/images/player-bullets/a/0.png");
    }


    public void run() {
        position.y -= SPEED;
    }
}
