package bases;

import bases.physics.BoxCollider;
import bases.physics.PhysicsBody;
import bases.physics.Vector2d;
import bases.renderers.Renderer;

import java.awt.*;
import java.util.Vector;

public class GameObject {
    public Vector2d position;
    public Renderer renderer;
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
        System.out.println(gameObjects.size());
    }
    public void reset(){
        isActive = true;
    }

    public static void renderAll(Graphics graphics) {
        for (GameObject gameObject : gameObjects) {
            if (gameObject.isActive)
                gameObject.render(graphics);
        }
    }

    public void render(Graphics graphics) {
        if (renderer != null) {
            renderer.render(graphics, position);
        }
    }

    public static void add(GameObject gameObject) {
        newgameObjects.add(gameObject);
    }

    public static <T extends GameObject> T recycle(Class<T> cls) {

        for (GameObject gameObject : gameObjects) {
            if (gameObject.getClass().equals(cls)) {
                if (!gameObject.isActive) {
                    gameObject.reset();
                    return (T) gameObject;
                }
            }
        }
        try {
            T newGameObject = cls.newInstance();
            add(newGameObject);
            return newGameObject;
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static <T extends PhysicsBody> T collideWith(BoxCollider boxCollider, Class<T> cls) {
        for (GameObject gameObject : gameObjects) {
            if (!gameObject.isActive) continue;
            if (!(gameObject instanceof PhysicsBody)) continue;
            if ((!gameObject.getClass().equals(cls))) continue;
            BoxCollider otherBoxCollider = ((PhysicsBody) gameObject).getBoxCollider();
            if (otherBoxCollider.collieWith(boxCollider)) {
                return (T) gameObject;
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


}
