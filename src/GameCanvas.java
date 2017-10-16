import touhou.BackGround;
import touhou.Enemy;
import touhou.Player;
import touhou.PlayerSpell;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class GameCanvas extends JPanel {

    BufferedImage backBuffer;
    Graphics backGraphics;

    BackGround backGround = new BackGround();
    Player player = new Player();
    Enemy enemy = new Enemy();
    ArrayList<PlayerSpell> spells = new ArrayList<>();

    boolean xPressed;



    public GameCanvas() {
        //1. Create back buffer
        backBuffer = new BufferedImage(384, 600, BufferedImage.TYPE_INT_ARGB);
        backGraphics = backBuffer.getGraphics();
    }

    public void render() {
        //1.Draw everything on back buffer
        backGround.render(backGraphics);
        player.render(backGraphics);
        enemy.render(backGraphics);
        for (PlayerSpell spell:spells){
            spell.render(backGraphics);
        }

        //2. Call repaint
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(backBuffer, 0, 0, null);
    }

    public void keyPressed(KeyEvent e) {
        player.keyPressed(e);
        if (e.getKeyCode() == KeyEvent.VK_X){
            xPressed = true;
        }

    }

    public void keyReleased(KeyEvent e) {
        player.keyReleased(e);
        if (e.getKeyCode() == KeyEvent.VK_X){
            xPressed = false;
        }
    }

    public void run() {
        player.run();
        backGround.run();
        enemy.run();
        if (xPressed){
            PlayerSpell newSpell = new PlayerSpell();
            newSpell.x = player.x;
            newSpell.y = player.y;
            spells.add(newSpell );
        }
        for (PlayerSpell spell:spells){
            spell.run();
        }
    }


}
