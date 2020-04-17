package Model;

public class Position {
    private final String name;
    private final double minPayment;
    private final double maxPayment;

    public Position(String name, double minPayment, double maxPayment) {
        this.name = name;
        this.minPayment = minPayment;
        this.maxPayment = maxPayment;
    }

    public String getName() {
        return name;
    }

    public double getMinPayment() {
        return minPayment;
    }

    public double getMaxPayment() {
        return maxPayment;
    }
}
