package dev.xdevl;

import dev.xdevl.commands.PushAway;
import dev.xdevl.events.PushEvent;
import dev.xdevl.util.Cooldown;
import dev.xdevl.util.ItemUtil;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.UUID;


public final class Main extends JavaPlugin {

    public ItemStack wand;
    public HashMap<UUID, Cooldown> cooldowns = new HashMap<>();

    @Override
    public void onEnable() {
        saveDefaultConfig();
        getCommand("pushaway").setExecutor(new PushAway(this));
        getServer().getPluginManager().registerEvents(new PushEvent(this), this);
        wand = ItemUtil.getWand();
    }

}
