package exercise;

// BEGIN
public class Segment {

    private final Point beginPoint;
    private final Point endPoint;


    public Point getBeginPoint() {
        return beginPoint;
    }

    public Point getEndPoint() {
        return endPoint;
    }

    public Segment(Point a, Point b) {
        this.beginPoint = a;
        this.endPoint = b;
    }

    public Point getMidPoint(){
        int x = (this.beginPoint.getX() + this.endPoint.getX()) / 2;
        int y = (this.beginPoint.getY() + this.endPoint.getY()) / 2;

        Point result = new Point(x, y);
        return result;

    }


}
// END
