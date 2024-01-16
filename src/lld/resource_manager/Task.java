package lld.resource_manager;

public class Task {

    private static int idCounter = 0;

    int id;
    Config minConfig;
    String name;

    private Task() {}

    public static Task createTask(String name, Config minConfig) {
        Task task = new Task();
        task.id = ++idCounter;
        task.name = name;
        task.minConfig = minConfig;
        return task;
    }

    @Override
    public String toString() {
        return String.format("{name : %s, id : %d, }", name, id);
    }
}
