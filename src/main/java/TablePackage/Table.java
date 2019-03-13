package TablePackage;

import java.util.*;
import static java.lang.Math.*;

public final class Table {
    private NavigableSet<Point> table;

    public Table() {
        table = new TreeSet<Point>();
    }

    public double distance(double x, double x0) {
        return abs(x - x0);
    }

    public boolean inRange(double x) {
        return x <= table.last().getX() && x >= table.first().getX();
    }

    public boolean add(final Point toAdd) {
        if (table.contains(toAdd))
            return false;
        else {table.add(toAdd);
        return true;}
    }

    public boolean remove(final Point toRemove) {
        if (table.contains(toRemove)) {
            table.remove(toRemove);
        return true;}
        else
           return false;
    }

    public Set<Point> getA() {
        return this.table;
    }

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
