package xyz.iono.craftbench.tests;

import xyz.iono.craftbench.util.RegionManager;

import java.util.ArrayList;

public class TestDispatch {
  private final RegionManager regionManager = new RegionManager(); // Holds the region manager for tests

  public ArrayList<Test> exec(ArrayList<Test> tests) {
    for (Test test:tests) {
      test.run(this.regionManager);
      // test.outputVerboseResults();
    }
    return tests;
  }
}
