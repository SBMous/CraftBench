package xyz.iono.craftbench.main;

import org.bukkit.plugin.java.JavaPlugin;
import xyz.iono.craftbench.tests.ExTest;
import xyz.iono.craftbench.tests.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class CraftBench extends JavaPlugin {

  public static Map<String, Test> tests; // Maps test alias to test
  public static List<Test> testQ; // Holds queued tests
  public static List<Integer> testResults; // Holds test results after tests have run

  @Override
  public void onEnable() {

    // get Command
    getCommand("cb").setExecutor(new CraftBenchCmd());

    // Load tests *Invalid test names: test, q*
    tests = new HashMap<>();
    tests.put("ExTest", new ExTest());

    // Make testQ
    testQ = new ArrayList<>();

  }

  @Override
  public void onDisable() {
    // Plugin shutdown logic
  }
}
