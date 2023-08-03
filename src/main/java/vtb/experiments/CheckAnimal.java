package vtb.experiments;

public class CheckAnimal {
    public static void main(String[] args) {
        Animal[] animals = new Animal[]{new Dog("Bobik", 150),
                };

        for (Animal animal : animals) {
            animal.run(150);
            animal.getCount();
        }
    }
}
