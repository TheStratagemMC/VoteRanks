package com.thestratagemmc.voteranks;

import com.vexsoftware.votifier.model.VotifierEvent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * Created by 18AxMoreen on 5/9/2016.
 */
public class VRListener implements Listener {

    @EventHandler
    public void join(PlayerJoinEvent event){
        PlayerDb.put(event.getPlayer());
    }

    @EventHandler
    public void vote(VotifierEvent event){
        VotingSite site = SitesDb.getSite(event.getVote().getServiceName());
        Player player = Bukkit.getPlayer(event.getVote().getUsername());
        if (player == null) return;
        if (site == null){
            player.sendMessage(ChatColor.RED + "Site is not registered in our database, sorry. Please report this to an administrator.");
            return;
        }
        if (!SitesDb.isSiteOfTheDay(site.hostname)){
            player.sendMessage(ChatColor.YELLOW + "Thanks for voting, unfortunately, that site is not one of today's sites. We cycle through the voting websites every day. Please use one of the links from /vote.");
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pay "+player.getName()+ " 1000");
            return;
        }

        VoteDb.addVote(player.getUniqueId());
    }
}
