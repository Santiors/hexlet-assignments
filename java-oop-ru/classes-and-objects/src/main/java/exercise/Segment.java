package exercise;

// BEGIN
public class Segment {

    Point begin;
    Point end;

    public Segment(Point start, Point end) {
        this.begin = start;
        this.end = end;
    }

    public Point getBeginPoint() {
        return begin;
    }

    public Point getEndPoint() {
        return end;
    }

    public Point getMidPoint() {
        int midX = (begin.getX() + end.getX()) / 2;
        int midY = (begin.getY() + end.getY()) / 2;
        return new Point(midX, midY);
    }
}
// END
