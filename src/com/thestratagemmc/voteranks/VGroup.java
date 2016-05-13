package com.thestratagemmc.voteranks;

/**
 * Created by 18AxMoreen on 5/12/2016.
 */
public class VGroup {
    String name;
    int votesRequired;

    public VGroup(String name, int votesRequired) {
        this.name = name;
        this.votesRequired = votesRequired;
    }

    public int getVotesRequired() {
        return votesRequired;
    }

    public String getName() {
        return name;
    }
}
