package problem;
import javax.media.opengl.GL2;
public class Length {
    Point pl;
    Point pl2;
    public Length(Point pl, Point pl2){
        this.pl =pl;
        this.pl2= pl2;

    }
    public void render(GL2 gl) {
        Figures.renderLength(gl,  pl, pl2, 1);
    }
}
