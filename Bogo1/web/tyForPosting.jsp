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
        <h2>BOGObyZip INFO page</h2>
        <h3 class="flash">${flash}</h3>
        <br><br><br>
        <p> </p>
    <div class="actionbox">
                <a href="main?action=index" style="font-size:100%">
                    Thank you for posting.  Goodbye (click here)
                </a>
    </div>
    </body>    
</html>