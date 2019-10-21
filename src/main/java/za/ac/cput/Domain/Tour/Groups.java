package za.ac.cput.Domain.Tour;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Groups {

    @Id
    private String groupName;
    private int noOfGroups;
    private int members;

    public Groups() {
    }

    private Groups(Builder builder){
        this.groupName = builder.groupName;
        this.noOfGroups = builder.noOfGroups;
        this.members = builder.members;
    }
    public String getGroupName() {
        return groupName;
    }

    public int getNoOfGroups() {
        return noOfGroups;
    }

    public int getMembers() {
        return members;
    }
    public static class Builder{
        private String groupName;
        private int noOfGroups;
        private int members;

        public Builder groupName(String groupName){
            this.groupName = groupName;
            return this;
        }
        public Builder noGroups(int noOfGroups){
            this.noOfGroups = noOfGroups;
            return this;
        }
        public Builder members(int members){
            this.members = members;
            return this;
        }
        public Groups build() {
            return new Groups(this);
        }

        public Builder copy(Groups groups) {
            this.groupName = groups.groupName;
            this.noOfGroups = groups.noOfGroups;
            this.members = groups.members;

            return this;
        }
    }
}
