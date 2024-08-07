package exercise;

// BEGIN
public class Cottage implements Home{
    double area;
    int floorCount;


    public Cottage(double area, int floorCount) {
        this.area = area;
        this.floorCount = floorCount;
    }


    @Override
    public String toString() {
        return this.floorCount
                + " этажный коттедж площадью "
                + this.area + " метров";
    }


    @Override
    public double getArea() {
        return this.area;
    }

    @Override
    public int compareTo(Home enother) {
        if (this.getArea() > enother.getArea()) {
            return 1;
        }
        if (this.getArea() == enother.getArea()) {
            return 0;
        }
        else {
            return -1;
        }
    }
}
// END
