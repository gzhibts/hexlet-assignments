package exercise;

// BEGIN

public class Flat implements Home{
    double area;
    double balconyArea;
    int floor;


    public Flat(double area, double balconyArea, int floor) {
        this.area = area;
        this.balconyArea = balconyArea;
        this.floor = floor;
    }


    @Override
    public String toString() {
        return "Квартира площадью " +
                getArea() +
                " метров на " + floor +
                " этаже";
    }


    @Override
    public double getArea() {
        return this.area + this.balconyArea;
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
