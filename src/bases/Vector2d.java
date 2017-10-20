package bases;

import java.util.Vector;

public class Vector2d {
    public float x;
    public float y;

    @Override
    public String toString() {
        return "Vector2d{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public Vector2d() {
        this(0, 0);
    }

    public Vector2d(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Vector2d clone() {
        return new Vector2d(this.x, this.y);
    }

    public Vector2d addUP(Vector2d v) {
        this.x += v.x;
        this.y += v.y;
        return this;
    }

    public Vector2d addUP(float otherX, float otherY) {
        this.x += otherX;
        this.y += otherY;
        return this;
    }

    public Vector2d add(Vector2d v) {
        Vector2d result = new Vector2d(x, y);
        result.x += v.x;
        result.y += v.y;
        return result;
    }

    public Vector2d add(float otherX, float otherY) {
        Vector2d result = new Vector2d(x, y);
        result.x += otherX;
        result.y += otherY;
        return result;
    }

    public Vector2d subtractBy(Vector2d v) {
        this.x -= v.x;
        this.y -= v.y;
        return this;
    }

    public Vector2d subtractBy(float otherX, float otherY) {
        this.x -= otherX;
        this.y -= otherY;
        return this;
    }

    public Vector2d subtract(Vector2d v) {
        Vector2d result = new Vector2d();
        result.x = this.x - v.x;
        result.y = this.y - v.y;
        return result;
    }

    public Vector2d subtract(float otherX, float otherY) {
        Vector2d result = new Vector2d(x, y);
        result.x -= otherX;
        result.y -= otherY;
        return result;
    }

    public Vector2d multiply(float factor) {
        Vector2d result = new Vector2d();
        result.x = this.x * factor;
        result.y = this.y * factor;
        return result;
    }

    public static void main(String[] args) {
        Vector2d v = new Vector2d();
        Vector2d v2 = new Vector2d(1, 5);
        Vector2d v3 = new Vector2d();
        Vector2d v4 = v.clone().subtract(v2);
        Vector2d v5 = v2.clone().multiply(2);
        System.out.println(v);
        System.out.println(v2);
        System.out.println(v3);
        System.out.println(v4);
        System.out.println(v5);
    }
}

