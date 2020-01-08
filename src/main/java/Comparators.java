import java.util.Comparator;

public class Comparators {

    public static class SweetWeightComparator implements Comparator<SweetInterface> {

        public int compare(SweetInterface a, SweetInterface b){
            return Double.compare(a.getWeight(),b.getWeight());
        }
    }

    public static class SweetVolumeComparator implements Comparator<SweetInterface> {

        public int compare(SweetInterface a, SweetInterface b){
            return Double.compare(a.getVolume(),b.getVolume());
        }
    }

    public static class SweetSugarWeightComparator implements Comparator<SweetInterface> {

        public int compare(SweetInterface a, SweetInterface b){
            return Double.compare(a.getSugarWeight(),b.getSugarWeight());
        }
    }
}
