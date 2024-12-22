import java.util.Scanner;

public class Main {

    public static double calculate(String expression) {
        String[] parts = expression.split(" ");

        if (parts.length != 3) {
            throw new IllegalArgumentException("Некорректный формат ввода. Ожидается: <число> <оператор> <число>");
        }

        double num1 = Double.parseDouble(parts[0]);
        String operator = parts[1];
        double num2 = Double.parseDouble(parts[2]);

        switch (operator) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                if (num2 == 0) {
                    throw new ArithmeticException("Деление на ноль невозможно.");
                }
                return num1 / num2;
            default:
                throw new IllegalArgumentException("Некорректный оператор: " + operator);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите выражение (например, 2 * 6.5): ");
        String input = scanner.nextLine();

        try {
            double result = calculate(input);
            System.out.println("Результат: " + result);
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: одно из введённых значений не является числом.");
        } catch (IllegalArgumentException | ArithmeticException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
