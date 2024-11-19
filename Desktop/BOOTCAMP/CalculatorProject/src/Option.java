import java.util.ArrayList;

public class Option {
    ArrayList<Double> collection = new ArrayList<>();
    double result = 0;

    public double add(double x, double y)
        {
            result = x + y;
            collection.add(result);
            return result;
        }
}