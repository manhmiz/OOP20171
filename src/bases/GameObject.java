package bases;

import bases.physics.BoxCollider;
import sun.nio.cs.ext.DoubleByte;
import touhou.enemies.Enemy;
import touhou.players.Player;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Vector;

public class GameObject {
    public Vector2d position;
    public BufferedImage image;
    public boolean isActive;

    static Vector<GameObject> gameObjects = new Vector<>();
    static Vector<GameObject> newgameObjects = new Vector<>();

    public static void runAll() {
        for (GameObject gameObject : gameObjects) {
            if (gameObject.isActive)
                gameObject.run();
        }

        gameObjects.addAll(newgameObjects);
        newgameObjects.clear();
    }

    public static void renderAll(Graphics graphics) {
        for (GameObject gameObject : gameObjects) {
            if (gameObject.isActive)
                gameObject.render(graphics);
        }
    }

    public static void add(GameObject gameObject) {
        newgameObjects.add(gameObject);
    }

    public static Enemy collideWith(BoxCollider boxCollider) {
        for (GameObject gameObject : gameObjects) {
            if (gameObject.isActive && gameObject instanceof Enemy) {
                Enemy enemy = (Enemy) gameObject;
                if (enemy.boxCollider.collieWith(boxCollider)) {
                    return enemy;
                }
            }
        }

        return null;
    }
    public static Player collideWith2(BoxCollider boxCollider){
        for (GameObject gameObject : gameObjects){
            if (gameObject.isActive && gameObject instanceof Player){
                Player player = (Player) gameObject;
                if (player.boxCollider.collieWith(boxCollider)){
                    return player;
                }
            }
        }
        return null;
    }

    public GameObject() {
        position = new Vector2d();
        isActive = true;
    }

    public void run() {
    }

    public void render(Graphics graphics) {
        if (image != null) {
            graphics.drawImage(image,
                    (int) (position.x - image.getWidth() / 2),
                    (int) (position.y - image.getHeight() / 2),
                    null);
        }
    }

}
