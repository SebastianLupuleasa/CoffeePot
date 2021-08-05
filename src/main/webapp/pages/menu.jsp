<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<html lang="en">
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="css/style.css">
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

    <img src="images/home-logo.png" alt=""/>

    <div class="flex-menu">
 <c:forEach items="${coffeeList}" var="coffee">
          <div class="p-2 bd-highlight col-example text-center"><div class="card" style="width: 18rem;">
            <img class="card-img-top" src="<c:out value='${coffee.imagePath}'/>" width="150px" height="150px" alt="Menu">
            <div class="card-body">
                <h5 class="card-title">Name: <c:out value="${coffee.name}"/></h5>
                <p class="card-text">Description: <c:out value="${coffee.description}"/></p>
                Ingredients:
     <c:forEach items="${coffee.recipe.ingredients}" var="ingredient">
                <p class="card-text"> <c:out value="${ingredient.name}"/></p>
     </c:forEach>
                <p class="card-text">Price: <c:out value="${coffee.price}"/> $</p>
                <a href="/menu" class="btn btn-warning">Pick</a>
            </div>
        </div></div>
 </c:forEach>
</div></div>


</body>
</html>

