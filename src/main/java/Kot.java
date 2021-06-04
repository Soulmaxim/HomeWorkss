public class Kot {

    private String name;
    private int appetite;
    private boolean satiety;
    private long lastMealTime;

    public boolean isSatiety() {
        checkSatiety();
        return satiety;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAppetite() {
        return appetite;
    }

    public void setAppetite(int appetite) {
        this.appetite = appetite;
    }

    public Kot(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.satiety = true;
    }

    private void checkSatiety() {
        long currentTime = System.currentTimeMillis();
        int timeToSatiety = (int)(Math.random() * 2000.0) + 4000;
        if (currentTime - lastMealTime > timeToSatiety) satiety = true;
    }

    public void eat(Plate p) {
        checkSatiety();
        try {
            if (satiety) {
                if (p.decreaseFood(appetite)) {
                    satiety = false;
                    lastMealTime = System.currentTimeMillis();
                }
            }
            else {
                throw new Exception("Cat is full");
            }
        }
        catch (Exception ex) {
            System.out.println(ex);
        }

    }
}
