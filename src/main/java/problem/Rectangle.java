package problem;

import javax.media.opengl.GL2;
import java.util.Random;

public class Rectangle {

    Vector a;
    Vector b;
    Vector c;
    Vector d;

    public Rectangle(Vector a, Vector b) {
        this.a = a;
        this.b = b;
    }

    public static Rectangle getRandomRectangle() {
        Random r = new Random();
        return (new Rectangle( r.nextInt(50) / 25 - 1,  r.nextInt(50) / 25 - 1)))
    }


    public void render(GL2 gl) {
        Figures.renderPQuad(gl, a, b, false);
    }
}

