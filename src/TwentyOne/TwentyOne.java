package TwentyOne;

import java.util.Scanner;

public class TwentyOne {

    public static boolean isAss(int pikedCard){
        if (pikedCard == 11){
            return true;
        } else {
            return false;
        }
    }

    public static void showMessage(int gameState){

        switch (gameState){
            case 0: System.out.println("The game started. Do you want to take a card? y-YES/ n-NO");break;
            case 1: System.out.println("You piked YES");break;
            case 2: System.out.println("You piked NO, the game is ended.");break;
            case 3: System.out.println("please, write y->YES / n->NO");break;
            default: System.out.println("Do you want one more card? y-YES / n-NO");break;
        }
    }

    public static void showPikedCard(int pikedCard){
        switch (pikedCard){
            case 11:System.out.println("Your card is A (1<->11). Please, write '1' or '11'");break;
            case 12:System.out.println("Your card is J (2)");break;
            case 13:System.out.println("Your card is Q (3)");break;
            case 14:System.out.println("Your card is K (4)");break;
            default:System.out.println("Your kard is " + pikedCard);break;
        }
    }

    public static int gesAssDecision(){
        Scanner scanner = new Scanner(System.in);
        int assChoice = scanner.nextInt();
        return assChoice;
    }

    public static int getUserDecision(){
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

    public static int getCard(){
        return (int) (Math.random() * 100 % 14 +1);
    }

    public static int getComputerAccount(){
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

    public static int changeUserAccount(int userAccount, int piKedCard, int ass){
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
    }

    public static void main(String[] args) {
        twentyOne();
    }
}
