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
        <h2>BOGObyZip business selection page</h2>
        <h3 class="flash">${flash}</h3>    
        <form method="POST" action="main">
            <br><br>
            <div class="actionbox">
                <a href="main?action=bizinfo" style="font-size:100%">
                    I need to see more information
                </a>
            </div><br><br><br>
            <div class="actionbox">
                <a href="main?action=register" style="font-size:100%">
                    I need to register
                </a>
            </div><br><br><br>
            <div class="actionbox">
                <a href="main?action=login" style="font-size:100%">
                    Take me to the sign in page
                </a>
            </div>
        </form>
    </body>
</html>
