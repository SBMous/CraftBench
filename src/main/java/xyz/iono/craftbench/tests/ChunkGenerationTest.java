package xyz.iono.craftbench.tests;

import xyz.iono.craftbench.util.RegionManager;

public class ChunkGenerationTest implements Test {
  long runtimeMs;
  long[] tickTimes;

  public ChunkGenerationTest() {

  }

  @Override
  public void setup() {
    // No setup required assuming world is blank aside from normal spawn chunk gen
  }

  @Override
  public void run(RegionManager regionManager) {

  }

  @Override
  public void cleanup() {

  }

  @Override
  public boolean isComplete() {
    return false;
  }

  @Override
  public int getStandardisedScore() {
    return 0;
  }

  @Override
  public float getRuntimeMs() {
    return this.runtimeMs;
  }

  @Override
  public void setRuntimeMs(long runtimeMs) { this.runtimeMs = runtimeMs; }

  @Override
  public void outputVerboseResults() {

  }
}
