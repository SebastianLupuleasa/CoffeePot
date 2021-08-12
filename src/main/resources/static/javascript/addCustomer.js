"use strict";

function changeColor(element) {


    if (element.style.backgroundColor === 'red' || !element.style.backgroundColor) {
                element.style.backgroundColor = 'green';
                document.getElementById("textNo").innerText="Yes";
    }
    else {
                element.style.backgroundColor = 'red';
            document.getElementById("textNo").innerText="No";
    }


}