<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8" />
  <title>Accept a card payment</title>
  <meta name="description" content="A demo of a card payment on Stripe" />
  <meta name="viewport" content="width=device-width, initial-scale=1" />

  <link rel="stylesheet" href="/css/style.css" />
  <link rel="stylesheet" href="/css/global.css" />

  <script src="https://js.stripe.com/v3/"></script>
  <script src="https://polyfill.io/v3/polyfill.min.js?version=3.52.1&features=fetch"></script>
  <script
          src="https://code.jquery.com/jquery-2.2.4.js"
          integrity="sha256-iT6Q9iMJYuQiMWNd9lDyBUStIq/8PuOW33aOqmvFpqI="
          crossorigin="anonymous"></script>

</head>

<body>

<div class="bg-image"></div>

<div class="bg-text">


  <img src="/images/home-logo.png"  onclick="location.href = 'https://endava-coffeepot.herokuapp.com';" alt=""/>

  <h1 style="color: goldenrod">Make your payment and finish your puchase!</h1>
  <h2 style="color: gainsboro">You will be billed <span style="color: red"> <fmt:formatNumber type="number" maxFractionDigits="2" value="${total}"/> </span> $! </h2>
  <p id="weird" hidden>${great}</p>
  <div class="flex-menu">
        <!-- Display a payment form -->
    <form id="payment-form">
      <div id="card-element"><!--Stripe.js injects the Card Element--></div>
      <button id="submit">
        <div class="spinner hidden" id="spinner"></div>
        <span id="button-text">Pay now</span>
      </button>
      <p id="card-error" role="alert"></p>
      <p class="result-message hidden">
        Payment succeeded!
        <a href="" target="_blank"></a>
      </p>
    </form>

     </div>

<p style="color:lightgray "> Default stripe card : 4242 4242 4242 4242</p>

</div>

<script>

  let value = ${total};

  let lpo = document.getElementById("weird").innerText;

</script>

<script src="/javascript/client.js"></script>

</body>
</html>

