package lld.resource_manager;

public class Config {
    int cpu;
    int ram;
    Performance cpuPerformance;
    enum Performance{HIGH, MEDIUM, LOW}

    Config(int cpu, int ram, Performance cpuPerformance) {
        this.cpu = cpu;
        this.ram = ram;
        this.cpuPerformance = cpuPerformance;
    }

    @Override
    public String toString() {
        String performance = cpuPerformance == Performance.HIGH ? "HIGH"
                                : cpuPerformance == Performance.MEDIUM ? "MEDIUM"
                                : "LOW";
        return String.format("(%d, %d, %s)", cpu, ram, performance);
    }
}
