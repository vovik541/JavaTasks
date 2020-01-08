/*
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class MainWithManyGifts {
    public static void main(String[] args) {
    List<Gift> gifts = makeGifts();
    int consoleStatus = 0;
    int giftChoose;

        link:while (true){
            System.out.println("There are: "+gifts.size()+" Gifts, choose the gift: ...");
            giftChoose = toGetIntInput(gifts.size());
            System.out.println("You choose gift number: "+giftChoose);
            System.out.println("What would you like to do?");
            System.out.println("1 -> Sort the sweets in the gift");
            System.out.println("2 -> Find the gift from the given parameters");
            System.out.println("3 -> Get the gift's weight");
            System.out.println("4 -> Start again");
            System.out.println("5 -> STOP");
            consoleStatus = toGetIntInput(6);

            switch (consoleStatus){
                case 1:;
                case 2:;
                case 3:System.out.println("gift's weight is: "+gifts.get(giftChoose-1).findGiftWeight()+" gr"); continue link;
                case 4:continue link;
                default:break link;
            }
        }
    }


    public static int toGetIntInput(int giftsNumber){
        Scanner scanner = new Scanner(System.in);
        int giftNum = -1;
        giftNum = scanner.nextInt();
        while (giftsNumber < giftNum || giftNum < 0){
            System.out.println("please, write possible number!");
            giftNum = scanner.nextInt();
        }
        return giftNum;
    }

    public static void showMessage(int consoleStatus){
        switch (consoleStatus){
            case 0 :
            default: break;
        }
    }

    public static List<Gift> makeGifts(){List
        List<Gift> gifts = new LinkedList<>();
        gifts.add(new Gift(Arrays.asList(new RoundSweet("Round","RoundSweet_1",3.8,0.5,4.1),
                new RoundSweet("Round","RoundSweet_2",4.4,0.35,5.1),
                new RoundSweet("Round","RoundSweet_3",5.1,0.56,6.6),
                new RoundSweet("Round","RoundSweet_3",5.1,0.56,6.6),
                new RoundSweet("Round","RoundSweet_3",5.1,0.56,6.6),
                new SquareSweet("Square","SquareSweet_2",5.5,0.72,6.5))
                )
        );
        gifts.add(new Gift(Arrays.asList(new RoundSweet("Round","RoundSweet_1",3.8,0.5,4.1),
                new RoundSweet("Round","RoundSweet_2",4.4,0.35,5.1),
                new RoundSweet("Round","RoundSweet_3",5.1,0.56,6.6),
                new RoundSweet("Round","RoundSweet_3",5.1,0.56,6.6),
                new RoundSweet("Round","RoundSweet_3",5.1,0.56,6.6),
                new SquareSweet("Square","SquareSweet_2",5.5,0.72,6.5))
                )
        );
        return gifts;
    }

}
*/
