public class Point implements Comparable<Point> {  private double x;  private double y;    public Point(double x, double y) {    this.x = x;    this.y = y;  }    public double getX() {    return x;  }    public double getY() {    return y;  }    public int compareTo(Point other) {    if (x < other.x) {      return -1;    } else if (x > other.x) {      return 1;    } else {      if (y < other.y) {        return -1;      } else if (y > other.y) {        return 1;      } else {        return 0;      }    }  }}
