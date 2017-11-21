package bases.renderers;

import bases.physics.Vector2d;

import java.awt.*;

public interface Renderer {
    void render(Graphics graphics,Vector2d position);
}
