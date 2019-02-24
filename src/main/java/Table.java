import java.util.NavigableMap;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import static java.lang.Math.*;

/*Вариант 6 — табличная функция
    Хранит таблицу значений функции (y) от одного аргумента (x).
    Методы:
        - добавить пару(x,y),                                                    (+)
        - удалить пару(x,y),                                                     (+)
        - выдать множество всех пар(x,y),                                        (-/+)
        - поиск пары(x,y), ближайшей к заданному значению x0,                    (+)
        - рассчитать значение функции по заданному x (используя интерполяцию).   (+)

    Комментарий: Попробую сделать частные случаи (Выход за  интервала, сущес -
    вование эллемента в таблице, попытка добавить эллемент, который уже есть,
    попытка удалить эллемент, который уже есть) через подклассы.
*/


public final class Table {
    private NavigableMap<Double, Double> table;

    Table() {
        table = new TreeMap<Double, Double>();
    }

    public boolean inTable(double x, double y) {
        return table.containsKey(x) && table.get(x) == y;
    }

    public boolean inRange(double x) {
        return x <= table.lastKey() && x >= table.firstKey();
    }

    public void add(double x, double y) throws Exception {
        if (!inTable(x, y))
            table.put(x, y);
        else
            throw new Exception("Already  employed");
    }

    public void remove(double x) throws Exception {
        if (table.containsKey(x))
            table.remove(x);
        else
            throw new Exception("Not found");
    }

    public Set<Map.Entry<Double, Double>> getA() {
        return this.table.entrySet();
    }

    public Point getNearestPoint(double x) {
        double x1 = table.ceilingKey(x);
        double x2 = table.floorKey(x);

        if ((abs(x - x1) == abs(x - x2)) && (abs(round(x) - x1) < (abs(round(x) - x2))))
            return new Point(x1, table.get(x1));
        if ((abs(x - x1) == abs(x - x2)) && (abs(round(x) - x1) > (abs(round(x) - x2))))
            return new Point(x2, table.get(x2));
        if(abs(x1 - x) > abs(x2 - x))
            return new Point(x2, table.get(x2));
        else return new Point(x1, table.get(x1));

    }

    public double calculate(double x) throws Exception {
        if (table.containsKey(x))
            return table.get(x);
        if (!inRange(x)) {
            throw new Exception("Not in range");
        }
        else {
            double x1 = table.ceilingKey(x);
            double x2 = table.floorKey(x);
            double y1 = table.get(x1);
            double y2 = table.get(x2);

            return y1 + (x - x1)*(y2 - y1)/(x2 - x1);
        }
    }
}
/*
Sources:
https://metanit.com/java/tutorial/5.9.php
*/ 