<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>BOGO by Zip</title>
        <link rel="stylesheet" type="text/css" href="styles/formatcss.css"/>
    </head>
    <body>
        <h1>BOGObyZip</h1>
        <h2>Thanks for choosing BOGO by Zip to post your coupon</h2>
        <h3 class="flash">${flash}</h3>
        <form method="POST" action="main">
            <input type="hidden" name="action" value="postCoupon"/>
            <table id="formtable">
                <tr><td>Business name:</td><td><input  
                type="text" name="bizName" placeholder="Max 40 characters."/></td></tr>
                <tr><td>BOGO description:</td><td><input  
                type="text" name="bogoDesc" placeholder="Max 40 characters."></td></tr>
                <tr><td>Address of participating location:</td><td><input
                type="text" name="bizLoc" placeholder="Max 60 characters"/></td></tr>
                <tr><td>Max value: $</td><td><input  
                type="text" name="couponValue" placeholder="max $ amount"/></td></tr>
                <tr><td>ZipCode1:</td><td><input  
                type="text" name="zip1" placeholder="Zipcode"/></td></tr>
                <tr><td>ZipCode2:</td><td><input  
                type="text" name="zip2" placeholder="optional"/></td></tr>
                <tr><td>ZipCode3:</td><td><input  
                type="text" name="zip3" placeholder="optional"/></td></tr>
                <tr><td colspan="2"><input type="submit" value="Post Your Coupon"/></td></tr>
            </table>
        </form>
        <br><br>
        <div class="actionbox">  
            <a href="main?action=bizaction" style="font-size:60%">
                Take me back
            </a>
        </div>
        <br><br><br>    
    </body>    
</html>
