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
    
    protected void addCoupon(CouponBean coupon) {
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
            String zip3, Integer userId) {
        CouponBean coupon = new CouponBean(
            bizName,bogoDesc,bizLoc,couponValue,zip1,zip2,zip3,userId,new Date());
    //    post.setAuthor(user);
        addCoupon(coupon);
    }
    
    public List<CouponBean> getSortedCoupons() {
        return getSortedCouponsFor("%");
    }
    
    public List<CouponBean> getSortedCouponsFor(String zip) {
        String zipchosen = zip;
        List<CouponBean> couponList = new ArrayList<>();
        String sql = "SELECT * FROM Coupons ";
        sql += "WHERE (zip1 LIKE '%s' OR zip2 LIKE '%s' OR zip3 LIKE '%s') "
                + "ORDER BY coupondate DESC";
        sql = String.format(sql, zipchosen, zipchosen, zipchosen);
        Statement stat = null;
        ResultSet rs = null;
        try {
            stat = CONN.createStatement();
            rs = stat.executeQuery(sql);
            while (rs.next()) {
                CouponBean c = new CouponBean(
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
    
  public List<CouponBean> getSortedCouponsFor(int userId) {
        int userOn = userId;
        List<CouponBean> couponList = new ArrayList<>();
        String sql = "SELECT * FROM Coupons ";
        sql += "WHERE postersid =" + userOn + " ORDER BY coupondate DESC";
//        sql = String.format(sql, userOn);
        Statement stat = null;
        ResultSet rs = null;
        try {
            stat = CONN.createStatement();
            rs = stat.executeQuery(sql);
            while (rs.next()) {
                CouponBean c = new CouponBean(
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
        String userSql = "INSERT INTO JAVAUSER.USERS "
                + "(username, password, firstname, lastname, email, bizname) "
                + "VALUES (?,?,?,?,?,?)";
        PreparedStatement pstatUser = null;
        ResultSet userRs = null;
        int id = 0;
        try {
            pstatUser = CONN.prepareStatement(userSql, Statement.RETURN_GENERATED_KEYS);
            pstatUser.setString(1, bean.getUserName());
            pstatUser.setString(2, bean.getPassword1());
            pstatUser.setString(3, bean.getFirstName());
            pstatUser.setString(4, bean.getLastName());
            pstatUser.setString(5, bean.getEmail());
            pstatUser.setString(6, bean.getBizName());
            pstatUser.executeUpdate();
            lastError = null;
        } catch (SQLException sqle) {
            lastError = sqle.getMessage();
        } finally {
            if (userRs != null)
                try { userRs.close(); } catch (SQLException sqle) {}
            if (pstatUser != null)
                try { pstatUser.close(); } catch (SQLException sqle) {}
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
