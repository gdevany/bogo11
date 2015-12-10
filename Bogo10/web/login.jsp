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
        <h2>BOGO LOGIN page</h2>
        <h3 class="flash">${flash}</h3><br><br> 
        <form method="POST" action="main">
            <input type="hidden" name="action" value="login"/>
            <table id="formtable">
                <tr><td>User Name:</td><td>
                    <input type="text" name="user" class="textbox3"/></td></tr>
                <tr><td>Password:</td><td>
                    <input type="password" name="pass" class="textbox3"/></td></tr>
                <tr><td colspan="2"><input type="submit" value="Login"
                /></td></tr>
            </table>
        </form>
        <br><br>
        <div class="actionbox">  
            <a href="main?action=bizaction" style="font-size:60%">
                Take me back
            </a>
        </div>&nbsp;
        <div class="actionbox">
            <a href="main?action=register" style="font-size:60%">
                 Register
            </a>
        </div>
    </body>
</html>
