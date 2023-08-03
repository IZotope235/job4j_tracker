package vtb.experiments;

public class Animal {
    private String name;
    private int runAbility;
    private static int count = 0;

    public Animal(String name, int runAbility) {
        this.name = name;
        this.runAbility = runAbility;

        count++;
    }

    void run(int length) {
        if (length > runAbility) {
            System.out.println(this.name + " can't run so far");
        }
        if (length > 0 && length <= runAbility) {
            System.out.println(this.name + " run " + length);
        }
    }

    void getCount() {
        System.out.println(count);
    }

    @Override
    public String toString() {
        return "Animal{"
                + "name='" + name + '\''
                + ", runAbility=" + runAbility
                + '}';

    }
}


