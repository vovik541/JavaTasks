import java.io.Serializable;

public class RoundSweet extends Sweet implements SweetInterface{
    private static final long serialVersionUID = 1L;

    private double radius;
    public RoundSweet(String name, double weight, double sugarCapacity, double radius) {
        super(name, weight, sugarCapacity);
        this.radius = radius;
    }

    @Override
    public double getVolume(){
        return 4/3*Math.PI*Math.pow(radius,3);
    }
    @Override
    public double getSugarWeight(){
        return this.sugarCapacity*this.weight;
    }

    @Override
    public String getName(){
        return this.name;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    public double getRadius(){
        return this.radius;
    }

}
