public class TestAnimal {
    public static void main(String[] args) {
        Cat catVaska = new Cat("Васька");
        Dog dogBobik = new Dog("Бобик");

        catVaska.run(30);
        dogBobik.run(150);
        catVaska.run(230);
        dogBobik.run(550);

        catVaska.swim(3);
        dogBobik.swim(7);
        dogBobik.swim(15);

        System.out.println("\nБыло создано " + catVaska.getCounterOfAnimals() + " животных");

    }
}
