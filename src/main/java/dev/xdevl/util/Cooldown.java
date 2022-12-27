package dev.xdevl.util;

import dev.xdevl.Main;
import lombok.Getter;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.UUID;

public class Cooldown {

    @Getter
    private int timeRemaining;

    public Cooldown(UUID uuid, int cooldownTime) {
        Main plugin = Main.getPlugin(Main.class);
        timeRemaining = cooldownTime;

        BukkitRunnable task = new BukkitRunnable() {
            @Override
            public void run() {
                timeRemaining--;
                if (timeRemaining == 0) {
                    plugin.cooldowns.remove(uuid);
                    cancel();
                }
            }
        };
        task.runTaskTimerAsynchronously(plugin, 5, 20);
    }
}