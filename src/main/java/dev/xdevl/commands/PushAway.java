package dev.xdevl.commands;


import dev.xdevl.Main;
import dev.xdevl.util.ItemUtil;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PushAway implements CommandExecutor {
    private final Main plugin;

    public PushAway(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        final String giveMsg = plugin.getConfig().getString("Messages.Given-Wand");
        String giveOtherMsg = plugin.getConfig().getString("Messages.Give-Other-Wand");
        switch(args.length) {
            case 1:
                if(args[0].toLowerCase().startsWith("r")) {
                    if(!sender.hasPermission("pushaway.reload")) {
                        sender.sendMessage(ItemUtil.format(plugin.getConfig().getString("Messages.Permission")));
                        return true;
                    }
                    plugin.reloadConfig();
                    plugin.wand = ItemUtil.getWand();
                    sender.sendMessage(ItemUtil.format("&7Push&cAway &areloaded..."));
                    return true;
                }
                if(args[0].toLowerCase().startsWith("g")) {
                    if(!sender.hasPermission("pushaway.givewand")) {
                        sender.sendMessage(ItemUtil.format(plugin.getConfig().getString("Messages.Permission")));
                        return true;
                    }
                    if(sender instanceof Player) {
                        Player p = (Player) sender;
                        p.getInventory().addItem(plugin.wand);
                        p.sendMessage(ItemUtil.format(giveMsg));
                        return true;
                    }

                    sender.sendMessage(ItemUtil.format("&cYou must be a player to use this command!"));
                    return true;
                }
                return true;
            case 2:
                if(!args[0].toLowerCase().startsWith("g")) {
                    sender.sendMessage("&cUnkown command! &eTry /pushaway for help.");
                    return true;
                }
                if(!sender.hasPermission("pushaway.givewand.others")) {
                    sender.sendMessage(ItemUtil.format(plugin.getConfig().getString("Messages.Permission")));
                    return true;
                }
                Player target = Bukkit.getPlayerExact(args[1]);
                if(target == null) {
                    sender.sendMessage("&c" + args[1] + " &7is currently offline.");
                    return true;
                }
                target.getInventory().addItem(plugin.wand);
                target.sendMessage(ItemUtil.format(giveMsg));
                sender.sendMessage(ItemUtil.format(giveOtherMsg.replaceAll("%player%", target.getName())));
                return true;
            default:
                if(sender.hasPermission("pushaway.use")) {
                    sender.sendMessage(ItemUtil.format("&8&m         [ &ePushAway &8]&m         "));
                    sender.sendMessage(ItemUtil.format("&e/pushaway &8- &7Shows this page. Aliases &8[&7pa, pusha, paway&8]"));
                    if(sender.hasPermission("pushaway.reload"))
                        sender.sendMessage(ItemUtil.format("&e/pushaway reload &8- &7Reloads the plugin."));
                    if(sender.hasPermission("pushaway.givewand")) {
                        sender.sendMessage(ItemUtil.format("&e/pushaway give &8- &7Gives you a wand."));
                    }
                    if(sender.hasPermission("pushaway.givewand.others")) {
                        sender.sendMessage(ItemUtil.format("&e/pushaway give <player> &8- &7Gives the player a wand."));
                    }
                    return true;
                }
                sender.sendMessage(ItemUtil.format(plugin.getConfig().getString("Messages.Permission")));
                return true;
        }
    }
}