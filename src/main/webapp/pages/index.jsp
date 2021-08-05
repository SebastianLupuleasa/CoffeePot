<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

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

    <img src="images/home-logo.png" alt=""/>

    <div class="flex-menu">
        <div class="p-2 bd-highlight col-example text-center"><div class="card" style="width: 18rem;">
            <img class="card-img-top" src="images/menu-logo.png" width="150px" height="150px" alt="Menu">
            <div class="card-body">
                <h5 class="card-title">Our Selection</h5>
                <p class="card-text">5 mouth-watering coffees</p>
                <a href="/menu" class="btn btn-warning">Select</a>
            </div>
        </div></div>

        <div class="p-2 bd-highlight col-example text-center"><div class="card" style="width: 18rem;">
            <img class="card-img-top" src="images/custom-logo.png" width="150px" height="150px" alt="Custom">
            <div class="card-body">
                <h5 class="card-title">Custom</h5>
                <p class="card-text">customise your coffee using the finest ingredients</p>
                <a href="/custom" class="btn btn-warning">Customise</a>
            </div>
        </div></div>

        <div class="p-2 bd-highlight col-example text-center"><div class="card" style="width: 18rem;">
            <img class="card-img-top" src="images/orders-logo.png" width="150px" height="150px" alt="Order">
            <div class="card-body ">
                <h5 class="card-title">Orders</h5>
                <p class="card-text">check your orders</p>
                <a href="/orders" class="btn btn-warning">Check</a>
            </div>
        </div></div>
    </div>
</div>

<br>
<form action="logout">
    <input type="submit" value="logout">
</form>
</body>
</html>
