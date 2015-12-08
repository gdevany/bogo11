<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>BOGO by Zip</title>
        <link rel="stylesheet" type="text/css" href="styles/couponcss.css"/>
    </head>
    <body>
        <h1>BOGObyZip</h1>
        <h2>Coupon posting review</h2>
        <h3 class="flash">${flash}</h3>
        <br><br><br>
        <p> </p>
      <form>   
        <div class="actionbox">
            <div class="businessname">
                ${coupon.bizName}
            </div><br>
                BUY ONE.......${coupon.bogoDesc}.......GET ONE FREE<br><br>
                ${coupon.bizLoc}<br>
            <span class="footer">
                Max Coupon value: $ ${coupon.couponValue}&nbsp;&nbsp;&nbsp;
                Coupon posted on: <fmt:formatDate
                type="DATE" value="${coupon.couponDate}"/>
            </span>
        </div><br>   
     
        <div class="actionboxleft">
            <a href="main?action=payment" style="font-size:100%">
                PERFECT.  LET'S PAY FOR IT.
            </a>
        </div>
        <div class="actionboxright">
            <a href="main?action=deleteCoupon" style="font-size:100%">
                Let me start over.
            </a>
        </div>
      </form>
    </body>    
</html>