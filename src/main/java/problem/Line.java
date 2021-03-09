package problem;
import javax.media.opengl.GL2;
public class Line {


    public static void renderLine(GL2 gl, Point p, Point p2) {

        gl.glBegin(GL2.GL_LINES);
        gl.glColor3d(0, 1, 0);
        gl.glVertex2d(p.x, p.y);
        gl.glVertex2d(p2.x, p2.y);
        gl.glEnd();
    }

}
