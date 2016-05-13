package com.thestratagemmc.voteranks;

import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by 18AxMoreen on 5/9/2016.
 */
public class PlayerDb {

    private static BiHashMap<UUID,String> nameMap = new BiHashMap<>();

    public static boolean load(List<String> lines){
        nameMap.clear();

        for (String line : lines){
            String[] p = line.split("///");
            nameMap.put(UUID.fromString(p[0]), p[1]);
        }
        return true;
    }

    public static List<String> save(){
        List<String> list = new ArrayList<>();
        for (Map.Entry<UUID,String> entry : nameMap.getEntries()){
            list.add(entry.getKey().toString() + "///" + entry.getValue());
        }
        return list;
    }

    public static void put(Player player){
        nameMap.put(player.getUniqueId(), player.getName());
    }
    public static UUID getLastWithName(String name){
        return nameMap.getKey(name);
    }

    public static String getLastName(UUID id){
        return nameMap.getValue(id);
    }
}
