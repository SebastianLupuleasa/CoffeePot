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

    <img src="/images/home-logo.png" onclick="location.href = 'http://localhost:8080/admin';" alt=""/>

    <button type="button" onclick="location.href = 'http://localhost:8080/addCustomer';" class="btn btn-success createCoffee">Add Customer</button>

    <div class="flex-menu">
        <c:forEach items="${customerList}" var="customer">
            <div class="p-2 bd-highlight col-example text-center"><div class="card" style="width: 18rem;">
               <div class="card-body">
                    <h5 class="card-title">Name: <c:out value="${customer.userName}"/></h5>
                    <p class="card-text">Roles: <c:out value="${customer.roles}"/></p>
                    <p class="card-text">Address: <c:out value="${customer.address.streetName} ${customer.address.buildingNumber}"/> </p>
                   <a href="/addCustomer/<c:out value="${customer.id}"/>" class="btn btn-warning">Modify</a>
                   <a href="/admin/customers/<c:out value="${customer.id}"/>" class="btn btn-danger">Delete</a>
                </div>
            </div></div>
        </c:forEach>
    </div></div>
    </div>
</div>
</body>
</html>

