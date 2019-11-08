package Flowers;

import java.util.ArrayList;

public class Flowers {

    public static int USER_CASH = 279;

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

        public void buy(){
            this.soldAmount++;
            this.flowerAmount--;
        }
        public void turnBack(){
            this.soldAmount--;
            this.flowerAmount++;
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

    public static void showMessage(int messageStatus, int numberOfFlowers, int shortChange, int numberOfKinds){
        switch (messageStatus){
            case 0:System.out.println("You have no money for even one flower!");break;
            case 1:System.out.println("You have bought "+ numberOfFlowers +" flowers from "+ numberOfKinds +" different kinds. Your account is: "+shortChange+".");break;
            default:break;
        }
    }

    public static int makeMinimumBouquet(ArrayList<FlowersClass> variety, ArrayList<FlowersClass> bouquet, int userCash){

        for (int i = 0; i < variety.size(); i++){
            if(variety.get(i).getPrice() <= userCash){
                bouquet.add(variety.get(i));
                bouquet.get(i).buy();
                userCash-=bouquet.get(i).price;
            }else {
                showMessage(1,i,userCash,i);
                break;
            }
        }

        int numberOfFlowers = bouquet.size()+1;
        int k = 0;

        while (numberOfFlowers % 2 != 1){
            if(bouquet.get(k).getFlowerAmount() != 0 && bouquet.get(k).getPrice() <= userCash){
                bouquet.get(k).buy();
                userCash -= bouquet.get(k).getPrice();
                numberOfFlowers++;
            }
        }

        if(numberOfFlowers % 2 != 1){
            userCash += bouquet.get(bouquet.size()-1).getPrice();
            bouquet.get(bouquet.size()-1).turnBack();
            bouquet.remove(bouquet.size()-1);
            numberOfFlowers--;
        }
        showMessage(1, numberOfFlowers(bouquet), userCash, bouquet.size());
        return userCash;
    }

    public static FlowersClass findTheCheapestFlower(ArrayList<FlowersClass> bouquet){
        for (int i = 0; i < bouquet.size(); i++){
            if(bouquet.get(i).flowerAmount != 0){
                return bouquet.get(i);
            }
        }
        return null;
    }
    public static FlowersClass findTheSecondCheapestFlower(ArrayList<FlowersClass> bouquet){
        for (int i = 0; i < bouquet.size(); i++){
            if(bouquet.get(i).flowerAmount != 0){
                for (int j = i+1; j < bouquet.size(); j++){
                    if(bouquet.get(j).flowerAmount != 0){
                        return bouquet.get(j);
                    }
                }
            }
        }
        return null;
    }

    public static int makeMaxBouquet(ArrayList<FlowersClass> variety, ArrayList<FlowersClass> bouquet, int userCash){
        int i = 0;
        FlowersClass theCheapestFlower;
        FlowersClass theSecondCheapestFlower;
        while (true){
            theCheapestFlower = findTheCheapestFlower(bouquet);
            theSecondCheapestFlower = findTheSecondCheapestFlower(bouquet);

            if(findTheCheapestFlower(bouquet)==null){
                return userCash;
            }

            if(theCheapestFlower.getFlowerAmount()/2 > 0){
                if (userCash >= theCheapestFlower.getPrice()*2){
                    theCheapestFlower.buy();
                    theCheapestFlower.buy();
                    userCash -= theCheapestFlower.getPrice()*2;
                    continue;
                } else {
                    return userCash;
                }
            } else if (theCheapestFlower.getFlowerAmount() == 1 && theSecondCheapestFlower.getFlowerAmount() > 1){
                if (userCash >= theCheapestFlower.getPrice() + theSecondCheapestFlower.getPrice()){
                    theCheapestFlower.buy();
                    theSecondCheapestFlower.buy();
                    userCash -= (theCheapestFlower.getPrice() + theSecondCheapestFlower.getPrice());
                    continue;
                } else {
                    return userCash;
                }
            } else {
                return userCash;
            }
        }
    }

    public static int numberOfFlowers(ArrayList<FlowersClass> bouquet){
        int num = 0;
        for(int i = 0; i < bouquet.size(); i++){
            num += bouquet.get(i).soldAmount;
//            System.out.println(bouquet.get(i).soldAmount);
        }
        return num;
    }

    public static void flowers(){
        ArrayList<FlowersClass> variety = getAllFlowers(); //here we gets all available flowers and sort them by price
        sortByPrice(variety);

        ArrayList<FlowersClass> bouquet = new ArrayList<>(); //our bouquet of flowers

        int userCash = USER_CASH;

        if (userCash < variety.get(0).price){  //check if user have enough money to buy the cheapest flower: if yes -> he buys it/
            showMessage(0,0,0,0);
        } else {
            userCash = makeMinimumBouquet(variety,bouquet,userCash);  //makes the minimum "odd numbered" bouquet with maximum flower names
            userCash = makeMaxBouquet(variety,bouquet,userCash);    //take 2 flowers each time and add them to bouquet
            // makeMaximumBouquet --> (if user still have enough money and if there is more than 1 flower in the market)

            showMessage(1,numberOfFlowers(bouquet),userCash,bouquet.size());
        }

    }

    public static void main(String[] args) {
        flowers();
    }
}
