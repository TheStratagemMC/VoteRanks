package com.thestratagemmc.voteranks;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by 18AxMoreen on 5/12/2016.
 */
public class SitesDb {

    public static HashMap<String,VotingSite>  siteMap = new HashMap<>();
    public static HashSet<String> sitesOfTheDay = new HashSet<>();

    public static VotingSite getSite(String hostname){
        if (!siteMap.containsKey(hostname)){
            siteMap.put(hostname, null);
            return null;
        }

        return siteMap.get(hostname);
    }

    public static boolean isSiteOfTheDay(String hostName){
        return sitesOfTheDay.contains(hostName);
    }


    public static List<String> save(){
        List<String> out = new ArrayList<>();

        for (VotingSite site : siteMap.values()){
            out.add(site.hostname + " "+site.voteLink);
        }
        return out;
    }

    public static void load(List<String> lines){
        for (String line : lines){
            String[] p = line.split(" ");
            siteMap.put(p[0], new VotingSite(p[0], p[1]));
        }

        ArrayList<Integer> pickedNumbers = new ArrayList<>();
        for (int i = 0; i < Math.min(3, siteMap.size()); i++){
            int pick = ThreadLocalRandom.current().nextInt(siteMap.size());
            while (pickedNumbers.contains(pick)){
                pick = ThreadLocalRandom.current().nextInt(siteMap.size());
            }
            pickedNumbers.add(pick);
        }

        Set<String> keys = siteMap.keySet();
        String[] k = keys.toArray(new String[keys.size()]);
        for (int num : pickedNumbers){
            sitesOfTheDay.add(k[num]);
        }
    }




}
