<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html lang="en">
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="/css/style.css">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>CoffeePot</title>
    <script  src="https://code.jquery.com/jquery-2.2.4.js"
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

    <img class="logo" src="/images/home-logo.png"  onclick="location.href = 'http://localhost:8080';" alt=""/>

    <form id="customCoffee" action="addCustom" method="post" >
        <div class="row">

            <h1>Coffee Info:</h1>
            <input type="text" class="rightInput" id="coffeeName" name="coffeeName" placeholder="Name" required/>
            <input type="text" class="rightInput" id="coffeeDesc" name="coffeeDesc" placeholder="Description" />

            <h1>Ingredients:</h1>
            <h2 id="menuTotal">Total: 0.00$</h2>
<c:forEach items="${ingredientList}" var="ingredient">

    <c:choose>
    <c:when test="${ingredient.stock >3}">
            <label class="col-12 col-md-8" ><input name="ingredients" value="<c:out value="${ingredient.id}"/>" onclick="changeIngredientsColor(this.parentElement,<c:out value="${ingredient.price}"/>)" type="checkbox" ><c:out value="${ingredient.name}"/> (<c:out value="${ingredient.price}"/>$)</label>
    </c:when>
    <c:otherwise>
        <label class="col-12 col-md-8" style="background-color: grey; font-size: small;"><small style="color: blue">Out of stock!</small> <c:out value="${ingredient.name}"/> (<c:out value="${ingredient.price}"/>$)</label>
    </c:otherwise>
    </c:choose>
</c:forEach>

        </div>
        <input type="image" class="submitCustom"  id="submitCustomBtn" src="/images/submitIconCustom.png"  alt="Submit" style="width: 75px;" />
    </form>

</div>
    <script src="/javascript/custom.js"></script>
</body>
</html>

