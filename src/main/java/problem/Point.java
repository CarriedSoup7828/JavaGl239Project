package problem;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;
import java.util.Random;

/**
 * Класс точки
 */
public class Point {
    /**
     * константа множества 1
     */
    public static final int SET_1 = 0;
    /**
     * константа множества 2
     */
    public static final int SET_2 = 1;
    /**
     * пересекается ли точка с точкой из другого множества
     * (является ли она решением)
     */
    boolean isSolution = false;
    /**
     * x - координата точки
     */
    Vector pos;

    /**
     * Конструктор точки
     *
     */
    Point(Vector pos) {
        this.pos = pos;
    }

    /**
     * Получить случайную точку
     *
     * @return случайная точка
     */
    static Point getRandomPoint() {
        Random r = new Random();
        return new Point(new Vector((double) r.nextInt(50) / 25 - 1, (double) r.nextInt(50) / 25 - 1));
    }

    /**
     * Рисование точки
     *
     * @param gl переменная OpenGl для рисования
     * @return
     */
    public void render(GL2 gl) {
//        if (isSolution)
//            gl.glColor3d(1.0, 0.0, 0.0);
//        else
//            switch (setNumber) {
//                case Point.SET_1:
//                    gl.glColor3d(0.0, 1.0, 0.0);
//                    break;
//                case Point.SET_2:
//                    gl.glColor3d(0.0, 0.0, 1.0);
//                    break;
//            }
        gl.glPointSize(3);
        gl.glBegin(GL.GL_POINTS);
        gl.glVertex2d(pos.x, pos.y);
        gl.glEnd();
        gl.glPointSize(1);

    }

    /**
     * Получить строковое представление точки
     *
     * @return строковое представление точки
     */
    @Override
    public String toString() {
        return "Точка с координатами: {" + pos.x + "," + pos.y + "}";
    }

}
