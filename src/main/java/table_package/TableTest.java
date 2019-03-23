package table_package;

import org.junit.Test;
import java.util.Set;
import java.util.TreeSet;
import static org.junit.Assert.*;
public class TableTest {

    @Test
    public void inRange(){
        Table table = new Table();
        for (int i = 0; i < 10; i++) {
            table.add(new Point(i, i + 5));
        }
        assertFalse(table.inRange(20));
        assertTrue(table.inRange(5));
        assertTrue(table.inRange(5.5));
        assertTrue(table.inRange(3));
    }
    @Test
    public void inRangeEmpty(){
        Table table = new Table();
        assertFalse(table.inRange(20));
    }


    @Test(expected = Exception.class)
    public void add(){
        Table table = new Table();
        table.add(new Point(10, 10));
        assertFalse(table.add(new Point(10, 10)));
        assertFalse(table.add(new Point(10, 25)));
        assertTrue(table.add(new Point(8,10)));
        System.out.print(table.getA());
        table.add(null);
    }

    @Test(expected = Exception.class)
    public void remove(){
        Table table = new Table();
        table.add(new Point(10, 10));
        table.add(new Point(9, 10));
        assertTrue(table.remove(new Point(9, 10)));
        assertFalse(table.remove(new Point(20, 10)));
        table.remove(null);
    }

    @Test
    public void getNearestPoint(){
        Table table = new Table();
        for (int i = 0; i < 10; i++) {
            table.add(new Point(i, i + 5));
        }
        assertEquals(new Point(3,8), table.getNearestPoint(2.6));
        assertEquals(new Point(4,9), table.getNearestPoint(3.9));
        assertEquals(new Point(3,8), table.getNearestPoint(2.5));
        assertEquals(new Point(0,5), table.getNearestPoint(0.1));
        assertEquals(new Point(8,13), table.getNearestPoint(8.4));
        assertEquals(new Point(9,14), table.getNearestPoint(20));
        assertEquals(new Point(0,5), table.getNearestPoint(-5.0));
    }

    @Test(expected = Exception.class)
    public void getNearestPointEmpty(){
        Table table = new Table();
        table.getNearestPoint(2.0); }

    @Test
    public void calculate(){
        Table table = new Table();
        for (int i = -10; i < 10; i++) {
            table.add(new Point(i, i * i));
        }
        assertEquals(0.5, table.calculate(0.5),1.0E-05);
        assertEquals(9.98, table.calculate(3.14),1.0E-05);
        assertEquals(0.0, table.calculate(0),1.0E-05);
        assertEquals(9.98, table.calculate(-3.14),1.0E-05);
        assertEquals(81, table.calculate(9), 1.0E-05);
    }

    @Test(expected = Exception.class)
    public void calculateEmptyE(){
        Table table = new Table();
        table.calculate(60); }

    @Test
    public void calculateOne(){
        Table table = new Table();
        table.add(new Point(5, 30));
        assertEquals(30, table.calculate(5),1.0E-05);
    }

    @Test(expected = Exception.class)
    public void calculateOneE(){
        Table table = new Table();
        table.add(new Point(5, 30));
        table.calculate(60); }

    @Test
    public void getA(){
        Table table = new Table();
        Set<Point> set = new TreeSet<Point>() {};
        for (int i = 0; i < 10; i++) {
            table.add(new Point(i, i + 5));
            set.add(new Point(i, i + 5));
        }
        assertEquals(table.getA(), set);
    }
}



