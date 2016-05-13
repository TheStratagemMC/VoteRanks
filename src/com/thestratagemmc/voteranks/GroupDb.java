package com.thestratagemmc.voteranks;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;

/**
 * Created by 18AxMoreen on 5/9/2016.
 */
public class GroupDb {
//make VGroup class, compare vgroups instead of dynamically guessing
    private static HashMap<UUID,VGroup> currentPlayerGroups = new HashMap<>();
    private static HashMap<String,VGroup> globalGroups = new HashMap<>();

    public static VGroup updateGroup(UUID player){
        VGroup group = getVGroup(player);
        if (group == null) group = new VGroup("default", 0);

        int votes = VoteDb.getVotes(player);
        for (VGroup vgroup : globalGroups.values()){
            if (vgroup.getVotesRequired() > group.getVotesRequired() && votes > vgroup.getVotesRequired()){
                group = vgroup;
            }
        }

        currentPlayerGroups.put(player, group);
        return group;
    }
    @Deprecated
    public static VGroup getVGroup(UUID player){
        if (currentPlayerGroups.containsKey(player)) return currentPlayerGroups.get(player);
        return null;
    }

    public static VGroup getGroup(UUID player){
        if (currentPlayerGroups.containsKey(player)) return currentPlayerGroups.get(player);
        return updateGroup(player);
    }

    public static void loadGroups(List<String> lines){
        globalGroups.clear();
        for (String line : lines){
            String[] p = line.split(" ");
            String group = p[0];
            int amount = Integer.valueOf(p[1]);
            globalGroups.put(group, new VGroup(group, amount));
        }
    }

    public static VGroup getGroup(String name){
        if (!globalGroups.containsKey(name)) return null;
        return globalGroups.get(name);
    }
}
