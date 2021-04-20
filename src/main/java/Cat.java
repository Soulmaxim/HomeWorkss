public class Cat extends Animal{
    public Cat(String newName) {
        super(newName);
    }

    @Override
    public void run(int distance) {
        if (distance <= 200) super.run(distance);
        else System.out.println(name + " пробежал 200м и устал. " + distance + "м это слишком много.");
    }

    @Override
    public void swim(int distance) {
        System.out.println(name + " не умеет плавать.");
    }
}
