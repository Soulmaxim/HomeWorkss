public class MainClass {
    public static void main(String[] args) {
        Kot[] cat = new Kot[5];
        cat[0] = new Kot("Barsik", 7);
        cat[1] = new Kot("Vaska", 5);
        cat[2] = new Kot("Murka", 2);
        cat[3] = new Kot("Persik", 13);
        cat[4] = new Kot("Tishka", 9);
        Plate plate = new Plate(26);

        System.out.println("В тарелке было " + plate.getFood() + " еды");
        for (int i = 0; i < cat.length; i++) {
            cat[i].eat(plate);
            System.out.print("Кот " + cat[i].getName());
            if (!cat[i].isSatiety()) System.out.println(" сыт");
            else System.out.println(" остался голоден");
            System.out.println("В тарелке осталось " + plate.getFood() + " еды\n");
        }

        plate.addFood(10);
        System.out.println("В тарелке теперь " + plate.getFood() + " еды");
        for (int i = 0; i <cat.length; i++) {
            if (cat[i].isSatiety()) {
                cat[i].eat(plate);
                System.out.print("Кот " + cat[i].getName());
                if (!cat[i].isSatiety()) System.out.println(" теперь сыт");
                else System.out.println(" всё ещё голоден");
                System.out.println("В тарелке осталось " + plate.getFood() + " еды\n");
            }
        }

        System.out.println("Ждём 5 секунд ...");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < cat.length; i++) {
            System.out.print("Кот " + cat[i].getName());
            if (cat[i].isSatiety()) System.out.println(" снова голоден");
            else System.out.println(" ещё не голоден");
        }

    }
}
