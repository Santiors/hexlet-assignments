package exercise;

// BEGIN
public class App {
    public static void printSquare(Circle circle) throws NegativeRadiusException{
        try {
            double square = circle.getSquare();
            if (circle.getRadius() < 0) {
                throw new NegativeRadiusException();
            }
            System.out.print(Math.round(square));
        } catch (NegativeRadiusException e) {
            System.out.print("Не удалось посчитать площадь");
        } finally {
            System.out.print("\nВычисление окончено");
        }
    }
}
// END
