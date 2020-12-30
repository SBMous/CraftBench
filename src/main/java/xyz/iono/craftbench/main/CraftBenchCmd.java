package xyz.iono.craftbench.main;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CraftBenchCmd implements CommandExecutor {

    /*
    Command List:
    /cb | /cb help - help
    /cb q all - adds all tests to the queue
    /cb q <test> - queues a certain test
    /cb run <test> - runs specific test
    /cb run | /cb run q - runs tests in the queue
    /cb run all - runs all tests
     */

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String cmdTxt, String[] args) {
        if (cmdTxt.equalsIgnoreCase("cb")) {
            if (commandSender.isOp()) {

                // Help Msg
                if (args.length == 0 || args[0].equalsIgnoreCase("help")) {
                    //help text
                }

                // Queue Tests
                else if (args[0].equalsIgnoreCase("q")) {
                    if (args[1].equalsIgnoreCase("all")) {
                        // q all
                    }
                    else {
                        // /q test
                    }

                }

                // Run Tests
                else if (args[0].equalsIgnoreCase("run")) {

                }

                // Unrecognised
                else {
                    commandSender.sendMessage("Unrecognised command");
                    return false;
                }

                return true;
            }
            commandSender.sendMessage(ChatColor.DARK_RED + "You do not have access to this command");
        }
        return false;
    }
}
