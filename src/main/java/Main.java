import org.apache.log4j.Logger;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {

        final int NUMBER_OF_OPERATIONS = 7;
        final int HOW_TO_START_WAYS = 2;

        int status;

        Formatter formatter = getMenuFormatter();

        Gift gift = howToContinue(HOW_TO_START_WAYS);

    label: while (true){
            System.out.println(formatter);
            status = getUserInput(NUMBER_OF_OPERATIONS);

            switch (status){
                case 1:System.out.println("Gift's weight is: " + gift.findGiftWeight()/0.01/100 + " gr"); continue;
                case 2:
                    gift = sortWithComp(gift, new Comparators.SweetVolumeComparator());
                    for(SweetInterface sweet: gift.getSweets()){
                        System.out.println(sweet.getVolume());
                    }break ;
                case 3:
                    gift = sortWithComp(gift, new Comparators.SweetSugarWeightComparator());
                    for(SweetInterface sweet: gift.getSweets()){
                        System.out.println(sweet.getVolume());
                    }break ;
                case 4:
                    gift = sortByName(gift);
                    for(SweetInterface sweet: gift.getSweets()){
                        System.out.println(sweet.getName());
                    }break ;
                case 5:
                    gift = sortWithComp(gift, new Comparators.SweetWeightComparator());
                    for(SweetInterface sweet: gift.getSweets()){
                        System.out.println(sweet.getWeight());
                    }break ;
                case 6:

                case 7:
                    break label;
                default:
                    break ;
            }

        }

        serializeGift(gift);
    }

    public static Formatter getMenuFormatter(){
        Formatter formatter = new Formatter();
        formatter.format("1-->Get(find) the gift's weight %n");
        formatter.format("2-->Sort the gift by Volume %n");
        formatter.format("3-->Sort the gift by SugarWeight %n");
        formatter.format("4-->Sort the gift by Name %n");
        formatter.format("5-->Sort the gift by Weight %n");
        formatter.format("6-->Find by parameters %n");
        formatter.format("7-->End(stop) the programme %n");
        logger.info("menuFormatter created");
        return formatter;
    }

    public static Gift howToContinue(int numberOfChoices){
        System.out.println("Input \"1\" If you want to initialise Gift\nInput \"2\" to deserialize the old object");
        int userChoice = getUserInput(numberOfChoices);
        Gift gift;
        if(userChoice == 1){
            gift = getGift();
        }else {
            gift = deserializeGift();
        }
        return gift;
    }

    public static Gift sortByName(Gift gift){
        logger.info("Started sorting");
        List<SweetInterface> sortedByName = gift.getSweets().stream()
                .sorted((e1, e2) -> -e1.getName().compareTo(e2.getName()))
                .collect(Collectors.toList());
        Gift giftSortedByName = new Gift(sortedByName);
        logger.info("Sorted");
        return giftSortedByName;
    }

    public static Gift sortWithComp(Gift gift, Comparator<SweetInterface> sweetComp){
        logger.info("Started sorting");
        List<SweetInterface> sweetsList = gift.getSweets();
        Collections.sort(sweetsList,sweetComp);
        Gift sortedGift = new Gift(sweetsList);
        logger.info("Sorted");
        return sortedGift;
    }

    public static Gift getGift(){

        double weight,sugarCapacity,estimation;
        String name,type;
        String[] sweetInnit;

        Gift gift = new Gift(new LinkedList<>());

        try {
            logger.info("the gift creation started");
            String str = null;
            BufferedReader br = new BufferedReader(new FileReader(getPath(1)));
            while ((str = br.readLine()) != null){
                sweetInnit = str.split(" ");
                type = sweetInnit[0];
                name = sweetInnit[1];
                weight = Double.parseDouble(sweetInnit[2]);
                sugarCapacity = Double.parseDouble(sweetInnit[3]);
                estimation = Double.parseDouble(sweetInnit[4]);

                if (type.equals("Round")){
                    gift.addSweet(new RoundSweet(name,weight,sugarCapacity,estimation));
                }else if (type.equals("Square")){
                    gift.addSweet(new SquareSweet(name,weight,sugarCapacity,estimation));
                }else {
                    logger.warn("unreal sweet type!!!");
                }
            }
            br.close();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        logger.info("the gift was created");

        return gift;
    }

    public static int getUserInput(int max){
        Scanner scanner = new Scanner(System.in);
        int giftNum = -1;
        giftNum = scanner.nextInt();
        while (max < giftNum || giftNum < 0){
            logger.info("User has chosen impossible number in userInput");
            System.out.println("please, write possible choice");
            giftNum = scanner.nextInt();
        }
        logger.info("User gave userInput");
        return giftNum;
    }

    public static void serializeGift(Gift gift){
        try {
            logger.info("The serialization started");
            FileOutputStream outputStream = new FileOutputStream(getPath(2));
            ObjectOutputStream objectOutputStream = null;
            objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(gift);
            logger.info("The serialization finished");
        } catch (IOException e) {
            logger.error("IOException in serializeGift(){}");
            e.printStackTrace();
        }
    }

    public static Gift deserializeGift(){
        Gift gift = null;
        try {
            logger.info("The deserialization started");
            FileInputStream fileInputStream = new FileInputStream(getPath(2));
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            gift = (Gift) objectInputStream.readObject();
            logger.info("The deserialization finished");
        }catch (IOException e){
            logger.error("IOException in deserializeGift(){}");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            logger.error("ClassNotFoundException in deserializeGift(){}");
            e.printStackTrace();
        }
        return gift;
    }

    public static String getPath(int pathNum){
        logger.info("getting the paths");
        ArrayList<String> text = new ArrayList<>();
        try {
            String str = null;
            BufferedReader br = new BufferedReader(new FileReader("paths.txt"));
            while ((str = br.readLine()) != null){
                text.add(str);
            }
            br.close();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        logger.info("paths were gotten. Returning the path by pathNum");
        return text.get(pathNum - 1);
    }
}
