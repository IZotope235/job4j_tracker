package vtb.experiments;

public class Dog extends Pet {
    static int count = 0;

    public Dog(String name, int runAbility) {
        super(name, runAbility);
        count++;
    }

    @Override
    void getCount() {
        System.out.println(count);
    }

}
