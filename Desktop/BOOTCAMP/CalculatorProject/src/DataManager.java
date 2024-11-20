import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DataManager {
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
                // 람다, 데이터 삭제
                boolean removed = dataList.removeIf(data -> data == value.doubleValue());
                return removed ? "Complete delete one data" : "Data not found for deletion";

            default:
                return "Unknown condition: " + condition;
        }
    }

    // `modify data` 작업을 위한 메서드 (제네릭 사용)
    public <T extends Number> String confirm(String condition, T value, T value2) {
        if ("modified data".equals(condition)) {
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
