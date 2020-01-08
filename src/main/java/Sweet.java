import java.io.Serializable;

public abstract class Sweet implements Serializable {
    protected String name;
    protected double weight;
    protected double sugarCapacity;

    public Sweet(String name, double weight, double sugarCapacity) {
        this.name = name;
        this.weight = weight;
        this.sugarCapacity = sugarCapacity;
    }

    public double getSugarCapacity() {
        return sugarCapacity;
    }

}
