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


    <div class="flex-menu">
        <div class="p-2 bd-highlight col-example text-center"><div class="card" style="width: 18rem;">
            <img class="card-img-top" src="/images/customer-icon.png" width="150px" height="150px" alt="Menu">
            <div class="card-body">
                <h5 class="card-title">Manage Customers</h5>
                <p class="card-text">see and change info about customers</p>
                <a href="/admin/customers" class="btn btn-warning">Select</a>
            </div>
        </div></div>

        <div class="p-2 bd-highlight col-example text-center"><div class="card" style="width: 18rem;">
            <img class="card-img-top" src="/images/ingredients-icon.png" width="150px" height="150px" alt="Order">
            <div class="card-body ">
                <h5 class="card-title">Manage Ingredients</h5>
                <p class="card-text">see and change info about ingredients</p>
                <a href="/admin/ingredients" class="btn btn-warning">Select</a>
            </div>
        </div></div>

            <div class="p-2 bd-highlight col-example text-center"><div class="card" style="width: 18rem;">
                <img class="card-img-top" src="/images/orders-logo.png" width="150px" height="150px" alt="Menu">
                <div class="card-body">
                    <h5 class="card-title">See orders and profit</h5>
                    <p class="card-text">see all your profits</p>
                    <a href="/admin/orders" class="btn btn-warning">Select</a>
                </div>
            </div></div>

    </div>

</div>
</body>
</html>

