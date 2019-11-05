package WineCatalog;

public class WineCatalog {

    public static class Cat {

        public String name;
        public int age;
        public int weight;

        public Cat(String name, int age, int weight) {
            this.name = name;
            this.age = age;
            this.weight = weight;
        }

        public Cat() {
        }

        public void sayMeow() {
            System.out.println("Мяу!");
        }
    }

    public static void main(String[] args) {
        Cat cat = new Cat("Vasia",12,12);
        cat.sayMeow();
    }
}
