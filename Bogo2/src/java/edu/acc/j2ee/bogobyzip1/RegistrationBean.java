package edu.acc.j2ee.bogobyzip1;

public class RegistrationBean implements java.io.Serializable {
    public String userName;
    public String password1;
    public String password2;
    public String firstName;
    public String lastName;
    public String email;
    public String bizip;
    public String bizName;

    public RegistrationBean() {}
    
    public RegistrationBean(String un, String p1, String p2, String fn,
            String ln, String e, String z, String bn) {
        userName = un;
        password1 = p1;
        password2 = p2;
        firstName = fn;
        lastName = ln;
        email = e;
        bizip = z;
        bizName = bn;
    }
    
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBizip() {
        return bizip;
    }

    public void setBizip(String bizip) {
        this.bizip = bizip;
    }

    public String getBizName() {
        return bizName;
    }

    public void setBizName(String bizName) {
        this.bizName = bizName;
    }

}
