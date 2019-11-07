package TwentyOne;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class TwentyOne {

    private static final int CARDS_NUMBER = 36; //size of Deck
    private static final int MAX_NUM_CARD = 10; // this is number of maximum numbered card
    private static final int AGRESSIVE_VALUE = 16; //This is value till which computer takes cards

    public static class Card{

        private String name;
        private int value;
        private boolean isAss;

        public Card(String name, int value, boolean isAss){
            this.name = name;
            this.value = value;
            this.isAss = isAss;
        }
        public String getName(){
            return this.name;
        }
        public int getValue(){
            return this.value;
        }
        public boolean getIsAss(){
            return this.isAss;
        }
    }

    private static ArrayList<Card> getDeck(){
        ArrayList<Card> deckOfCards = new ArrayList<>();

        String[] unusualCardNames = new String[]{
                "Jack",
                "Queen",
                "King",
                "Ass"
        };

        for (int i = 0; i < unusualCardNames.length; i++){
            for(int j =0; j < 4; j++){
                if(unusualCardNames[i]=="Ass"){
                    deckOfCards.add(new Card(unusualCardNames[i],1,true));
                } else {
                    deckOfCards.add(new Card(unusualCardNames[i],i+2,false));
                }
            }
        }

        for (int i = 0; i < CARDS_NUMBER/4 - unusualCardNames.length; i++){
            for (int j = 0; j < 4; j++){
                deckOfCards.add(new Card(Integer.toString(MAX_NUM_CARD-i),MAX_NUM_CARD-i, false));
            }
        }
//        System.out.println(deckOfCards.size());
        return deckOfCards;
    }

    private static int getCardIndex(int size){
        return (int)(Math.random()*1000%size);
    }

    private static Card getCard(ArrayList<Card> deckOfCards, int cardIndex){
        Card card = deckOfCards.get(cardIndex);
        deckOfCards.remove(cardIndex);
        return card;
    }

    private static int getComputerAccount(ArrayList<Card> deckOfCards){
        int computerAccount = 0;

        while (computerAccount < AGRESSIVE_VALUE){
            int cardIndex = getCardIndex(deckOfCards.size());
            Card card = getCard(deckOfCards,cardIndex);
            computerAccount += card.getValue();
        }
        return computerAccount;
    }

    private static void showMessage(int gameState, Card card, int userAccount,int computerAccount){
        switch (gameState){
            case 0:System.out.println("Do you want to take a card? y-Yes / n-NO (your account is "+userAccount+" )");break;
            case 1:System.out.println("YOU WIN! (your account is "+userAccount+" against computer's once: "+computerAccount+")");break;
            case 2:System.out.println("DRAVE! (your account is "+userAccount+" against computer's once: "+computerAccount+")");break;
            case 3:System.out.println("YOU LOSE! (your account is "+userAccount+" against computer's once: "+computerAccount+")");break;
            case 4:System.out.println("You get an Ass, do you want it 1 or 11? press 'n' for 1 / 'y' for 11 (your account is "+userAccount+" )");break;
            case 5:System.out.println("You got '"+card.getName()+"' (it's value is:"+card.getValue()+" )");break;
            case 6:System.out.println("Please, press y-Yes / n-NO (your account is "+userAccount+" )");break;
            case 7:System.out.println("Please, press 'n' for 1 / 'y' for 11 (your account is "+userAccount+" )");break;
            default:break;
        }
    }

    private static int getUserDecision(){
        Scanner scanner = new Scanner(System.in);
        char userDecision = scanner.next().charAt(0);
        if (userDecision == 'y'){
            return 1;
        } else if (userDecision == 'n'){
            return 2;
        } else {
            return 3;
        }
    }

    public static void twentyOne(){
        ArrayList<Card> deckOfCards = getDeck();
        int computerAccount = getComputerAccount(deckOfCards);
        int userAccount = 0;
        int gameState;
        int userDesision;
        Card card;

        while (true){

            gameState = 0;
            card = getCard(deckOfCards,getCardIndex(deckOfCards.size()));
            showMessage(gameState,card,userAccount,computerAccount);

            if (userAccount > 21 && computerAccount > 21){
                gameState = 2;
                showMessage(gameState,card,userAccount,computerAccount);
                break;
            }else if(userAccount > 21){
                gameState = 3;
                showMessage(gameState,card,userAccount,computerAccount);
                break;
            }

            userDesision = 3;
            while (userDesision == 3){
                userDesision = getUserDecision();
                if(userDesision==3){
                    gameState = 6;
                    showMessage(gameState,card,userAccount,computerAccount);
                }
            }

            if(userDesision==2){
                if((userAccount > computerAccount && computerAccount < 22)||(userAccount < 22 && computerAccount > 21)){
                    gameState = 1;
                    showMessage(gameState,card,userAccount,computerAccount);
                    break;
                }else if (userAccount == computerAccount || (userAccount > 21 && computerAccount > 21)){
                    gameState = 2;
                    showMessage(gameState,card,userAccount,computerAccount);
                    break;
                }else {
                    gameState = 3;
                    showMessage(gameState,card,userAccount,computerAccount);
                    break;
                }
            }else {
                if(card.isAss){
                    gameState = 4;
                    showMessage(gameState,card,userAccount,computerAccount);

                    userDesision = 3;
                    while (userDesision == 3){
                        userDesision = getUserDecision();
                        if(userDesision==3){
                            gameState = 7;
                            showMessage(gameState,card,userAccount,computerAccount);
                        }
                    }

                    if(userDesision==2){
                        userAccount++;
                        continue;
                    }else {
                        userAccount+=11;
                        continue;
                    }

                }else {
                    gameState = 5;
                    showMessage(gameState,card,userAccount,computerAccount);
                    userAccount += card.getValue();
                    continue;
                }
            }
        }

    }

    public static void main(String[] args) {
        twentyOne();
    }
}


/*
    private static boolean isAss(int pikedCard){
        if (pikedCard == 11){
            return true;
        } else {
            return false;
        }
    }

    private static void showMessage(int gameState){

        switch (gameState){
            case 0: System.out.println("The game started. Do you want to take a card? y-YES/ n-NO");break;
            case 1: System.out.println("You piked YES");break;
            case 2: System.out.println("You piked NO, the game is ended.");break;
            case 3: System.out.println("please, write y->YES / n->NO");break;
            default: System.out.println("Do you want one more card? y-YES / n-NO");break;
        }
    }

    private static void showPikedCard(int pikedCard){
        switch (pikedCard){
            case 11:System.out.println("Your card is A (1<->11). Please, write '1' or '11'");break;
            case 12:System.out.println("Your card is J (2)");break;
            case 13:System.out.println("Your card is Q (3)");break;
            case 14:System.out.println("Your card is K (4)");break;
            default:System.out.println("Your kard is " + pikedCard);break;
        }
    }

    private static int gesAssDecision(){
        Scanner scanner = new Scanner(System.in);
        int assChoice = scanner.nextInt();
        return assChoice;
    }

    private static int getUserDecision(){
        Scanner scanner = new Scanner(System.in);
        char userDecision = scanner.next().charAt(0);
        if (userDecision == 'y'){
            return 1;
        } else if (userDecision == 'n'){
            return 2;
        } else {
            return 3;
        }
    }

    private static int getCard(){
        return (int) (Math.random() * 100 % 14 +1);
    }

    private static int getComputerAccount(){
        int computerAccount = 0;
        int computerCard;

        while (computerAccount < 16){
            computerCard = getCard();
            if (computerCard == 11 && (computerCard+computerAccount)>21){
                computerAccount++;
            } else if (computerCard > 11) {
                computerAccount += computerCard -10;
            } else {
                computerAccount += computerCard;
            }
        }
        return computerAccount;
    }

    private static int changeUserAccount(int userAccount, int piKedCard, int ass){
        if(piKedCard > 11){
            return userAccount + piKedCard - 10;
        } else if (piKedCard == 11){
            return userAccount + ass;
        } else {
            return userAccount + piKedCard;
        }
    }

    public static void twentyOne(){
        int computerAccount = getComputerAccount();
        int userAccount = 0;
        int gameState = 0;
        int assChoice = 0;
        int pikedCard;

        computerAccount = getComputerAccount();
        showMessage(gameState);

        while (gameState != 2){

            if (gameState == 1){
                showMessage(4);
            }
            gameState = getUserDecision();
            showMessage(gameState);

            if(gameState == 2){
                if((userAccount > computerAccount && computerAccount < 22)||(userAccount < 22 && computerAccount > 21)){
                    System.out.println("YOU WIN! You have: " + userAccount + " While computer account is: " + computerAccount);
                    break;
                }else if (userAccount == computerAccount){
                    System.out.println("DRAVE! You and computer have the same result: " + userAccount + " !");
                    break;
                }else {
                    System.out.println("YOU LOSE! You have: " + userAccount + " While computer account is: " + computerAccount);
                    break;
                }
            } else if (gameState == 1){
                pikedCard = getCard();
                showPikedCard(pikedCard);
                userAccount = changeUserAccount(userAccount,pikedCard,assChoice);
                System.out.println("Your account is: " + userAccount );

                if (isAss(pikedCard)){
                    while (true){
                        assChoice = gesAssDecision();
                        if (assChoice == 1 || assChoice == 11){
                            userAccount = changeUserAccount(userAccount,pikedCard,assChoice);
                            System.out.println("Your account is: " + userAccount );
                            break;
                        }
                        System.out.println("WRITE '1' OR '11' !!!");
                    }
                }

                if (userAccount > 21 && computerAccount >21){
                    System.out.println("DRAVE! You and computer have more than 21! Your account:" + userAccount +" comp. acc.:" + computerAccount);
                    break;
                } else if(userAccount > 21){
                    System.out.println("Game Over, YOU LOSE! you have: " + userAccount +" > 21 (computer has: " + computerAccount +")");
                    break;
                }
            }
        }
    }*/
