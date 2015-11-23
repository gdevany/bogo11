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
        <h2>Welcome to BOGO by Zip, where you get buy-one get-one stuff near you.</h2>
        <h3 class="flash">${flash}</h3>    
        <form method="POST" action="coupons">
           <c:forEach var="coupon" items="${coupons}">
            <div class="actionbox">
                <div class="headdivide">
                    ${coupon.bizname}<br>
                    ${coupon.bizloc}<br>
                    ${coupon.bogodesc}<br>
                    Max Coupon value: $ ${coupon.couponvalue}<br>
                </div>
                    <span>Coupon expire 7 days after: <fmt:formatDate
                        type="DATE" value="${coupon.coupondate}"/>
                    </span>
            </div>
           </c:forEach> 
        </form>
    </body>
</html>