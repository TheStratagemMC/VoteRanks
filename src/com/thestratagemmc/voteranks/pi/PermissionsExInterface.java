package com.thestratagemmc.voteranks.pi;

import com.thestratagemmc.voteranks.PermissionsInterface;

import java.util.List;
import java.util.UUID;

/**
 * Created by 18AxMoreen on 5/13/2016.
 */
public class PermissionsExInterface implements PermissionsInterface {
    @Override
    public String getCurrentGroup(UUID id) {
        return null;
    }

    @Override
    public List<String> getGroupNames() {
        return null;
    }
}
