package xyz.iono.craftbench.tests;

import xyz.iono.craftbench.util.RegionManager;

public interface Test {
    // Server Interaction
    void setup(); // Possible Deprecation
    void run(RegionManager regionManager);
    void cleanup();

    // Results Interaction
    boolean isComplete();
    int getStandardisedScore();
    float getRuntimeMs();
    void setRuntimeMs(long runtimeMs);

    void outputVerboseResults();
}

