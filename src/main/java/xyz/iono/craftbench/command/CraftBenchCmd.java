package xyz.iono.craftbench.command;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.jetbrains.annotations.NotNull;
import xyz.iono.craftbench.CraftBench;

public class CraftBenchCmd implements CommandExecutor {
    protected final CraftBench craftBench;

    public CraftBenchCmd(CraftBench craftBench) { this.craftBench = craftBench; }
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
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String cmdTxt, @NotNull String[] args) {
        if (commandSender instanceof ConsoleCommandSender) {
            if (cmdTxt.equalsIgnoreCase("cb")) {
                // Help Msg
                if (args.length == 0 || args[0].equalsIgnoreCase("help")) {
                    // 2 Edit
                    sendMsg(commandSender, "&3----- &bCraftBench Help &3-----");
                    sendMsg(commandSender, "&e/cb &7- &fshows help message");
                    return true;
                }

                // Queue Tests
                else if (args[0].equalsIgnoreCase("q")) {
                    if (args.length == 1) {
                        commandSender.sendMessage(ChatColor.RED + "No arguments for q command provided\n"+
                                "Usage: /cb q <test name>\n"+
                                "Or:    /cb q all\n"+
                                "For more detail see /cb help");
                        return false;
                    }
                    else if (args[1].equalsIgnoreCase("all")) {
                        return qAllTests(); // queues all tests
                    }
                    else {
                        // Searches for test then queues test if found else sends error message
                        return qTest(args[1], commandSender);
                    }

                }

                // Run Tests
                else if (args[0].equalsIgnoreCase("run")) {

                    //Run all
                    if (args.length >= 2 && args[1].equalsIgnoreCase("all")) {

                        // Queues all tests to be run
                        if (!qAllTests()) {
                            return false;
                        }
                    }

                    // Run Specified (logic - if the command is not to run the queue then run specified)
                    else if (!(args.length == 1 || args[1].equalsIgnoreCase("q"))) {

                        // If test exists then clear queue and add specified test
                        if (CraftBench.tests.containsKey(args[1])) {
                            CraftBench.tests.clear();
                            qTest(args[1], commandSender);
                        }
                        else {
                            commandSender.sendMessage(ChatColor.RED + "Invalid test name '"+args[1]+"'");
                            return false;
                        }
                    }

                    // Run queue
                    //CraftBench.testQ.forEach(test -> CraftBench.testResults.add(test.runTest()));

                }

                // Unrecognised Command
                else {
                    commandSender.sendMessage(ChatColor.RED + "Unrecognised command");
                    return false;
                }
            }
        } else {
            commandSender.sendMessage(ChatColor.DARK_RED + "You do not have access to this command");
        }
        return false;
    }

    // Queues all tests in map
    public static boolean qAllTests() {
        CraftBench.testQ.clear();
        CraftBench.tests.forEach((key, value) -> CraftBench.testQ.add(value));
        return true;
    }

    // Queues test (true) or returns false
    public static boolean qTest(String alias, CommandSender commandSender) {
        // Searches for test then queues test if found
        if (CraftBench.tests.containsKey(alias)) {
            CraftBench.testQ.add(CraftBench.tests.get(alias));
            return true;
        }
        else {
            commandSender.sendMessage(ChatColor.RED + "Invalid test name '"+alias+"'");
            return false;
        }
    }

    public static void sendMsg(CommandSender sender, String message) {
        Bukkit.getLogger().info(ChatColor.translateAlternateColorCodes('&', message));
    }


}
