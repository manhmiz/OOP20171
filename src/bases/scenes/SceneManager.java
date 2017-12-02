package bases.scenes;

public class SceneManager {

    static Scene currentScene;
    static Scene nextScene;
    public static void changeScene(Scene newScene){
        nextScene = newScene;

    }

    public static void changeSceneIfNeeded() {
        if (nextScene != null){
            if (currentScene != null)
                currentScene.deinit();

            nextScene.init();

            currentScene = nextScene;
            nextScene = null;
        }
    }
    public static Scene getCurrentScene(){
        return currentScene;
    }
}
