package edu.acc.j2ee.bogobyzip1;

import java.util.Date;

public class CouponBean implements java.io.Serializable {
    private String bizName;
    private String bogoDesc;
    private String couponValue;
    public Date couponDate;
    private String zip1;
    private String zip2;
    private String zip3;
    private int userId;
    private String bizLoc;
    
    public CouponBean(String bizName, String bogoDesc, String bizLoc, 
            String couponValue, String zip1, String zip2, String zip3, Date couponDate) {
        this.bizName = bizName;
        this.bogoDesc = bogoDesc;
        this.couponValue = couponValue;
        this.bizLoc = bizLoc;
 //       this.couponDate = couponDate;
        this.zip1 = zip1;
        this.zip2 = zip2;
        this.zip3 = zip3;
    }
 /*   
    public CouponBean(String bizName, String bogoDesc, String bizLoc,
            String couponValue, String zip) {
        
    }
*/
    public CouponBean() {}

    public String getBizName() {
        return bizName;
    }

    public void setBizName(String bizName) {
        this.bizName = bizName;
    }

    public String getBogoDesc() {
        return bogoDesc;
    }

    public void setBogoDesc(String bogoDesc) {
        this.bogoDesc = bogoDesc;
    }

    public Date getCouponDate() {
        return couponDate;
    }

    public void setCouponDate(Date couponDate) {
        this.couponDate = couponDate;
    }

    public String getCouponValue() {
        return couponValue;
    }

    public void setCouponValue(String couponValue) {
        this.couponValue = couponValue;
    }

    public String getZip1() {
        return zip1;
    }

    public void setZip1(String zip1) {
        this.zip1 = zip1;
    }

    public String getZip2() {
        return zip2;
    }

    public void setZip2(String zip2) {
        this.zip2 = zip2;
    }

    public String getZip3() {
        return zip3;
    }

    public void setZip3(String zip3) {
        this.zip3 = zip3;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getBizLoc() {
        return bizLoc;
    }

    public void setBizLoc(String bizLoc) {
        this.bizLoc = bizLoc;
    }
}
