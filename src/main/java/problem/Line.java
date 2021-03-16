package problem;

import javax.media.opengl.GL2;

public class Line {
    Point p;
    Point p2;

    public Line(Point p, Point p2) {
        this.p = p;
        this.p2 = p2;

    }

    public void render(GL2 gl) {
        Figures.renderLine(gl,  p, p2, 3);
    }

}
