public class Calculator {

    public <T extends Number> double calculate(T x, T y, Operator operator) {
        double num1 = x.doubleValue(); // double형 변환
        double num2 = y.doubleValue();

        switch (operator) {
            case ADD:
                return num1 + num2;
            case SUBTRACT:
                return num1 - num2;
            case MULTIPLY:
                return num1 * num2;
            case DIVIDE:
                if (num2 == 0) {
                    throw new ArithmeticException("Cannot divide by zero");
                }
                return num1 / num2;
            default:
                throw new IllegalArgumentException("Unsupported operator: " + operator);
        }
    }
}
