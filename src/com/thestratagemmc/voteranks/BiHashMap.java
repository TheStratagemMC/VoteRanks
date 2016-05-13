package com.thestratagemmc.voteranks;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by 18AxMoreen on 5/9/2016.
 */
public class BiHashMap<T1,T2>{
    public HashMap<T1,T2> original;
    public HashMap<T2,T1> reverse;

    public BiHashMap(){
        original = new HashMap<>();
        reverse = new HashMap<>();
    }

    public void put(T1 key, T2 value){
        original.put(key, value);
        reverse.put(value, key);
    }

    public T1 getKey(T2 value){
        if (!reverse.containsKey(value)) return null;
        return reverse.get(value);
    }

    public T2 getValue(T1 key){
        if (!original.containsKey(key)) return null;
        return original.get(key);
    }

    public void clear(){
        original.clear();
        reverse.clear();
    }

    public Set<Map.Entry<T1,T2>> getEntries(){
        return original.entrySet();
    }
}
