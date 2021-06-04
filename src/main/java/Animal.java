public class Animal {
    protected String name;
    protected static int counterOfAnimals = 0;

    public Animal(String newName)
    {
        name = newName;
        counterOfAnimals++;
    }

    public void run(int distance) {
        System.out.println(name + " пробежал " + distance + "м.");
    }

    public void swim(int distance) {
        System.out.println(name + " проплыл " + distance + "м.");
    }

    public int getCounterOfAnimals() {
        return counterOfAnimals;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
