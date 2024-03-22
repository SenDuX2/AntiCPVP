package me.savag3.anti.crystal;

import me.savag3.anti.crystal.configurate.ConfigLoader;
import net.md_5.bungee.api.chat.TranslatableComponentDeserializer;
import org.bukkit.plugin.java.JavaPlugin;

public class AntiCrystalPVP extends JavaPlugin {
  private Config conf;
  
  public Config getConf() {
    return this.conf;
  }
  
  public void onEnable() {
    try {
      new TranslatableComponentDeserializer(this);
    } catch (Exception exception) {}
    getLogger().info("Attempting to enable AntiCrystalPVP...");
    getDataFolder().mkdirs();
    this.conf = (Config)ConfigLoader.load(getDataFolder().toPath().resolve("config.yml"), Config.class);
    new CrystalExplosionHandler(this);
    getLogger().info("AntiCrystalPVP has been enabled!");
  }
  
  public void onDisable() {
    getLogger().info("AntiCrystalPVP has been disabled!");
  }
}


/* Location:              C:\Users\jonas\Desktop\AntiCPVP-1.0.jar!\me\savag3\anti\crystal\AntiCrystalPVP.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */