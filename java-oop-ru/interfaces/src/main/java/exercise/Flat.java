package exercise;

// BEGIN
public class Flat implements Home {

    double area;
    double balconyArea;
    int floor;

    public Flat(double area, double balconyArea, int floor) {
        this.area = area;
        this.balconyArea = balconyArea;
        this.floor = floor;
    }

    @Override
    public double getArea() {
        return area + balconyArea;
    }

    public double getBalconyArea() {
        return this.balconyArea;
    }

    public int getFloor() {
        return this.floor;
    }

    @Override
    public String toString() {
        return "Квартира площадью " + getArea() + " метров на " + getFloor() + " этаже";
    }

    @Override
    public int compareTo(Home another) {
        if (getArea() > another.getArea()) {
            return 1;
        } else if (getArea() == another.getArea()) {
            return 0;
        } else {
            return -1;
        }
    }
}
// END
