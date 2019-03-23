package table_package;

import org.jetbrains.annotations.NotNull;

public class Point implements Comparable<Point> {
  private double y;
  private double x;

  /**
   * Класс точки
   * @param x Значение ординаты точки
   * @param y Значение абциссы точки
   */
  public Point(double x, double y) {
    this.y = y;
    this.x = x;
  }

  /**
   * Получение значения ординаты точки
   * @return Ординату точки
   */
  public double getX() {
    return x;
  }

  /**
   * Получение значения абциссы точки
   * @return Абциссу точки
   */
  public double getY() {
    return y;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Point other = (Point) obj;
    if (x != other.x)
      return false;
    return !(y != other.y);
  }

  @Override
  public int compareTo(@NotNull Point o) {
    return Double.compare(this.getX(), o.getX());
  }

    public String toString() {
    return "TablePackage.Point (" + " x = " + x + ", y = " + y + ")";
  }
}
