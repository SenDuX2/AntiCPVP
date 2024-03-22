package me.savag3.anti.crystal;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.plugin.Plugin;

public class CrystalExplosionHandler implements Listener {
  private final AntiCrystalPVP plugin;
  
  public CrystalExplosionHandler(AntiCrystalPVP plugin) {
    this.plugin = plugin;
    plugin.getServer().getPluginManager().registerEvents(this, (Plugin)plugin);
  }
  
  @EventHandler
  public void handlePlayerDamage(EntityDamageByEntityEvent e) {
    if (e.getCause() == EntityDamageEvent.DamageCause.ENTITY_EXPLOSION && 
      e.getDamager().getType() == EntityType.ENDER_CRYSTAL && 
      e.getEntity() instanceof org.bukkit.entity.Player) {
      String worldName = e.getEntity().getWorld().getName();
      if (this.plugin.getConf().isDisableGlobalCrystalExplosionDamage()) {
        if (this.plugin.getConf().getWorldList().contains(worldName))
          return; 
      } else if (!this.plugin.getConf().getWorldList().contains(worldName)) {
        return;
      } 
      e.setCancelled(true);
    } 
  }
}


/* Location:              C:\Users\jonas\Desktop\AntiCPVP-1.0.jar!\me\savag3\anti\crystal\CrystalExplosionHandler.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */