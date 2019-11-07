import java.util.ArrayList;
import java.util.Scanner;

public class TwentyOne {

    public static final int CARDS_NUMBER = 36; //size of Deck
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

    public static ArrayList<Card> getDeck(){
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

    public static int getCardIndex(int size){
        return (int)(Math.random()*1000%size);
    }

    public static Card getCard(ArrayList<Card> deckOfCards, int cardIndex){
        Card card = deckOfCards.get(cardIndex);
        deckOfCards.remove(cardIndex);
        return card;
    }

    public static int getComputerAccount(ArrayList<Card> deckOfCards){
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
            case 0:System.out.println("Do you want to take a card? '+'/'-' (your account is "+userAccount+" )");break;
            case 1:System.out.println("YOU WIN! (your account is "+userAccount+" against computer's once: "+computerAccount+")");break;
            case 2:System.out.println("DRAVE! (your account is "+userAccount+" against computer's once: "+computerAccount+")");break;
            case 3:System.out.println("YOU LOSE! (your account is "+userAccount+" against computer's once: "+computerAccount+")");break;
            case 4:System.out.println("You get an Ass, do you want it 1 or 11? press '-' for 1 / '+' for 11 (your account is "+userAccount+" )");break;
            case 5:System.out.println("You got '"+card.getName()+"' (it's value is:"+card.getValue()+" )");break;
            case 6:System.out.println("Please, press '+' for Yes / '-' for NO (your account is "+userAccount+" )");break;
            case 7:System.out.println("Please, press '-' for 1 / '+' for 11 (your account is "+userAccount+" )");break;
            default:break;
        }
    }

    private static int getUserDecision(){
        Scanner scanner = new Scanner(System.in);
        char userDecision = scanner.next().charAt(0);
        return convertDecision(userDecision);
    }

    public static int convertDecision(char userDecision){
        if (userDecision == '+'){
            return 1;
        } else if (userDecision == '-'){
            return 2;
        } else {
            return 3;
        }
    }

    public static void main(String[] args) {
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
}