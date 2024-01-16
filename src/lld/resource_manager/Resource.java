package lld.resource_manager;

public class Resource {
    int id;
    Config config;
    float price;
    Status status;
    enum Status {FREE, BUSY};

    Resource(int id, Config config, float price) {
        status = Status.FREE;
        this.price = price;
        this.id = id;
        this.config = config;
    }

    ResourceManager rm;
    synchronized void execute(Task task) throws InterruptedException {
        status = Status.BUSY;
        float sleepMultiplier = (float) task.minConfig.cpu / config.cpu;
        Thread.sleep((long) (2000 * sleepMultiplier));
        status = Status.FREE;
        rm.notifyCompletion(this, task);
    }
}
