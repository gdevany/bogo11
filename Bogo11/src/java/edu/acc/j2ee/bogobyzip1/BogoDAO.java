package edu.acc.j2ee.bogobyzip1;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BogoDAO {
    private String lastError;
    
    private Connection CONN;
    
    public BogoDAO(String jdbcUrl) {
        try {
            CONN = DriverManager.getConnection(jdbcUrl);
            lastError = null;
        } catch (SQLException sqle) {
            System.out.println("****** can't get connection " + jdbcUrl);
            lastError = sqle.getMessage();
        }
    }
    
    public String getLastError() { return lastError;}
    
    protected void addCoupon(Coupons coupon) {
        String sql = 
                "INSERT INTO JAVAUSER.COUPONS "
                + "(bizName, bogoDesc, bizLoc, postersId, couponValue, zip1, zip2, zip3) "
                + "VALUES (?,?,?,?,?,?,?,?)";
        PreparedStatement pstat = null;
        try {
            pstat = CONN.prepareStatement(sql);
            pstat.setString(1, coupon.getBizName());
            pstat.setString(2, coupon.getBogoDesc());
            pstat.setString(3, coupon.getBizLoc());
            pstat.setInt(4, coupon.getUserId());
//            pstat.setInt(4, 1);
            pstat.setString(5, coupon.getCouponValue());
//            pstat.setDate(6, new java.sql.Date(coupon.getCouponDate().getTime()));
            pstat.setString(6, coupon.getZip1());
            pstat.setString(7, coupon.getZip2());
            pstat.setString(8, coupon.getZip3());
            pstat.executeUpdate();
        } catch (SQLException sqle) {
            lastError = sqle.getMessage();
        } finally {
            if (pstat != null)
                try {
                    pstat.close();
                } catch (SQLException sqle) {}
        }
    }
    
    public void addCoupon(String bizName, String bogoDesc, String bizLoc,
            String couponValue, String zip1, String zip2, 
            String zip3, int userId) {
        Coupons coupon = new Coupons(
            bizName,bogoDesc,bizLoc,couponValue,zip1,zip2,zip3,userId,new Date());
        addCoupon(coupon);
    }
    
    public List<Coupons> getSortedCoupons() {
        return getSortedCouponsFor("%");
    }
    
    public List<Coupons> getSortedCouponsFor(String zip) {
        String zipchosen = zip;
        List<Coupons> couponList = new ArrayList<>();
        String sql = "SELECT * FROM Coupons ";
        sql += "WHERE (zip1 LIKE '%s' OR zip2 LIKE '%s' OR zip3 LIKE '%s') "
                + "ORDER BY coupondate ASC";
        sql = String.format(sql, zipchosen, zipchosen, zipchosen);
        Statement stat = null;
        ResultSet rs = null;
        try {
            stat = CONN.createStatement();
            rs = stat.executeQuery(sql);
            while (rs.next()) {
                Coupons c = new Coupons(
                    rs.getString("bizName"),
                    rs.getString("bogoDesc"),
                    rs.getString("bizLoc"),
                    rs.getString("couponValue"),                   
                    rs.getString("zip1"),
                    rs.getString("zip2"),
                    rs.getString("zip3"),
 //                   rs.getInt("userId"),
                    new Date(rs.getDate("couponDate").getTime())
                );        
                couponList.add(c);
            }
            lastError = null;
        } catch (SQLException sqle) {
            lastError = sqle.getMessage();
        } finally {
            if (rs != null)
                try {
                    rs.close();
                } catch (SQLException sqle) {}
            if (stat != null)
                try {
                    stat.close();
                } catch (SQLException sqle) {}
        }
        return couponList;
    }
    
    public List<Coupons> getSortedCouponsFor(int userId) {
        int userOn = userId;
        List<Coupons> couponList = new ArrayList<>();
        String sql = "SELECT * FROM Coupons ";
        sql += "WHERE postersid =" + userOn + " ORDER BY coupondate ASC";
        Statement stat = null;
        ResultSet rs = null;
        try {
            stat = CONN.createStatement();
            rs = stat.executeQuery(sql);
            while (rs.next()) {
                Coupons c = new Coupons(
                    rs.getString("bizName"),
                    rs.getString("bogoDesc"),
                    rs.getString("bizLoc"),
                    rs.getString("couponValue"),                   
                    rs.getString("zip1"),
                    rs.getString("zip2"),
                    rs.getString("zip3"),
                    new Date(rs.getDate("couponDate").getTime())
                );        
                couponList.add(c);
            }
            lastError = null;
        } catch (SQLException sqle) {
            lastError = sqle.getMessage();
        } finally {
            if (rs != null)
                try {
                    rs.close();
                } catch (SQLException sqle) {}
            if (stat != null)
                try {
                    stat.close();
                } catch (SQLException sqle) {}
        }
        return couponList;
    }  
    
    public void deleteCoupon(int userId) {
        String sql = "SELECT * FROM Coupons WHERE postersid = " + userId;
        Statement stat = null;
        ResultSet rs = null;
        try {
            stat = CONN.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, 
                    ResultSet.CONCUR_UPDATABLE);
            rs = stat.executeQuery(sql);
            rs.last();
            rs.deleteRow();
            lastError = null;
        } catch (SQLException sqle) {
            lastError = sqle.getMessage();
            System.out.println(lastError);
        } finally {
            if (rs != null)
                try {
                    rs.close();
                } catch (SQLException sqle) {}
            if (stat != null)
                try {
                    stat.close();
                } catch (SQLException sqle) {}
        }
    }  
  
    public User getUserById(int id) {
        String sql = "SELECT * JAVAUSER.USERS WHERE id = " + id;
        Statement stat = null;
        ResultSet rs = null;
        User user = null;
        try {
            stat = CONN.createStatement();
            rs = stat.executeQuery(sql);
            if (rs.next()) {
                user = new User(rs.getString("username"));
                user.setUserId(rs.getInt("id"));
            }
            lastError = null;
        } catch (SQLException sqle) {
            lastError = sqle.getMessage();
        } finally {
            if (rs != null)
                try {
                    rs.close();
                } catch (SQLException sqle) {}
            if (stat != null)
                try {
                    stat.close();
                } catch (SQLException sqle) {}
        }
        return user;
    }
    
    public User authenticate(String userName, String password) {
        User user = null;
        String sql = "SELECT * FROM JAVAUSER.USERS WHERE username = '%s' AND password = '%s'";
        sql = String.format(sql, userName, password);
        Statement stat = null;
        ResultSet rs = null;
        try {
            stat = CONN.createStatement();
            rs = stat.executeQuery(sql);
            if (rs.next()) {
                user = new User(rs.getString("username"));
                user.setUserId(rs.getInt("id"));
 //               user.setProfile(getProfileFor(user.getUserId()));
            }
            lastError = null;
        } catch (SQLException sqle) {
            lastError = sqle.getMessage();
        } finally {
            if (rs != null)
                try {
                    rs.close();
                } catch (SQLException sqle) {}
            if (stat != null)
                try {
                    stat.close();
                } catch (SQLException sqle) {}
        }
        return user;
    }
    
    public int register(RegistrationBean bean) {
        String sql = "INSERT INTO JAVAUSER.USERS "
                + "(username, password, firstname, lastname, email, bizname) "
                + "VALUES (?,?,?,?,?,?)";
        PreparedStatement pstat = null;
        ResultSet userRs = null;
        int id = 0;
        try {
            pstat = CONN.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstat.setString(1, bean.getUserName());
            pstat.setString(2, bean.getPassword1());
            pstat.setString(3, bean.getFirstName());
            pstat.setString(4, bean.getLastName());
            pstat.setString(5, bean.getEmail());
            pstat.setString(6, bean.getBizName());
            pstat.executeUpdate();
            lastError = null;
        } catch (SQLException sqle) {
            lastError = sqle.getMessage();
        } finally {
            if (userRs != null)
                try { userRs.close(); } catch (SQLException sqle) {}
            if (pstat != null)
                try { pstat.close(); } catch (SQLException sqle) {}
        }
    return id;
    }
    
    public void close() {
        if(CONN != null)
            try {
                CONN.close();
            } catch (SQLException sqle) {}
    }
}
