<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<html lang="en">
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="/css/style.css">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>CoffeePot</title>
</head>
<body>
<div class="bg-image"></div>

<div class="bg-text">


    <form action="logout">
        <input type="submit" class="btn btn-danger logoutBtn" value="Logout">
    </form>
    <br>
    <br>
    <br>

    <img src="/images/home-logo.png"  onclick="location.href = 'http://localhost:8080/admin';" alt=""/>

    <h1 style="color: chartreuse">Profit for today: <c:out value='${total}'/> $</h1>


    <div class="flex-menu">
        <c:forEach items="${ordersList}" var="order">
            <div class="p-2 bd-highlight col-example text-center"><div class="card" style="width: 18rem;">
                <div class="card-body">
                    <h5 class="card-title">Id:  <c:out value='${order.id}'/></h5>
                    <p class="card-text">Customer: <c:out value='${order.customer.userName}'/></p>
                    <p class="card-text">Amount: <fmt:formatNumber type="number" maxFractionDigits="2" value="${order.amount}"/> $</p>
                    <p class="card-text">Purchase Date: <c:out value='${order.createDate}'/></p>
                    <p class="card-text">Delivery Method: <c:out value='${order.deliver}'/></p>
                    <p style="color: chartreuse" class="card-text">Profit: <fmt:formatNumber type="number" maxFractionDigits="2" value="${order.amount /10}"/> $</p>
                    <a href="/orders/<c:out value="${order.id}"/>" class="btn btn-warning">Check</a><br><br>
                </div>
            </div></div>
        </c:forEach>
        </div>

</body>
</html>