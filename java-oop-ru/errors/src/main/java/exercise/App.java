package exercise;

// BEGIN
public class App {

    public static void printSquare(Circle a) {

        try {
            double s = a.getSquare();
            long roundedS = Math.round(s);
            System.out.println(roundedS);
            System.out.println("Вычисление окончено");
        }
        catch (NegativeRadiusException e) {
            System.out.println("Не удалось посчитать площадь");
            System.out.println("Вычисление окончено");
        }
    }
}
// END
