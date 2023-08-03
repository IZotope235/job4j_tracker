package patterns.strategy;

public class Relax implements Activity {
    @Override
    public void justDoIt() {
        System.out.println("I am Relax...");
    }
}
