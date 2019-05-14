package za.ac.cput.Domain.Tour;

public class Group {
    private int no;
    private String groupName;
    private int members;

    public Group() {
    }

    private Group(Builder builder) {
        this.no = no;
        this.groupName = groupName;
        this.members = members;
    }

    public int getNo() {
        return no;
    }

    public String getGroupName() {
        return groupName;
    }

    public int getMembers() {
        return members;
    }
    public static class Builder{
        private int no;
        private String groupName;
        private int members;

        public Builder no(int no){
            this.no = no;
            return this;
        }
        public Builder groupName(String groupName){
            this.groupName = groupName;
            return this;
        }
        public Builder members(int members){
            this.members = members;
            return this;
        }
        public Group build() {
            return new Group(this);
        }
    }
}
