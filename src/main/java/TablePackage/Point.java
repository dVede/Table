package TablePackage;

public class Point implements Comparable<Point> {
  private double y;
  private double x;

  public Point(double x, double y) {
    this.y = y;
    this.x = x;
  }

  public double getX() {
    return x;
  }

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
    if (y != other.y)
      return false;
    return true;
  }

  @Override
  public int compareTo(Point o) {
    return Double.compare(this.getX(), o.getX());
  }

    public String toString() {
    return "TablePackage.Point (" + " x = " + x + ", y = " + y + ")";
  }
}
