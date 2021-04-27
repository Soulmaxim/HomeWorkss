public class Plate {

    private int food;

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public Plate(int food) {
        this.food = food;
    }

    public void info() {
        System.out.println("Food amount: " + food);
    }

    public void addFood(int newFood) {
        food += newFood;
    }

    public boolean decreaseFood(int amount) {
        try {
            if (food - amount >= 0) {
                food -= amount;
                return true;
            }
            else throw new Exception("Low on food in plate");
        }
        catch (Exception ex) {
            System.out.println(ex);
            return false;
        }
    }

}
