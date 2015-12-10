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
        <h2>BOGO PAYMENT page</h2>
        <h3 class="flash">${flash}</h3>    
        <br>
        <p>This page is not functional and payment will not really be accepted.</p>
        <p>All coupons are free to post until further notice.</p>
        <form method="POST" action="main">
           <input type="hidden" name="action" value="usersCoupons">
              Enter Credit Card Info<br><br>
              <input type="text" class="textbox" name="payment"/><br>
              Information will not be used.
        </form>
        <br><br>
        <div class="actionbox">  
                <a href="main?action=deleteCoupon" style="font-size:60%">  
                    I do not want to pay
                </a>
        </div>
        
        
 <!--       
        <form method="POST" action="main">
            <input type="hidden" name="action" value="userzip">
            <p>Enter Zip</p>
            <p>
            <input type="text"/>
        </form>    
            <div class="actionbox">  
                <a href="main?action=bizaction" style="font-size:60%">  
                    I'm a business and would like to post a coupon
                </a>
            </div>
    </body>
-->
 </html>