package problem;

import javax.media.opengl.GL2;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

/**
 * Класс задачи
 */
public class Problem {
    /**
     * текст задачи
     */
    public static final String PROBLEM_TEXT = "ПОСТАНОВКА ЗАДАЧИ:\n" +
            "Задано множество точек в пространстве\n" +
            "И'Параллельный' прямоугольник.Точки образуют всевозможные прямые\n " +
            "Найти такую прямую(и такие 2 точки черз которые она проходит)\n" +
            "что эта прямая пересекает указанный прямоугольник, при этом\n" +
            "длина отрезка прямой,находящейся внутри прямоугольника,максимальна.";

    /**
     * заголовок окна
     */
    public static final String PROBLEM_CAPTION = "Итоговый проект ученика 10-7 Марюшко Виктора";

    /**
     * путь к файлу
     */
    private static final String FILE_NAME = "points.txt";

    /**
     * список точек
     */
    private ArrayList<Point> points;
    Rectangle rectangle;
    Line line;
    Length length;
    Point pointred;
    Point pointres;

    /**
     * Конструктор класса задачи
     */
    public Problem() {
        points = new ArrayList<>();
        rectangle = new Rectangle(new Vector(0.1, 0.3), new Vector(-0.1, 0.4));
    }

    /**
     * Добавить точку
     */
    public void addPoint(double x, double y) {
        Point point = new Point(x, y);
        points.add(point);
    }

    public void setRect(double x1, double y1, double x2, double y2) {
        rectangle = new Rectangle(new Vector(x1, y1), new Vector(x2, y2));
    }

    /**
     * Решить задачу
     */
    public void solve() {
        double maxLength = 0;

        // перебираем пары точек
        for (Point p : points) {
            for (Point p2 : points) {
                // если точки являются разными
                if (p != p2) {
                    // если координаты у них не совпадают
                    if (Math.abs(p.x - p2.x) > 0.0001 && Math.abs(p.y - p2.y) > 0.0001) {
                        //length = new Length(p, p2);
                        // line = new Line(p, p2);
                        double k = ((p.y - p2.y) / (p.x - p2.x));
                        double b = (p.y - k * p.x);
                        double x1 = (rectangle.a.y - b) / k;
                        double y1 = rectangle.a.x * k + b;
                        double x2 = (rectangle.b.y - b) / k;
                        double y2 = rectangle.b.x * k + b;

                        Point o1 = new Point(x1, rectangle.a.y);
                        Point o2 = new Point(x2, rectangle.b.y);
                        Point o3 = new Point(rectangle.a.x, y1);
                        Point o4 = new Point(rectangle.b.x, y2);

                        ArrayList<Point> pointpl = new ArrayList<>();
                        pointpl.add(o1);
                        pointpl.add(o2);
                        pointpl.add(o3);
                        pointpl.add(o4);

                        for (Point point : pointpl) {
                            if (((point.x <= rectangle.a.x)  & (point.x >= rectangle.b.x)& (point.y <= rectangle.a.y) & (point.y >= rectangle.b.y))||
                                    ((point.x >= rectangle.a.x)& (point.x <= rectangle.b.x) & (point.y >= rectangle.a.y)  & (point.y <= rectangle.b.y)) ||
                                    ((point.x <= rectangle.a.x)& (point.x >= rectangle.b.x) & (point.y >= rectangle.a.y)  & (point.y <= rectangle.b.y))||
                                    ((point.x >= rectangle.a.x)& (point.x <= rectangle.b.x) & (point.y <= rectangle.a.y)  & (point.y >= rectangle.b.y))) {

                                for (Point point1 : pointpl) {
                                    if (((point1.x <= rectangle.a.x)  & (point1.x >= rectangle.b.x)& (point1.y <= rectangle.a.y) & (point1.y >= rectangle.b.y))||
                                            ((point1.x >= rectangle.a.x)& (point1.x <= rectangle.b.x) & (point1.y >= rectangle.a.y)  & (point1.y <= rectangle.b.y)) ||
                                            ((point1.x <= rectangle.a.x)& (point1.x >= rectangle.b.x) & (point1.y >= rectangle.a.y)  & (point1.y <= rectangle.b.y))||
                                            ((point1.x >= rectangle.a.x)& (point1.x <= rectangle.b.x) & (point1.y <= rectangle.a.y)  & (point1.y >= rectangle.b.y))) {
                                        double l = Math.sqrt((point.x-point1.x)*(point.x-point1.x) + (point1.y - point1.y)*(point1.y - point1.y));
                                        if (l > maxLength) {
                                            maxLength = l;
                                            length = new Length(point, point1);
                                            line = new Line(point, point1);
                                            pointred = new Point(p.x, p.y);
                                            pointres = new Point(p2.x, p2.y);

                                            System.out.println(maxLength);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

            }
        }
    }
    //  }
    //     }
    //   }

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
                Point point = new Point(x, y);
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
                out.printf("%.2f %.2f\n", point.x, point.y);
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
            Point p = Point.getRandomPoint();
            points.add(p);
        }
    }


    public void setRandomQuad() {
        rectangle = Rectangle.getRandomRectangle();
    }

    /**
     * Очистить задачу
     */
    public void clear() {
        points.clear();
        line = null;
    }

    /**
     * Нарисовать задачу
     *
     * @param gl переменная OpenGL для рисования
     */
    public void render(GL2 gl) {
        for (Point point : points)
            point.render(gl, false);
        rectangle.render(gl);
        if (line != null && length != null) {
             line.render(gl);
            length.render(gl);
           pointred.render(gl, true);
           pointres.render(gl, true);
            }

        }

    }

