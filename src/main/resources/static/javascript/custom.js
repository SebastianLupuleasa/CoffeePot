"use strict";

function changeIngredientsColor(element,price){

 let total = parseFloat(document.getElementById("menuTotal").textContent.match(/\d.+/g));
 
 if(element.style.backgroundColor === 'red' || !element.style.backgroundColor)
 {
      total= total + price;
      element.style.backgroundColor = 'green' ; 
 }
 else
 {
    total= total-price;
    element.style.backgroundColor = 'red' ;
 }

 document.getElementById("menuTotal").textContent= "Total: "+total.toFixed(2)+"$";

}

$(document).ready(function () {
    $('#submitCustomBtn').click(function() {
       let checked = $("input[type=checkbox]:checked").length;

        if(!checked) {
            alert("You must add at least one ingredient.");
            return false;
        }

    });
});

$(document).on('click','.deleteBtn', function() {
    let mycoffee = $(this).val();
    $.ajax({
        type: "DELETE",
        url: "/cart",
        data: {
            'mycoffee': mycoffee,
         }
    });
});

$(document).on('click','.pickBtn', function() {
    let mycoffee = $(this).val();
    console.log("over here");
    let myamount = document.getElementById('a'+mycoffee).value;
    $.ajax({
        type: "POST",
        url: "/cart",
        data: {
            'mycoffee': mycoffee,
            'myamount': myamount
        },success(data)
        { alert(data);}
    });
});

function coffeeSUB(variable)
{
    if(document.getElementById("a"+variable).value > 1)
    {
        document.getElementById("a"+variable).value--;
    }
}

function coffeeADD(variable)
{

    document.getElementById("a"+variable).value++;

}