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



    <br>
    <br>
    <br>

    <img src="/images/home-logo.png"  onclick="location.href = 'https://endava-coffeepot.herokuapp.com';" alt=""/>


    <div class="flex-menu">
        <div class="container-sm">
       Id: ${order.id}<br>
       Amount: <fmt:formatNumber type="number" maxFractionDigits="2" value="${order.amount}"/>  $<br>
       Purchase Date: ${order.createDate}<br>
       Address: Strada: ${address.streetName}, Numarul: ${address.buildingNumber}<br>
       Deliver Mehod: ${order.deliver}<br>
        <c:forEach items="${order.coffees}" var="coffee">
            <c:forEach items="${ingredients}" var="ingredient">
                       <p class="card-text"> <c:out value="${coffee.amount}"/> x <c:out value="${ingredient}"/> = <fmt:formatNumber type="number" maxFractionDigits="2" value="${coffee.amount * coffee.price}"/> $ </p>
            </c:forEach>
            </c:forEach>
        </div>
    </div>
</div>
</body>
</html>