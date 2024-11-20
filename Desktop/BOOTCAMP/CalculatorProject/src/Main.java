import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double result = 0.0;
        String input1, input2, input3, operator;
        Scanner scanner = new Scanner(System.in);
        Calculator calc = new Calculator();
        DataManager dataManager = new DataManager(); // 데이터 매니저 인스턴스 생성

        while (true) {
            try {
                System.out.print("Enter first number or command (exit/delete data/find data): ");
                input1 = scanner.nextLine();

                // break 문을 통해 루프를 중지합니다.
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

                    try {
                        double number2 = Double.parseDouble(input2);
                        System.out.println(dataManager.confirm(input1, number2));
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter a valid number.");
                    }
                    continue;
                }

                // 각 상황별 대응을 코딩하였습니다.
                // 추가로 클래스를 이용한 인스턴스를 통해 문제를 해결했습니다.
                if (input1.equalsIgnoreCase("modified data")) { //데이터 수정
                    try {
                        System.out.print("Origin data: ");
                        input2 = scanner.nextLine();
                        double number2 = Double.parseDouble(input2);

                        System.out.print("Modified data: ");
                        input3 = scanner.nextLine();
                        double number3 = Double.parseDouble(input3);

                        System.out.println(dataManager.confirm(input1, number2, number3));
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter valid numbers.");
                    }
                    continue;
                }

                if (input1.equalsIgnoreCase("add data")) {// 데이터 추가
                    System.out.print("Enter add number: ");
                    input2 = scanner.nextLine();

                    try {
                        double number2 = Double.parseDouble(input2);
                        System.out.println(dataManager.confirm(input1, number2));
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter a valid number.");
                    }
                    continue;
                }

                if (input1.equalsIgnoreCase("find data")) {// 데이터 찾기
                    System.out.print("Enter comparison operator (e.g., '>'): ");
                    String findOption = scanner.nextLine();

                    System.out.print("Enter the number to compare with: ");
                    try {
                        double comparisonValue = Double.parseDouble(scanner.nextLine());

                        // 조건에 맞는 데이터 검색 후 출력
                        List<Double> foundData = dataManager.findDataByCondition(findOption, comparisonValue);
                        System.out.println("Found data: " + foundData);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter a valid number.");
                    }
                    continue;
                }

                // 사측연산 구현
                double number1 = Double.parseDouble(input1);

                System.out.print("Enter second number: ");
                input2 = scanner.nextLine();
                double number2 = Double.parseDouble(input2);

                System.out.print("Enter an operator (+, -, *, /): ");
                operator = scanner.nextLine();

                try {
                    Operator operatorEnum = Operator.fromString(operator);

                    result = calc.calculate(number1, number2, operatorEnum);

                    System.out.println("Result: " + result);

                    // 결과를 DataManager에 저장
                    dataManager.addData(result);
                    // 아래는 예외처리입니다. 글자가 입력된 경우, 연산자 오류인경우, 잘못된 산술연산이 발생한 경우, 특정 예외 전부를 탐색하기 위해 Exception클래스를 사용한 전체 예외처리
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid operator. Please enter one of +, -, *, /.");
                } catch (ArithmeticException e) {
                    System.out.println(e.getMessage());
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
