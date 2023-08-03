package vtb.experiments;

public class Pet extends Animal {

    static int count = 0;

    public Pet(String name, int runAbility) {
        super(name, runAbility);
        count++;
    }

    @Override
    void getCount() {
        System.out.println(count);
    }
}
