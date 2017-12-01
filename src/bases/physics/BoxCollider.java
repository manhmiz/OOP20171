package bases.physics;

import bases.GameObject;

public class BoxCollider extends GameObject{
    private float width;
    private float height;

    public BoxCollider(float x, float y, float width, float height){
        super();
        this.position.set(x, y);
        this.width = width;
        this.height = height;
    }
    public BoxCollider(float width, float height) { this(0,0,width,height);}

    public BoxCollider shift(float dx, float dy){
        BoxCollider shiftedBoxCollider = new BoxCollider(this.width,this.height);
        shiftedBoxCollider.position.set(this.position.add(dx,dy));
        return shiftedBoxCollider;
    }
    public float left() {
        return position.x - width / 2;
    }

    public float right() {
        return position.x + width / 2;
    }

    public float top() {
        return position.y - height / 2;
    }

    public float bottom() {
        return position.y + height / 2;
    }

    public boolean collieWith(BoxCollider other) {
        boolean xOverlap = other.right() >= this.left() && other.left() <= this.right();
        boolean yOverlap = other.bottom() >= this.top() && other.top() <= this.bottom();
        return xOverlap && yOverlap;
    }
}
