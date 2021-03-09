package problem;

import javax.media.opengl.GL2;

public class Figures {
    public static void renderPoint(GL2 gl, Vector pos, float size) {
        gl.glPointSize(5);
        gl.glBegin(GL2.GL_POINTS);
        gl.glColor3d(0, 1, 0);
        gl.glVertex2d(pos.x, pos.y);
        gl.glEnd();
    }

    public static void renderLine(GL2 gl, Vector pos, Vector pos2, float width) {
        gl.glLineWidth(width);
        gl.glBegin(GL2.GL_LINES);
        gl.glColor3d(0, 1, 0);
        gl.glVertex2d(pos.x, pos.y);
        gl.glVertex2d(pos2.x, pos2.y);
        gl.glEnd();

    }

    public static void renderTriangle(GL2 gl, Vector pos, Vector pos2, Vector pos3, boolean field) {

        if (true == field) {

            gl.glBegin(GL2.GL_TRIANGLES);
            gl.glColor3d(0, 1, 0);
            gl.glVertex2d(pos.x, pos.y);
            gl.glVertex2d(pos2.x, pos2.y);
            gl.glVertex2d(pos3.x, pos3.y);
            gl.glEnd();
        } else {

            gl.glBegin(GL2.GL_LINE_STRIP);
            gl.glColor3d(0, 1, 0);
            gl.glVertex2d(pos.x, pos.y);
            gl.glVertex2d(pos2.x, pos2.y);
            gl.glVertex2d(pos3.x, pos3.y);
            gl.glVertex2d(pos.x, pos.y);
            gl.glEnd();
        }
    }

    public static void renderQuad(GL2 gl, Vector pos, Vector pos2, Vector pos4, boolean field) {
        if (field) {
            gl.glBegin(GL2.GL_QUADS);
            gl.glColor3d(0, 1, 0);
            gl.glVertex2d(pos.x, pos.y);
            gl.glVertex2d(pos2.x, pos.y);
            gl.glVertex2d(pos2.x, pos2.y);
            gl.glVertex2d(pos.x, pos2.y);
            gl.glEnd();

        } else {
            gl.glBegin(GL2.GL_LINE_STRIP);
            gl.glColor3d(0, 1, 0);
            gl.glVertex2d(pos.x, pos.y);
            gl.glVertex2d(pos2.x, pos.y);
            gl.glVertex2d(pos2.x, pos2.y);
            gl.glVertex2d(pos.x, pos2.y);
            gl.glVertex2d(pos.x, pos.y);
            gl.glEnd();
        }

    }


}

