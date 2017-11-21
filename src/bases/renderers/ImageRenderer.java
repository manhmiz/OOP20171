package bases.renderers;

import bases.Utils;
import bases.physics.Vector2d;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageRenderer implements Renderer {
    public BufferedImage image;

    public ImageRenderer(BufferedImage image){
        this.image = image;
    }
    public ImageRenderer(String url){
        this.image = Utils.loadImage(url);
    }

    public void render(Graphics graphics, Vector2d position) {
        if (image != null) {
            graphics.drawImage(image,
                    (int) (position.x - image.getWidth() / 2),
                    (int) (position.y - image.getHeight() / 2),
                    null);
        }
    }

}
