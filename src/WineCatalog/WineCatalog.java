package WineCatalog;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class WineCatalog {

    public static class Wine {

        private String name;
        private String country;
        private Calendar cloggingDate;

        public Wine(String name,String country, int year, int month, int day) {
            this.cloggingDate = new GregorianCalendar(year,month,day);
            this.name = name;
            this.country = country;
        }

        public String getName(){
            return this.name;
        }
        public void setName(String name){
            this.name = name;
        }
        public String getCountry(){
            return this.country;
        }
        public void setCountry(String country){
            this.country = country;
        }
        public Calendar getCloggingDate(){
            return this.cloggingDate;
        }
        public void setCloggingDate(Calendar cloggingDate){
            this.cloggingDate = cloggingDate;
        }

        public int yearOfExp (){
            Calendar currentDate = Calendar.getInstance();
            currentDate.roll(Calendar.DAY_OF_MONTH,-cloggingDate.get(Calendar.DAY_OF_MONTH));
            currentDate.roll(Calendar.MONTH,-cloggingDate.get(Calendar.MONTH));
            currentDate.roll(Calendar.YEAR,-cloggingDate.get(Calendar.YEAR));
            return currentDate.get(Calendar.YEAR);
        }

    }

    public static void main(String[] args) {
        ArrayList<Wine> wineCatalog = new ArrayList();

        wineCatalog.add(new Wine("Dr. Loosen","Germany",2008,5,20));
        wineCatalog.add(new Wine("Amarone","Italy",2006,6,1));
        wineCatalog.add(new Wine("Greppone Mazzi","Italy",2003,0,11));
        wineCatalog.add(new Wine("Pomerol","France",2005,11,2));

        Wine wine;

        System.out.printf("%-15s %-10s %-10s%n","Wine:","Country:","Year of exposure:");

        for (int i = 0; i < wineCatalog.size(); i++){
            wine = wineCatalog.get(i);
            System.out.printf("%-15s %-10s %-10d%n",wine.getName(),wine.getCountry(),wineCatalog.get(i).yearOfExp());
        }
    }
}
