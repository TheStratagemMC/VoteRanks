package com.thestratagemmc.voteranks;

import java.util.List;
import java.util.UUID;

/**
 * Created by 18AxMoreen on 5/9/2016.
 */
public interface PermissionsInterface {
    public String getCurrentGroup(UUID id);
    public List<String> getGroupNames();
}
