"use strict";

function coffeeSUB(variable)
{
    if(document.getElementById(variable).value > 1)
    {
        document.getElementById(variable).value--;
    }
}

function coffeeADD(variable)
{

    document.getElementById(variable).value++;

}

$(document).on('click','.removeBtn', function() {
    let mycoffee = $(this).val();
    let myamount = document.getElementById(mycoffee).value;
    $.ajax({
        type: "PUT",
        url: "/cart",
        data: {
            'mycoffee': mycoffee,
            'myamount': myamount
        },
    });
});

$(document).on('click','.emptyCart', function() {
   $.ajax({
        type: "GET",
        url: "/cart/",
        data: {
            },
    });
});

$(document).ajaxStop(function(){
    window.location.reload();
});

$("#submit").click(function(){
    $(".dialog").dialog('open');
});

function call()
{
 let deliver = prompt("What is the delivery method?\n1: to go\n2: pickup");

 while(deliver!= 1 && deliver!=2)
 {
     alert("don't try to be funny!");
     deliver = prompt("What is the delivery method?\n1: to-go\n2: pick-up");
 }

 return deliver;
}

