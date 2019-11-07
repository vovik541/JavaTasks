package Flowers;

import java.util.ArrayList;

//DANGEROUS!!! THIS ALGORITHM WORKS BAD

public class Flowers {

    public static class FlowersClass{

        private String name;
        private int price;
        private int flowerAmount;
//        private boolean isInBouquet = false;

        public FlowersClass(String name, int price, int flowerAmount) {
            this.name = name;
            this.price = price;
            this.flowerAmount = flowerAmount;
        }
        public String getName(){
            return this.name;
        }
        public void setName(String name){
            this.name = name;
        }
        public int getPrice(){
            return this.price;
        }
        public void setPrice(int price){
            this.price = price;
        }
        public int getFlowerAmount(){
            return this.flowerAmount;
        }
        public void setFlowerAmount(int price){
            this.flowerAmount = flowerAmount;
        }
//        public boolean getIsInBouquet(){
//            return this.isInBouquet;
//        }
//        public void setIsInBouquet(){
//
//        }
    }

    public static ArrayList<FlowersClass> fillByFlowers(){
        ArrayList<FlowersClass> variety = new ArrayList<>();
        variety.add(new FlowersClass("Rose",25,12));
        variety.add(new FlowersClass("Bluebell",12,15));
        variety.add(new FlowersClass("Lotus",50,2));
        variety.add(new FlowersClass("Snowdrop",15,5));
        variety.add(new FlowersClass("Crocus",33,7));
        return variety;
    }

    public static void sortByPrice(ArrayList<FlowersClass> variety){
        int minValue;
        for(int i = 0; i < variety.size(); i++){
            minValue = variety.get(i).getPrice();
            for (int j = i; j < variety.size(); j++){
                if(minValue > variety.get(j).getPrice()){
                    minValue = variety.get(j).getPrice();
                    variety.add(i,variety.get(j));
                    variety.remove(j+1);
                }
            }
        }
    }

//    public static ArrayList<FlowersClass> getMinOddBouquet(ArrayList<FlowersClass> variety, int userCash){
//        ArrayList<FlowersClass> bouquet = new ArrayList<>();
//
//
//    }

    public static void flowers(){
        int userCash = 120;
        int numberOfFlowers;

        ArrayList<FlowersClass> variety = fillByFlowers();
        sortByPrice(variety);



    }

    public static void main(String[] args) {
        flowers();
    }
}
