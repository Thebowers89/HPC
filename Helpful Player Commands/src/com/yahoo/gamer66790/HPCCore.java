package com.yahoo.gamer66790;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class HPCCore extends JavaPlugin{
	
	@Override
	public void onEnable() {
		getCommand("heal").setExecutor(new HealCommand(this));
		getCommand("feed").setExecutor(new FeedCommand(this));
		getCommand("poc").setExecutor(new PocCommand(this));
		getCommand("tts").setExecutor(new TTSCommand(this));
		getCommand("skull").setExecutor(new SkullCommand());
		getCommand("killit").setExecutor(new KillitCommand());
		getCommand("tillik").setExecutor(new TillikCommand());
		getCommand("playnice").setExecutor(new PlayniceCommand(this));
		getCommand("playmean").setExecutor(new PlaymeanCommand());
		
		final FileConfiguration config = this.getConfig();
		
		config.addDefault("Command.Cooldown-time", 5);
		config.addDefault("Serverwide.pvp.disable", "PVP is disabled");
		
		config.options().copyDefaults(true);
		
		saveConfig();
	}
	
	@Override
	public void onDisable() {
		
	}
	
}