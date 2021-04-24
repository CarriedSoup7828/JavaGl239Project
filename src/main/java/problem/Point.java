package problem;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;
import java.util.Random;

/**
 * Класс точки
 */
public class Point {
    /**
     * пересекается ли точка с точкой из другого множества
     * (является ли она решением)
     */
    boolean isSolution = false;
    /**
     * x - координата точки
     */
    double x;
    double y;


    /**
     * Конструктор точки
     */
    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Получить случайную точку
     *
     * @return случайная точка
     */
    static Point getRandomPoint() {
        Random r = new Random();
        return new Point((double) r.nextInt(50) / 25 - 1, (double) r.nextInt(50) / 25 - 1);
    }

    /**
     * Рисование точки
     *
     * @param gl переменная OpenGl для рисования
     * @return
     */
    public void render(GL2 gl, boolean red) {
        if (red)
            gl.glColor3d(1, 2, 1);
        else gl.glColor3d(1, 1, 1);
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
        gl.glVertex2d(x, y);
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
        return "Точка с координатами: {" + x + "," + y + "}";
    }

}
