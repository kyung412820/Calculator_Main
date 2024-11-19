import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        double result = 0.0;
        String input1, input2, input3, operator;
        Scanner scanner = new Scanner(System.in);
        Calculator calc = new Calculator();
        DataManager dataManager = new DataManager(); // 데이터 매니저 인스턴스 생성

        while (true) {
            System.out.print("Enter first number or command (exit/delete data/find data): ");
            input1 = scanner.nextLine();

            // exit command to break the loop
            if (input1.equalsIgnoreCase("exit")) {
                System.out.println("Exiting the program.");
                break;
            }

            if (input1.equalsIgnoreCase("delete data")) {
                System.out.println("Deleting all data...");
                dataManager.clearAllData(); // 모든 데이터 삭제
                continue;
            }

            if (input1.equalsIgnoreCase("delete one data")) {
                System.out.print("Deleting one data: ");
                input2 = scanner.nextLine();
                double number2 = Double.parseDouble(input2);

                System.out.println(dataManager.confirm(input1, number2));
                continue;
            }

            if (input1.equalsIgnoreCase("modified data")) {
                System.out.print("origin data : ");
                input2 = scanner.nextLine();
                double number2 = Double.parseDouble(input2);
                System.out.print("modified data : ");
                input3 = scanner.nextLine();
                double number3 = Double.parseDouble(input3);
                System.out.println(dataManager.confirm(input1, number2, number3));
                continue;
            }
            if (input1.equalsIgnoreCase("add data")) {
                System.out.print("Enter add number: ");
                input2 = scanner.nextLine();
                double number2 = Double.parseDouble(input2);
                System.out.println(dataManager.confirm(input1, number2));
                continue;
            }
            if (input1.equalsIgnoreCase("find data")) {
                System.out.print("Enter comparison operator (e.g., '>'): ");
                String findOption = scanner.nextLine();

                System.out.print("Enter the number to compare with: ");
                double comparisonValue = scanner.nextDouble();
                scanner.nextLine(); // clear the buffer

                // 조건에 맞는 데이터 검색 후 출력
                List<Double> foundData = dataManager.findDataByCondition(findOption, comparisonValue);
                System.out.println("Found data: " + foundData);
                continue;
            }

            // Convert input1 to a double if it's not a command
            double number1 = Double.parseDouble(input1);

            System.out.print("Enter second number: ");
            input2 = scanner.nextLine();
            double number2 = Double.parseDouble(input2);

            System.out.print("Enter an operator (+, -, *, /): ");
            operator = scanner.nextLine();

            try {
                // Get the corresponding Operator enum value
                Operator operatorEnum = Operator.fromString(operator);

                // Perform the calculation based on the operator
                result = calc.calculate(number1, number2, operatorEnum);

                System.out.println("Result: " + result);

                // 결과를 DataManager에 저장
                dataManager.addData(result);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid operator. Please enter one of +, -, *, /.");
            } catch (ArithmeticException e) {
                System.out.println(e.getMessage());
            }
        }

        scanner.close();
    }
}
enum Operator {
    ADD("+"),
    SUBTRACT("-"),
    MULTIPLY("*"),
    DIVIDE("/");

    private final String symbol;

    Operator(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public static Operator fromString(String symbol) {
        for (Operator operator : Operator.values()) {
            if (operator.getSymbol().equals(symbol)) {
                return operator;
            }
        }
        throw new IllegalArgumentException("Invalid operator: " + symbol);
    }
}

class Calculator {

    // Perform arithmetic operation with generics, where T can be Integer, Double, Float, etc.
    public <T extends Number> double calculate(T x, T y, Operator operator) {
        double num1 = x.doubleValue(); // Convert T to double
        double num2 = y.doubleValue(); // Convert T to double

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

class DataManager {
    private List<Double> dataList;

    public DataManager() {
        this.dataList = new ArrayList<>();
    }

    // 데이터 추가
    public void addData(double data) {
        dataList.add(data);
    }

    // 조건에 맞는 데이터를 찾기 (>, <, = 조건) using Streams
    public List<Double> findDataByCondition(String condition, double value) {
        return dataList.stream()
                .filter(data -> {
                    switch (condition) {
                        case ">": return data > value;
                        case "<": return data < value;
                        case "=": return data == value;
                        default:
                            System.out.println("Invalid condition. Use >, <, or =.");
                            return false;
                    }
                })
                .collect(Collectors.toList());
    }

    // `add data` 및 `delete one data` 작업을 위한 메서드 (제네릭 사용)
    public <T extends Number> String confirm(String condition, T value) {
        switch (condition) {
            case "add data":
                dataList.add(value.doubleValue());
                return "Data added: " + value.doubleValue();

            case "delete one data":
                // Lambda and stream to remove data
                boolean removed = dataList.removeIf(data -> data == value.doubleValue());
                return removed ? "Complete delete one data" : "Data not found for deletion";

            default:
                return "Unknown condition: " + condition;
        }
    }

    // `modify data` 작업을 위한 메서드 (제네릭 사용)
    public <T extends Number> String confirm(String condition, T value, T value2) {
        if ("modified data".equals(condition)) {
            // Lambda and stream to find and modify data
            for (int i = 0; i < dataList.size(); i++) {
                if (dataList.get(i) == value.doubleValue()) {
                    dataList.set(i, value2.doubleValue());
                    return "Complete data modify: " + value + " -> " + value2;
                }
            }
        }
        return "Condition not found for modification.";
    }

    // 모든 데이터 삭제
    public void clearAllData() {
        dataList.clear();
        System.out.println("All data has been deleted.");
    }
}
