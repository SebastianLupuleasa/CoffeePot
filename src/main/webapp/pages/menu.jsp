<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html lang="en">
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="css/style.css">
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

    <img src="images/home-logo.png"  onclick="location.href = 'http://localhost:8080';" alt=""/>

    <div class="flex-menu">
 <c:forEach items="${coffeeList}" var="coffee">
          <div class="p-2 bd-highlight col-example text-center"><div class="card" style="width: 18rem;">
            <img class="card-img-top" src="<c:out value='${coffee.imagePath}'/>" width="150px" height="150px" alt="Menu">
            <div class="card-body">
                <h5 class="card-title">Name: <c:out value="${coffee.name}"/></h5>
                <p class="card-text">Description: <c:out value="${coffee.description}"/></p>
                Ingredients:
     <c:forEach items="${coffee.recipe.ingredients}" var="ingredient">
         <c:if test="${ingredient.stock <= 3}"><c:set var="status" value="out" /></c:if>
                  <p class="card-text"> <c:out value="${ingredient.name}"/></p>
     </c:forEach>
                <c:choose>
                <c:when test="${status.equals('out')}">
                    <p style="color: red;">Out of stock!</p>
                </c:when>
                    <c:otherwise>
                        <p class="card-text">Price: <fmt:formatNumber type="number" maxFractionDigits="2" value="${coffee.price}"/> $</p>
                        <button id="btnADD" onclick="coffeeSUB(<c:out value="${coffee.id}"/>)" class="btn btn-warning">-</button>
                        <input id='a<c:out value="${coffee.id}"/>' type="text" style="width: 60px; height: 40px; text-align: center;" value="1">
                        <button id="btnSUB" onclick="coffeeADD(<c:out value="${coffee.id}"/>)" class="btn btn-warning">+</button><br><br>
                        <button value='<c:out value="${coffee.id}"/>' class="btn btn-warning pickBtn">Choose</button>
                    </c:otherwise>
                </c:choose>
            </div>
          </div></div>
 </c:forEach>
</div></div>

<script src="javascript/menu.js"></script>

</body>
</html>

