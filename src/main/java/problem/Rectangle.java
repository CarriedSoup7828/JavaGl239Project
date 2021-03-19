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
        Random randomQuad = new Random();
        return new Rectangle(
                new Vector(randomQuad.nextDouble() * 2 - 1, randomQuad.nextDouble() * 2 - 1),
                new Vector(randomQuad.nextDouble() * 2 - 1, randomQuad.nextDouble() * 2 - 1)
        );
    }


    public void render(GL2 gl) {
        Figures.renderPQuad(gl, a, b, false);
    }
}

