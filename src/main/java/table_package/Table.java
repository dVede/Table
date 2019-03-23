package table_package;
import org.jetbrains.annotations.NotNull;
import java.util.*;
import static java.lang.Math.*;

/**
 * @author dVede
 * @version 1.0
 */
public final class Table {
    private NavigableSet<Point> table;


    /**
     * Создание таблицы
     */
    public Table() {
        table = new TreeSet<Point>();
    }

    /**
     * Нахождение расстояния между двумя ординатами
     * @param x Значение первой одинаты
     * @param x0 Значение второй ординаты
     * @return Расстояние между двумя ординатами
     */
    public double distance(double x, double x0) {
        return abs(x - x0);
    }

    /**
     * Определения вхождения ординаты в допустимую область определения
     * @param x Проверяемая ордината
     * @return <b>true</b>, если ордината пренадлежит области определения
     */
    public boolean inRange(double x) {
        return !table.isEmpty() && x <= table.last().getX() && x >= table.first().getX();
    }

    /**
     * Добавление эллемента
     * @param toAdd Точка, добавляемая в таблицу
     * @return <b>true</b>, если есть возможность добавить такую Точку
     */
    public Boolean add(@NotNull final Point toAdd) {
            return table.add(toAdd);
    }

    /**
     * Удаление эллемента
     * @param toRemove Точка, удаляемая из таблицы
     * @return <b>true</b>, если есть возможность удалить такую Точку
     */
    public boolean remove(@NotNull final Point toRemove) {
        return table.remove(toRemove);
    }

    /**
     * Получение текущего состояния таблицы
     * @return Текущее состояние таблицы
     */
    public Set<Point> getA() {
        return this.table;
    }

    /**
     * Поиск ближайшей точки
     * @param x Значение ординаты, по отношению к которой ищется ближайшая точка из таблицы
     * @return Точку, ближйшую к заданной и таблицы
     */
    public Point getNearestPoint(double x) {
        if(table.isEmpty())
            throw new IllegalStateException("Table is Empty");
        Point point0 = new Point(x, 0);
        Point point1 = table.ceiling(point0);
        Point point2 = table.floor(point0);
        if(x > table.last().getX())
            return point2;
        if(x < table.first().getX())
            return point1;
        double x1 = point1.getX();
        double x2 = point2.getX();
        if (distance(x, x1) == distance(x, x2)){
            if (round(x) > x)
            return point1;
        else
            return point2;}
        if(distance(x, x1) > distance(x, x2))
            return point2;
        else
            return point1;
    }

    /**
     * Нахождение промежуточного значения (интерполяция)
     * @param x Промежуточное значение абциссы, для которой ищется промежуточное значение ординаты
     * @return Промежуточное значение ординаты
     */
    public double calculate(double x) {
        if (table.isEmpty())
            throw new IllegalStateException("Table is Empty");
        if (!inRange(x))
            throw new IndexOutOfBoundsException("Not in range");
        Point point0 = new Point(x, 0);
        Point near = getNearestPoint(x);
        if (near.getX() == x)
            return near.getY();
        else {
            double x1 = table.ceiling(point0).getX();
            double x2 = table.floor(point0).getX();
            double y1 = table.ceiling(point0).getY();
            double y2 = table.floor(point0).getY();

            return y1 + (x - x1)*(y2 - y1)/(x2 - x1);
        }
    }
}
