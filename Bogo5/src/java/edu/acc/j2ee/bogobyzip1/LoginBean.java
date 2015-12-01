package edu.acc.j2ee.bogobyzip1;

public class LoginBean implements java.io.Serializable {
    public String userName;
    public String password;


    public LoginBean(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }    
}
