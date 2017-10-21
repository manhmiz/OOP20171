package bases;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Vector;

public class GameObject {
    public Vector2d position;

    public BufferedImage image;

    static Vector<GameObject> gameObjects = new Vector<>();
    static Vector<GameObject> newgameObjects = new Vector<>();
    public static void runAll(){
        for (GameObject gameObject: gameObjects){
            gameObject.run();
        }

        gameObjects.addAll(newgameObjects);
        newgameObjects.clear();
    }

    public static void renderAll(Graphics graphics){
        for (GameObject gameObject: gameObjects){
            gameObject.render(graphics);
        }
    }
    public static void add(GameObject gameObject){
        newgameObjects.add(gameObject);
    }

    public GameObject(){
        position = new Vector2d();

    }

    public void run(){
    }

    public void render(Graphics graphics){
        if (image != null){
            graphics.drawImage(image,
                    (int)(position.x - image.getWidth()/2),
                    (int)(position.y - image.getHeight()/2),
                    null);
        }
    }

}
