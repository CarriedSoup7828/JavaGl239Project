package problem;

import javax.media.opengl.GL2;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Класс задачи
 */
public class Problem {
    /**
     * текст задачи
     */
    public static final String PROBLEM_TEXT = "ПОСТАНОВКА ЗАДАЧИ:\n" +
            "Заданы два множества точек в пространстве.\n" +
            "Требуется построить пересечения и разность этих множеств";

    /**
     * заголовок окна
     */
    public static final String PROBLEM_CAPTION = "Итоговый проект ученика 10-7 Иванова Ивана";

    /**
     * путь к файлу
     */
    private static final String FILE_NAME = "points.txt";

    /**
     * список точек
     */
    private ArrayList<Point> points;
    private ArrayList<Rectangle> rectangles;

    /**
     * Конструктор класса задачи
     */
    public Problem() {
        points = new ArrayList<>();
        rectangles = new ArrayList<>();
    }

    /**
     * Добавить точку
     */
    public void addPoint(double x, double y) {
        Point point = new Point(new Vector(x, y));
        points.add(point);
    }

    /**
     * Решить задачу
     */
    public void solve() {
        // перебираем пары точек
        for (Point p : points) {
            for (Point p2 : points) {
                // если точки являются разными
                if (p != p2) {
                    // если координаты у них совпадают
                    if (Math.abs(p.pos.x - p2.pos.x) < 0.0001 && Math.abs(p.pos.y - p2.pos.y) < 0.0001) {
                        p.isSolution = true;
                        p2.isSolution = true;
                    }
                }
            }
        }
    }

    /**
     * Загрузить задачу из файла
     */
    public void loadFromFile() {
        points.clear();
        try {
            File file = new File(FILE_NAME);
            Scanner sc = new Scanner(file);
            // пока в файле есть непрочитанные строки
            while (sc.hasNextLine()) {
                double x = sc.nextDouble();
                double y = sc.nextDouble();
                sc.nextLine();
                Point point = new Point(new Vector(x, y));
                points.add(point);
            }
        } catch (Exception ex) {
            System.out.println("Ошибка чтения из файла: " + ex);
        }
    }

    /**
     * Сохранить задачу в файл
     */
    public void saveToFile() {
        try {
            PrintWriter out = new PrintWriter(new FileWriter(FILE_NAME));
            for (Point point : points) {
                out.printf("%.2f %.2f\n", point.pos.x, point.pos.y);
            }
            out.close();
        } catch (IOException ex) {
            System.out.println("Ошибка записи в файл: " + ex);
        }
    }

    /**
     * Добавить заданное число случайных точек
     *
     * @param n кол-во точек
     */
    public void addRandomPoints(int n) {
        for (int i = 0; i < n; i++) {
            Rectangle r = Rectangle.getRandomRectangle();
            rectangles.add(r);
        }
    }

    /**
     * Очистить задачу
     */
    public void clear() {
        points.clear();
    }

    /**
     * Нарисовать задачу
     *
     * @param gl переменная OpenGL для рисования
     */
    public void render(GL2 gl) {
        for (Rectangle rectangle : rectangles) {
            rectangle.render(gl);
        }
        // Figures.renderPoint(gl, new Vector(0.3, 0.3), 6);
//
//        Figures.renderLine(gl, p., new Vector(0.13, 0.2), 3);
//        //Figures.renderTriangle(gl, new Vector(0.3, 0.3), new Vector(0.13, 0.2), new Vector(0, 1),  false);
//        Figures.renderQuad(gl, new Vector(0.3, -0.3), new Vector(-0.4, 0.4), new Vector(-0.9, -0.1),  false);
//        //Figures.renderCircle(gl, new Vector(0.3, -0.3), 360, 0.3, false);

//        Point point = new Point(new Vector(0.13, 0.2));
//        Point point2 = new Point(new Vector(0, 1));
//        point.render(gl);
//        point2.render(gl);
//        Rectangle rectangle = new Rectangle(new Vector(0.3, -0.3), new Vector(-0.4, 0.4));
//        rectangle.render(gl);

    }

}

