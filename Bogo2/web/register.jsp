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
        <h2>BOGO registration page</h2>
        <h3 class="flash">${flash}</h3><br><br>
        <form method="POST" action="main">
            <input type="hidden" name="action" value="register"/>
            <table id="formtable">
                <tr><td>Choose a USERNAME:</td><td><input value="${bean.userName}" 
                type="text" name="user" placeholder="4 to 12 characters."/></td></tr>
                <tr><td>Choose a PASSWORD:</td><td><input type="password" 
                name="pass1" placeholder="6 to 15 characters."></td></tr>
                <tr><td>Re-type Password:</td><td><input type="password" 
                name="pass2" placeholder="retype password"/></td></tr>
                <tr><td>First Name:</td><td><input value="${bean.firstName}" 
                type="text" name="fname"/></td></tr>
                <tr><td>Last Name:</td><td><input value="${bean.lastName}" 
                type="text" name="lname"/></td></tr>
                <tr><td>Email Address:</td><td><input value="${bean.email}" 
                type="email" name="email"/></td></tr>
                <tr><td>Zip Code:</td><td><input value="${bean.zipCode}" 
                type="text" name="bizip" placeholder="5 digit format"/></td></tr>
                <tr><td colspan="2"><input type="submit" value="Register"/></td></tr>
            </table>
        </form>
        <br><br>
        <div class="actionbox">  
            <a href="main?action=bizaction" style="font-size:60%">
                Take me back
            </a>
        </div>
        <div class="actionbox">
            <a href="main?action=login" style="font-size:60%">
                 Login
            </a>
        </div>
    </body>
</html>
