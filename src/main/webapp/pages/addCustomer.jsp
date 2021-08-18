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

    <form id="customCoffee" action="addCustomer/${customer.id}" method="post" >
        <div class="row">

            <h1>Customer Info:</h1>
            <input type="text" class="rightInput"  id="customerName" value="${customer.userName}" name="customerName" placeholder="Name" required/>
            <input type="password"  class="rightInput" id="customerPass" value="${customer.password}" name="customerPass" placeholder="Password" required/>
            <input type="text"  class="rightInput" id="streetName" value="${customer.address.streetName}" name="customerStreet" placeholder="Street" required/>
            <input type="number"  class="rightInput" id="streetNumber" value="${customer.address.buildingNumber}" name="customerNumber" placeholder="Number" required/>

            <p> Admin:   <label class="col-12 col-md-8" <c:if test="${customer.roles.equals('ROLE_ADMIN')}"> style="background-color:green;" </c:if> ><input id="customerRole" name="customerRole" <c:if test="${customer.roles.equals('ROLE_ADMIN')}"> checked </c:if> value="admin" onclick="changeColor(this.parentElement)" type="checkbox" > <span id="textNo"> ${customer.roles.equals('ROLE_ADMIN') ? "Yes" : "No"} </span></label></p>


        </div>
        <input type="image" class="submitCustom"  id="submitCustomBtn" src="/images/add-icon.png"  alt="Submit" style="width: 75px;" />
    </form>

</div>
<script src="/javascript/addCustomer.js"></script>
</body>
</html>

