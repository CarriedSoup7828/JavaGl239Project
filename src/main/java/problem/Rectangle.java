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
        return new Rectangle(new Vector ( (double)randomQuad.nextInt() *2 - 1,  (double)randomQuad.nextInt() / 25 - 1) , new Vector( (double)randomQuad.nextInt() *2 - 1,  (double)randomQuad.nextInt() / 25 - 1));
    }


    public void render(GL2 gl) {
        Figures.renderPQuad(gl, a, b, false);
    }
}

