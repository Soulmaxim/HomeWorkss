public class Dog extends Animal {
    public Dog(String newName) {
        super(newName);
    }

    @Override
    public void run(int distance) {
        if (distance <= 500) super.run(distance);
        else System.out.println(name + " пробежал 500м и устал. " + distance + "м это слишком много.");
    }

    @Override
    public void swim(int distance) {
        if (distance <= 10) super.swim(distance);
        else {
            System.out.println(name + " проплыл 5м и поплыл обратно. Всего проплыл 10м. " + distance + "м это слишком много.");
        }
    }
}
