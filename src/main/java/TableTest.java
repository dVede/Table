import org.junit.Test;

import java.util.Map;
import java.util.TreeMap;

import static org.junit.Assert.*;

public class TableTest {

    @Test
    public void inTable() throws Exception {
        Table table = new Table();
        for (int i = 0; i < 10; i++) {
               table.add(i, i + 5);
       }
       assertEquals(false, table.inTable(1, -5));
       assertEquals(true, table.inTable(1, 6));
       assertEquals(false, table.inTable(1, -5));
       assertEquals(false, table.inTable(1, -5));
       assertEquals(true, table.inTable(9, 14));
    }

    @Test
    public void inRange() throws Exception {
        Table table = new Table();
        for (int i = 0; i < 10; i++) {
                table.add(i, i + 5);
        }
        assertEquals(false, table.inRange(-2));
        assertEquals(false, table.inRange(20));
        assertEquals(true, table.inRange(5));
        assertEquals(true, table.inRange(5.5));
        assertEquals(true, table.inRange(3));
    }

    @Test(expected = Exception.class)
    public void add() throws Exception {
        Table table = new Table();
        table.add(2, 2);
        table.add(2, 2);
    }

    @Test(expected = Exception.class)
    public void remove() throws Exception {
        Table table = new Table();
        table.remove(0);
    }

    @Test
    public void getA() throws Exception {
        Table table = new Table();
        Map<Double, Double> map = new TreeMap<Double, Double>() {};
        for (int i = 0; i < 10; i++) {
            table.add(i, i + 5);
            map.put((double) i,(double) i + 5);
        }
        assertEquals(table.getA(), map.entrySet());
    }

    @Test
    public void getNearestPoint() throws Exception {
        Table table = new Table();
        for (int i = 0; i < 10; i++) {
            table.add(i, i + 5);
            }
        assertEquals(new Point(3,8), table.getNearestPoint(2.6));
        assertEquals(new Point(4,9), table.getNearestPoint(3.9));
        assertEquals(new Point(3,8), table.getNearestPoint(2.5));
        assertEquals(new Point(0,5), table.getNearestPoint(0.1));
        assertEquals(new Point(8,13), table.getNearestPoint(8.4));
        }


    @Test
    public void calculate() throws Exception {
        Table table = new Table();
        for (int i = -10; i < 10; i++) {
            try {
                table.add(i, i * i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        assertEquals(0.5, table.calculate(0.5),1.0E-05);
        assertEquals(9.98, table.calculate(3.14),1.0E-05);
        assertEquals(0.0, table.calculate(0),1.0E-05);
        assertEquals(9.98, table.calculate(-3.14),1.0E-05);
    }

    @Test(expected = Exception.class)
    public void testCalculate() throws Exception{
        Table table = new Table();
        for (int i = -10; i < 10; i++) {
            try {
                table.add(i, i * i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        table.calculate(24);

    }
}
