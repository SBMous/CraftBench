package xyz.iono.craftbench.tests;

public interface Test {
    // Server Interaction
    void setup();
    void run();
    void cleanup();

    // Results Interaction
    boolean isComplete();
    int getStandardisedScore();
    int getRuntimeMs();

    // void getResults(); // Needs return type
    int getTestId();
}

