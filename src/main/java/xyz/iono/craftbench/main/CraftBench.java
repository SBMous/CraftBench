package xyz.iono.craftbench.main;

import org.bukkit.plugin.java.JavaPlugin;

public final class CraftBench extends JavaPlugin {

  @Override
  public void onEnable() {

    // get Command
    getCommand("cb").setExecutor(new CraftBenchCmd());

  }

  @Override
  public void onDisable() {
    // Plugin shutdown logic
  }
}
