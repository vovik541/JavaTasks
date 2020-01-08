public class SquareSweet extends Sweet implements SweetInterface {
    private static final long serialVersionUID = 1L;

    private double length;
    public SquareSweet(String name, double weight, double sugarCapacity, double length) {
        super(name, weight, sugarCapacity);
        this.length = length;
    }

    @Override
    public double getVolume(){
        return Math.pow(length,3);
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

    public double getLength(){
        return this.length;
    }
}
