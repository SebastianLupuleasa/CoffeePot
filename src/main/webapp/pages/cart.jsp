<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html lang="en">
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="/css/style.css">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>CoffeePot</title>
    <script
  src="https://code.jquery.com/jquery-2.2.4.js"
  integrity="sha256-iT6Q9iMJYuQiMWNd9lDyBUStIq/8PuOW33aOqmvFpqI="
  crossorigin="anonymous"></script>

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

    <img src="/images/home-logo.png" onclick="location.href = 'https://endava-coffeepot.herokuapp.com';" alt=""/>
   
    <button type="button"  class="btn btn-danger emptyCart">Empty Cart</button>
    <button type="button"  <c:if test="${total <= 0}"> disabled </c:if> onclick="let deliver=call(); location.href = 'https://endava-coffeepot.herokuapp.com/checkout/${total}/'+deliver;" class="btn btn-success makePurchase">Make Purchase</button>
     <h1>Total: <fmt:formatNumber type="number" maxFractionDigits="2" value="${total}"/> $</h1>

    <div class="flex-menu">
        <c:forEach items="${coffeeList}" var="coffee">
            <div class="p-2 bd-highlight col-example text-center"><div class="card" style="width: 18rem;">
                <img class="card-img-top" src="<c:out value='${coffee.imagePath}'/>" width="150px" height="150px" alt="Menu">
                <div class="card-body">
                    <h5 class="card-title">Name: <c:out value="${coffee.name}"/></h5>

                    <p class="card-text">Quantity: <c:out value="${coffee.amount}"/></p>
                    <p class="card-text">Total: <c:out value="${coffee.amount}"/> x <fmt:formatNumber type="number" maxFractionDigits="2" value="${coffee.price}"/> $ =  <fmt:formatNumber type="number" maxFractionDigits="2" value="${coffee.price * coffee.amount}"/>  $</p>

                    <button id="btnADD" onclick="coffeeSUB('<c:out value="${coffee.name}"/>')" class="btn btn-warning">-</button>
                    <input id='<c:out value="${coffee.name}"/>' type="text" style="width: 60px; height: 40px; text-align: center;" value="1">
                    <button id="btnSUB" onclick="coffeeADD('<c:out value="${coffee.name}"/>')" class="btn btn-warning">+</button><br><br>
                    <button value='<c:out value="${coffee.name}"/>' class="btn btn-danger removeBtn">Remove</button>
                </div>
            </div></div>
        </c:forEach>
    </div></div>


  </div>
<script src="/javascript/cart.js"></script>
</body></html>

