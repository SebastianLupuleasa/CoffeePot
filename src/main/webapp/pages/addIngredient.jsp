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

    <img class="logo" src="/images/home-logo.png"  onclick="location.href = 'https://endava-coffeepot.herokuapp.com';" alt=""/>

    <form id="customCoffee" action="addIngredient/${ingredient.id}" method="post" >
        <div class="row">

            <h1>Customer Info:</h1>
            <input type="text" class="rightInput"  id="ingredientName" value="${ingredient.name}" name="ingredientName" placeholder="Name" required/>
            <input type="number"  class="rightInput" id="ingredientPrice" value="${ingredient.price}" name="ingredientPrice" placeholder="Price" required/>
            <input type="number"  class="rightInput" id="ingredientStock" value="${ingredient.stock}" name="ingredientStock" placeholder="Stock" required/>

        </div>
        <input type="image" class="submitCustom"  id="submitCustomBtn" src="/images/add-icon.png"  alt="Submit" style="width: 75px;" />
    </form>

</div>
</body>
</html>

