package xyz.iono.craftbench.main;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CraftBenchCmd implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String cmdTxt, String[] strings) {
        if (cmdTxt.equalsIgnoreCase("cb")) {
            commandSender.sendMessage("Nice");
            return true;
        }
        return false;
    }
}
