package xyz.iono.craftbench.util;

import java.util.ArrayList;

import static org.bukkit.Chunk.getChunkKey;

public class Region {
  int x;
  int z;

  Region(int x) {
    this.x = x;
    this.z = 0;
  }

  Region(int x, int z) {
    this.x = x;
    this.z = z;
  }

  public int getX() { return this.x; }
  public int getZ() { return this.z; }

  public void setX(int x) { this.x = x; }
  public void setZ(int z) { this.z = z; }

  public ArrayList<int[]> getChunkArray() {
    int baseX = this.x*32;
    int baseZ = this.z*32;
    ArrayList<int[]> chunkArray = new ArrayList<>();

    // Iteratively create array of chunks within that region
    for(int x=baseX; x<baseX+32; x++) {
      for(int z=baseZ; z<baseZ+32; z++) {
        chunkArray.add( new int[]{x, z} );
      }
    }

    return chunkArray;
  }
}
