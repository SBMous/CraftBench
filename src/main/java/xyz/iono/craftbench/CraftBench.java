package xyz.iono.craftbench;

import org.bukkit.command.Command;
import org.bukkit.plugin.java.JavaPlugin;
//import xyz.iono.craftbench.tests.ExTest;
import xyz.iono.craftbench.command.CraftBenchCmd;
import xyz.iono.craftbench.tests.ChunkLoadingTest;
import xyz.iono.craftbench.tests.Test;
import xyz.iono.craftbench.tests.TestDispatch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class CraftBench extends JavaPlugin {
  private TestDispatch testDispatch;
  private Map<String, Command> commands;
  public static Map<String, Test> tests; // Maps test alias to test
  public static ArrayList<Test> testQ; // Holds queued tests
  public static List<Integer> testResults; // Holds test results after tests have run

  @Override
  public void onEnable() {
    // get Command
    //this.getCommand("cb").setExecutor(new CraftBenchCmd(this));

    this.testDispatch = new TestDispatch();
    // Load tests *Invalid test names: test, q*
    tests = new HashMap<>();
    //tests.put("ExTest", new ExTest());

    // Make testQ
    testQ = new ArrayList<>();
    testQ.add(new ChunkLoadingTest());
    this.testDispatch.exec(testQ);
  }

  @Override
  public void onDisable() {
    // Plugin shutdown logic
  }

  // Move command handling into a map (As seen in chunky config)
//  @Override
//  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
//    if (args.length > 0 && commands.containsKey(args[0].toLowerCase())) {
//      commands.get(args[0].toLowerCase()).execute(sender, args);
//    } else {
//      commands.get("help").execute(sender, new String[]{});
//    }
//    return true;
//  }
}
