package edu.acc.j2ee.bogobyzip1;

public class User implements java.io.Serializable {
    private String userName;
//    private Profile profile;
    private int userId;
    
    public User(String userName) {
        this.userName = userName;
    }

    public User() {}
    
    public String getUserName() {
        return userName;
    }
    
 //   public Profile getProfile() {
 //       return profile;
 //   }
    
    public int getUserId() {
        return userId;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
 //   public void setProfile(Profile profile) {
 //       this.profile = profile;
 //   }
    
    public void setUserId(int userId) {
        this.userId = userId;
    }
    
    @Override
    public String toString() {
        return userName;
    }
}
