package Flowers;

import java.util.ArrayList;

//DANGEROUS!!! THIS ALGORITHM WORKS BAD

public class Flowers {

    public static int USER_CASH = 120;

    public static class FlowersClass{

        private String name;
        private int price;
        private int flowerAmount;
        private int soldAmount;

        public FlowersClass(String name, int price, int flowerAmount) {
            this.name = name;
            this.price = price;
            this.flowerAmount = flowerAmount;
            this.soldAmount = 0;
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
        public int getSoldAmount(){
            return this.soldAmount;
        }
        public void setIsInBouquet(int soldAmount){
            this.soldAmount = soldAmount;
        }
    }

    public static ArrayList<FlowersClass> getAllFlowers(){
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
        //here we gets all available flowers and sort them by price

        ArrayList<FlowersClass> variety = getAllFlowers();
        sortByPrice(variety);
/*
        RULE (1)  if the number of flower's variety is odd, we check if the user has enough money for buying at least 1 of each flower
        RULE (2) else if the number of flower's variety isn't odd, we check
         if the user has enough money for buying at least 1 of each flower += one more flower (the chippest once)
        RULE (3) if the user has not enough money for buying by the rules (1)||(2) we are looking for
        the variant, where the user can buy the biggest odd number of flower's variety
         (if cannot -> partly use (2) and buy pair number += one the cheapest)
*/
//        ArrayList<FlowersClass> user


    }

    public static void main(String[] args) {
        flowers();
    }
}