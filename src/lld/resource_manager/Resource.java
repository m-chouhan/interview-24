package lld.resource_manager;

public class Resource {
    int id;
    Config config;
    float price;
    Status status;
    public boolean isFree() {
        return status == Status.FREE;
    }
    ResourceManager resourceManager;
    enum Status {FREE, BUSY};

    Resource(int id, Config config, float price, ResourceManager resourceManager) {
        status = Status.FREE;
        this.price = price;
        this.id = id;
        this.config = config;
        this.resourceManager = resourceManager;
    }

    int getCpu() { return this.config.cpu; }
    float getPrice() { return this.price; }

    synchronized void execute(Task task) throws InterruptedException {
        status = Status.BUSY;
        float sleepMultiplier = (float) task.minConfig.cpu / config.cpu;
        java.lang.System.out.printf("Executing %s%n", task.name);
        Thread.sleep((long) (2000 * sleepMultiplier));
        status = Status.FREE;
        resourceManager.notifyCompletion(this, task);
    }

    @Override
    public String toString() {
        return String.format("(resource id : %d, config : %s, price : %f, status : %s)",
                id, config, price, status.name());
    }
}
