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

