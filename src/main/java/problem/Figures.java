package problem;

import javax.media.opengl.GL2;

public class Figures {
    public static void renderPoint(GL2 gl, Vector pos, float size) {
        gl.glPointSize(5);
        gl.glBegin(GL2.GL_POINTS);
        gl.glColor3d(1, 1, 1);
        gl.glVertex2d(pos.x, pos.y);
        gl.glEnd();
    }


    public static void renderLine(GL2 gl, Point p, Point p2, float width) {
Vector o= new Vector(p.x-p2.x, p.y- p2.y);
double l = Math.sqrt(o.x*o.x+ o.y* o.y);
Vector k =new Vector(o.x/l*3, o.y/l*3);

        gl.glLineWidth(width);
        gl.glBegin(GL2.GL_LINES);
        gl.glColor3d(0, 1, 0);
        gl.glVertex2d(p.x+k.x, p.y+k.y);
        gl.glVertex2d(p2.x-k.x, p2.y-k.y);
        gl.glEnd();

    }
    public static void renderLength(GL2 gl, Point pl, Point p2l, float width) {
        gl.glLineWidth(width);
        gl.glBegin(GL2.GL_LINES);
        gl.glColor3d(1, 1, 1 );
        gl.glVertex2d(pl.x, pl.y);
        gl.glVertex2d(p2l.x, p2l.y);
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

    public static void renderQuad(GL2 gl, Vector pos, Vector pos2, Vector pos3, Vector pos4, boolean field) {
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


    public static void renderPQuad(GL2 gl, Vector pos, Vector pos2, boolean field) {
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

