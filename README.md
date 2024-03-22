# AntiCPVP

This plugin is designed to prevent Crystal PVP. Players will still be able to place crystals, but they can't PVP with them.

```ymal
disable-global-crystal-explosion-damage: true
world-list:
 - world_nether
  - world_the_end
```

If `disable-global-crystal-explosion-damage` is `true` - `world-list` functions as a blacklist, excluding worlds from the global block.
If `disable-global-crystal-explosion-damage` is `false` - `world-list` functions as a whitelist, meaning worlds in the list will have explosions blocked.
