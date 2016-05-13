package com.thestratagemmc.voteranks;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

/**
 * Created by 18AxMoreen on 5/9/2016.
 */
public class VotesCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (args.length == 0 && !(sender instanceof Player)){
            sender.sendMessage("Please specify a name to lookup votes.");
            return true;
        }
        String name = null;
        UUID lookup = null;
        if (args.length == 0){
            Player player = (Player)sender;
            lookup = player.getUniqueId();
            name = player.getName();
        }
        else if (args.length > 0){
            name = args[0];
            lookup = PlayerDb.getLastWithName(args[0]);
            if (lookup == null){
                sender.sendMessage(ChatColor.RED+"Sorry, could not find history of player "+args[0]+".");
                return true;
            }
        }

        sender.sendMessage(ChatColor.BLUE + "Player "+name+ " has "+ChatColor.AQUA.toString() + VoteDb.getVotes(lookup) +  " votes.");
        sender.sendMessage(ChatColor.GREEN + " Current achieved rank of "+name + ": "+ChatColor.GOLD + GroupDb.getGroup(lookup).getName());
        return true;
    }
}
