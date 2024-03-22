package me.savag3.anti.crystal;

import java.util.Arrays;
import java.util.List;
import org.spongepowered.configurate.objectmapping.ConfigSerializable;

@ConfigSerializable
public class Config {
  private boolean disableGlobalCrystalExplosionDamage = true;
  
  public boolean isDisableGlobalCrystalExplosionDamage() {
    return this.disableGlobalCrystalExplosionDamage;
  }
  
  private List<String> worldList = Arrays.asList(new String[] { "world_nether", "world_the_end" });
  
  public List<String> getWorldList() {
    return this.worldList;
  }
}


/* Location:              C:\Users\jonas\Desktop\AntiCPVP-1.0.jar!\me\savag3\anti\crystal\Config.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */