package edu.acc.j2ee.bogobyzip1;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringEscapeUtils;

public class BogoController extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null)
            if (request.getMethod().equals("GET"))
                action = "index";
            else action = "index";
        switch (action) {
            case "index": action = index(request); break;
            case "coupons": action = coupons(request); break;
            case "bizinfo": action = bizinfo(request); break;
            case "bizaction": action = bizaction(request); break;
            case "login": action = login(request); break;
            case "postCoupon": action = postCoupon(request); break;
            case "register": action = register(request); break;
 //           case "upload": action = uploadImage(request); break;
 //           defaut: action = "index";
        }
        request.getRequestDispatcher(action + ".jsp").forward(request, response);
    }
    
    
    private String bizinfo(HttpServletRequest request) {
        return "bizinfo";
    }
    
    private String bizaction(HttpServletRequest request) {
        if (request.getMethod().equals("GET")) return "bizaction";
        return "bizaction";
    }
    
    private String index(HttpServletRequest request) {
         if (request.getMethod().equals("GET")) return "index";      
        return "coupons";
    }

    private String coupons(HttpServletRequest request) {
        String zip = request.getParameter("userzip");
        if (!zip.matches("^\\d{5}?$")) {
            request.setAttribute("flash", "Invalid zipcode");
        } else {
            BogoDAO db = (BogoDAO) getServletContext().getAttribute("db");
            List<CouponBean> coupons = db.getSortedCouponsFor(zip);
            if (db.getLastError() != null)
                request.setAttribute("flash", db.getLastError());
            request.setAttribute("zip", zip);
            request.setAttribute("coupons", coupons);
        }
        return "coupons";
    }
    
    private String login(HttpServletRequest request) {
        if (request.getMethod().equals("GET")) return "login";
        String userName = request.getParameter("user");
        String password = request.getParameter("pass");
        LoginBean bean = new LoginBean(userName, password);
        if (LoginValidator.validate(bean)) {
            BogoDAO db = (BogoDAO) getServletContext().getAttribute("db");
            User user = db.authenticate(userName, password);
            if (user == null) {
                String error = db.getLastError();
                request.setAttribute("flash", (error == null? "Access Denied" : error));
                return "login";
            } else {
                request.getSession().setAttribute("user", user);
                return postCoupon(request);
            }
        }   else {
            request.setAttribute("flash", "Invalid Username or Password");
            return "login";
        }
    }
    
    private String postCoupon(HttpServletRequest request) {
        if (request.getMethod().equals("GET")) return "postCoupon";
        String bizName = request.getParameter("bizName");
        String bogoDesc = request.getParameter("bogoDesc");
        String bizLoc = request.getParameter("bizLoc");
        String couponValue = request.getParameter("couponValue");
//        Date couponDate = request.getParameter("couponDate");
        String zip1 = request.getParameter("zip1");
        String zip2 = request.getParameter("zip2");
        String zip3 = request.getParameter("zip3");
        
        if (bizName == null || bizName.length() < 1 || bizName.length() > 40) {
            request.setAttribute(
                    "flash", "Content must be between 1-40 characters.");
            request.setAttribute(
                    "bizName", bizName);
            return "postCoupon";
        }
        if (bogoDesc == null || bogoDesc.length() < 1 || 
                bogoDesc.length() > 40) {
            request.setAttribute(
                    "flash", "Content must be between 1-40 characters.");
            request.setAttribute(
                    "bogoDesc", bogoDesc);
            return "postCoupon";
        }
        if (bizLoc == null || bizLoc.length() < 1 || bizLoc.length() > 60) {
            request.setAttribute(
                    "flash", "Content must be between 1-60 characters.");
            request.setAttribute(
                    "bizLoc", bizLoc);
            return "postCoupon";
        }
        if (!zip1.matches("^\\d{5}?$")) {
            request.setAttribute("flash", "Zipcode must be XXXXX or XXXXX-XXXX format");
            request.setAttribute("zip1", zip1);
            return "postCoupon";
        }
        if (!zip2.matches("^\\d{5}?$") 
                || !zip3.matches("^\\d{5}?$")) {
            if (zip2.length() == 0 && zip3.length() == 0)
                return "postCoupon";
            else request.setAttribute("flash", "Zipcode must be XXXXX format "
                    + "or can be left blank");
            request.setAttribute("zip2", zip2);
            request.setAttribute("zip3", zip3);
            return "postCoupon";
        }
        if (couponValue == null || couponValue.length() < 1 || couponValue.length() > 10) {
            request.setAttribute("flash", "Value must be between 1-10 characters.");
            request.setAttribute("couponValue", couponValue);
            return "postCoupon";
        }
        bizName = StringEscapeUtils.escapeHtml4(bizName);
        bizName = bizName.replace("'", "&#39;");
        bogoDesc = StringEscapeUtils.escapeHtml4(bogoDesc);
        bogoDesc = bogoDesc.replace("'", "&#39;");
        bizLoc = StringEscapeUtils.escapeHtml4(bizLoc);
        bizLoc = bizLoc.replace("'", "&#39;");
        BogoDAO db = (BogoDAO) this.getServletContext().getAttribute("db");
        db.addCoupon(bizName, bogoDesc, bizLoc, couponValue, zip1, zip2, zip3);
        if (db.getLastError() != null) {
            request.setAttribute("flash", db.getLastError());
            return "postCoupon";
        }
        return "tyForPosting";
    }

    private String logout(HttpServletRequest request) {;
        request.getSession().invalidate();
        return index(request);
    }
    
    private String register(HttpServletRequest request) {
        if (request.getMethod().equals("GET")) return "register";
            String un = request.getParameter("user");
            String p1 = request.getParameter("pass1");
            String p2 = request.getParameter("pass2");
            String fn = request.getParameter("fname");
            String ln = request.getParameter("lname");
            String em = request.getParameter("email");
            String z = request.getParameter("zip");
            String bn = request.getParameter("bname");
            String bz = request.getParameter("bizip");
            RegistrationBean bean = new RegistrationBean(un,p1,p2,fn,ln,em,z,bn);
            if (!RegistrationValidator.isValid(bean)) {
                request.setAttribute("flash", "One or more fields are invalid");
                request.setAttribute("bean", bean);
                return "register";
            }
            BogoDAO db = (BogoDAO)getServletContext().getAttribute("db");
            int id = db.register(bean);
            if (db.getLastError() != null) {
                request.setAttribute("flash", db.getLastError());
                request.setAttribute("bean", bean);
                return "register";
            }
            User user = db.getUserById(id);
            request.setAttribute("bean", bean);
            return login(request);
    }
/*    
    private String uploadImage(HttpServletRequest request) {
        if(request.getMethod().equals("GET")) return "upload";
        try {
            final Part filePart = request.getPart("pic");
            String filename = filePart.getSubmittedFileName();
            String filetype = filePart.getContentType();
            if (!filetype.contains("image")) {
                request.setAttribute("flash", db.getLastError());
                return "upload";
        }
        InputStream data = filePart.getInputStream();
        User user = (User)request.getSession().getAttribute("user");
        BogoDAO db = (BogoDAO)getServletContext().getAttribute("db");
        db.updateImage(user.getUserId(), filetype, data);
        if (db.getLastError() != null) {
            request.setAttribute("flash", db.getLastError());
            return "upload";
        }
        //
        } catch (IOException | ServletException e) {
            request.setAttribute("flash", e.getMessage());
        }
        return "upload";
    }
*/
 // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

