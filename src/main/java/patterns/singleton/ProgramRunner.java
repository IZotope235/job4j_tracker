package patterns.singleton;

public class ProgramRunner {
    public static void main(String[] args) {
        System.out.println(ProgramLogger.getProgramLogger().toString());
        ProgramLogger.getProgramLogger().addLogInfo("First log...");
        ProgramLogger.getProgramLogger().showLogFile();
    }
}
