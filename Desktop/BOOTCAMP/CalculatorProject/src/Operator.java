public enum Operator { // 스트림을 통한 사측연산 구현
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
