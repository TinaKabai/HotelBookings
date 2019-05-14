package za.ac.cput.Factory;

import za.ac.cput.Domain.Tour.Groups;

public class GroupsFactory {

    public static Groups groups(String gName, int noGroups, int members){
        return new Groups.Builder().groupName(gName).noGroups(noGroups).members(members).build();
    }
}
