package com.yahoo.gamer66790;

import com.yahoo.gamer66790.Commands.*;
import org.bukkit.plugin.java.JavaPlugin;

public class HPCCore extends JavaPlugin{

	@Override
	public void onEnable() {
        saveDefaultConfig();
        registerCommands();
	}


	private void registerCommands() {
        getCommand("heal").setExecutor(new HealCommand(this));
        getCommand("feed").setExecutor(new FeedCommand(this));
        getCommand("poc").setExecutor(new PocCommand(this));
        getCommand("tts").setExecutor(new TTSCommand(this));
        getCommand("skull").setExecutor(new SkullCommand());
        getCommand("killit").setExecutor(new KillitCommand());
        getCommand("tillik").setExecutor(new TillikCommand());
        getCommand("playnice").setExecutor(new PlayniceCommand(this));
        getCommand("playmean").setExecutor(new PlaymeanCommand(this));
        getCommand("hpcreload").setExecutor(new ReloadCommand(this));
        getCommand("locate").setExecutor(new LocateCommand());
        getCommand("echest").setExecutor(new EChestCommand());
    }

}
