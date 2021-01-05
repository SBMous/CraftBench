package xyz.iono.craftbench.util;

import org.bukkit.Bukkit;
import org.bukkit.World;

import java.util.ArrayList;

public class RegionManager {
  private Region currentRegion;
  private ArrayList<Region> usedRegions;
  private World world;

  public RegionManager() {
    this.currentRegion = new Region(6);
    this.usedRegions =  new ArrayList<>();
    this.world = Bukkit.getServer().getWorlds().get(0);
  }

  public Region getRegion() {
    return this.currentRegion;
  }

  public ArrayList<int[]> getChunks() {
    return this.currentRegion.getChunkArray();
  }

  public void nextRegion() {
    this.usedRegions.add(this.currentRegion);
    int nextRegionX = this.currentRegion.getX()+1;
    this.currentRegion = new Region(nextRegionX);
  }

  public World getWorld() { return this.world; }
}
