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

$(document).on('click','.makePurchase', function() {
    $.ajax({
        type: "GET",
        url: "/makePurchase",
        data: {
        },success() {
            alert("purchase made!");
            $.ajax({
                type: "GET",
                url: "/cart/",
                data: {
                },
            });
        }
    });
});

$(document).ajaxStop(function(){
    window.location.reload();
});