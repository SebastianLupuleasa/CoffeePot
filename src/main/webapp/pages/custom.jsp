<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html lang="en">
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="css/style.css">
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

    <img src="images/home-logo.png" alt=""/>

    <h1>Ingredients:</h1>
    <h2 id="menuTotal">Total: 0.00$</h2>
    <!-- here is work to be done -->


    <form action="">
        <div class="row">
<c:forEach items="${ingredientList}" var="ingredient">
            <label class="col-12 col-md-8" ><input onclick="changeIngredientsColor(this.parentElement,<c:out value="${ingredient.price}"/>)" type="checkbox"><c:out value="${ingredient.name}"/> (<c:out value="${ingredient.price}"/>$)</label>
</c:forEach>
        </div>
        <input type="image" name="submit" src="images/nextArrow.png"  alt="Submit" style="width: 50px;" />
    </form>

</div>
    <script src="javascript/scripts.js"></script>
</body>
</html>

