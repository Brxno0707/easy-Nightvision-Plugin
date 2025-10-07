package de.brxno.nightVisionPlugin;

import org.bukkit.plugin.java.JavaPlugin;

public class NightVisionPlugin extends JavaPlugin {
    @Override
    public void onEnable() {
        getLogger().info("NightVision Plugin is enabled!");

        this.getServer().getCommandMap().register("nv", new NightVisionCommand("nv"));
    }

    @Override
    public void onDisable() {
        getLogger().info("NightVision Plugin is disabled!");
    }
}
