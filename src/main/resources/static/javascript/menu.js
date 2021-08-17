"use strict";

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

$(document).on('click','.pickBtn', function() {
    let mycoffee = $(this).val();
    let myamount = document.getElementById('a'+mycoffee).value;
    $.ajax({
        type: "POST",
        url: "/cart",
        data: {
            'mycoffee': mycoffee,
            'myamount': myamount
        },success(data)
        { alert(data);;}
    });
});

