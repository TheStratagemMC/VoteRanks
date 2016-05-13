package com.thestratagemmc.voteranks;

import java.util.*;

/**
 * Created by 18AxMoreen on 5/9/2016.
 */
public class VoteDb {
    private static HashMap<UUID,Integer> voteMap = new HashMap<>();

    public static int getVotes(UUID id){
        if (voteMap.containsKey(id)) return voteMap.get(id);
        return 0;
    }

    public static void addVote(UUID id){
        voteMap.put(id, getVotes(id)+1);
    }

    public static List<String> save(){
        List<String> list = new ArrayList<>();
        for (Map.Entry<UUID,Integer> entry : voteMap.entrySet()){
            list.add(entry.getKey().toString()+"///"+entry.getValue().toString());
        }
        return list;
    }

    public static boolean load(List<String> lines){
        voteMap.clear();
        for (String line : lines){
            String[] p = line.split("///");
            UUID id = UUID.fromString(p[0]);
            int votes = Integer.valueOf(p[1]);
            voteMap.put(id, votes);
        }
        return true;
    }
}
