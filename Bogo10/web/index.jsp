<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>BOGO by Zip</title>
        <link rel="stylesheet" type="text/css" href="styles/indexcss.css"/>
    </head>
    <body>
        <h1>BOGObyZip</h1>
        <h2>Welcome to BOGO by Zip,<br> where you get Buy-One Get-One stuff near you.</h2>
        <h3 class="flash">${flash}</h3>    
        <br><br>
        <form method="POST" action="main">
           <input type="hidden" name="action" value="coupons">
              Enter Zip
              <input type="text" class="textbox" name="userzip"/><br><br>
            <input type="submit" name="submit"/>
        </form>
        <br><br><br><br>
        <div class="actionbox">  
                <a href="main?action=bizaction" style="font-size:60%">  
                    I'm a business
                </a>
        </div>
 </html>