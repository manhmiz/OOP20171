import touhou.*;

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
    ArrayList<EnemyBullet> bullets1 = new ArrayList<>();
    ArrayList<EnemyBullet> bullets2 = new ArrayList<>();
    ArrayList<EnemyBullet> bullets3 = new ArrayList<>();
    ArrayList<EnemyBullet> bullets4 = new ArrayList<>();

    long lastTimeUpdate = System.nanoTime();
    long lastTimeUpdate2 = System.nanoTime();

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

        for (PlayerSpell spell : spells) {
            spell.render(backGraphics);
        }

        for (EnemyBullet bullet : bullets1) {
            bullet.render(backGraphics);
        }
        for (EnemyBullet bullet : bullets2) {
            bullet.render(backGraphics);
        }
        for (EnemyBullet bullet : bullets3) {
            bullet.render(backGraphics);
        }
        for (EnemyBullet bullet : bullets4) {
            bullet.render(backGraphics);
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
        if (e.getKeyCode() == KeyEvent.VK_X) {
            xPressed = true;
        }

    }

    public void keyReleased(KeyEvent e) {
        player.keyReleased(e);
        if (e.getKeyCode() == KeyEvent.VK_X) {
            xPressed = false;
        }
    }

    public void run() {
        player.run();
        backGround.run();
        enemy.run();
    }

    public void runBullet() {
        long currentTime = System.nanoTime();
        long currentTime2 = System.nanoTime();
        if (currentTime - lastTimeUpdate >= 170000000) {
            if (xPressed) {
                PlayerSpell newSpell = new PlayerSpell();
                newSpell.x = player.x;
                newSpell.y = player.y;
                spells.add(newSpell);
            }

            lastTimeUpdate = currentTime;
        }
        if (currentTime2 - lastTimeUpdate2 >= 680000000) {
            EnemyBullet newBullet1 = new EnemyBullet();
            newBullet1.x = enemy.x1;
            newBullet1.y = enemy.y1;
            bullets1.add(newBullet1);

            EnemyBullet newBullet2 = new EnemyBullet();
            newBullet2.x = enemy.x2;
            newBullet2.y = enemy.y1;
            bullets2.add(newBullet2);

            EnemyBullet newBullet3 = new EnemyBullet();
            newBullet3.x = enemy.x3;
            newBullet3.y = enemy.y2;
            bullets3.add(newBullet3);

            EnemyBullet newBullet4 = new EnemyBullet();
            newBullet4.x = enemy.x4;
            newBullet4.y = enemy.y2;
            bullets4.add(newBullet4);
            lastTimeUpdate2 = currentTime2;
        }
        for (PlayerSpell spell : spells) {
            spell.run();
        }
        for (EnemyBullet bullet : bullets4) {
            bullet.run();
        }
        for (EnemyBullet bullet : bullets3) {
            bullet.run();
        }
        for (EnemyBullet bullet : bullets2) {
            bullet.run();
        }
        for (EnemyBullet bullet : bullets1) {
            bullet.run();
        }
    }

}
