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
        <h2>Your coupons</h2>
        <h3 class="flash">${flash}</h3>    
        <form method="POST" action="coupons">
           <c:forEach var="coupon" items="${coupons}">
            <div class="actionbox">
                <div class="businessname">
                    ${coupon.bizName}
                </div><br>
                BUY ONE.......${coupon.bogoDesc}.......GET ONE FREE<br><br>
                    ${coupon.bizLoc}
                    <br>
                    <span class="footer">
                        Max Coupon value: $ ${coupon.couponValue}&nbsp;&nbsp;&nbsp;
                        Coupon posted on: <fmt:formatDate
                        type="DATE" value="${coupon.couponDate}"/>
                    </span>
            </div><br>
           </c:forEach>
            <br>
        </form>    
            <div class="actionboxleft">
                <a href="main?action=bizaction" style="font-size:100%">
                    Take me back
                </a>
            </div>
    </body>
</html>