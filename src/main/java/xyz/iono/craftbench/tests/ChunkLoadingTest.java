package xyz.iono.craftbench.tests;

import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.World;
import xyz.iono.craftbench.util.RegionManager;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

public class ChunkLoadingTest implements Test {
  float runtimeMs;
  long[] tickTimes;
  boolean complete;

  public ChunkLoadingTest() {
    this.runtimeMs = -1;
    this.complete = false;
//    this.tickTimes = new long[] {1};
  }

  @Override
  public void setup() {
    // Blank
  }

  @Override
  public void run(RegionManager regionManager) {
    ArrayList<int[]> chunks = regionManager.getChunks();
    World world = regionManager.getWorld();
    ArrayList<CompletableFuture<Chunk>> chunkLoadTasks = new ArrayList<>();

    long startTime = System.nanoTime();
    for(int[] chunk:chunks) {
      chunkLoadTasks.add(world.getChunkAtAsync(chunk[0], chunk[1])
              .thenApply(data -> {
                // Bukkit.getLogger().info("Chunk x" + data.getX() + ", y" + data.getZ() + "Loaded");
                return data;
              })
      );
    }
    CompletableFuture<Void> allChunksLoaded = CompletableFuture.allOf(chunkLoadTasks.toArray(new CompletableFuture[0]));
    allChunksLoaded.thenApply(data -> {
      long endTime = System.nanoTime();
      Bukkit.getLogger().info("Chunks Loaded");
      this.tickTimes = Bukkit.getTickTimes();
      this.runtimeMs = (float)(endTime - startTime) / 1000000;
      this.outputVerboseResults();
      return data;
    });
  }

  @Override
  public void cleanup() {
    // Include Forced Unload Logic
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
    Bukkit.getLogger().info("ChunkLoadTestResults");
    for(long tickTime:this.tickTimes) {
      Bukkit.getLogger().info("Tick Time: " + (float)(tickTime / 1000000) + "ms");
    }
    Bukkit.getLogger().info("Total Time: " + this.runtimeMs + "ms");
  }
}
