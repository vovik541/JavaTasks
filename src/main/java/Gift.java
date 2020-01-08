import java.io.Serializable;
import java.util.List;

public class Gift implements Serializable {
    private static final long serialVersionUID = 1L;

    List<SweetInterface> gift = null;

    Gift(List<SweetInterface> gift){
        this.gift = gift;
    }

    public List<SweetInterface> getSweets(){
        return gift;
    }

    public double findGiftWeight(){
        double giftWeight = 0;
        for(int i = 0; i < gift.size(); i++){
            giftWeight += gift.get(i).getWeight();
        }
        return giftWeight;
    }

    public void addSweet(SweetInterface sweet){
        this.gift.add(sweet);
    }

}
